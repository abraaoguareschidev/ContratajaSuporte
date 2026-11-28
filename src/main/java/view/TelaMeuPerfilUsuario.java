package view;

import api.ApiClient;
import javax.swing.*;
import java.awt.*;

public class TelaMeuPerfilUsuario extends javax.swing.JFrame {

    private int idUsuario;
    private boolean veioDeMeusChamados = false;

    public void setVeioDeMeusChamados(boolean veioDeMeusChamados) {
        this.veioDeMeusChamados = veioDeMeusChamados;
    }

    public TelaMeuPerfilUsuario() {
        initComponents();
        jDateChooserDataNasc.setEnabled(false);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarVisual();
    }

    public TelaMeuPerfilUsuario(int idUsuario) {
        initComponents();
        jDateChooserDataNasc.setEnabled(false);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarVisual();
        this.idUsuario = idUsuario;
        carregarPerfil();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblMarca = new javax.swing.JLabel();
        lblMarcaSub = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        painelCabecalho = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblPapel = new javax.swing.JLabel();
        lblPapelSub = new javax.swing.JLabel();
        painelIdentidade = new javax.swing.JPanel();
        lblSeguranca = new javax.swing.JLabel();
        lblSegurancaSub = new javax.swing.JLabel();
        btnAlterarSenha = new javax.swing.JButton();
        painelSeguranca = new javax.swing.JPanel();
        painelLateral = new javax.swing.JPanel();
        lbljTextFieldNomeUsuario = new javax.swing.JLabel();
        jTextFieldNomeUsuario = new javax.swing.JTextField();
        lbljTextFieldEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        lbljTextFieldTelefone = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        lbljDateChooserDataNasc = new javax.swing.JLabel();
        jDateChooserDataNasc = new com.toedter.calendar.JDateChooser();
        lbljFormattedTextFieldCPF = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        lblPessoais = new javax.swing.JLabel();
        lblPessoaisSub = new javax.swing.JLabel();
        painelPessoais = new javax.swing.JPanel();
        lbljFormattedTextFieldCEP = new javax.swing.JLabel();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        lbljComboBoxEstado = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        lbljTextFieldCidade = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        lbljTextFieldBairro = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        lbljTextFieldRua = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        lbljTextFieldNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        lbljTextFieldComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblEnderecoSub = new javax.swing.JLabel();
        painelEndereco = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        lblRodape = new javax.swing.JLabel();
        painelAcoes = new javax.swing.JPanel();
        painelFormulario = new javax.swing.JPanel();
        painelPrincipal = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Meu perfil");
        lblMarca.setText("ContrataJá");
        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblMarca.setForeground(new java.awt.Color(0x064DC7));
        lblMarcaSub.setText("SUPORTE");
        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMarcaSub.setForeground(new java.awt.Color(0x526785));
        lblTitulo.setText("Meu perfil");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28));
        lblTitulo.setForeground(new java.awt.Color(0x18243C));
        lblSubtitulo.setText("Consulte e atualize seus dados cadastrais.");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblSubtitulo.setForeground(new java.awt.Color(0x526785));
        jButtonCancelar.setText("‹  Voltar");
        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jButtonCancelar.setForeground(new java.awt.Color(0x243B62));
        jButtonCancelar.setBackground(new java.awt.Color(0xEDF3FD));
        painelCabecalho.setBackground(new java.awt.Color(0xFFFFFF));
        lblAvatar.setText("");
        lblAvatar.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblAvatar.setForeground(new java.awt.Color(0x0754D8));
        lblAvatar.setHorizontalAlignment(0);
        lblPapel.setText("Equipe de suporte");
        lblPapel.setFont(new java.awt.Font("Segoe UI", 1, 15));
        lblPapel.setForeground(new java.awt.Color(0x18243C));
        lblPapel.setHorizontalAlignment(0);
        lblPapelSub.setText("ContrataJá Suporte");
        lblPapelSub.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblPapelSub.setForeground(new java.awt.Color(0x526785));
        lblPapelSub.setHorizontalAlignment(0);
        painelIdentidade.setBackground(new java.awt.Color(0xFFFFFF));
        lblSeguranca.setText("Segurança");
        lblSeguranca.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblSeguranca.setForeground(new java.awt.Color(0x18243C));
        lblSegurancaSub.setText("Proteja sua conta.");
        lblSegurancaSub.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSegurancaSub.setForeground(new java.awt.Color(0x526785));
        btnAlterarSenha.setText("Alterar senha");
        btnAlterarSenha.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnAlterarSenha.setForeground(new java.awt.Color(0xFFFFFF));
        btnAlterarSenha.setBackground(new java.awt.Color(0x0754D8));
        painelSeguranca.setBackground(new java.awt.Color(0xFFFFFF));
        painelLateral.setBackground(new java.awt.Color(0xF3F6FC));
        lbljTextFieldNomeUsuario.setText("Nome completo");
        lbljTextFieldNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldNomeUsuario.setForeground(new java.awt.Color(0x526785));
        jTextFieldNomeUsuario.setEditable(true);
        jTextFieldNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldNomeUsuario.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldNomeUsuario.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldEmail.setText("E-mail");
        lbljTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldEmail.setForeground(new java.awt.Color(0x526785));
        jTextFieldEmail.setEditable(true);
        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldEmail.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldEmail.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldTelefone.setText("Telefone");
        lbljTextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldTelefone.setForeground(new java.awt.Color(0x526785));
        jTextFieldTelefone.setEditable(true);
        jTextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldTelefone.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldTelefone.setForeground(new java.awt.Color(0x18243C));
        lbljDateChooserDataNasc.setText("Data de nascimento");
        lbljDateChooserDataNasc.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljDateChooserDataNasc.setForeground(new java.awt.Color(0x526785));
        jDateChooserDataNasc.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jDateChooserDataNasc.setBackground(new java.awt.Color(0xFFFFFF));
        jDateChooserDataNasc.setForeground(new java.awt.Color(0x18243C));
        jDateChooserDataNasc.setDateFormatString("dd/MM/yyyy");
        lbljFormattedTextFieldCPF.setText("CPF (somente leitura)");
        lbljFormattedTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljFormattedTextFieldCPF.setForeground(new java.awt.Color(0x526785));
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jFormattedTextFieldCPF.setBackground(new java.awt.Color(0xF1F5FA));
        jFormattedTextFieldCPF.setForeground(new java.awt.Color(0x18243C));
        lblPessoais.setText("Informações pessoais");
        lblPessoais.setFont(new java.awt.Font("Segoe UI", 1, 19));
        lblPessoais.setForeground(new java.awt.Color(0x18243C));
        lblPessoaisSub.setText("Dados da conta de suporte.");
        lblPessoaisSub.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblPessoaisSub.setForeground(new java.awt.Color(0x526785));
        painelPessoais.setBackground(new java.awt.Color(0xFFFFFF));
        lbljFormattedTextFieldCEP.setText("CEP");
        lbljFormattedTextFieldCEP.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljFormattedTextFieldCEP.setForeground(new java.awt.Color(0x526785));
        jFormattedTextFieldCEP.setEditable(true);
        jFormattedTextFieldCEP.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jFormattedTextFieldCEP.setBackground(new java.awt.Color(0xFFFFFF));
        jFormattedTextFieldCEP.setForeground(new java.awt.Color(0x18243C));
        lbljComboBoxEstado.setText("Estado");
        lbljComboBoxEstado.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljComboBoxEstado.setForeground(new java.awt.Color(0x526785));
        jComboBoxEstado.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jComboBoxEstado.setBackground(new java.awt.Color(0xFFFFFF));
        jComboBoxEstado.setForeground(new java.awt.Color(0x18243C));
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
        lbljTextFieldCidade.setText("Cidade");
        lbljTextFieldCidade.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldCidade.setForeground(new java.awt.Color(0x526785));
        jTextFieldCidade.setEditable(true);
        jTextFieldCidade.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldCidade.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldCidade.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldBairro.setText("Bairro");
        lbljTextFieldBairro.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldBairro.setForeground(new java.awt.Color(0x526785));
        jTextFieldBairro.setEditable(true);
        jTextFieldBairro.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldBairro.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldBairro.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldRua.setText("Rua");
        lbljTextFieldRua.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldRua.setForeground(new java.awt.Color(0x526785));
        jTextFieldRua.setEditable(true);
        jTextFieldRua.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldRua.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldRua.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldNumero.setText("Número");
        lbljTextFieldNumero.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldNumero.setForeground(new java.awt.Color(0x526785));
        jTextFieldNumero.setEditable(true);
        jTextFieldNumero.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldNumero.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldNumero.setForeground(new java.awt.Color(0x18243C));
        lbljTextFieldComplemento.setText("Complemento");
        lbljTextFieldComplemento.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lbljTextFieldComplemento.setForeground(new java.awt.Color(0x526785));
        jTextFieldComplemento.setEditable(true);
        jTextFieldComplemento.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextFieldComplemento.setBackground(new java.awt.Color(0xFFFFFF));
        jTextFieldComplemento.setForeground(new java.awt.Color(0x18243C));
        lblEndereco.setText("Endereço");
        lblEndereco.setFont(new java.awt.Font("Segoe UI", 1, 19));
        lblEndereco.setForeground(new java.awt.Color(0x18243C));
        lblEnderecoSub.setText("Mantenha seu endereço atualizado.");
        lblEnderecoSub.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblEnderecoSub.setForeground(new java.awt.Color(0x526785));
        painelEndereco.setBackground(new java.awt.Color(0xFFFFFF));
        jButtonSalvar.setText("Salvar alterações");
        jButtonSalvar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jButtonSalvar.setForeground(new java.awt.Color(0xFFFFFF));
        jButtonSalvar.setBackground(new java.awt.Color(0x0754D8));
        lblRodape.setText("As alterações são salvas na sua conta.");
        lblRodape.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblRodape.setForeground(new java.awt.Color(0x526785));
        painelAcoes.setBackground(new java.awt.Color(0xF3F6FC));
        painelFormulario.setBackground(new java.awt.Color(0xF3F6FC));
        painelPrincipal.setBackground(new java.awt.Color(0xF3F6FC));
        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(24)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblMarcaSub, javax.swing.GroupLayout.DEFAULT_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(24)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(14).addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(24)));
        painelCabecalhoLayout.setVerticalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(15)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblMarcaSub, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(15)));
        javax.swing.GroupLayout painelIdentidadeLayout = new javax.swing.GroupLayout(painelIdentidade);
        painelIdentidade.setLayout(painelIdentidadeLayout);
        painelIdentidadeLayout.setHorizontalGroup(painelIdentidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelIdentidadeLayout.createSequentialGroup().addGap(16)
                .addGroup(painelIdentidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblPapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblPapelSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(16)));
        painelIdentidadeLayout.setVerticalGroup(painelIdentidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelIdentidadeLayout.createSequentialGroup().addGap(23).addComponent(lblAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8).addComponent(lblPapel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblPapelSub, javax.swing.GroupLayout.DEFAULT_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(22)));
        javax.swing.GroupLayout painelSegurancaLayout = new javax.swing.GroupLayout(painelSeguranca);
        painelSeguranca.setLayout(painelSegurancaLayout);
        painelSegurancaLayout.setHorizontalGroup(painelSegurancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelSegurancaLayout.createSequentialGroup().addGap(16)
                .addGroup(painelSegurancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblSeguranca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblSegurancaSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnAlterarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(16)));
        painelSegurancaLayout.setVerticalGroup(painelSegurancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelSegurancaLayout.createSequentialGroup().addGap(16).addComponent(lblSeguranca, javax.swing.GroupLayout.DEFAULT_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblSegurancaSub, javax.swing.GroupLayout.DEFAULT_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15).addComponent(btnAlterarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(16)));
        javax.swing.GroupLayout painelLateralLayout = new javax.swing.GroupLayout(painelLateral);
        painelLateral.setLayout(painelLateralLayout);
        painelLateralLayout.setHorizontalGroup(painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelIdentidade, 0, 225, Short.MAX_VALUE).addComponent(painelSeguranca, 0, 225, Short.MAX_VALUE));
        painelLateralLayout.setVerticalGroup(painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLateralLayout.createSequentialGroup().addComponent(painelIdentidade, javax.swing.GroupLayout.DEFAULT_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(14).addComponent(painelSeguranca, javax.swing.GroupLayout.DEFAULT_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        javax.swing.GroupLayout painelPessoaisLayout = new javax.swing.GroupLayout(painelPessoais);
        painelPessoais.setLayout(painelPessoaisLayout);
        painelPessoaisLayout.setHorizontalGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelPessoaisLayout.createSequentialGroup().addGap(18)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblPessoaisSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPessoaisLayout.createSequentialGroup()
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldNomeUsuario, 0, 265, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldEmail, 0, 265, Short.MAX_VALUE)))
                .addGroup(painelPessoaisLayout.createSequentialGroup()
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldTelefone, 0, 265, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljDateChooserDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jDateChooserDataNasc, 0, 265, Short.MAX_VALUE)))
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljFormattedTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jFormattedTextFieldCPF, 0, 265, Short.MAX_VALUE))).addGap(18)));
        painelPessoaisLayout.setVerticalGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelPessoaisLayout.createSequentialGroup().addGap(14).addComponent(lblPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblPessoaisSub, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(13)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextFieldNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljDateChooserDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jDateChooserDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljFormattedTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(16)));
        javax.swing.GroupLayout painelEnderecoLayout = new javax.swing.GroupLayout(painelEndereco);
        painelEndereco.setLayout(painelEnderecoLayout);
        painelEnderecoLayout.setHorizontalGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEnderecoLayout.createSequentialGroup().addGap(18)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblEnderecoSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljFormattedTextFieldCEP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jFormattedTextFieldCEP, 0, 180, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljComboBoxEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jComboBoxEstado, 0, 180, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldCidade, 0, 180, Short.MAX_VALUE)))
                .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldBairro, 0, 265, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldRua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldRua, 0, 265, Short.MAX_VALUE)))
                .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldNumero, 0, 265, Short.MAX_VALUE)).addGap(16)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextFieldComplemento, 0, 265, Short.MAX_VALUE)))).addGap(18)));
        painelEnderecoLayout.setVerticalGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEnderecoLayout.createSequentialGroup().addGap(14).addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblEnderecoSub, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(13)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljFormattedTextFieldCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljComboBoxEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jComboBoxEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljTextFieldRua, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextFieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jTextFieldRua, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbljTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lbljTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(4)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(16)));
        javax.swing.GroupLayout painelAcoesLayout = new javax.swing.GroupLayout(painelAcoes);
        painelAcoes.setLayout(painelAcoesLayout);
        painelAcoesLayout.setHorizontalGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAcoesLayout.createSequentialGroup().addComponent(lblRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(12).addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)));
        painelAcoesLayout.setVerticalGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblRodape, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE));
        javax.swing.GroupLayout painelFormularioLayout = new javax.swing.GroupLayout(painelFormulario);
        painelFormulario.setLayout(painelFormularioLayout);
        painelFormularioLayout.setHorizontalGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPessoais, 0, 660, Short.MAX_VALUE).addComponent(painelEndereco, 0, 660, Short.MAX_VALUE).addComponent(painelAcoes, 0, 660, Short.MAX_VALUE));
        painelFormularioLayout.setVerticalGroup(painelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelFormularioLayout.createSequentialGroup().addComponent(painelPessoais).addGap(12).addComponent(painelEndereco).addGap(14).addComponent(painelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createSequentialGroup().addGap(22).addComponent(painelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(16).addComponent(painelFormulario, 0, 700, Short.MAX_VALUE).addGap(22)));
        painelPrincipalLayout.setVerticalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelPrincipalLayout.createSequentialGroup().addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(16)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(20)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jButtonSalvar.addActionListener(this::jButtonSalvarActionPerformed);
        jButtonCancelar.addActionListener(this::jButtonCancelarActionPerformed);
        btnAlterarSenha.addActionListener(this::btnAlterarSenhaActionPerformed);
        jFormattedTextFieldCEP.addActionListener(this::jFormattedTextFieldCEPActionPerformed);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void jFormattedTextFieldCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCEPActionPerformed
        // A consulta automática do CEP ainda não foi implementada.
    }//GEN-LAST:event_jFormattedTextFieldCEPActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            com.google.gson.JsonObject dados = new com.google.gson.JsonObject();
            dados.addProperty("nome", jTextFieldNomeUsuario.getText().trim());
            dados.addProperty("email", jTextFieldEmail.getText().trim());
            dados.addProperty("telefone", jTextFieldTelefone.getText().trim());
            dados.addProperty("cep", jFormattedTextFieldCEP.getText().trim());
            String estado = (String) jComboBoxEstado.getSelectedItem();
            dados.addProperty("estado", "UF".equals(estado) ? null : estado);
            dados.addProperty("cidade", jTextFieldCidade.getText().trim());
            dados.addProperty("bairro", jTextFieldBairro.getText().trim());
            dados.addProperty("rua", jTextFieldRua.getText().trim());
            dados.addProperty("numeroCasa", jTextFieldNumero.getText().trim());
            dados.addProperty("complemento", jTextFieldComplemento.getText().trim());
            ApiClient api = new ApiClient();
            api.atualizarPerfilSuporte(idUsuario, dados);
            JOptionPane.showMessageDialog(this, "Perfil atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar perfil: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (veioDeMeusChamados) {
            new MeusChamados(idUsuario).setVisible(true);
        } else {
            new ChamadosDisponiveis(idUsuario).setVisible(true);
        }

        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void btnAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSenhaActionPerformed
        TelaAlterarSenha tela = new TelaAlterarSenha(idUsuario);
        tela.setVeioDeMeusChamados(veioDeMeusChamados);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAlterarSenhaActionPerformed

    private void carregarPerfil() {
        try {
            ApiClient api = new ApiClient();
            String resposta = api.buscarPerfilSuporte(idUsuario);
            com.google.gson.JsonObject perfil = com.google.gson.JsonParser.parseString(resposta).getAsJsonObject();
            jTextFieldNomeUsuario.setText(perfil.get("nome").getAsString());
            jTextFieldEmail.setText(perfil.get("email").getAsString());
            jTextFieldTelefone.setText(perfil.get("telefone").getAsString());
            jFormattedTextFieldCPF.setText(perfil.get("cpf").getAsString());
            if (perfil.has("dataNasc") && !perfil.get("dataNasc").isJsonNull()) {
                String dataNascimento = perfil.get("dataNasc").getAsString();
                jDateChooserDataNasc.setDate(java.sql.Date.valueOf(dataNascimento));
            }
            jFormattedTextFieldCEP.setText(perfil.has("cep") && !perfil.get("cep").isJsonNull() ? perfil.get("cep").getAsString() : "");
            String estado = perfil.has("estado") && !perfil.get("estado").isJsonNull() ? perfil.get("estado").getAsString() : "UF";
            jComboBoxEstado.setSelectedItem(estado);
            jTextFieldCidade.setText(perfil.has("cidade") && !perfil.get("cidade").isJsonNull() ? perfil.get("cidade").getAsString() : "");
            jTextFieldBairro.setText(perfil.has("bairro") && !perfil.get("bairro").isJsonNull() ? perfil.get("bairro").getAsString() : "");
            jTextFieldRua.setText(perfil.has("rua") && !perfil.get("rua").isJsonNull() ? perfil.get("rua").getAsString() : "");
            jTextFieldNumero.setText(perfil.has("numeroCasa") && !perfil.get("numeroCasa").isJsonNull() ? perfil.get("numeroCasa").getAsString() : "");
            jTextFieldComplemento.setText(perfil.has("complemento") && !perfil.get("complemento").isJsonNull() ? perfil.get("complemento").getAsString() : "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar perfil: " + e.getMessage());
        }
    }

    private void configurarVisual() {
        for (JPanel p : new JPanel[]{painelCabecalho, painelIdentidade, painelSeguranca, painelPessoais, painelEndereco}) {
            estilizarPainel(p);
        }
        for (JButton b : new JButton[]{jButtonCancelar, jButtonSalvar, btnAlterarSenha}) {
            estilizarBotao(b);
        }
        for (JTextField f : new JTextField[]{jTextFieldNomeUsuario, jTextFieldEmail, jTextFieldTelefone, jFormattedTextFieldCPF, jFormattedTextFieldCEP, jTextFieldCidade, jTextFieldBairro, jTextFieldRua, jTextFieldNumero, jTextFieldComplemento}) {
            estilizarCampo(f);
        }
        lblAvatar.setIcon(new Icon() {
            public int getIconWidth() {
                return 112;
            }

            public int getIconHeight() {
                return 112;
            }

            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D p = (Graphics2D) g.create();
                p.translate(x, y);
                p.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                p.setColor(new Color(0xE0ECFF));
                p.fillOval(0, 0, 112, 112);
                p.setColor(new Color(0x0754D8));
                p.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                p.drawArc(28, 23, 56, 53, 0, 180);
                p.fillRoundRect(24, 48, 13, 25, 8, 8);
                p.fillRoundRect(75, 48, 13, 25, 8, 8);
                p.drawArc(48, 57, 31, 30, 270, 90);
                p.fillRoundRect(48, 83, 13, 6, 5, 5);
                p.dispose();
            }});
        lblAvatar.setToolTipText("Avatar institucional do suporte ContrataJá");
        setMinimumSize(new Dimension(850, 680));
        setLocationRelativeTo(null);
    }

    private void estilizarBotao(JButton b) {
        b.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                AbstractButton botao = (AbstractButton) c;
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color bg = botao.isEnabled() ? botao.getBackground() : new Color(0xEDF1F6);
                if (botao.isEnabled() && botao.getModel().isPressed()) {
                    bg = bg.darker();
                } else if (botao.isEnabled() && botao.getModel().isRollover()) {
                    bg = bg.darker();
                }
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                g2.setColor(new Color(0xD6E1EF));
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 14, 14);
                if (botao.hasFocus()) {
                    g2.setColor(new Color(0x7BA9F8));
                    g2.drawRoundRect(3, 3, c.getWidth() - 7, c.getHeight() - 7, 10, 10);
                }
                g2.dispose();
                super.paint(g, c);
            }});
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void estilizarCampo(JTextField f) {
        f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0xD5DFEE)), BorderFactory.createEmptyBorder(0, 11, 0, 9)));
        f.setCaretColor(new Color(0x0754D8));
    }

    private void estilizarPainel(JPanel p) {
        p.setBorder(BorderFactory.createLineBorder(new Color(0xDFE6F1)));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaMeuPerfilUsuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblPapel;
    private javax.swing.JLabel lblPapelSub;
    private javax.swing.JPanel painelIdentidade;
    private javax.swing.JLabel lblSeguranca;
    private javax.swing.JLabel lblSegurancaSub;
    private javax.swing.JButton btnAlterarSenha;
    private javax.swing.JPanel painelSeguranca;
    private javax.swing.JPanel painelLateral;
    private javax.swing.JLabel lbljTextFieldNomeUsuario;
    private javax.swing.JTextField jTextFieldNomeUsuario;
    private javax.swing.JLabel lbljTextFieldEmail;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JLabel lbljTextFieldTelefone;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JLabel lbljDateChooserDataNasc;
    private com.toedter.calendar.JDateChooser jDateChooserDataNasc;
    private javax.swing.JLabel lbljFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel lblPessoais;
    private javax.swing.JLabel lblPessoaisSub;
    private javax.swing.JPanel painelPessoais;
    private javax.swing.JLabel lbljFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JLabel lbljComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel lbljTextFieldCidade;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JLabel lbljTextFieldBairro;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JLabel lbljTextFieldRua;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JLabel lbljTextFieldNumero;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JLabel lbljTextFieldComplemento;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnderecoSub;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel lblRodape;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
