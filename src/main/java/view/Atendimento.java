/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import api.ApiClient;
import api.ChatWebSocketClient;
import javax.swing.JOptionPane;

/**
 *
 * @author ywdyl
 */
public class Atendimento extends javax.swing.JFrame {

    private int idSuporte;
    private int idChamado;
    private boolean modoHistorico = false;
    private String assunto, descricao, data, status, nome;
    private ChatWebSocketClient chat;
    private final java.util.List<javax.swing.JLabel> indicadoresLeitura = new java.util.ArrayList<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Atendimento.class.getName());

    /**
     * Creates new form Atendimento
     */
    public Atendimento() {
        initComponents();
    }

    public Atendimento(int idChamado, String assunto, String descricao,
            String data, String status, String nome,
            String email, String telefone, int idSuporte) {

        this(idChamado, assunto, descricao, data, status,
                nome, email, telefone, idSuporte, false);
    }

    public Atendimento(int idChamado, String assunto, String descricao, String data, String status, String nome, String email, String telefone, int idSuporte, boolean modoHistorico) {
        initComponents();
        txtAreaSolucao.setEditable(false);
        jPanelMensagens.setLayout(new javax.swing.BoxLayout(jPanelMensagens, javax.swing.BoxLayout.Y_AXIS));
        this.idChamado = idChamado;
        this.idSuporte = idSuporte;
        this.modoHistorico = modoHistorico;
        if (!modoHistorico) {
            marcarMensagensComoLidas();
        }

        carregarHistorico();
        this.assunto = assunto;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        jTextFieldIdChamado.setText(String.valueOf(idChamado));
        jTextFieldAssunto.setText(assunto);
        jTextFieldDataAbertura.setText(data);
        jTextFieldStatus.setText(status);
        TxtAreaDescricao.setText(descricao);
        lblNomeCliente.setText(nome);
        lblEmailCliente.setText(email);
        lblTelefoneCliente.setText(telefone);
        if (modoHistorico) {
            btnEnviar.setEnabled(false);
            btnEncerrarChamado.setEnabled(false);

            txtAreaMensagem.setEditable(false);
            txtAreaSolucao.setEditable(false);
        }
        if (!modoHistorico) {
            try {
                chat = new ChatWebSocketClient(idChamado);
                chat.setAoReceberMensagem(json -> {
                    javax.swing.SwingUtilities.invokeLater(() -> {

                        com.google.gson.JsonObject mensagem
                                = com.google.gson.JsonParser.parseString(json).getAsJsonObject();

                        int idRemetente = mensagem.get("idRemetente").getAsInt();
                        String nomeRemetente = mensagem.get("nomeRemetente").getAsString();
                        String conteudo = mensagem.get("conteudo").getAsString();
                        String dataEnvio = mensagem.get("dataEnvio").getAsString();
                        boolean statusLeitura = mensagem.get("statusLeitura").getAsBoolean();

                        adicionarMensagem(
                                nomeRemetente,
                                conteudo,
                                dataEnvio,
                                idRemetente,
                                statusLeitura
                        );
                    });
                });
                chat.setAoReceberLeitura(idUsuario -> {

                    javax.swing.SwingUtilities.invokeLater(() -> {

                        // Verifica se quem leu foi o cliente (ID 1)
                        if (idUsuario != idSuporte) {

                            for (javax.swing.JLabel indicador : indicadoresLeitura) {
                                indicador.setText("Lido");
                            }

                            jPanelMensagens.revalidate();
                            jPanelMensagens.repaint();
                        }
                    });
                });
                chat.connect();
            } catch (Exception e) {
                System.out.println("Erro ao conectar ao chat: " + e.getMessage());
            }

        }
    }

    public void exibirSolucao(String solucao) {
        txtAreaSolucao.setText(solucao == null ? "" : solucao);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackGround1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNomeCliente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdChamado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAssunto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jTextFieldDataAbertura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblTelefoneCliente = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnEncerrarChamado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelMensagens = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMensagem = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        PainelAreaDescricao = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtAreaDescricao = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaSolucao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("numerodochamado");

        jLabelNomeCliente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNomeCliente.setText("nome");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Tipo de problema");

        jLabelTipo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTipo.setText("tipoproblema");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Status");

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelStatus.setText("StatusChamado");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Tipo de conta");

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNomeUsuario.setText("Nome do usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeCliente)
                    .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipo)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabelNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblNomeUsuario))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTipo)
                        .addComponent(jLabelStatus)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Informações do chamado");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("ID do chamado:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Assunto:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Status:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Data abertura:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAssunto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldIdChamado)
                    .addComponent(jTextFieldStatus)
                    .addComponent(jTextFieldDataAbertura, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(57, 57, 57))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setPreferredSize(new java.awt.Dimension(403, 220));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Informações do usuário");

        jLabel15.setText("user");

        lblNomeCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomeCliente.setText("nome do cliente");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaAtendimento/email.32px.png"))); // NOI18N

        lblEmailCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmailCliente.setText("Email");

        jLabel19.setText("tel");

        lblTelefoneCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefoneCliente.setText("telefone");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setText("Ver Perfil do usuario");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(27, 27, 27)
                                .addComponent(lblNomeCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton2)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEmailCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefoneCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setText("Enviar link de redefinição de senha");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setText("Consultar conta");

        btnEncerrarChamado.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEncerrarChamado.setText("Encerrar chamado");
        btnEncerrarChamado.addActionListener(this::btnEncerrarChamadoActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEncerrarChamado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEncerrarChamado)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanelMensagens.setLayout(new javax.swing.BoxLayout(jPanelMensagens, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(jPanelMensagens);

        txtAreaMensagem.setColumns(20);
        txtAreaMensagem.setRows(5);
        jScrollPane2.setViewportView(txtAreaMensagem);

        btnEnviar.setText("send");
        btnEnviar.addActionListener(this::btnEnviarActionPerformed);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel22.setText("Chamd");
        jLabel22.setPreferredSize(new java.awt.Dimension(32, 32));

        jLabel23.setBackground(new java.awt.Color(49, 116, 195));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(21, 101, 192));
        jLabel23.setText("chamados");

        jLabel24.setText("perfil");
        jLabel24.setPreferredSize(new java.awt.Dimension(32, 32));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("meu perfil");

        btnVoltar.setText("voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 584, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setText("Atendimento de chamados");

        PainelAreaDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        TxtAreaDescricao.setColumns(20);
        TxtAreaDescricao.setRows(5);
        jScrollPane3.setViewportView(TxtAreaDescricao);

        javax.swing.GroupLayout PainelAreaDescricaoLayout = new javax.swing.GroupLayout(PainelAreaDescricao);
        PainelAreaDescricao.setLayout(PainelAreaDescricaoLayout);
        PainelAreaDescricaoLayout.setHorizontalGroup(
            PainelAreaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAreaDescricaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        PainelAreaDescricaoLayout.setVerticalGroup(
            PainelAreaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAreaDescricaoLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtAreaSolucao.setColumns(20);
        txtAreaSolucao.setRows(5);
        jScrollPane4.setViewportView(txtAreaSolucao);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanelBackGround1Layout = new javax.swing.GroupLayout(jPanelBackGround1);
        jPanelBackGround1.setLayout(jPanelBackGround1Layout);
        jPanelBackGround1Layout.setHorizontalGroup(
            jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(jLabel26))
                    .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PainelAreaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBackGround1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanelBackGround1Layout.setVerticalGroup(
            jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(12, 12, 12)
                .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                        .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBackGround1Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(PainelAreaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBackGround1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String conteudo = txtAreaMensagem.getText().trim();

        if (conteudo.isEmpty()) {
            return;
        }

        if (chat != null && chat.isOpen()) {

            chat.enviarMensagem(conteudo, idSuporte);

            txtAreaMensagem.setText("");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnEncerrarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarChamadoActionPerformed
        if (!txtAreaSolucao.isEditable()) {
            txtAreaSolucao.setEditable(true);
            txtAreaSolucao.requestFocusInWindow();

            JOptionPane.showMessageDialog(this, "Descreva a solução e clique novamente em Encerrar chamado.");
            return;
        }

        String solucao = txtAreaSolucao.getText().trim();

        if (solucao.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Informe a solução antes de encerrar o chamado.");
            return;
        }

        try {
            ApiClient api = new ApiClient();

            api.encerrarChamado(idChamado, solucao);

            jTextFieldStatus.setText("fechado");

            txtAreaSolucao.setEditable(false);
            txtAreaMensagem.setEnabled(false);
            btnEnviar.setEnabled(false);
            btnEncerrarChamado.setEnabled(false);

            JOptionPane.showMessageDialog(this,
                    "Chamado encerrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao encerrar chamado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEncerrarChamadoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void adicionarMensagem(
            String nomeRemetente,
            String conteudo,
            String dataEnvio,
            int idRemetente,
            boolean statusLeitura) {

        javax.swing.JPanel linha = new javax.swing.JPanel(
                new java.awt.FlowLayout(
                        idRemetente == idSuporte
                                ? java.awt.FlowLayout.RIGHT
                                : java.awt.FlowLayout.LEFT
                )
        );

        javax.swing.JPanel bolha = new javax.swing.JPanel();
        bolha.setLayout(new javax.swing.BoxLayout(
                bolha, javax.swing.BoxLayout.Y_AXIS));

        bolha.setBorder(javax.swing.BorderFactory.createEmptyBorder(
                10, 15, 10, 15));

        javax.swing.JLabel lblNome = new javax.swing.JLabel(nomeRemetente);
        javax.swing.JLabel lblConteudo = new javax.swing.JLabel(conteudo);
        javax.swing.JLabel lblData = new javax.swing.JLabel(dataEnvio);

        bolha.add(lblNome);
        bolha.add(lblConteudo);
        bolha.add(lblData);

        if (idRemetente == idSuporte) {

            javax.swing.JLabel lblLeitura = new javax.swing.JLabel(
                    statusLeitura ? "Lido" : ""
            );

            bolha.add(lblLeitura);

            indicadoresLeitura.add(lblLeitura);
        }

        linha.add(bolha);

        linha.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        linha.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE,
                linha.getPreferredSize().height));

        jPanelMensagens.add(linha);
        jPanelMensagens.revalidate();
        jPanelMensagens.repaint();
    }

    private void carregarHistorico() {
        try {
            ApiClient api = new ApiClient();

            String json = api.listarMensagens(idChamado);

            com.google.gson.JsonArray mensagens = com.google.gson.JsonParser.parseString(json).getAsJsonArray();

            for (com.google.gson.JsonElement elemento : mensagens) {

                com.google.gson.JsonObject mensagem = elemento.getAsJsonObject();

                int idRemetente = mensagem.get("idRemetente").getAsInt();
                String nomeRemetente = mensagem.get("nomeRemetente").getAsString();
                String conteudo = mensagem.get("conteudo").getAsString();
                String dataEnvio = mensagem.get("dataEnvio").getAsString();
                boolean statusLeitura = mensagem.get("statusLeitura").getAsBoolean();

                adicionarMensagem(
                        nomeRemetente,
                        conteudo,
                        dataEnvio,
                        idRemetente,
                        statusLeitura
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionarMensagem(String nomeRemetente, String conteudo, String dataEnvio, int idRemetente) {

        javax.swing.JPanel linha = new javax.swing.JPanel(new java.awt.FlowLayout(idRemetente == idSuporte ? java.awt.FlowLayout.RIGHT : java.awt.FlowLayout.LEFT)
        );

        javax.swing.JPanel bolha = new javax.swing.JPanel();
        bolha.setLayout(new javax.swing.BoxLayout(bolha, javax.swing.BoxLayout.Y_AXIS));

        bolha.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));

        javax.swing.JLabel lblNome = new javax.swing.JLabel(nomeRemetente);
        javax.swing.JLabel lblConteudo = new javax.swing.JLabel(conteudo);
        javax.swing.JLabel lblData = new javax.swing.JLabel(dataEnvio);

        bolha.add(lblNome);
        bolha.add(lblConteudo);
        bolha.add(lblData);

        linha.add(bolha);

        linha.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        linha.setMaximumSize(new java.awt.Dimension(
                Integer.MAX_VALUE,
                linha.getPreferredSize().height));

        jPanelMensagens.add(linha);
        jPanelMensagens.revalidate();
        jPanelMensagens.repaint();
    }

    private void marcarMensagensComoLidas() {
        try {
            ApiClient api = new ApiClient();

            api.marcarMensagensComoLidas(idChamado, idSuporte);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Atendimento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelAreaDescricao;
    private javax.swing.JTextArea TxtAreaDescricao;
    private javax.swing.JButton btnEncerrarChamado;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelBackGround1;
    private javax.swing.JPanel jPanelMensagens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldAssunto;
    private javax.swing.JTextField jTextFieldDataAbertura;
    private javax.swing.JTextField jTextFieldIdChamado;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblTelefoneCliente;
    private javax.swing.JTextArea txtAreaMensagem;
    private javax.swing.JTextArea txtAreaSolucao;
    // End of variables declaration//GEN-END:variables
}
