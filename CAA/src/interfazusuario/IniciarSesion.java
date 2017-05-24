package interfazusuario;

import javax.swing.JOptionPane;
import reglasnegocio.UsuarioDAO;
import reglasnegocio.Usuario;
import interfazusuario.asesor.MenuPrincipalAsesor;

/**
 *
 * @author Miguel Leonardo Jiménez Jiménez
 * @author Adrian Bustamante Zarate
 */
public class IniciarSesion extends javax.swing.JFrame {
    

    /**
     * Crea una nueva ventana de Inicio de sesion
     */
    public IniciarSesion() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void accionBotonIngresar(){
        if(txtUsuario.getText().isEmpty() || jPasswordContrasena.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }else{
            Usuario usuario = new Usuario();
            usuario.setContrasena(jPasswordContrasena.getText());
            usuario.setNombreUsuario(txtUsuario.getText());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            boolean autentificacion = usuarioDAO.autentificarUsuario(usuario.getNombreUsuario(), usuario.getContrasena());
            
            if(autentificacion){
                
                JOptionPane.showMessageDialog(this, "Acceso consedido");
                
                try{
                   usuario = usuarioDAO.sacarDatosUsuario(txtUsuario.getText()); 
                }catch(NullPointerException e){
                    autentificacion = false;
                }
                
                if(autentificacion){
                    if(usuario.getTipo().equals("ASE")){
                        new MenuPrincipalAsesor(usuario.getIdUsuario()).setVisible(true);
                        dispose();
                    }else if(usuario.getTipo().equals("COOR")){
                        //new MenuPrincipalCoordinador(usuario.getIdUsuario()).setVisible(true);
                        //dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Error al comprobar informacion porfavor vuelva a intentarlo");
                    txtUsuario.setText("");
                    jPasswordContrasena.setText("");
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Datos incorrectos");
                txtUsuario.setText("");
                jPasswordContrasena.setText("");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jPasswordContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificarIp = new javax.swing.JButton();
        jLabelCOntraseña = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 140, 30));
        getContentPane().add(jPasswordContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 140, 30));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        btnModificarIp.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btnModificarIp.setForeground(new java.awt.Color(0, 153, 255));
        btnModificarIp.setText("Modificar IP");
        btnModificarIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarIpActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarIp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 100, 20));

        jLabelCOntraseña.setText("Contraseña:");
        getContentPane().add(jLabelCOntraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoProyectoCAA.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel3");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        accionBotonIngresar();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIpActionPerformed
        try {
            new CofigurarBDD().setVisible(true);
        } catch (Exception ex) {
            
        }
        dispose();
    }//GEN-LAST:event_btnModificarIpActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificarIp;
    private javax.swing.JLabel jLabelCOntraseña;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
