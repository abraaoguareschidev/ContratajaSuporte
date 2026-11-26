package view;

import api.ApiClient;
import javax.swing.*;
import java.awt.*;

public class TelaAlterarSenha extends javax.swing.JFrame {

    private int idUsuario;
    private boolean veioDeMeusChamados = false;

    public void setVeioDeMeusChamados(boolean veioDeMeusChamados) {
        this.veioDeMeusChamados = veioDeMeusChamados;
    }

    private void voltarAoPerfil() {
        TelaMeuPerfilUsuario tela = new TelaMeuPerfilUsuario(idUsuario);
        tela.setVeioDeMeusChamados(veioDeMeusChamados);
        tela.setVisible(true);
        dispose();
    }

    public TelaAlterarSenha() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarVisual();
    }

    public TelaAlterarSenha(int idUsuario) {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        configurarVisual();
        this.idUsuario = idUsuario;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblMarca = new javax.swing.JLabel();
        lblMarcaSub = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        painelCabecalho = new javax.swing.JPanel();
        lblCadeado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblSenhaAtual = new javax.swing.JLabel();
        txtSenhaAtual = new javax.swing.JPasswordField();
        lblNovaSenha = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        lblDica = new javax.swing.JLabel();
        SalvarSenha = new javax.swing.JButton();
        painelSenha = new javax.swing.JPanel();
        painelPrincipal = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ContrataJá Suporte | Alterar senha");
        lblMarca.setText("ContrataJá");
        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblMarca.setForeground(new java.awt.Color(0x064DC7));
        lblMarcaSub.setText("SUPORTE");
        lblMarcaSub.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMarcaSub.setForeground(new java.awt.Color(0x526785));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnCancelar.setForeground(new java.awt.Color(0x243B62));
        btnCancelar.setBackground(new java.awt.Color(0xEDF3FD));
        painelCabecalho.setBackground(new java.awt.Color(0xFFFFFF));
        lblCadeado.setText("");
        lblCadeado.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblCadeado.setForeground(new java.awt.Color(0x0754D8));
        lblCadeado.setHorizontalAlignment(0);
        lblTitulo.setText("Alterar senha");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 27));
        lblTitulo.setForeground(new java.awt.Color(0x18243C));
        lblTitulo.setHorizontalAlignment(0);
        lblSubtitulo.setText("Atualize sua senha de acesso ao sistema.");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblSubtitulo.setForeground(new java.awt.Color(0x526785));
        lblSubtitulo.setHorizontalAlignment(0);
        lblSenhaAtual.setText("Senha atual");
        lblSenhaAtual.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblSenhaAtual.setForeground(new java.awt.Color(0x526785));
        txtSenhaAtual.setEditable(true);
        txtSenhaAtual.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtSenhaAtual.setBackground(new java.awt.Color(0xFFFFFF));
        txtSenhaAtual.setForeground(new java.awt.Color(0x18243C));
        lblNovaSenha.setText("Nova senha");
        lblNovaSenha.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblNovaSenha.setForeground(new java.awt.Color(0x526785));
        txtNovaSenha.setEditable(true);
        txtNovaSenha.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtNovaSenha.setBackground(new java.awt.Color(0xFFFFFF));
        txtNovaSenha.setForeground(new java.awt.Color(0x18243C));
        lblConfirmarSenha.setText("Confirmar nova senha");
        lblConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblConfirmarSenha.setForeground(new java.awt.Color(0x526785));
        txtConfirmarSenha.setEditable(true);
        txtConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtConfirmarSenha.setBackground(new java.awt.Color(0xFFFFFF));
        txtConfirmarSenha.setForeground(new java.awt.Color(0x18243C));
        lblDica.setText("Use no mínimo 8 caracteres.");
        lblDica.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblDica.setForeground(new java.awt.Color(0x526785));
        SalvarSenha.setText("Salvar nova senha");
        SalvarSenha.setFont(new java.awt.Font("Segoe UI", 1, 13));
        SalvarSenha.setForeground(new java.awt.Color(0xFFFFFF));
        SalvarSenha.setBackground(new java.awt.Color(0x0754D8));
        painelSenha.setBackground(new java.awt.Color(0xFFFFFF));
        painelPrincipal.setBackground(new java.awt.Color(0xF3F6FC));
        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(25)
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblMarcaSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(25)));
        painelCabecalhoLayout.setVerticalGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCabecalhoLayout.createSequentialGroup().addGap(13).addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblMarcaSub, javax.swing.GroupLayout.DEFAULT_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(12)));
        javax.swing.GroupLayout painelSenhaLayout = new javax.swing.GroupLayout(painelSenha);
        painelSenha.setLayout(painelSenhaLayout);
        painelSenhaLayout.setHorizontalGroup(painelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelSenhaLayout.createSequentialGroup().addGap(28)
                .addGroup(painelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblCadeado, 0, 390, Short.MAX_VALUE).addComponent(lblTitulo, 0, 390, Short.MAX_VALUE).addComponent(lblSubtitulo, 0, 390, Short.MAX_VALUE).addComponent(lblSenhaAtual, 0, 390, Short.MAX_VALUE).addComponent(txtSenhaAtual, 0, 390, Short.MAX_VALUE).addComponent(lblNovaSenha, 0, 390, Short.MAX_VALUE).addComponent(txtNovaSenha, 0, 390, Short.MAX_VALUE).addComponent(lblConfirmarSenha, 0, 390, Short.MAX_VALUE).addComponent(txtConfirmarSenha, 0, 390, Short.MAX_VALUE).addComponent(lblDica, 0, 390, Short.MAX_VALUE)
                .addGroup(painelSenhaLayout.createSequentialGroup().addComponent(SalvarSenha, 0, 238, Short.MAX_VALUE).addGap(12).addComponent(btnCancelar, 0, 140, Short.MAX_VALUE))).addGap(28)));
        painelSenhaLayout.setVerticalGroup(painelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelSenhaLayout.createSequentialGroup().addGap(18).addComponent(lblCadeado, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(7).addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20).addComponent(lblSenhaAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5).addComponent(txtSenhaAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(13).addComponent(lblNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5).addComponent(txtNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(13).addComponent(lblConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5).addComponent(txtConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8).addComponent(lblDica, javax.swing.GroupLayout.DEFAULT_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20)
                .addGroup(painelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(SalvarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(22)));
        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createSequentialGroup().addGap(55, 55, Short.MAX_VALUE).addComponent(painelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(55, 55, Short.MAX_VALUE)));
        painelPrincipalLayout.setVerticalGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelPrincipalLayout.createSequentialGroup().addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20, 20, Short.MAX_VALUE).addComponent(painelSenha).addGap(22, 22, Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        SalvarSenha.addActionListener(this::SalvarSenhaActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void SalvarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarSenhaActionPerformed
        String senhaAtual = new String(txtSenhaAtual.getPassword());
        String novaSenha = new String(txtNovaSenha.getPassword());
        String confirmarSenha = new String(txtConfirmarSenha.getPassword());
        if (senhaAtual.isBlank() || novaSenha.isBlank() || confirmarSenha.isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }
        if (novaSenha.length() < 8) {
            JOptionPane.showMessageDialog(this, "A nova senha deve ter pelo menos 8 caracteres.");
            return;
        }
        if (!novaSenha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem.");
            return;
        }
        try {
            ApiClient api = new ApiClient();
            api.alterarSenha(idUsuario, senhaAtual, novaSenha);
            JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!");
            voltarAoPerfil();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar senha: " + e.getMessage());
        }
    }//GEN-LAST:event_SalvarSenhaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        voltarAoPerfil();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void configurarVisual() {
        estilizarPainel(painelCabecalho);
        estilizarPainel(painelSenha);
        estilizarBotao(SalvarSenha);
        estilizarBotao(btnCancelar);
        for (JPasswordField f : new JPasswordField[]{txtSenhaAtual, txtNovaSenha, txtConfirmarSenha}) {
            estilizarCampo(f);
        }
        lblCadeado.setIcon(new Icon() {
            public int getIconWidth() {
                return 56;
            }

            public int getIconHeight() {
                return 56;
            }

            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D p = (Graphics2D) g.create();
                p.translate(x, y);
                p.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                p.setColor(new Color(0xE0ECFF));
                p.fillRoundRect(0, 0, 56, 56, 16, 16);
                p.setColor(new Color(0x0754D8));
                p.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                p.drawRoundRect(16, 25, 24, 20, 5, 5);
                p.drawArc(20, 13, 16, 20, 0, 180);
                p.drawLine(20, 23, 20, 25);
                p.drawLine(36, 23, 36, 25);
                p.fillOval(26, 31, 4, 4);
                p.drawLine(28, 34, 28, 38);
                p.dispose();
            }
        });
        getRootPane().setDefaultButton(SalvarSenha);
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
            }
        });
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
        java.awt.EventQueue.invokeLater(() -> new TelaAlterarSenha().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarcaSub;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JLabel lblCadeado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblSenhaAtual;
    private javax.swing.JPasswordField txtSenhaAtual;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JLabel lblDica;
    private javax.swing.JButton SalvarSenha;
    private javax.swing.JPanel painelSenha;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
