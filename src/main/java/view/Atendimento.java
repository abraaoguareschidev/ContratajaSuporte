package view;

import api.ApiClient;
import api.ChatWebSocketClient;
import javax.swing.*;
import java.awt.*;

/**
 * Atendimento do ContrataJá Suporte. Interface editável pelo GUI Builder.
 */
public class Atendimento extends javax.swing.JFrame {

    private int idSuporte;
    private int idChamado;
    private boolean modoHistorico = false;
    private String assunto, descricao, data, status, nome;
    private ChatWebSocketClient chat;
    private final java.util.List<JLabel> indicadoresLeitura = new java.util.ArrayList<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Atendimento.class.getName());

    public Atendimento() {
        initComponents();
        configurarVisual();
        btnEnviar.setEnabled(false);
        btnEncerrarChamado.setEnabled(false);
        txtAreaMensagem.setEditable(false);
        lblModoChat.setText("Selecione um chamado na lista para iniciar.");
    }

    public Atendimento(int idChamado, String assunto, String descricao,
            String data, String status, String nome, String email, String telefone, int idSuporte) {
        this(idChamado, assunto, descricao, data, status, nome, email, telefone, idSuporte, false);
    }

    public Atendimento(int idChamado, String assunto, String descricao, String data, String status,
            String nome, String email, String telefone, int idSuporte, boolean modoHistorico) {
        initComponents();
        configurarVisual();
        this.idChamado = idChamado;
        this.idSuporte = idSuporte;
        this.modoHistorico = modoHistorico;
        this.assunto = assunto;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.nome = nome;
        jTextFieldIdChamado.setText(String.valueOf(idChamado));
        jTextFieldAssunto.setText(assunto);
        jTextFieldDataAbertura.setText(data);
        TxtAreaDescricao.setText(descricao);
        lblNomeCliente.setText(nome);
        lblEmailCliente.setText(email);
        lblTelefoneCliente.setText(telefone);
        lblEmailCliente.setToolTipText(email);
        lblSubtitulo.setText("Chamado #" + idChamado + " · " + assunto);
        atualizarStatusVisual(status);
        if (!modoHistorico) {
            marcarMensagensComoLidas();
        }
        carregarHistorico();
        if (modoHistorico) {
            btnEnviar.setEnabled(false);
            btnEncerrarChamado.setEnabled(false);
            txtAreaMensagem.setEditable(false);
            txtAreaSolucao.setEditable(false);
            lblDica.setText("Histórico somente para consulta.");
        } else {
            try {
                chat = new ChatWebSocketClient(idChamado);
                chat.setAoReceberMensagem(json -> SwingUtilities.invokeLater(() -> {
                    if (!isDisplayable()) {
                        return;
                    }
                    com.google.gson.JsonObject mensagem = com.google.gson.JsonParser.parseString(json).getAsJsonObject();
                    adicionarMensagem(mensagem.get("nomeRemetente").getAsString(),
                            mensagem.get("conteudo").getAsString(), mensagem.get("dataEnvio").getAsString(),
                            mensagem.get("idRemetente").getAsInt(), mensagem.get("statusLeitura").getAsBoolean());

                    if (mensagem.get("idRemetente").getAsInt() != idSuporte
                            && isShowing()) {
                        marcarMensagensComoLidas();
                    }
                }));
                chat.setAoReceberLeitura(idUsuario -> SwingUtilities.invokeLater(() -> {
                    if (idUsuario != idSuporte) {
                        for (JLabel indicador : indicadoresLeitura) {
                            indicador.setText("Lido");
                        }
                        jPanelMensagens.revalidate();
                        jPanelMensagens.repaint();
                    }
                }));
                chat.connect();
            } catch (Exception e) {
                System.out.println("Erro ao conectar ao chat: " + e.getMessage());
            }
        }
    }

    public void exibirSolucao(String solucao) {
        txtAreaSolucao.setText(solucao == null ? "" : solucao);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        lblMarcaSub = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        painelChat = new javax.swing.JPanel();
        lblTituloChat = new javax.swing.JLabel();
        lblModoChat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelMensagens = new javax.swing.JPanel();
        lblDica = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMensagem = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        painelDireito = new javax.swing.JPanel();
        painelInformacoes = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        lblIdChamado = new javax.swing.JLabel();
        lblAssunto = new javax.swing.JLabel();
        lblDataAbertura = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jTextFieldIdChamado = new javax.swing.JTextField();
        jTextFieldAssunto = new javax.swing.JTextField();
        jTextFieldDataAbertura = new javax.swing.JTextField();
        jTextFieldStatus = new javax.swing.JTextField();
        painelCliente = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblRotuloNomeCliente = new javax.swing.JLabel();
        lblRotuloEmailCliente = new javax.swing.JLabel();
        lblRotuloTelefoneCliente = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        lblTelefoneCliente = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        painelDescricao = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtAreaDescricao = new javax.swing.JTextArea();
        painelSolucao = new javax.swing.JPanel();
        lblSolucao = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaSolucao = new javax.swing.JTextArea();
        btnEncerrarChamado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Atendimento");

        painelPrincipal.setBackground(new java.awt.Color(243, 246, 252));

        painelCabecalho.setBackground(new java.awt.Color(255, 255, 255));

        lblMarca.setText("ContrataJá");
        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(6, 77, 199));

        lblMarcaSub.setText("SUPORTE");
        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMarcaSub.setForeground(new java.awt.Color(82, 103, 133));

        btnVoltar.setBackground(new java.awt.Color(237, 243, 253));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(36, 59, 98));
        btnVoltar.setText("‹  Voltar aos chamados");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        lblTitulo.setText("Atendimento");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(24, 36, 60));

        lblSubtitulo.setText("Gerencie a conversa e acompanhe os detalhes do chamado.");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(82, 103, 133));

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCabecalhoLayout.createSequentialGroup()
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCabecalhoLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        painelChat.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloChat.setText("Conversa do chamado");
        lblTituloChat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloChat.setForeground(new java.awt.Color(24, 36, 60));

        lblModoChat.setText("Atendimento em andamento");
        lblModoChat.setForeground(new java.awt.Color(82, 103, 133));

        jPanelMensagens.setBackground(new java.awt.Color(243, 246, 252));

        javax.swing.GroupLayout jPanelMensagensLayout = new javax.swing.GroupLayout(jPanelMensagens);
        jPanelMensagens.setLayout(jPanelMensagensLayout);
        jPanelMensagensLayout.setHorizontalGroup(
            jPanelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMensagensLayout.setVerticalGroup(
            jPanelMensagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelMensagens);

        lblDica.setText("Digite sua mensagem no campo abaixo.");
        lblDica.setForeground(new java.awt.Color(82, 103, 133));

        txtAreaMensagem.setLineWrap(true);
        txtAreaMensagem.setWrapStyleWord(true);
        txtAreaMensagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAreaMensagem.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaMensagem.setForeground(new java.awt.Color(24, 36, 60));
        jScrollPane2.setViewportView(txtAreaMensagem);

        btnEnviar.setText("Enviar  ›");
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setBackground(new java.awt.Color(7, 84, 216));
        btnEnviar.addActionListener(this::btnEnviarActionPerformed);

        javax.swing.GroupLayout painelChatLayout = new javax.swing.GroupLayout(painelChat);
        painelChat.setLayout(painelChatLayout);
        painelChatLayout.setHorizontalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelChatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModoChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        painelChatLayout.setVerticalGroup(
            painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelChatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTituloChat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblModoChat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, 0, 432, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(lblDica, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(painelChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        painelDireito.setBackground(new java.awt.Color(243, 246, 252));

        painelInformacoes.setBackground(new java.awt.Color(255, 255, 255));

        lblInfo.setText("Informações do chamado");
        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(24, 36, 60));

        lblIdChamado.setText("ID do chamado:");
        lblIdChamado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdChamado.setForeground(new java.awt.Color(82, 103, 133));

        lblAssunto.setText("Assunto:");
        lblAssunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAssunto.setForeground(new java.awt.Color(82, 103, 133));

        lblDataAbertura.setText("Data de abertura:");
        lblDataAbertura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDataAbertura.setForeground(new java.awt.Color(82, 103, 133));

        lblStatus.setText("Status:");
        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(82, 103, 133));

        jTextFieldIdChamado.setEditable(false);
        jTextFieldIdChamado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldIdChamado.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldIdChamado.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldAssunto.setEditable(false);
        jTextFieldAssunto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldAssunto.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldAssunto.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldDataAbertura.setEditable(false);
        jTextFieldDataAbertura.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldDataAbertura.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldDataAbertura.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldStatus.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldStatus.setForeground(new java.awt.Color(24, 36, 60));

        javax.swing.GroupLayout painelInformacoesLayout = new javax.swing.GroupLayout(painelInformacoes);
        painelInformacoes.setLayout(painelInformacoesLayout);
        painelInformacoesLayout.setHorizontalGroup(
            painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelInformacoesLayout.createSequentialGroup()
                        .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdChamado)
                            .addComponent(lblAssunto)
                            .addComponent(lblDataAbertura)
                            .addComponent(lblStatus))
                        .addGap(10, 10, 10)
                        .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdChamado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAssunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDataAbertura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        painelInformacoesLayout.setVerticalGroup(
            painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        painelCliente.setBackground(new java.awt.Color(255, 255, 255));

        lblCliente.setText("Dados do usuário");
        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(24, 36, 60));

        lblRotuloNomeCliente.setText("Nome");
        lblRotuloNomeCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRotuloNomeCliente.setForeground(new java.awt.Color(82, 103, 133));

        lblRotuloEmailCliente.setText("E-mail");
        lblRotuloEmailCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRotuloEmailCliente.setForeground(new java.awt.Color(82, 103, 133));

        lblRotuloTelefoneCliente.setText("Telefone");
        lblRotuloTelefoneCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRotuloTelefoneCliente.setForeground(new java.awt.Color(82, 103, 133));

        lblNomeCliente.setText("—");
        lblNomeCliente.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNomeCliente.setForeground(new java.awt.Color(24, 36, 60));

        lblEmailCliente.setText("—");
        lblEmailCliente.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblEmailCliente.setForeground(new java.awt.Color(24, 36, 60));

        lblTelefoneCliente.setText("—");
        lblTelefoneCliente.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTelefoneCliente.setForeground(new java.awt.Color(24, 36, 60));

        jButton2.setText("Ver perfil do usuário");
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(36, 59, 98));
        jButton2.setBackground(new java.awt.Color(237, 243, 253));
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRotuloNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRotuloEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRotuloTelefoneCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefoneCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblRotuloNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRotuloEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRotuloTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));

        lblDescricao.setText("Descrição do chamado");
        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(24, 36, 60));

        TxtAreaDescricao.setEditable(false);
        TxtAreaDescricao.setLineWrap(true);
        TxtAreaDescricao.setWrapStyleWord(true);
        TxtAreaDescricao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TxtAreaDescricao.setBackground(new java.awt.Color(248, 250, 253));
        TxtAreaDescricao.setForeground(new java.awt.Color(24, 36, 60));
        jScrollPane3.setViewportView(TxtAreaDescricao);

        javax.swing.GroupLayout painelDescricaoLayout = new javax.swing.GroupLayout(painelDescricao);
        painelDescricao.setLayout(painelDescricaoLayout);
        painelDescricaoLayout.setHorizontalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(14, 14, 14))
        );
        painelDescricaoLayout.setVerticalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, 0, 73, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        painelSolucao.setBackground(new java.awt.Color(255, 255, 255));

        lblSolucao.setText("Solução do chamado");
        lblSolucao.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSolucao.setForeground(new java.awt.Color(24, 36, 60));

        txtAreaSolucao.setEditable(false);
        txtAreaSolucao.setLineWrap(true);
        txtAreaSolucao.setWrapStyleWord(true);
        txtAreaSolucao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAreaSolucao.setBackground(new java.awt.Color(248, 250, 253));
        txtAreaSolucao.setForeground(new java.awt.Color(24, 36, 60));
        jScrollPane4.setViewportView(txtAreaSolucao);

        javax.swing.GroupLayout painelSolucaoLayout = new javax.swing.GroupLayout(painelSolucao);
        painelSolucao.setLayout(painelSolucaoLayout);
        painelSolucaoLayout.setHorizontalGroup(
            painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolucaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(14, 14, 14))
        );
        painelSolucaoLayout.setVerticalGroup(
            painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolucaoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, 0, 79, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        btnEncerrarChamado.setText("Encerrar chamado");
        btnEncerrarChamado.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEncerrarChamado.setForeground(new java.awt.Color(255, 255, 255));
        btnEncerrarChamado.setBackground(new java.awt.Color(180, 35, 54));
        btnEncerrarChamado.addActionListener(this::btnEncerrarChamadoActionPerformed);

        javax.swing.GroupLayout painelDireitoLayout = new javax.swing.GroupLayout(painelDireito);
        painelDireito.setLayout(painelDireitoLayout);
        painelDireitoLayout.setHorizontalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEncerrarChamado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelDireitoLayout.setVerticalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitoLayout.createSequentialGroup()
                .addComponent(painelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(painelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(painelDescricao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(painelSolucao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnEncerrarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(painelChat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(painelDireito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDireito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Comportamento e estilo fora dos blocos gerados pelo NetBeans.
    private void configurarVisual() {
        Color borda = new Color(0xDFE6F1);
        for (JPanel p : new JPanel[]{painelCabecalho, painelChat, painelInformacoes, painelCliente, painelDescricao, painelSolucao}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JTextField f : new JTextField[]{jTextFieldIdChamado, jTextFieldAssunto, jTextFieldStatus, jTextFieldDataAbertura}) {
            f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borda), BorderFactory.createEmptyBorder(0, 8, 0, 6)));
        }
        for (JScrollPane s : new JScrollPane[]{jScrollPane1, jScrollPane2, jScrollPane3, jScrollPane4}) {
            s.setBorder(BorderFactory.createLineBorder(borda));
            s.getVerticalScrollBar().setUnitIncrement(16);
        }
        for (JTextArea a : new JTextArea[]{txtAreaMensagem, TxtAreaDescricao, txtAreaSolucao}) {
            a.setMargin(new Insets(8, 10, 8, 10));
        }
        jPanelMensagens.setLayout(new BoxLayout(jPanelMensagens, BoxLayout.Y_AXIS));
        jPanelMensagens.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
        jScrollPane1.getViewport().setBackground(new Color(0xF3F6FC));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        for (JButton b : new JButton[]{btnVoltar, btnEnviar, btnEncerrarChamado, jButton2}) {
            b.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    AbstractButton botao = (AbstractButton) c;
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Color bg = botao.isEnabled() ? botao.getBackground() : new Color(0xEDF1F6);
                    if (botao.isEnabled() && botao.getModel().isPressed()) {
                        bg = bg.darker();
                    }
                    g2.setColor(bg);
                    g2.fillRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                    g2.setColor(new Color(0xD6E1EF));
                    g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                    g2.dispose();
                    super.paint(g, c);
                }
            });
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        jButton2.setEnabled(false);
        jButton2.setToolTipText("Consulta do perfil do usuário ainda não implementada.");
        txtAreaSolucao.setEditable(false);
        setMinimumSize(new Dimension(980, 720));
        setLocationRelativeTo(null);
    }

    private void atualizarStatusVisual(String valor) {
        status = valor;
        jTextFieldStatus.setText("fechado".equalsIgnoreCase(valor) ? "Fechado"
                : "em_atendimento".equalsIgnoreCase(valor) ? "Em atendimento" : valor);
        if ("fechado".equalsIgnoreCase(valor)) {
            jTextFieldStatus.setBackground(new Color(0xDDF5E7));
            jTextFieldStatus.setForeground(new Color(0x126B3D));
            lblModoChat.setText("Chamado encerrado · histórico");
            lblModoChat.setForeground(new Color(0x126B3D));
        } else {
            jTextFieldStatus.setBackground(new Color(0xE0ECFF));
            jTextFieldStatus.setForeground(new Color(0x0754D8));
            lblModoChat.setText(modoHistorico ? "Consulta de histórico" : "Em atendimento");
            lblModoChat.setForeground(new Color(0x0754D8));
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Consulta de perfil do cliente ainda não implementada no projeto original.
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String conteudo = txtAreaMensagem.getText().trim();
        if (conteudo.isEmpty() || modoHistorico || "fechado".equalsIgnoreCase(status)) {
            return;
        }
        if (chat != null && chat.isOpen()) {
            chat.enviarMensagem(conteudo, idSuporte);
            txtAreaMensagem.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Chat desconectado. Aguarde a reconexão.");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnEncerrarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarChamadoActionPerformed
        if (modoHistorico || "fechado".equalsIgnoreCase(status)) {
            return;
        }
        if (!txtAreaSolucao.isEditable()) {
            txtAreaSolucao.setEditable(true);
            txtAreaSolucao.requestFocusInWindow();
            JOptionPane.showMessageDialog(this, "Descreva a solução e clique novamente em Encerrar chamado.");
            return;
        }
        String solucao = txtAreaSolucao.getText().trim();
        if (solucao.isBlank()) {
            JOptionPane.showMessageDialog(this, "Informe a solução antes de encerrar o chamado.");
            return;
        }
        try {
            ApiClient api = new ApiClient();
            api.encerrarChamado(idChamado, solucao);
            atualizarStatusVisual("fechado");
            txtAreaSolucao.setEditable(false);
            txtAreaMensagem.setEnabled(false);
            btnEnviar.setEnabled(false);
            btnEncerrarChamado.setEnabled(false);
            lblDica.setText("Atendimento encerrado.");
            JOptionPane.showMessageDialog(this, "Chamado encerrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao encerrar chamado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEncerrarChamadoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void adicionarMensagem(String nomeRemetente, String conteudo, String dataEnvio,
            int idRemetente, boolean statusLeitura) {
        boolean minha = idRemetente == idSuporte;
        JPanel linha = new JPanel(new FlowLayout(minha ? FlowLayout.RIGHT : FlowLayout.LEFT, 8, 6));
        linha.setOpaque(false);
        Color fundo = minha ? new Color(0xE0ECFF) : Color.WHITE;
        JPanel bolha = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(fundo);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 18, 18);
                g2.setColor(new Color(0xDFE6F1));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 18, 18);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        bolha.setOpaque(false);
        bolha.setLayout(new BoxLayout(bolha, BoxLayout.Y_AXIS));
        bolha.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        JLabel lblNome = new JLabel();
        lblNome.putClientProperty("html.disable", Boolean.TRUE);
        lblNome.setText(nomeRemetente);
        lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNome.setForeground(new Color(0x0754D8));
        JTextArea texto = new JTextArea(conteudo == null ? "" : conteudo);
        texto.setUI(new javax.swing.plaf.basic.BasicTextAreaUI());
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setBorder(BorderFactory.createEmptyBorder());
        texto.setMargin(new Insets(0, 0, 0, 0));
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        texto.setForeground(new Color(0x18243C));
        int larguraDisponivel = jScrollPane1.getViewport().getWidth();
        int larguraMax = Math.max(210, Math.min(410, larguraDisponivel > 0 ? larguraDisponivel - 100 : 410));
        int largura = Math.min(larguraMax, Math.max(160, texto.getFontMetrics(texto.getFont()).stringWidth(conteudo == null ? "" : conteudo) + 8));
        texto.setSize(largura, Short.MAX_VALUE);
        texto.setPreferredSize(new Dimension(largura, texto.getPreferredSize().height));
        String hora = dataEnvio;
        try {
            hora = java.time.LocalDateTime.parse(dataEnvio).format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        } catch (Exception ignored) {
        }
        JLabel lblData = new JLabel(hora);
        lblData.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblData.setForeground(new Color(0x526785));
        for (JComponent c : new JComponent[]{lblNome, texto, lblData}) {
            c.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        bolha.add(lblNome);
        bolha.add(Box.createVerticalStrut(4));
        bolha.add(texto);
        bolha.add(Box.createVerticalStrut(6));
        bolha.add(lblData);
        if (minha) {
            JLabel lblLeitura = new JLabel(statusLeitura ? "Lido" : "");
            lblLeitura.setFont(new Font("Segoe UI", Font.BOLD, 11));
            lblLeitura.setForeground(new Color(0x0754D8));
            lblLeitura.setAlignmentX(Component.LEFT_ALIGNMENT);
            bolha.add(lblLeitura);
            indicadoresLeitura.add(lblLeitura);
        }
        linha.add(bolha);
        linha.setAlignmentX(Component.LEFT_ALIGNMENT);
        linha.setMaximumSize(new Dimension(Integer.MAX_VALUE, linha.getPreferredSize().height));
        jPanelMensagens.add(linha);
        jPanelMensagens.revalidate();
        jPanelMensagens.repaint();
        SwingUtilities.invokeLater(() -> {
            JScrollBar barra = jScrollPane1.getVerticalScrollBar();
            barra.setValue(barra.getMaximum());
        });
    }

    private void adicionarMensagem(String nomeRemetente, String conteudo, String dataEnvio, int idRemetente) {
        adicionarMensagem(nomeRemetente, conteudo, dataEnvio, idRemetente, false);
    }

    private void carregarHistorico() {
        try {
            ApiClient api = new ApiClient();
            String json = api.listarMensagens(idChamado);
            com.google.gson.JsonArray mensagens = com.google.gson.JsonParser.parseString(json).getAsJsonArray();
            for (com.google.gson.JsonElement elemento : mensagens) {
                com.google.gson.JsonObject mensagem = elemento.getAsJsonObject();
                adicionarMensagem(mensagem.get("nomeRemetente").getAsString(),
                        mensagem.get("conteudo").getAsString(), mensagem.get("dataEnvio").getAsString(),
                        mensagem.get("idRemetente").getAsInt(), mensagem.get("statusLeitura").getAsBoolean());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void marcarMensagensComoLidas() {
        try {
            new ApiClient().marcarMensagensComoLidas(idChamado, idSuporte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        if (chat != null) {
            chat.desconectar();
        }
        super.dispose();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Atendimento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtAreaDescricao;
    private javax.swing.JButton btnEncerrarChamado;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanelMensagens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldAssunto;
    private javax.swing.JTextField jTextFieldDataAbertura;
    private javax.swing.JTextField jTextFieldIdChamado;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JLabel lblAssunto;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataAbertura;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDica;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblIdChamado;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JLabel lblModoChat;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblRotuloEmailCliente;
    private javax.swing.JLabel lblRotuloNomeCliente;
    private javax.swing.JLabel lblRotuloTelefoneCliente;
    private javax.swing.JLabel lblSolucao;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTelefoneCliente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloChat;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelChat;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelDescricao;
    private javax.swing.JPanel painelDireito;
    private javax.swing.JPanel painelInformacoes;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSolucao;
    private javax.swing.JTextArea txtAreaMensagem;
    private javax.swing.JTextArea txtAreaSolucao;
    // End of variables declaration//GEN-END:variables
}
