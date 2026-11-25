package view;

import api.ApiClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class TelaConsultaConversa extends javax.swing.JFrame {

    private int idCliente;
    private int idProfissional;
    private SwingWorker<JsonArray, Void> consulta;

    // Construtor para o Design do NetBeans, sem acesso à API.
    public TelaConsultaConversa() {
        initComponents();
        configurarVisual();
        btnAtualizar.setEnabled(false);
    }

    public TelaConsultaConversa(int idCliente, int idProfissional,
            String nomeCliente, String nomeProfissional) {
        this();
        this.idCliente = idCliente;
        this.idProfissional = idProfissional;
        lblCliente.setText("Cliente: " + nomeCliente + " · ID " + idCliente);
        lblProfissional.setText("Profissional: " + nomeProfissional + " · ID " + idProfissional);
        lblCliente.setToolTipText(lblCliente.getText());
        lblProfissional.setToolTipText(lblProfissional.getText());
        carregarMensagens();
    }

    private void configurarVisual() {
        Color borda = new Color(0xDFE6F1);
        for (JPanel p : new JPanel[]{painelCabecalho, painelParticipantes, painelHistorico}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JButton b : new JButton[]{btnVoltar, btnAtualizar}) {
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borda),
                    BorderFactory.createEmptyBorder(5, 12, 5, 12)));
        }
        scrollMensagens.setBorder(BorderFactory.createLineBorder(borda));
        scrollMensagens.getVerticalScrollBar().setUnitIncrement(16);
        txtMensagens.setContentType("text/html");
        txtMensagens.setEditable(false);
        txtMensagens.setBackground(new Color(0xF3F6FC));
        txtMensagens.putClientProperty(javax.swing.JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        exibirAviso("As mensagens serão exibidas aqui.");
        setMinimumSize(new Dimension(900, 600));
        setSize(1040, 730);
        setLocationRelativeTo(null);
    }

    private void carregarMensagens() {
        if (idCliente <= 0 || idProfissional <= 0) {
            lblEstado.setText("Identificação dos participantes inválida.");
            return;
        }
        if (consulta != null && !consulta.isDone()) return;
        btnAtualizar.setEnabled(false);
        lblEstado.setText("Consultando a API...");
        lblQuantidade.setText("Carregando...");
        exibirAviso("Carregando histórico de mensagens...");
        consulta = new SwingWorker<JsonArray, Void>() {
            @Override
            protected JsonArray doInBackground() throws Exception {
                String resposta = new ApiClient().listarConversas(idCliente, idProfissional);
                return JsonParser.parseString(resposta).getAsJsonArray();
            }

            @Override
            protected void done() {
                if (!isDisplayable() || isCancelled()) return;
                try {
                    JsonArray mensagens = get();
                    exibirMensagens(mensagens);
                    lblQuantidade.setText(mensagens.size() + " mensagem(ns) encontrada(s)");
                    lblEstado.setText("Consulta concluída · nenhuma mensagem foi alterada.");
                } catch (Exception e) {
                    lblQuantidade.setText("Falha na consulta");
                    lblEstado.setText("Não foi possível consultar. Verifique a API e tente novamente.");
                    exibirAviso("Não foi possível carregar as mensagens.");
                } finally {
                    btnAtualizar.setEnabled(true);
                }
            }
        };
        consulta.execute();
    }

    private void exibirAviso(String mensagem) {
        txtMensagens.setText("<html><body style='background-color:#F3F6FC;font-family:Segoe UI;padding:20px;color:#526785;'>"
                + html(mensagem) + "</body></html>");
        txtMensagens.setCaretPosition(0);
    }

    private void exibirMensagens(JsonArray mensagens) {
        if (mensagens.size() == 0) {
            exibirAviso("Nenhuma mensagem registrada entre estes usuários.");
            return;
        }
        StringBuilder pagina = new StringBuilder("<html><body style='background-color:#F3F6FC;font-family:Segoe UI;color:#18243C;margin:16px;'>");
        for (JsonElement elemento : mensagens) {
            JsonObject m = elemento.getAsJsonObject();
            boolean cliente = m.get("id_remetente").getAsInt() == idCliente;
            String fundo = cliente ? "#FFFFFF" : "#E0ECFF";
            String papel = cliente ? "Cliente" : "Profissional";
            pagina.append("<table width='100%' cellspacing='0' cellpadding='0'><tr>");
            if (!cliente) pagina.append("<td width='23%'>&nbsp;</td>");
            pagina.append("<td width='77%'><table width='100%' cellspacing='0' cellpadding='10' bgcolor='")
                    .append(fundo).append("'><tr><td>")
                    .append("<font color='#064DC7'><b>").append(html(texto(m, "nome_remetente")))
                    .append(" · ").append(papel).append("</b></font><br>")
                    .append(html(texto(m, "conteudo")).replace("\r\n", "\n").replace("\n", "<br>"))
                    .append("<br><font size='2' color='#526785'>")
                    .append(html(data(texto(m, "data_envio"))))
                    .append(" · Conversa #").append(html(texto(m, "id_conversa")))
                    .append(" · Mensagem #").append(html(texto(m, "id_mensagem")))
                    .append("</font></td></tr></table></td>");
            if (cliente) pagina.append("<td width='23%'>&nbsp;</td>");
            pagina.append("</tr></table><br>");
        }
        pagina.append("</body></html>");
        txtMensagens.setText(pagina.toString());
        txtMensagens.setCaretPosition(0);
    }

    private static String texto(JsonObject obj, String chave) {
        JsonElement e = obj.get(chave);
        return e == null || e.isJsonNull() ? "—" : e.getAsString();
    }

    private static String html(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }

    private static String data(String s) {
        try {
            return Instant.parse(s).atZone(ZoneId.systemDefault())
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (Exception e) { return s; }
    }

    @Override
    public void dispose() {
        if (consulta != null) consulta.cancel(true);
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        lblMarcaSub = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        painelParticipantes = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblProfissional = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        painelHistorico = new javax.swing.JPanel();
        lblHistorico = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        scrollMensagens = new javax.swing.JScrollPane();
        txtMensagens = new javax.swing.JEditorPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Consulta de conversa");
        painelPrincipal.setBackground(new java.awt.Color(0xF3F6FC));
        painelCabecalho.setBackground(new java.awt.Color(0xFFFFFF));
        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblMarca.setForeground(new java.awt.Color(0x064DC7));
        lblMarca.setText("ContrataJá");
        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMarcaSub.setForeground(new java.awt.Color(0x526785));
        lblMarcaSub.setText("SUPORTE");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 27));
        lblTitulo.setForeground(new java.awt.Color(0x18243C));
        lblTitulo.setText("Consulta de conversa");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubtitulo.setForeground(new java.awt.Color(0x526785));
        lblSubtitulo.setText("Investigação de atendimento · somente leitura");
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnVoltar.setForeground(new java.awt.Color(0x243B62));
        btnVoltar.setBackground(new java.awt.Color(0xEDF3FD));
        btnVoltar.setText("‹  Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        painelParticipantes.setBackground(new java.awt.Color(0xFFFFFF));
        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblCliente.setForeground(new java.awt.Color(0x18243C));
        lblCliente.setText("Cliente: —");
        lblProfissional.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblProfissional.setForeground(new java.awt.Color(0x18243C));
        lblProfissional.setText("Profissional: —");
        lblAviso.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblAviso.setForeground(new java.awt.Color(0x526785));
        lblAviso.setText("Histórico entre os usuários; não vinculado exclusivamente a um contrato.");
        painelHistorico.setBackground(new java.awt.Color(0xFFFFFF));
        lblHistorico.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblHistorico.setForeground(new java.awt.Color(0x18243C));
        lblHistorico.setText("Histórico de mensagens");
        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblQuantidade.setForeground(new java.awt.Color(0x526785));
        lblQuantidade.setText("Nenhuma consulta iniciada");
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnAtualizar.setForeground(new java.awt.Color(0x243B62));
        btnAtualizar.setBackground(new java.awt.Color(0xEDF3FD));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);
        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblEstado.setForeground(new java.awt.Color(0x526785));
        lblEstado.setText("Selecione uma contratação para consultar.");
        txtMensagens.setEditable(false);
        txtMensagens.setBackground(new java.awt.Color(0xF3F6FC));
        txtMensagens.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtMensagens.setText("As mensagens serão exibidas aqui.");
        scrollMensagens.setViewportView(txtMensagens);
        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(20).addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(20).addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(20).addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20)));
        painelCabecalhoLayout.setVerticalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(14).addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelCabecalhoLayout.createSequentialGroup().addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(painelCabecalhoLayout.createSequentialGroup().addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(14)));
        javax.swing.GroupLayout painelParticipantesLayout = new javax.swing.GroupLayout(painelParticipantes);
        painelParticipantes.setLayout(painelParticipantesLayout);
        painelParticipantesLayout.setHorizontalGroup(painelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelParticipantesLayout.createSequentialGroup().addGap(18).addGroup(painelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelParticipantesLayout.createSequentialGroup().addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(20).addComponent(lblProfissional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18)));
        painelParticipantesLayout.setVerticalGroup(painelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelParticipantesLayout.createSequentialGroup().addGap(12).addGroup(painelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4).addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(12)));
        javax.swing.GroupLayout painelHistoricoLayout = new javax.swing.GroupLayout(painelHistorico);
        painelHistorico.setLayout(painelHistoricoLayout);
        painelHistoricoLayout.setHorizontalGroup(painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelHistoricoLayout.createSequentialGroup().addGap(16).addGroup(painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelHistoricoLayout.createSequentialGroup().addGroup(painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(12).addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(scrollMensagens, 0, 860, Short.MAX_VALUE).addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(16)));
        painelHistoricoLayout.setVerticalGroup(painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelHistoricoLayout.createSequentialGroup().addGap(14).addGroup(painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelHistoricoLayout.createSequentialGroup().addComponent(lblHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(12).addComponent(scrollMensagens, 0, 420, Short.MAX_VALUE).addGap(8).addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(12)));
        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(painelPrincipalLayout.createSequentialGroup().addGap(20).addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(painelHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(20)));
        painelPrincipalLayout.setVerticalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(painelPrincipalLayout.createSequentialGroup().addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(16).addComponent(painelParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(16).addComponent(painelHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(20)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarMensagens();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaConsultaConversa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel painelParticipantes;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JPanel painelHistorico;
    private javax.swing.JLabel lblHistorico;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JScrollPane scrollMensagens;
    private javax.swing.JEditorPane txtMensagens;
    // End of variables declaration//GEN-END:variables
}
