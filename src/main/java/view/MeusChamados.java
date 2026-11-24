package view;

import api.ApiClient;
import api.ChamadosWebSocketClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MeusChamados extends javax.swing.JFrame {

    private final int idSuporte;
    private ChamadosWebSocketClient websocketChamados;
    private final Map<Integer, JsonObject> detalhesChamados = new HashMap<>();
    private TableRowSorter<DefaultTableModel> filtro;

    public MeusChamados() {
        this(0);
    }

    public MeusChamados(int idSuporte) {
        this.idSuporte = idSuporte;

        initComponents();
        configurarVisual();
        configurarEventos();
        carregarMeusChamados();
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
        cardAndamento = new javax.swing.JPanel();
        lblTituloAndamento = new javax.swing.JLabel();
        lblAndamento = new javax.swing.JLabel();
        cardEncerrados = new javax.swing.JPanel();
        lblTituloEncerrados = new javax.swing.JLabel();
        lblEncerrados = new javax.swing.JLabel();
        cardTotal = new javax.swing.JPanel();
        lblTituloTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        painelFiltros = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblFiltroStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        painelTabela = new javax.swing.JPanel();
        scrollChamados = new javax.swing.JScrollPane();
        tblMeusChamados = new javax.swing.JTable();
        painelDireito = new javax.swing.JPanel();
        painelDetalhes = new javax.swing.JPanel();
        lblDetalhes = new javax.swing.JLabel();
        lblIdChamado = new javax.swing.JLabel();
        lblAssunto = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblDataAbertura = new javax.swing.JLabel();
        lblStatusChamado = new javax.swing.JLabel();
        txtIdChamado = new javax.swing.JTextField();
        txtAssunto = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtDataAbertura = new javax.swing.JTextField();
        txtStatusChamado = new javax.swing.JTextField();
        painelDescricao = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        scrollDescricao = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        painelSolucao = new javax.swing.JPanel();
        lblSolucao = new javax.swing.JLabel();
        scrollSolucao = new javax.swing.JScrollPane();
        txtSolucao = new javax.swing.JTextArea();
        painelAcoes = new javax.swing.JPanel();
        btnAbrirAtendimento = new javax.swing.JButton();
        btnVerHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Meus chamados");

        painelPrincipal.setBackground(new java.awt.Color(243, 246, 252));

        painelMenu.setBackground(new java.awt.Color(255, 255, 255));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(6, 77, 199));
        lblMarca.setText("ContrataJá");

        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMarcaSub.setForeground(new java.awt.Color(82, 103, 133));
        lblMarcaSub.setText("SUPORTE");

        btnChamados.setBackground(new java.awt.Color(237, 243, 253));
        btnChamados.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnChamados.setForeground(new java.awt.Color(36, 59, 98));
        btnChamados.setText("Chamados");
        btnChamados.addActionListener(this::btnChamadosActionPerformed);

        btnMeusChamados.setBackground(new java.awt.Color(7, 84, 216));
        btnMeusChamados.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMeusChamados.setForeground(new java.awt.Color(255, 255, 255));
        btnMeusChamados.setText("Meus chamados");

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
                    .addComponent(btnMeusChamados, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
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
        lblTitulo.setText("Meus chamados");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(82, 103, 133));
        lblSubtitulo.setText("Visualize e gerencie apenas os chamados atribuídos a você.");

        painelLista.setBackground(new java.awt.Color(243, 246, 252));

        painelIndicadores.setBackground(new java.awt.Color(243, 246, 252));

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

        cardTotal.setBackground(new java.awt.Color(237, 241, 248));

        lblTituloTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTituloTotal.setForeground(new java.awt.Color(24, 36, 60));
        lblTituloTotal.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(35, 59, 103));
        lblTotal.setText("0");

        javax.swing.GroupLayout cardTotalLayout = new javax.swing.GroupLayout(cardTotal);
        cardTotal.setLayout(cardTotalLayout);
        cardTotalLayout.setHorizontalGroup(
            cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTotalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        cardTotalLayout.setVerticalGroup(
            cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTotalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTituloTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout painelIndicadoresLayout = new javax.swing.GroupLayout(painelIndicadores);
        painelIndicadores.setLayout(painelIndicadoresLayout);
        painelIndicadoresLayout.setHorizontalGroup(
            painelIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelIndicadoresLayout.createSequentialGroup()
                .addComponent(cardAndamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(cardEncerrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(cardTotal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelIndicadoresLayout.setVerticalGroup(
            painelIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cardEncerrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cardTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painelFiltros.setBackground(new java.awt.Color(255, 255, 255));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(24, 36, 60));
        lblBuscar.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lblFiltroStatus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFiltroStatus.setForeground(new java.awt.Color(24, 36, 60));
        lblFiltroStatus.setText("Status:");

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Em atendimento", "Fechados" }));

        javax.swing.GroupLayout painelFiltrosLayout = new javax.swing.GroupLayout(painelFiltros);
        painelFiltros.setLayout(painelFiltrosLayout);
        painelFiltrosLayout.setHorizontalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBuscar)
                .addGap(8, 8, 8)
                .addComponent(txtBuscar, 0, 350, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblFiltroStatus)
                .addGap(8, 8, 8)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        painelFiltrosLayout.setVerticalGroup(
            painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltroStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        painelTabela.setBackground(new java.awt.Color(255, 255, 255));

        tblMeusChamados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Assunto", "Usuário", "Data de abertura", "Status", "Novas mensagens"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMeusChamados.setRowHeight(44);
        tblMeusChamados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblMeusChamados.setForeground(new java.awt.Color(24, 36, 60));
        tblMeusChamados.setBackground(new java.awt.Color(255, 255, 255));
        tblMeusChamados.setGridColor(new java.awt.Color(231, 237, 246));
        tblMeusChamados.setSelectionBackground(new java.awt.Color(220, 234, 255));
        tblMeusChamados.setSelectionForeground(new java.awt.Color(24, 36, 60));
        scrollChamados.setViewportView(tblMeusChamados);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollChamados, 0, 742, Short.MAX_VALUE)
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

        lblDataAbertura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDataAbertura.setForeground(new java.awt.Color(24, 36, 60));
        lblDataAbertura.setText("Data de abertura:");

        lblStatusChamado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatusChamado.setForeground(new java.awt.Color(24, 36, 60));
        lblStatusChamado.setText("Status:");

        txtIdChamado.setEditable(false);
        txtIdChamado.setBackground(new java.awt.Color(248, 250, 253));
        txtIdChamado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtIdChamado.setForeground(new java.awt.Color(24, 36, 60));

        txtAssunto.setEditable(false);
        txtAssunto.setBackground(new java.awt.Color(248, 250, 253));
        txtAssunto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAssunto.setForeground(new java.awt.Color(24, 36, 60));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(248, 250, 253));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(24, 36, 60));

        txtDataAbertura.setEditable(false);
        txtDataAbertura.setBackground(new java.awt.Color(248, 250, 253));
        txtDataAbertura.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDataAbertura.setForeground(new java.awt.Color(24, 36, 60));

        txtStatusChamado.setEditable(false);
        txtStatusChamado.setBackground(new java.awt.Color(248, 250, 253));
        txtStatusChamado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtStatusChamado.setForeground(new java.awt.Color(24, 36, 60));

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
                            .addComponent(lblDataAbertura)
                            .addComponent(lblStatusChamado))
                        .addGap(10, 10, 10)
                        .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdChamado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAssunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataAbertura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStatusChamado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(txtIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatusChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        painelDescricao.setBackground(new java.awt.Color(255, 255, 255));

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(24, 36, 60));
        lblDescricao.setText("Descrição");

        txtDescricao.setEditable(false);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDescricao.setBackground(new java.awt.Color(248, 250, 253));
        txtDescricao.setForeground(new java.awt.Color(24, 36, 60));
        scrollDescricao.setViewportView(txtDescricao);

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

        txtSolucao.setEditable(false);
        txtSolucao.setLineWrap(true);
        txtSolucao.setWrapStyleWord(true);
        txtSolucao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSolucao.setBackground(new java.awt.Color(248, 250, 253));
        txtSolucao.setForeground(new java.awt.Color(24, 36, 60));
        scrollSolucao.setViewportView(txtSolucao);

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

        btnAbrirAtendimento.setBackground(new java.awt.Color(7, 84, 216));
        btnAbrirAtendimento.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAbrirAtendimento.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirAtendimento.setText("Abrir atendimento");
        btnAbrirAtendimento.addActionListener(this::btnAbrirAtendimentoActionPerformed);

        btnVerHistorico.setBackground(new java.awt.Color(237, 243, 253));
        btnVerHistorico.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnVerHistorico.setForeground(new java.awt.Color(36, 59, 98));
        btnVerHistorico.setText("Ver histórico");
        btnVerHistorico.addActionListener(this::btnVerHistoricoActionPerformed);

        javax.swing.GroupLayout painelAcoesLayout = new javax.swing.GroupLayout(painelAcoes);
        painelAcoes.setLayout(painelAcoesLayout);
        painelAcoesLayout.setHorizontalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcoesLayout.createSequentialGroup()
                .addComponent(btnAbrirAtendimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnVerHistorico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAcoesLayout.setVerticalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbrirAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVerHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAbrirAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirAtendimentoActionPerformed
        abrirAtendimento();
    }//GEN-LAST:event_btnAbrirAtendimentoActionPerformed

    private void btnVerHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistoricoActionPerformed

        int linha = tblMeusChamados.getSelectedRow();

        if (linha == -1) {
            return;
        }

        int idChamado = Integer.parseInt(tblMeusChamados.getValueAt(linha, 0).toString());

        JsonObject chamado = detalhesChamados.get(idChamado);

        if (chamado == null) {
            return;
        }

        String status = chamado.get("status").getAsString();

        if (!"fechado".equals(status)) {
            return;
        }

        JsonObject usuario = chamado.getAsJsonObject("usuario");

        String email = usuario.has("email") && !usuario.get("email").isJsonNull()
                ? usuario.get("email").getAsString() : "";

        String telefone = usuario.has("telefone") && !usuario.get("telefone").isJsonNull()
                ? usuario.get("telefone").getAsString() : "";

        Atendimento tela = new Atendimento(
                idChamado,
                txtAssunto.getText(),
                txtDescricao.getText(),
                txtDataAbertura.getText(),
                status,
                txtUsuario.getText(),
                email,
                telefone,
                idSuporte,
                true
        );

        tela.exibirSolucao(txtSolucao.getText());
        tela.setVisible(true);

    }//GEN-LAST:event_btnVerHistoricoActionPerformed

    private void btnChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamadosActionPerformed
        for (Window janela : Window.getWindows()) {

            if (janela instanceof ChamadosDisponiveis && janela.isDisplayable()) {

                janela.setVisible(true);
                janela.toFront();
                dispose();
                return;
            }
        }

        new ChamadosDisponiveis(idSuporte).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnChamadosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            for (Window janela : Window.getWindows()) {
                janela.dispose();
            }

            new LoginSuporte().setVisible(true);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    // Estilização separada do código gerado pelo NetBeans.
    private void configurarVisual() {
        Color borda = new Color(0xDFE6F1);
        for (JPanel p : new JPanel[]{painelMenu, painelFiltros, painelTabela,
            painelDetalhes, painelDescricao, painelSolucao}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JPanel p : new JPanel[]{cardAndamento, cardEncerrados, cardTotal}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JButton b : new JButton[]{btnChamados, btnMeusChamados, btnMeuPerfil,
            btnSair, btnAbrirAtendimento, btnVerHistorico}) {
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setOpaque(true);
        }
        tblMeusChamados.setDefaultEditor(Object.class, null);
        tblMeusChamados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMeusChamados.setShowHorizontalLines(true);
        tblMeusChamados.setIntercellSpacing(new Dimension(0, 1));
        tblMeusChamados.setFillsViewportHeight(true);
        tblMeusChamados.getTableHeader().setReorderingAllowed(false);
        tblMeusChamados.getTableHeader().setPreferredSize(new Dimension(0, 42));
        tblMeusChamados.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblMeusChamados.getTableHeader().setBackground(new Color(0xEAF0FA));
        tblMeusChamados.getTableHeader().setForeground(new Color(0x18243C));
        DefaultTableCellRenderer header = new DefaultTableCellRenderer();
        header.setOpaque(true);
        header.setBackground(new Color(0xEAF0FA));
        header.setForeground(new Color(0x18243C));
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 4));
        tblMeusChamados.getTableHeader().setDefaultRenderer(header);
        int[] larguras = {45, 174, 122, 130, 151, 116};
        for (int i = 0; i < larguras.length; i++) {
            tblMeusChamados.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
        }
        tblMeusChamados.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean selected, boolean focus, int row, int col) {
                super.getTableCellRendererComponent(table, value, selected, false, row, col);
                setBackground(selected ? new Color(0xDCEAFF) : row % 2 == 0 ? Color.WHITE : new Color(0xF9FBFE));
                setForeground(new Color(0x18243C));
                setFont(new Font("Segoe UI", col == 0 ? Font.BOLD : Font.PLAIN, 12));
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 4));
                return this;
            }
        });
        tblMeusChamados.getColumnModel().getColumn(4).setCellRenderer(new IndicadorRenderer(false));
        tblMeusChamados.getColumnModel().getColumn(5).setCellRenderer(new IndicadorRenderer(true));
        filtro = new TableRowSorter<>((DefaultTableModel) tblMeusChamados.getModel());
        tblMeusChamados.setRowSorter(filtro);
        scrollChamados.getViewport().setBackground(Color.WHITE);
        scrollChamados.setBorder(BorderFactory.createLineBorder(borda));
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
                fundoIndicador = new Color(0xFEE2E2);
                corTexto = new Color(0xB91C1C);
            } else if ("em_atendimento".equalsIgnoreCase(texto)) {
                setText("Em atendimento");
                fundoIndicador = new Color(0xE0ECFF);
                corTexto = new Color(0x0754D8);
            } else {
                setText(texto);
                fundoIndicador = new Color(0xDDF5E7);
                corTexto = new Color(0x126B3D);
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

    private void configurarEventos() {
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                aplicarFiltros();
            }

            public void removeUpdate(DocumentEvent e) {
                aplicarFiltros();
            }

            public void changedUpdate(DocumentEvent e) {
                aplicarFiltros();
            }
        });
        cmbStatus.addActionListener(e -> aplicarFiltros());
        tblMeusChamados.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                atualizarDetalhes();
            }
        });

    }

    private void aplicarFiltros() {
        List<RowFilter<DefaultTableModel, Integer>> filtros = new ArrayList<>();
        String texto = txtBuscar.getText().trim();
        if (!texto.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + Pattern.quote(texto), 0, 1, 2));
        }
        Object status = cmbStatus.getSelectedItem();
        if ("Em atendimento".equals(status)) {
            filtros.add(RowFilter.regexFilter("^em_atendimento$", 4));
        }
        if ("Fechados".equals(status)) {
            filtros.add(RowFilter.regexFilter("^fechado$", 4));
        }
        filtro.setRowFilter(filtros.isEmpty() ? null : RowFilter.andFilter(filtros));
        atualizarDetalhes();
    }

    private void atualizarIndicadores() {
        DefaultTableModel m = (DefaultTableModel) tblMeusChamados.getModel();
        int andamento = 0, encerrados = 0;
        for (int i = 0; i < m.getRowCount(); i++) {
            if ("em_atendimento".equals(m.getValueAt(i, 4))) {
                andamento++;
            }
            if ("fechado".equals(m.getValueAt(i, 4))) {
                encerrados++;
            }
        }
        lblAndamento.setText(String.valueOf(andamento));
        lblEncerrados.setText(String.valueOf(encerrados));
        lblTotal.setText(String.valueOf(m.getRowCount()));
    }

    private void atualizarDetalhes() {
        int linha = tblMeusChamados.getSelectedRow();
        if (linha == -1) {
            for (JTextField f : new JTextField[]{txtIdChamado, txtAssunto, txtUsuario, txtDataAbertura, txtStatusChamado}) {
                f.setText("");
            }
            txtDescricao.setText("");
            txtSolucao.setText("");
            btnAbrirAtendimento.setEnabled(false);
            btnVerHistorico.setEnabled(false);
            return;
        }
        txtIdChamado.setText(String.valueOf(tblMeusChamados.getValueAt(linha, 0)));
        txtAssunto.setText(String.valueOf(tblMeusChamados.getValueAt(linha, 1)));
        txtUsuario.setText(String.valueOf(tblMeusChamados.getValueAt(linha, 2)));
        txtDataAbertura.setText(String.valueOf(tblMeusChamados.getValueAt(linha, 3)));
        boolean fechado = "fechado".equals(tblMeusChamados.getValueAt(linha, 4));
        txtStatusChamado.setText(fechado ? "Fechado" : "Em atendimento");

        int idChamado = Integer.parseInt(txtIdChamado.getText());

        JsonObject chamado = detalhesChamados.get(idChamado);

        if (chamado != null) {

            txtDescricao.setText(
                    chamado.has("descricao") && !chamado.get("descricao").isJsonNull()
                    ? chamado.get("descricao").getAsString() : ""
            );

            txtSolucao.setText(
                    chamado.has("solucao") && !chamado.get("solucao").isJsonNull()
                    ? chamado.get("solucao").getAsString() : ""
            );

        } else {
            txtDescricao.setText("");
            txtSolucao.setText("");
        }

        btnAbrirAtendimento.setEnabled(!fechado);
        btnVerHistorico.setEnabled(fechado);
    }

    private void abrirAtendimento() {

        int linha = tblMeusChamados.getSelectedRow();

        if (linha == -1) {
            return;
        }

        int idChamado = Integer.parseInt(
                tblMeusChamados.getValueAt(linha, 0).toString()
        );

        JsonObject chamado = detalhesChamados.get(idChamado);

        if (chamado == null) {
            return;
        }

        String status = chamado.get("status").getAsString();

        if (!"em_atendimento".equals(status)) {
            return;
        }

        JsonObject usuario = chamado.getAsJsonObject("usuario");

        String email = usuario.has("email") && !usuario.get("email").isJsonNull()
                ? usuario.get("email").getAsString() : "";

        String telefone = usuario.has("telefone") && !usuario.get("telefone").isJsonNull()
                ? usuario.get("telefone").getAsString() : "";

        Atendimento tela = new Atendimento(
                idChamado,
                txtAssunto.getText(),
                txtDescricao.getText(),
                txtDataAbertura.getText(),
                status,
                txtUsuario.getText(),
                email,
                telefone,
                idSuporte
        );

        tela.setVisible(true);
    }

    @Override
    public void dispose() {
        if (websocketChamados != null) {
            websocketChamados.close();
        }

        super.dispose();
    }

    private void conectarWebSocketChamados() {
        try {
            websocketChamados = new ChamadosWebSocketClient();

            websocketChamados.setAoReceberAtualizacao(mensagem -> {

                SwingUtilities.invokeLater(() -> {
                    carregarMeusChamados();
                });

            });

            websocketChamados.connect();

        } catch (Exception e) {
            System.out.println("Erro ao conectar WebSocket: "
                    + e.getMessage());
        }
    }

    private void carregarMeusChamados() {

        try {
            ApiClient api = new ApiClient();

            String resposta = api.listarMeusChamados(idSuporte);

            JsonArray chamados = JsonParser.parseString(resposta).getAsJsonArray();

            DefaultTableModel modelo = (DefaultTableModel) tblMeusChamados.getModel();

            modelo.setRowCount(0);
            detalhesChamados.clear();

            for (JsonElement elemento : chamados) {

                JsonObject chamado = elemento.getAsJsonObject();
                int idChamado = chamado.get("idChamado").getAsInt();

                detalhesChamados.put(idChamado, chamado);
                long mensagensNaoLidas = 0;

                if (!"fechado".equalsIgnoreCase(chamado.get("status").getAsString())) {
                    mensagensNaoLidas = api.contarMensagensNaoLidas(idChamado, idSuporte);
                }

                JsonObject usuario = chamado.getAsJsonObject("usuario");

                modelo.addRow(new Object[]{
                    chamado.get("idChamado").getAsInt(),
                    chamado.get("assunto").getAsString(),
                    usuario.get("nome").getAsString(),
                    chamado.get("dataAbertura").getAsString(),
                    chamado.get("status").getAsString(),
                    mensagensNaoLidas
                });
            }

            atualizarIndicadores();
            atualizarDetalhes();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar meus chamados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MeusChamados().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirAtendimento;
    private javax.swing.JButton btnChamados;
    private javax.swing.JButton btnMeuPerfil;
    private javax.swing.JButton btnMeusChamados;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVerHistorico;
    private javax.swing.JPanel cardAndamento;
    private javax.swing.JPanel cardEncerrados;
    private javax.swing.JPanel cardTotal;
    private javax.swing.JComboBox<String> cmbStatus;
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
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloAndamento;
    private javax.swing.JLabel lblTituloEncerrados;
    private javax.swing.JLabel lblTituloTotal;
    private javax.swing.JLabel lblTotal;
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
    private javax.swing.JTable tblMeusChamados;
    private javax.swing.JTextField txtAssunto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDataAbertura;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtIdChamado;
    private javax.swing.JTextArea txtSolucao;
    private javax.swing.JTextField txtStatusChamado;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
