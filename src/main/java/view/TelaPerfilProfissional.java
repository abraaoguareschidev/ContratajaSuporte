package view;

import api.ApiClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.*;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaPerfilProfissional extends javax.swing.JFrame {

    private int idUsuario;
    private String nomeUsuario, emailUsuario, telefoneUsuario;
    private final ArrayList<JsonObject> contratos = new ArrayList<>();
    private boolean carregando;

    // Construtor para o GUI Builder: não consulta a API.
    public TelaPerfilProfissional() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarVisual();
        btnAtualizar.setEnabled(false);
        btnVerOutraParte.setEnabled(false);
        btnComoCliente.setEnabled(false);
    }

    public TelaPerfilProfissional(int idUsuario, String nome, String email, String telefone) {
        this();
        this.idUsuario = idUsuario;
        this.nomeUsuario = nome;
        this.emailUsuario = email;
        this.telefoneUsuario = telefone;
        lblNome.setText(nome == null || nome.isBlank() ? "Usuário #" + idUsuario : nome);
        lblIdentificacao.setText("ID " + idUsuario + "  ·  Profissional");
        lblContato.setText("E-mail: " + exibicao(email) + "  |  Telefone: " + exibicao(telefone));
        lblContato.setToolTipText(lblContato.getText());
        btnAtualizar.setEnabled(idUsuario > 0);
        btnComoCliente.setEnabled(idUsuario > 0);
        carregarContratacoes();
    }

    public TelaPerfilProfissional(int idUsuario, String nome) {
        this(idUsuario, nome, null, null);
    }

    private void configurarVisual() {
        Color borda = new Color(0xDFE6F1);
        for (JPanel p : new JPanel[]{painelCabecalho, painelPerfil, painelLista, painelDetalhes}) {
            p.setBorder(BorderFactory.createLineBorder(borda));
        }
        for (JButton b : new JButton[]{btnVoltar, btnAtualizar, btnVerOutraParte, btnComoCliente, btnConsultarConversa}) {
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
            b.setOpaque(true);
        }
        for (JScrollPane s : new JScrollPane[]{scrollTabela, scrollDetalhes}) {
            s.setBorder(BorderFactory.createLineBorder(borda));
            s.getViewport().setBackground(Color.WHITE);
        }
        tblContratacoes.setRowHeight(38);
        tblContratacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblContratacoes.setAutoCreateRowSorter(true);
        tblContratacoes.setGridColor(new Color(0xDFE6F1));
        tblContratacoes.setShowVerticalLines(false);
        tblContratacoes.setSelectionBackground(new Color(0xE0ECFF));
        tblContratacoes.setSelectionForeground(new Color(0x18243C));
        tblContratacoes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblContratacoes.getTableHeader().setBackground(new Color(0xEDF3FD));
        tblContratacoes.getTableHeader().setForeground(new Color(0x243B62));
        tblContratacoes.getTableHeader().setReorderingAllowed(false);
        tblContratacoes.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblContratacoes.getColumnModel().getColumn(1).setPreferredWidth(185);
        tblContratacoes.getColumnModel().getColumn(2).setPreferredWidth(155);
        tblContratacoes.getColumnModel().getColumn(3).setPreferredWidth(105);
        tblContratacoes.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblContratacoes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, int row, int column) {
                super.getTableCellRendererComponent(table, value, selected, focus, row, column);
                setFont(getFont().deriveFont(Font.BOLD));
                String s = String.valueOf(value).toLowerCase(Locale.ROOT);
                setForeground(s.contains("cancel") ? new Color(0xB91C1C) : s.contains("conclu") || s.equals("ativa") ? new Color(0x126B3D) : new Color(0x0754D8));
                return this;
            }
        });
        tblContratacoes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                exibirDetalhes();
            }
        });
        txtDetalhes.setMargin(new Insets(12, 12, 12, 12));
        setMinimumSize(new Dimension(1020, 660));
        setLocationRelativeTo(null);
    }

    private void carregarContratacoes() {
        if (idUsuario <= 0 || carregando) {
            return;
        }
        carregando = true;
        btnAtualizar.setEnabled(false);
        btnVerOutraParte.setEnabled(false);
        lblEstado.setText("Consultando a API...");
        new SwingWorker<JsonArray, Void>() {
            @Override
            protected JsonArray doInBackground() throws Exception {
                ApiClient api = new ApiClient();
                return JsonParser.parseString(api.listarContratacoesProfissional(idUsuario)).getAsJsonArray();
            }

            @Override
            protected void done() {
                if (!isDisplayable()) {
                    return;
                }
                try {
                    JsonArray dados = get();
                    DefaultTableModel modelo = (DefaultTableModel) tblContratacoes.getModel();
                    tblContratacoes.clearSelection();
                    contratos.clear();
                    modelo.setRowCount(0);
                    for (JsonElement elemento : dados) {
                        JsonObject contrato = elemento.getAsJsonObject();
                        contratos.add(contrato);
                        modelo.addRow(new Object[]{texto(contrato, "id_contratacao"), texto(contrato, "nome_servico"), texto(contrato, "nome_cliente"), moeda(contrato), status(contrato)});
                    }
                    lblQuantidade.setText(contratos.size() + (contratos.size() == 1 ? " contratação" : " contratações"));
                    lblEstado.setText(contratos.isEmpty() ? "Nenhuma contratação encontrada." : "Selecione um registro para investigar.");
                    if (!contratos.isEmpty()) {
                        tblContratacoes.setRowSelectionInterval(0, 0);
                    } else {
                        exibirDetalhes();
                    }
                } catch (Exception ex) {
                    lblEstado.setText("Falha ao consultar a API. Tente atualizar.");
                    JOptionPane.showMessageDialog(TelaPerfilProfissional.this, "Não foi possível carregar as contratações: " + (ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage()), "Consulta", JOptionPane.ERROR_MESSAGE);
                } finally {
                    carregando = false;
                    btnAtualizar.setEnabled(true);
                    exibirDetalhes();
                }
            }
        }.execute();
    }

    private JsonObject contratoSelecionado() {
        int linha = tblContratacoes.getSelectedRow();
        if (linha < 0) {
            return null;
        }
        int indice = tblContratacoes.convertRowIndexToModel(linha);
        return indice >= 0 && indice < contratos.size() ? contratos.get(indice) : null;
    }

    private void exibirDetalhes() {
        JsonObject c = contratoSelecionado();
        btnVerOutraParte.setEnabled(!carregando && c != null && idOutraParte(c) > 0);
        if (c == null) {
            lblSelecao.setText("Nenhum contrato selecionado");
            txtDetalhes.setText("Selecione uma contratação na tabela.");
            return;
        }
        lblSelecao.setText("Contratação #" + texto(c, "id_contratacao"));
        txtDetalhes.setText("SERVIÇO\n" + texto(c, "nome_servico")
                + "\n\nCLIENTE\n" + texto(c, "nome_cliente") + " · ID " + texto(c, "id_cliente")
                + "\n\nPROFISSIONAL\n" + texto(c, "nome_profissional") + " · ID " + texto(c, "id_profissional")
                + "\n\nSTATUS / VALOR\n" + status(c) + "  |  " + moeda(c)
                + "\n\nDATA DA CONTRATAÇÃO\n" + data(c, "data_contratacao", true)
                + "\n\nINÍCIO / CONCLUSÃO\n" + data(c, "data_inicio", false) + " / " + data(c, "data_conclusao", false)
                + "\n\nDESCRIÇÃO DO PEDIDO\n" + texto(c, "descricao_pedido")
                + "\n\nDESCRIÇÃO DA PROPOSTA\n" + texto(c, "descricao_proposta"));
        txtDetalhes.setCaretPosition(0);
    }

    private int idOutraParte(JsonObject c) {
        try {
            return c.get("id_cliente").getAsInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String exibicao(String s) {
        return s == null || s.isBlank() ? "—" : s;
    }

    private static String texto(JsonObject c, String chave) {
        JsonElement e = c.get(chave);
        return e == null || e.isJsonNull() ? "—" : exibicao(e.getAsString());
    }

    private static String moeda(JsonObject c) {
        try {
            return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(c.get("valor_final").getAsBigDecimal());
        } catch (Exception e) {
            return "—";
        }
    }

    private static String status(JsonObject c) {
        String s = texto(c, "status").replace('_', ' ');
        return s.isEmpty() ? "—" : Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static String data(JsonObject c, String chave, boolean hora) {
        String s = texto(c, chave);
        try {
            if (hora) {
                DateTimeFormatter formato
                        = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                try {
                    return LocalDateTime.parse(s).format(formato);
                } catch (Exception e) {
                    return Instant.parse(s).atZone(ZoneId.systemDefault()).format(formato);
                }
            }
            return LocalDate.parse(s.substring(0, 10)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return s;
        }
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
        painelPerfil = new javax.swing.JPanel();
        lblPerfil = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblIdentificacao = new javax.swing.JLabel();
        lblContato = new javax.swing.JLabel();
        btnComoCliente = new javax.swing.JButton();
        painelLista = new javax.swing.JPanel();
        lblLista = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tblContratacoes = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        painelDetalhes = new javax.swing.JPanel();
        lblDetalhes = new javax.swing.JLabel();
        lblSelecao = new javax.swing.JLabel();
        scrollDetalhes = new javax.swing.JScrollPane();
        txtDetalhes = new javax.swing.JTextArea();
        btnVerOutraParte = new javax.swing.JButton();
        btnConsultarConversa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Perfil do profissional");

        painelPrincipal.setBackground(new java.awt.Color(243, 246, 252));

        painelCabecalho.setBackground(new java.awt.Color(255, 255, 255));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(6, 77, 199));
        lblMarca.setText("ContrataJá");

        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMarcaSub.setForeground(new java.awt.Color(82, 103, 133));
        lblMarcaSub.setText("SUPORTE");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(24, 36, 60));
        lblTitulo.setText("Perfil do profissional");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(82, 103, 133));
        lblSubtitulo.setText("Investigação de atendimento · somente leitura");

        btnVoltar.setBackground(new java.awt.Color(237, 243, 253));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(36, 59, 98));
        btnVoltar.setText("‹  Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCabecalhoLayout.createSequentialGroup()
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblMarcaSub, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCabecalhoLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        painelPerfil.setBackground(new java.awt.Color(255, 255, 255));

        lblPerfil.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPerfil.setForeground(new java.awt.Color(6, 77, 199));
        lblPerfil.setText("DADOS DO USUÁRIO");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lblNome.setForeground(new java.awt.Color(24, 36, 60));
        lblNome.setText("Usuário não selecionado");

        lblIdentificacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblIdentificacao.setForeground(new java.awt.Color(82, 103, 133));
        lblIdentificacao.setText("ID —  ·  Profissional");

        lblContato.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblContato.setForeground(new java.awt.Color(82, 103, 133));
        lblContato.setText("E-mail: —  |  Telefone: —");

        btnComoCliente.setBackground(new java.awt.Color(237, 243, 253));
        btnComoCliente.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnComoCliente.setForeground(new java.awt.Color(36, 59, 98));
        btnComoCliente.setText("Ver perfil como cliente");
        btnComoCliente.addActionListener(this::btnComoClienteActionPerformed);

        javax.swing.GroupLayout painelPerfilLayout = new javax.swing.GroupLayout(painelPerfil);
        painelPerfil.setLayout(painelPerfilLayout);
        painelPerfilLayout.setHorizontalGroup(
            painelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPerfilLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdentificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(btnComoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        painelPerfilLayout.setVerticalGroup(
            painelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPerfilLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPerfilLayout.createSequentialGroup()
                        .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblContato, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPerfilLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnComoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        painelLista.setBackground(new java.awt.Color(255, 255, 255));

        lblLista.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblLista.setForeground(new java.awt.Color(24, 36, 60));
        lblLista.setText("Serviços prestados");

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(82, 103, 133));
        lblQuantidade.setText("0 contratações");

        btnAtualizar.setBackground(new java.awt.Color(237, 243, 253));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(36, 59, 98));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        tblContratacoes.setForeground(new java.awt.Color(24, 36, 60));
        tblContratacoes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblContratacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Serviço", "Cliente", "Valor final", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabela.setViewportView(tblContratacoes);

        lblEstado.setForeground(new java.awt.Color(82, 103, 133));
        lblEstado.setText("Selecione um usuário para consultar.");

        javax.swing.GroupLayout painelListaLayout = new javax.swing.GroupLayout(painelLista);
        painelLista.setLayout(painelListaLayout);
        painelListaLayout.setHorizontalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelListaLayout.createSequentialGroup()
                        .addGroup(painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTabela, 0, 617, Short.MAX_VALUE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        painelListaLayout.setVerticalGroup(
            painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelListaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelListaLayout.createSequentialGroup()
                        .addComponent(lblLista, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(scrollTabela, 0, 340, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        painelDetalhes.setBackground(new java.awt.Color(255, 255, 255));

        lblDetalhes.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        lblDetalhes.setForeground(new java.awt.Color(24, 36, 60));
        lblDetalhes.setText("Detalhes da contratação");

        lblSelecao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSelecao.setForeground(new java.awt.Color(82, 103, 133));
        lblSelecao.setText("Nenhum contrato selecionado");

        txtDetalhes.setForeground(new java.awt.Color(24, 36, 60));
        txtDetalhes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDetalhes.setText("Selecione uma contratação na tabela.");
        txtDetalhes.setEditable(false);
        txtDetalhes.setLineWrap(true);
        txtDetalhes.setWrapStyleWord(true);
        txtDetalhes.setRows(12);
        txtDetalhes.setColumns(25);
        scrollDetalhes.setViewportView(txtDetalhes);

        btnVerOutraParte.setBackground(new java.awt.Color(6, 77, 199));
        btnVerOutraParte.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnVerOutraParte.setForeground(new java.awt.Color(255, 255, 255));
        btnVerOutraParte.setText("Ver perfil do cliente");
        btnVerOutraParte.addActionListener(this::btnVerOutraParteActionPerformed);

        btnConsultarConversa.setBackground(new java.awt.Color(237, 243, 253));
        btnConsultarConversa.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConsultarConversa.setForeground(new java.awt.Color(36, 59, 98));
        btnConsultarConversa.setText("Consultar conversa");
        btnConsultarConversa.addActionListener(this::btnConsultarConversaActionPerformed);

        javax.swing.GroupLayout painelDetalhesLayout = new javax.swing.GroupLayout(painelDetalhes);
        painelDetalhes.setLayout(painelDetalhesLayout);
        painelDetalhesLayout.setHorizontalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDetalhesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsultarConversa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDetalhes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelecao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollDetalhes, javax.swing.GroupLayout.Alignment.LEADING, 0, 334, Short.MAX_VALUE)
                    .addComponent(btnVerOutraParte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        painelDetalhesLayout.setVerticalGroup(
            painelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDetalhesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrollDetalhes, 0, 293, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btnVerOutraParte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarConversa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(painelLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(painelDetalhes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(painelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void abrirTela(JFrame tela) {

        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                TelaPerfilProfissional.this.setVisible(true);
            }
        });

        this.setVisible(false);
        tela.setVisible(true);
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarContratacoes();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnVerOutraParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOutraParteActionPerformed
        JsonObject c = contratoSelecionado();
        if (c == null || idOutraParte(c) <= 0) {
            return;
        }
        TelaPerfilCliente tela = new TelaPerfilCliente(idOutraParte(c), texto(c, "nome_cliente"));

        abrirTela(tela);
    }//GEN-LAST:event_btnVerOutraParteActionPerformed
    private void btnComoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComoClienteActionPerformed
        TelaPerfilCliente tela = new TelaPerfilCliente(idUsuario, nomeUsuario, emailUsuario, telefoneUsuario);

        abrirTela(tela);
    }//GEN-LAST:event_btnComoClienteActionPerformed

    private void btnConsultarConversaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarConversaActionPerformed
        JsonObject c = contratoSelecionado();

        if (c == null || carregando) {
            JOptionPane.showMessageDialog(this,
                    "Selecione uma contratação.");
            return;
        }

        int idCliente = c.get("id_cliente").getAsInt();
        int idProfissional = c.get("id_profissional").getAsInt();

        TelaConsultaConversa tela = new TelaConsultaConversa(idCliente,idProfissional,texto(c, "nome_cliente"),texto(c, "nome_profissional"));

        abrirTela(tela);
    }//GEN-LAST:event_btnConsultarConversaActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            if (args.length > 0) {
                new TelaPerfilProfissional(Integer.parseInt(args[0]), args.length > 1 ? args[1] : null).setVisible(true);
            } else {
                new TelaPerfilProfissional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnComoCliente;
    private javax.swing.JButton btnConsultarConversa;
    private javax.swing.JButton btnVerOutraParte;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblDetalhes;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdentificacao;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSelecao;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelDetalhes;
    private javax.swing.JPanel painelLista;
    private javax.swing.JPanel painelPerfil;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JScrollPane scrollDetalhes;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tblContratacoes;
    private javax.swing.JTextArea txtDetalhes;
    // End of variables declaration//GEN-END:variables
}
