/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import api.ApiClient;
import api.ChamadosWebSocketClient;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ywdyl
 */
public class ChamadosDisponiveis extends javax.swing.JFrame {

    private int idSuporte;
    private final java.util.Map<Integer, String> descricoesChamados = new java.util.HashMap<>();
    private final java.util.Map<Integer, String> emailUsuario = new java.util.HashMap<>();
    private final java.util.Map<Integer, String> telefoneUsuario = new java.util.HashMap<>();
    private final java.util.Map<Integer, String> solucoesChamados = new java.util.HashMap<>();
    private final java.util.Map<Integer, Integer> suportesResponsaveis = new java.util.HashMap<>();
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> filtroChamados;
    private ChamadosWebSocketClient websocketChamados;
    private boolean recarregandoChamados;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChamadosDisponiveis.class.getName());

    /**
     * Creates new form ChamadosDisponiveis
     */
    public ChamadosDisponiveis() {
        initComponents();
        configurarVisual();
        TableChamadosDisponiveis.setDefaultEditor(Object.class, null);
        filtroChamados = new javax.swing.table.TableRowSorter<>(
                (javax.swing.table.DefaultTableModel) TableChamadosDisponiveis.getModel()
        );

        TableChamadosDisponiveis.setRowSorter(filtroChamados);
        carregarChamados();
        conectarWebSocketChamados();

    }

    public ChamadosDisponiveis(int idSuporte) {
        initComponents();
        configurarVisual();
        TableChamadosDisponiveis.setDefaultEditor(Object.class, null);
        filtroChamados = new javax.swing.table.TableRowSorter<>(
                (javax.swing.table.DefaultTableModel) TableChamadosDisponiveis.getModel()
        );

        TableChamadosDisponiveis.setRowSorter(filtroChamados);
        this.idSuporte = idSuporte;
        carregarChamados();
        conectarWebSocketChamados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelMenu = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        lblMarcaSub = new javax.swing.JLabel();
        btnChamados = new javax.swing.JButton();
        btnMeusChamados = new javax.swing.JButton();
        btnMeuPerfil = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        painelConteudo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        painelLista = new javax.swing.JPanel();
        painelIndicadores = new javax.swing.JPanel();
        cardAbertos = new javax.swing.JPanel();
        lblTituloAbertos = new javax.swing.JLabel();
        lblAbertos = new javax.swing.JLabel();
        cardAndamento = new javax.swing.JPanel();
        lblTituloAndamento = new javax.swing.JLabel();
        lblAndamento = new javax.swing.JLabel();
        cardEncerrados = new javax.swing.JPanel();
        lblTituloEncerrados = new javax.swing.JLabel();
        lblEncerrados = new javax.swing.JLabel();
        painelFiltros = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        lblFiltroStatus = new javax.swing.JLabel();
        jComboBoxStatusChamados = new javax.swing.JComboBox<>();
        painelTabela = new javax.swing.JPanel();
        scrollChamados = new javax.swing.JScrollPane();
        TableChamadosDisponiveis = new javax.swing.JTable();
        painelDireito = new javax.swing.JPanel();
        painelDetalhes = new javax.swing.JPanel();
        lblDetalhes = new javax.swing.JLabel();
        lblIdChamado = new javax.swing.JLabel();
        lblAssunto = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblDataAbertura = new javax.swing.JLabel();
        lblStatusChamado = new javax.swing.JLabel();
        jTextFieldIdChamado = new javax.swing.JTextField();
        jTextFieldAssunto = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldDataAbertura = new javax.swing.JTextField();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        painelDescricao = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        scrollDescricao = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        painelSolucao = new javax.swing.JPanel();
        lblSolucao = new javax.swing.JLabel();
        scrollSolucao = new javax.swing.JScrollPane();
        jTextAreaResposta = new javax.swing.JTextArea();
        painelAcoes = new javax.swing.JPanel();
        jButtonAtender = new javax.swing.JButton();
        btnConsultarHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ContrataJá Suporte | Chamados");

        painelPrincipal.setBackground(new java.awt.Color(243, 246, 252));

        painelMenu.setBackground(new java.awt.Color(255, 255, 255));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(6, 77, 199));
        lblMarca.setText("ContrataJá");

        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMarcaSub.setForeground(new java.awt.Color(82, 103, 133));
        lblMarcaSub.setText("SUPORTE");

        btnChamados.setBackground(new java.awt.Color(7, 84, 216));
        btnChamados.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnChamados.setForeground(new java.awt.Color(255, 255, 255));
        btnChamados.setText("Chamados");

        btnMeusChamados.setBackground(new java.awt.Color(237, 243, 253));
        btnMeusChamados.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMeusChamados.setForeground(new java.awt.Color(36, 59, 98));
        btnMeusChamados.setText("Meus chamados");
        btnMeusChamados.addActionListener(this::btnMeusChamadosActionPerformed);

        btnMeuPerfil.setBackground(new java.awt.Color(237, 243, 253));
        btnMeuPerfil.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMeuPerfil.setForeground(new java.awt.Color(36, 59, 98));
        btnMeuPerfil.setText("Meu perfil");
        btnMeuPerfil.addActionListener(this::btnMeuPerfilActionPerformed);

        btnSair.setBackground(new java.awt.Color(237, 243, 253));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSair.setForeground(new java.awt.Color(36, 59, 98));
        btnSair.setText("Sair");
        btnSair.addActionListener(this::btnSairActionPerformed);

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMarcaSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChamados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMeusChamados, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(btnMeuPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnMeusChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnMeuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        painelConteudo.setBackground(new java.awt.Color(243, 246, 252));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(24, 36, 60));
        lblTitulo.setText("Chamados");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(82, 103, 133));
        lblSubtitulo.setText("Acompanhe, assuma e consulte os chamados de suporte.");

        painelLista.setBackground(new java.awt.Color(243, 246, 252));

        painelIndicadores.setBackground(new java.awt.Color(243, 246, 252));

        cardAbertos.setBackground(new java.awt.Color(255, 243, 217));

        lblTituloAbertos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTituloAbertos.setForeground(new java.awt.Color(24, 36, 60));
        lblTituloAbertos.setText("Abertos");

        lblAbertos.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblAbertos.setForeground(new java.awt.Color(149, 96, 6));
        lblAbertos.setText("0");

        javax.swing.GroupLayout cardAbertosLayout = new javax.swing.GroupLayout(cardAbertos);
        cardAbertos.setLayout(cardAbertosLayout);
        cardAbertosLayout.setHorizontalGroup(
            cardAbertosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAbertosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cardAbertosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloAbertos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAbertos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        cardAbertosLayout.setVerticalGroup(
            cardAbertosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAbertosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTituloAbertos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblAbertos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        cardAndamento.setBackground(new java.awt.Color(231, 240, 255));

        lblTituloAndamento.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTituloAndamento.setForeground(new java.awt.Color(24, 36, 60));
        lblTituloAndamento.setText("Em atendimento");

        lblAndamento.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblAndamento.setForeground(new java.awt.Color(7, 84, 216));
        lblAndamento.setText("0");

        javax.swing.GroupLayout cardAndamentoLayout = new javax.swing.GroupLayout(cardAndamento);
        cardAndamento.setLayout(cardAndamentoLayout);
        cardAndamentoLayout.setHorizontalGroup(
            cardAndamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAndamentoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cardAndamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloAndamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAndamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        cardAndamentoLayout.setVerticalGroup(
            cardAndamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardAndamentoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTituloAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        cardEncerrados.setBackground(new java.awt.Color(232, 247, 238));

        lblTituloEncerrados.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTituloEncerrados.setForeground(new java.awt.Color(24, 36, 60));
        lblTituloEncerrados.setText("Encerrados");

        lblEncerrados.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblEncerrados.setForeground(new java.awt.Color(19, 115, 70));
        lblEncerrados.setText("0");

        javax.swing.GroupLayout cardEncerradosLayout = new javax.swing.GroupLayout(cardEncerrados);
        cardEncerrados.setLayout(cardEncerradosLayout);
        cardEncerradosLayout.setHorizontalGroup(
            cardEncerradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardEncerradosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cardEncerradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloEncerrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncerrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        cardEncerradosLayout.setVerticalGroup(
            cardEncerradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardEncerradosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTituloEncerrados, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblEncerrados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout painelIndicadoresLayout = new javax.swing.GroupLayout(painelIndicadores);
        painelIndicadores.setLayout(painelIndicadoresLayout);
        painelIndicadoresLayout.setHorizontalGroup(
            painelIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIndicadoresLayout.createSequentialGroup()
                .addComponent(cardAbertos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(cardAndamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(cardEncerrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelIndicadoresLayout.setVerticalGroup(
            painelIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardAbertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cardAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cardEncerrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painelFiltros.setBackground(new java.awt.Color(255, 255, 255));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(24, 36, 60));
        lblBuscar.setText("Buscar:");

        jTextFieldBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        lblFiltroStatus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFiltroStatus.setForeground(new java.awt.Color(24, 36, 60));
        lblFiltroStatus.setText("Status:");

        jComboBoxStatusChamados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jComboBoxStatusChamados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Abertos", "Em atendimento", "Fechados" }));
        jComboBoxStatusChamados.addActionListener(this::jComboBoxStatusChamadosActionPerformed);

        javax.swing.GroupLayout painelFiltrosLayout = new javax.swing.GroupLayout(painelFiltros);
        painelFiltros.setLayout(painelFiltrosLayout);
        painelFiltrosLayout.setHorizontalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBuscar)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldBuscar, 0, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblFiltroStatus)
                .addGap(8, 8, 8)
                .addComponent(jComboBoxStatusChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        painelFiltrosLayout.setVerticalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatusChamados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        painelTabela.setBackground(new java.awt.Color(255, 255, 255));

        TableChamadosDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Assunto", "Usuário", "Tipo", "Data de abertura", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableChamadosDisponiveis.setRowHeight(44);
        TableChamadosDisponiveis.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TableChamadosDisponiveis.setForeground(new java.awt.Color(24, 36, 60));
        TableChamadosDisponiveis.setBackground(new java.awt.Color(255, 255, 255));
        TableChamadosDisponiveis.setGridColor(new java.awt.Color(231, 237, 246));
        TableChamadosDisponiveis.setSelectionBackground(new java.awt.Color(220, 234, 255));
        TableChamadosDisponiveis.setSelectionForeground(new java.awt.Color(24, 36, 60));
        TableChamadosDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableChamadosDisponiveisMouseClicked(evt);
            }
        });
        scrollChamados.setViewportView(TableChamadosDisponiveis);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollChamados, 0, 680, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollChamados, 0, 430, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout painelListaLayout = new javax.swing.GroupLayout(painelLista);
        painelLista.setLayout(painelListaLayout);
        painelListaLayout.setHorizontalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelIndicadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelListaLayout.setVerticalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaLayout.createSequentialGroup()
                .addComponent(painelIndicadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(painelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(painelTabela, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelDireito.setBackground(new java.awt.Color(243, 246, 252));

        painelDetalhes.setBackground(new java.awt.Color(255, 255, 255));

        lblDetalhes.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblDetalhes.setForeground(new java.awt.Color(24, 36, 60));
        lblDetalhes.setText("Detalhes do chamado");

        lblIdChamado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdChamado.setForeground(new java.awt.Color(24, 36, 60));
        lblIdChamado.setText("ID do chamado:");

        lblAssunto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAssunto.setForeground(new java.awt.Color(24, 36, 60));
        lblAssunto.setText("Assunto:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(24, 36, 60));
        lblUsuario.setText("Usuário:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(24, 36, 60));
        lblTipo.setText("Tipo:");

        lblDataAbertura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDataAbertura.setForeground(new java.awt.Color(24, 36, 60));
        lblDataAbertura.setText("Data de abertura:");

        lblStatusChamado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatusChamado.setForeground(new java.awt.Color(24, 36, 60));
        lblStatusChamado.setText("Status:");

        jTextFieldIdChamado.setEditable(false);
        jTextFieldIdChamado.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldIdChamado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldIdChamado.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldAssunto.setEditable(false);
        jTextFieldAssunto.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldAssunto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldAssunto.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldUsuario.setEditable(false);
        jTextFieldUsuario.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldUsuario.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldTipo.setEditable(false);
        jTextFieldTipo.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldTipo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldTipo.setForeground(new java.awt.Color(24, 36, 60));

        jTextFieldDataAbertura.setEditable(false);
        jTextFieldDataAbertura.setBackground(new java.awt.Color(248, 250, 253));
        jTextFieldDataAbertura.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextFieldDataAbertura.setForeground(new java.awt.Color(24, 36, 60));

        jComboBoxStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aberto", "em_atendimento", "fechado" }));
        jComboBoxStatus.setEnabled(false);

        javax.swing.GroupLayout painelDetalhesLayout = new javax.swing.GroupLayout(painelDetalhes);
        painelDetalhes.setLayout(painelDetalhesLayout);
        painelDetalhesLayout.setHorizontalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDetalhesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDetalhesLayout.createSequentialGroup()
                        .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdChamado)
                            .addComponent(lblAssunto)
                            .addComponent(lblUsuario)
                            .addComponent(lblTipo)
                            .addComponent(lblDataAbertura)
                            .addComponent(lblStatusChamado))
                        .addGap(10, 10, 10)
                        .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdChamado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAssunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDataAbertura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        painelDetalhesLayout.setVerticalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDetalhesLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(24, 36, 60));
        lblDescricao.setText("Descrição");

        jTextAreaDescricao.setEditable(false);
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setWrapStyleWord(true);
        jTextAreaDescricao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextAreaDescricao.setBackground(new java.awt.Color(248, 250, 253));
        jTextAreaDescricao.setForeground(new java.awt.Color(24, 36, 60));
        scrollDescricao.setViewportView(jTextAreaDescricao);

        javax.swing.GroupLayout painelDescricaoLayout = new javax.swing.GroupLayout(painelDescricao);
        painelDescricao.setLayout(painelDescricaoLayout);
        painelDescricaoLayout.setHorizontalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollDescricao))
                .addGap(14, 14, 14))
        );
        painelDescricaoLayout.setVerticalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(scrollDescricao, 0, 86, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        painelSolucao.setBackground(new java.awt.Color(255, 255, 255));

        lblSolucao.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblSolucao.setForeground(new java.awt.Color(24, 36, 60));
        lblSolucao.setText("Solução");

        jTextAreaResposta.setEditable(false);
        jTextAreaResposta.setLineWrap(true);
        jTextAreaResposta.setWrapStyleWord(true);
        jTextAreaResposta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextAreaResposta.setBackground(new java.awt.Color(248, 250, 253));
        jTextAreaResposta.setForeground(new java.awt.Color(24, 36, 60));
        scrollSolucao.setViewportView(jTextAreaResposta);

        javax.swing.GroupLayout painelSolucaoLayout = new javax.swing.GroupLayout(painelSolucao);
        painelSolucao.setLayout(painelSolucaoLayout);
        painelSolucaoLayout.setHorizontalGroup(
            painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolucaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollSolucao))
                .addGap(14, 14, 14))
        );
        painelSolucaoLayout.setVerticalGroup(
            painelSolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolucaoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(scrollSolucao, 0, 76, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        painelAcoes.setBackground(new java.awt.Color(243, 246, 252));

        jButtonAtender.setBackground(new java.awt.Color(7, 84, 216));
        jButtonAtender.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButtonAtender.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtender.setText("Atender chamado");
        jButtonAtender.addActionListener(this::jButtonAtenderActionPerformed);

        btnConsultarHistorico.setBackground(new java.awt.Color(237, 243, 253));
        btnConsultarHistorico.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConsultarHistorico.setForeground(new java.awt.Color(36, 59, 98));
        btnConsultarHistorico.setText("Consultar histórico");
        btnConsultarHistorico.addActionListener(this::btnConsultarHistoricoActionPerformed);

        javax.swing.GroupLayout painelAcoesLayout = new javax.swing.GroupLayout(painelAcoes);
        painelAcoes.setLayout(painelAcoesLayout);
        painelAcoesLayout.setHorizontalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcoesLayout.createSequentialGroup()
                .addComponent(jButtonAtender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnConsultarHistorico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAcoesLayout.setVerticalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnConsultarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout painelDireitoLayout = new javax.swing.GroupLayout(painelDireito);
        painelDireito.setLayout(painelDireitoLayout);
        painelDireitoLayout.setHorizontalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelDireitoLayout.setVerticalGroup(
            painelDireitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitoLayout.createSequentialGroup()
                .addComponent(painelDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(painelDescricao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(painelSolucao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelConteudoLayout.createSequentialGroup()
                        .addComponent(painelLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(painelDireito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConteudoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDireito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        int linha = TableChamadosDisponiveis.getSelectedRow();

        if (linha == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um chamado para atender.");
            return;
        }

        String status = TableChamadosDisponiveis.getValueAt(linha, 5).toString();

        if (!status.equalsIgnoreCase("aberto")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este chamado não está disponível para atendimento.");
            return;
        }
        int idChamado = Integer.parseInt(TableChamadosDisponiveis.getValueAt(linha, 0).toString());
        String assunto = TableChamadosDisponiveis.getValueAt(linha, 1).toString();
        String descricao = descricoesChamados.get(idChamado);
        String data = TableChamadosDisponiveis.getValueAt(linha, 4).toString();
        String nome = TableChamadosDisponiveis.getValueAt(linha, 2).toString();
        String email = emailUsuario.get(idChamado);
        String telefone = telefoneUsuario.get(idChamado);
        try {
            ApiClient api = new ApiClient();

            api.assumirChamado(idChamado, idSuporte);
            status = "em_atendimento";
            Atendimento telaAtendimento = new Atendimento(
                    idChamado, assunto, descricao, data, status,
                    nome, email, telefone, idSuporte);

            telaAtendimento.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível assumir o chamado: " + e.getMessage());
        }

    }//GEN-LAST:event_jButtonAtenderActionPerformed

    private void TableChamadosDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableChamadosDisponiveisMouseClicked
        int linha = TableChamadosDisponiveis.getSelectedRow();

        atualizarDetalhesChamado();
        if (evt.getClickCount() == 2) {

            if (linha == -1) {
                return;
            }

            String status = TableChamadosDisponiveis
                    .getValueAt(linha, 5).toString();

            if ("em_atendimento".equalsIgnoreCase(status)) {

                int idChamado = Integer.parseInt(
                        TableChamadosDisponiveis.getValueAt(linha, 0).toString()
                );

                Integer idResponsavel = suportesResponsaveis.get(idChamado);

                if (idResponsavel != null && idResponsavel == idSuporte) {

                    String assunto = TableChamadosDisponiveis.getValueAt(linha, 1).toString();
                    String nome = TableChamadosDisponiveis.getValueAt(linha, 2).toString();
                    String data = TableChamadosDisponiveis.getValueAt(linha, 4).toString();

                    String descricao = descricoesChamados.get(idChamado);
                    String email = emailUsuario.get(idChamado);
                    String telefone = telefoneUsuario.get(idChamado);

                    Atendimento telaAtendimento = new Atendimento(
                            idChamado, assunto, descricao, data, status,
                            nome, email, telefone, idSuporte
                    );

                    telaAtendimento.setVisible(true);
                } else {

                    JOptionPane.showMessageDialog(this,
                            "Este chamado já está em atendimento por outro suporte.");

                }
            }
        }
    }//GEN-LAST:event_TableChamadosDisponiveisMouseClicked

    private void btnConsultarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistoricoActionPerformed
        int linha = TableChamadosDisponiveis.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um chamado para consultar.");
            return;
        }

        String status = TableChamadosDisponiveis
                .getValueAt(linha, 5).toString();

        if (!"fechado".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(this,
                    "O histórico está disponível apenas para chamados encerrados.",
                    "Consulta de histórico",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int idChamado = Integer.parseInt(
                TableChamadosDisponiveis.getValueAt(linha, 0).toString()
        );

        String assunto = TableChamadosDisponiveis.getValueAt(linha, 1).toString();
        String nome = TableChamadosDisponiveis.getValueAt(linha, 2).toString();
        String data = TableChamadosDisponiveis.getValueAt(linha, 4).toString();

        String descricao = descricoesChamados.get(idChamado);
        String email = emailUsuario.get(idChamado);
        String telefone = telefoneUsuario.get(idChamado);

        Atendimento telaHistorico = new Atendimento(
                idChamado, assunto, descricao, data, status,
                nome, email, telefone, idSuporte, true
        );

        telaHistorico.exibirSolucao(solucoesChamados.get(idChamado));

        telaHistorico.setVisible(true);
    }//GEN-LAST:event_btnConsultarHistoricoActionPerformed


    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
        aplicarFiltros();
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void jComboBoxStatusChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusChamadosActionPerformed
        aplicarFiltros();
    }//GEN-LAST:event_jComboBoxStatusChamadosActionPerformed

    private void btnMeuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeuPerfilActionPerformed
        for (Window janela : Window.getWindows()) {

            if (janela instanceof TelaMeuPerfilUsuario && janela.isDisplayable()) {

                janela.setVisible(true);
                janela.toFront();
                return;
            }
        }

        TelaMeuPerfilUsuario tela = new TelaMeuPerfilUsuario(idSuporte);
        tela.setVisible(true);
    }//GEN-LAST:event_btnMeuPerfilActionPerformed

    private void btnMeusChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeusChamadosActionPerformed
        MeusChamados tela = new MeusChamados(idSuporte);
        tela.setVisible(true);
    }//GEN-LAST:event_btnMeusChamadosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            for (Window janela : Window.getWindows()) {
                janela.dispose();
            }

            new LoginSuporte().setVisible(true);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void aplicarFiltros() {

        String texto = jTextFieldBuscar.getText().trim();
        String status = (String) jComboBoxStatusChamados.getSelectedItem();

        java.util.List<javax.swing.RowFilter<javax.swing.table.DefaultTableModel, Integer>> filtros
                = new java.util.ArrayList<>();

        // Filtro de pesquisa
        if (!texto.isEmpty()) {
            filtros.add(javax.swing.RowFilter.regexFilter(
                    "(?i)" + java.util.regex.Pattern.quote(texto)
            ));
        }

        // Filtro por status
        String statusBanco = null;

        if ("Abertos".equals(status)) {
            statusBanco = "aberto";
        } else if ("Em atendimento".equals(status)) {
            statusBanco = "em_atendimento";
        } else if ("Fechados".equals(status)) {
            statusBanco = "fechado";
        }

        if (statusBanco != null) {
            filtros.add(javax.swing.RowFilter.regexFilter(
                    "^" + statusBanco + "$", 5
            ));
        }

        if (filtroChamados == null) {
            return;
        }
        filtroChamados.setRowFilter(
                filtros.isEmpty() ? null : javax.swing.RowFilter.andFilter(filtros)
        );
        atualizarDetalhesChamado();
    }

    private void carregarChamados() {
        int linhaSelecionada = TableChamadosDisponiveis.getSelectedRow();

        Integer idSelecionado = null;

        if (linhaSelecionada != -1) {
            idSelecionado = Integer.parseInt(
                    TableChamadosDisponiveis
                            .getValueAt(linhaSelecionada, 0).toString()
            );
        }
        try {
            ApiClient api = new ApiClient();
            String resposta = api.listarChamados();

            com.google.gson.JsonArray chamados = com.google.gson.JsonParser.parseString(resposta).getAsJsonArray();

            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) TableChamadosDisponiveis.getModel();

            recarregandoChamados = true;
            modelo.setRowCount(0);
            descricoesChamados.clear();
            emailUsuario.clear();
            telefoneUsuario.clear();
            solucoesChamados.clear();
            suportesResponsaveis.clear();

            for (com.google.gson.JsonElement elemento : chamados) {
                com.google.gson.JsonObject chamado = elemento.getAsJsonObject();

                int id = chamado.get("idChamado").getAsInt();
                if (chamado.has("suporte")
                        && !chamado.get("suporte").isJsonNull()) {

                    int idResponsavel = chamado
                            .getAsJsonObject("suporte")
                            .get("idUsuario")
                            .getAsInt();

                    suportesResponsaveis.put(id, idResponsavel);
                }
                String solucao = chamado.has("solucao") && !chamado.get("solucao").isJsonNull() ? chamado.get("solucao").getAsString() : "";

                solucoesChamados.put(id, solucao);
                String assunto = chamado.get("assunto").getAsString();
                String descricao = chamado.get("descricao").getAsString();
                descricoesChamados.put(id, descricao);
                String usuario = chamado.getAsJsonObject("usuario").get("nome").getAsString();
                String email = chamado.getAsJsonObject("usuario").get("email").getAsString();
                emailUsuario.put(id, email);
                String telefone = chamado.getAsJsonObject("usuario").get("telefone").getAsString();
                telefoneUsuario.put(id, telefone);
                String dataOriginal = chamado.get("dataAbertura").getAsString();
                java.time.LocalDateTime dataHora = java.time.LocalDateTime.parse(dataOriginal);
                String data = dataHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                String status = chamado.get("status").getAsString();

                com.google.gson.JsonObject dadosUsuario = chamado.getAsJsonObject("usuario");
                String tipo = dadosUsuario.has("tipoUsuario") && !dadosUsuario.get("tipoUsuario").isJsonNull()
                        ? dadosUsuario.get("tipoUsuario").getAsString() : "";
                modelo.addRow(new Object[]{id, assunto, usuario, tipo, data, status});
            }

            if (idSelecionado != null) {

                for (int i = 0; i < TableChamadosDisponiveis.getRowCount(); i++) {

                    int idAtual = Integer.parseInt(
                            TableChamadosDisponiveis.getValueAt(i, 0).toString()
                    );

                    if (idAtual == idSelecionado) {

                        TableChamadosDisponiveis.setRowSelectionInterval(i, i);

                        break;
                    }
                }
            }

            atualizarIndicadores();
            atualizarDetalhesChamado();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar chamados: " + e.getMessage());
        } finally {
            recarregandoChamados = false;
        }
    }

    private void conectarWebSocketChamados() {

        try {
            websocketChamados = new ChamadosWebSocketClient();

            websocketChamados.setAoReceberAtualizacao(evento -> {

                System.out.println("Evento recebido: " + evento);

                javax.swing.SwingUtilities.invokeLater(() -> {
                    if (isDisplayable()) {
                        carregarChamados();
                    }
                });

            });

            websocketChamados.connect();

        } catch (Exception e) {
            System.out.println("Erro ao conectar WebSocket: "
                    + e.getMessage());
        }
    }

    private void atualizarDetalhesChamado() {

        int linha = TableChamadosDisponiveis.getSelectedRow();

        if (linha == -1) {
            jTextFieldIdChamado.setText("");
            jTextFieldAssunto.setText("");
            jTextFieldUsuario.setText("");
            jTextFieldTipo.setText("");
            jTextFieldDataAbertura.setText("");
            jTextAreaDescricao.setText("");
            jTextAreaResposta.setText("");
            jComboBoxStatus.setSelectedIndex(-1);
            return;
        }

        int id = Integer.parseInt(
                TableChamadosDisponiveis.getValueAt(linha, 0).toString()
        );

        jTextFieldIdChamado.setText(String.valueOf(id));

        jTextFieldAssunto.setText(
                TableChamadosDisponiveis.getValueAt(linha, 1).toString()
        );

        jTextFieldUsuario.setText(
                TableChamadosDisponiveis.getValueAt(linha, 2).toString()
        );

        jTextFieldDataAbertura.setText(
                TableChamadosDisponiveis.getValueAt(linha, 4).toString()
        );

        jTextFieldTipo.setText(String.valueOf(TableChamadosDisponiveis.getValueAt(linha, 3)));
        jTextAreaDescricao.setText(descricoesChamados.get(id));
        jTextAreaResposta.setText(solucoesChamados.get(id));

        jComboBoxStatus.setSelectedItem(
                TableChamadosDisponiveis.getValueAt(linha, 5).toString()
        );
    }

    @Override
    public void dispose() {

        if (websocketChamados != null) {
            websocketChamados.close();
        }

        super.dispose();
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
        java.awt.EventQueue.invokeLater(() -> new ChamadosDisponiveis().setVisible(true));
    }

    // estilo separado do codigo do netbeans
    private void configurarVisual() {
        Color borda = new Color(0xDFE6F1);
        for (JPanel p : new JPanel[]{painelMenu, painelFiltros, painelTabela,
            painelDetalhes, painelDescricao, painelSolucao}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JPanel p : new JPanel[]{cardAbertos, cardAndamento, cardEncerrados}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JButton b : new JButton[]{btnChamados, btnMeusChamados, btnMeuPerfil,
            btnSair, jButtonAtender, btnConsultarHistorico}) {
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setOpaque(true);
        }
        TableChamadosDisponiveis.setDefaultEditor(Object.class, null);
        TableChamadosDisponiveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableChamadosDisponiveis.setShowHorizontalLines(true);
        TableChamadosDisponiveis.setIntercellSpacing(new Dimension(0, 1));
        TableChamadosDisponiveis.setFillsViewportHeight(true);
        TableChamadosDisponiveis.getTableHeader().setReorderingAllowed(false);
        TableChamadosDisponiveis.getTableHeader().setPreferredSize(new Dimension(0, 42));
        TableChamadosDisponiveis.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        TableChamadosDisponiveis.getTableHeader().setBackground(new Color(0xEAF0FA));
        TableChamadosDisponiveis.getTableHeader().setForeground(new Color(0x18243C));
        DefaultTableCellRenderer header = new DefaultTableCellRenderer();
        header.setOpaque(true);
        header.setBackground(new Color(0xEAF0FA));
        header.setForeground(new Color(0x18243C));
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 4));
        TableChamadosDisponiveis.getTableHeader().setDefaultRenderer(header);
        int[] larguras = {44, 155, 108, 102, 132, 145};
        for (int i = 0; i < larguras.length; i++) {
            TableChamadosDisponiveis.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }
        TableChamadosDisponiveis.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean selected, boolean focus, int row, int col) {
                super.getTableCellRendererComponent(table, value, selected, false, row, col);
                setBackground(selected ? new Color(0xDCEAFF) : row % 2 == 0 ? Color.WHITE : new Color(0xF9FBFE));
                setForeground(new Color(0x18243C));
                setFont(new Font("Segoe UI", col == 0 ? Font.BOLD : Font.PLAIN, 12));
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 4));
                if (col == 3 && value != null) {
                    if ("CLIENTE".equals(value)) {
                        setText("Cliente");
                    } else if ("PROFISSIONAL".equals(value)) {
                        setText("Profissional");
                    }
                }
                return this;
            }
        });
        TableChamadosDisponiveis.getColumnModel().getColumn(5).setCellRenderer(new IndicadorRenderer(false));
        scrollChamados.getViewport().setBackground(Color.WHITE);
        scrollChamados.setBorder(BorderFactory.createLineBorder(borda));

        btnMeusChamados.setToolTipText("Meus chamados");
        btnSair.setEnabled(false);
        btnSair.setToolTipText("Logout será integrado posteriormente");
        jComboBoxStatus.setSelectedIndex(-1);
        for (JTextField f : new JTextField[]{jTextFieldIdChamado, jTextFieldAssunto,
            jTextFieldUsuario, jTextFieldTipo, jTextFieldDataAbertura, jTextFieldBuscar}) {
            f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borda),
                    BorderFactory.createEmptyBorder(0, 8, 0, 6)));
        }
        for (JTextArea a : new JTextArea[]{jTextAreaDescricao, jTextAreaResposta}) {
            a.setMargin(new Insets(7, 8, 7, 8));
        }
        TableChamadosDisponiveis.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !recarregandoChamados) {
                atualizarDetalhesChamado();
            }
        });
        setMinimumSize(new Dimension(1180, 700));
        // Botões planos, com cantos arredondados, independentes do Look & Feel.
        for (JButton b : new JButton[]{btnChamados, btnMeusChamados, btnMeuPerfil,
            btnSair, jButtonAtender, btnConsultarHistorico}) {
            b.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    AbstractButton botao = (AbstractButton) c;
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Color bg = botao.isEnabled() ? botao.getBackground() : new Color(0xEDF1F6);
                    if (botao.getModel().isPressed() && botao.isEnabled()) {
                        bg = bg.darker();
                    }
                    g2.setColor(bg);
                    g2.fillRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                    g2.setColor(botao.isEnabled() && botao.getForeground().equals(Color.WHITE)
                            ? bg : new Color(0xD6E1EF));
                    g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                    g2.dispose();
                    super.paint(g, c);
                }
            });
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        }
        btnChamados.addActionListener(e -> carregarChamados());
        jComboBoxStatus.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean selected, boolean focus) {
                String raw = value == null ? "" : value.toString();
                String texto = switch (raw) {
                    case "aberto" ->
                        "Aberto";
                    case "em_atendimento" ->
                        "Em atendimento";
                    case "fechado" ->
                        "Fechado";
                    default ->
                        raw;
                };
                return super.getListCellRendererComponent(list, texto, index, selected, focus);
            }
        });
    }

    private static class IndicadorRenderer extends DefaultTableCellRenderer {

        private final boolean mensagens;
        private Color fundoIndicador;
        private Color corTexto;

        IndicadorRenderer(boolean mensagens) {
            this.mensagens = mensagens;
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean selected, boolean focus, int row, int col) {
            super.getTableCellRendererComponent(table, value, selected, false, row, col);
            setBackground(selected ? new Color(0xDCEAFF) : row % 2 == 0 ? Color.WHITE : new Color(0xF9FBFE));
            setFont(new Font("Segoe UI", Font.BOLD, 12));
            setBorder(null);
            String texto = value == null ? "" : value.toString();
            if (mensagens) {
                int qtd = 0;
                try {
                    qtd = Integer.parseInt(texto);
                } catch (NumberFormatException ignored) {
                }
                setText(qtd == 0 ? "—" : qtd + (qtd == 1 ? " nova" : " novas"));
                fundoIndicador = qtd == 0 ? null : new Color(0xD9E8FF);
                corTexto = qtd == 0 ? new Color(0x687894) : new Color(0x0754D8);
            } else if ("fechado".equalsIgnoreCase(texto)) {
                setText("Fechado");
                fundoIndicador = new Color(0xDDF5E7);
                corTexto = new Color(0x126B3D);
            } else if ("em_atendimento".equalsIgnoreCase(texto)) {
                setText("Em atendimento");
                fundoIndicador = new Color(0xE0ECFF);
                corTexto = new Color(0x0754D8);
            } else {
                setText("aberto".equalsIgnoreCase(texto) ? "Aberto" : texto);
                fundoIndicador = new Color(0xFFF1CF);
                corTexto = new Color(0x865400);
            }
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int w = Math.min(getWidth() - 8, fm.stringWidth(getText()) + 22);
            int h = 27, x = (getWidth() - w) / 2, y = (getHeight() - h) / 2;
            if (fundoIndicador != null && w > 0) {
                g2.setColor(fundoIndicador);
                g2.fillRoundRect(x, y, w, h, h, h);
            }
            g2.setColor(corTexto == null ? getForeground() : corTexto);
            g2.drawString(getText(), (getWidth() - fm.stringWidth(getText())) / 2,
                    (getHeight() - fm.getHeight()) / 2 + fm.getAscent());
            g2.dispose();
        }
    }

    private void atualizarIndicadores() {
        javax.swing.table.TableModel m = TableChamadosDisponiveis.getModel();
        int abertos = 0, andamento = 0, encerrados = 0;
        for (int i = 0; i < m.getRowCount(); i++) {
            String status = String.valueOf(m.getValueAt(i, 5));
            if ("aberto".equalsIgnoreCase(status)) {
                abertos++;
            } else if ("em_atendimento".equalsIgnoreCase(status)) {
                andamento++;
            } else if ("fechado".equalsIgnoreCase(status)) {
                encerrados++;
            }
        }
        lblAbertos.setText(String.valueOf(abertos));
        lblAndamento.setText(String.valueOf(andamento));
        lblEncerrados.setText(String.valueOf(encerrados));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableChamadosDisponiveis;
    private javax.swing.JButton btnChamados;
    private javax.swing.JButton btnConsultarHistorico;
    private javax.swing.JButton btnMeuPerfil;
    private javax.swing.JButton btnMeusChamados;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel cardAbertos;
    private javax.swing.JPanel cardAndamento;
    private javax.swing.JPanel cardEncerrados;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxStatusChamados;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaResposta;
    private javax.swing.JTextField jTextFieldAssunto;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldDataAbertura;
    private javax.swing.JTextField jTextFieldIdChamado;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JLabel lblAbertos;
    private javax.swing.JLabel lblAndamento;
    private javax.swing.JLabel lblAssunto;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDataAbertura;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDetalhes;
    private javax.swing.JLabel lblEncerrados;
    private javax.swing.JLabel lblFiltroStatus;
    private javax.swing.JLabel lblIdChamado;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JLabel lblSolucao;
    private javax.swing.JLabel lblStatusChamado;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloAbertos;
    private javax.swing.JLabel lblTituloAndamento;
    private javax.swing.JLabel lblTituloEncerrados;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelDescricao;
    private javax.swing.JPanel painelDetalhes;
    private javax.swing.JPanel painelDireito;
    private javax.swing.JPanel painelFiltros;
    private javax.swing.JPanel painelIndicadores;
    private javax.swing.JPanel painelLista;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelSolucao;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JScrollPane scrollChamados;
    private javax.swing.JScrollPane scrollDescricao;
    private javax.swing.JScrollPane scrollSolucao;
    // End of variables declaration//GEN-END:variables
}
