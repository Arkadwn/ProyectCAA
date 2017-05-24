package interfazusuario;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.JOptionPane;
import reglasnegocio.DatosConexionBDD;
import reglasnegocio.utilerias.UtileriasConexionBDD;
import reglasnegocio.utilerias.UtileriasEncriptado;

public class CofigurarBDD extends javax.swing.JFrame {

    public CofigurarBDD() throws BadPaddingException, Exception {
        initComponents();
        cargarConfiguracion();
        setLocationRelativeTo(null);
    }

    private void cargarConfiguracion() throws IllegalBlockSizeException, BadPaddingException {
        File archivo = new File("C:\\Archivos\\dataBDD.ser");
        if (archivo.exists()) {
            try {
                DatosConexionBDD datosBDD = UtileriasConexionBDD.obtenerDatosBDD();
                txtIP.setText(datosBDD.getDireccionIP());
                txtUsuario.setText(datosBDD.getUsuario());
                txtContraseña.setText(UtileriasEncriptado.descifra(datosBDD.getContraseña()));
            } catch (Exception ex) {
                //Logger.getLogger(CofigurarBDD.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ah ocurrido un error al cargar la configuración grabada, se mostrara la de por default");
            }
        } else {
            creacionDirectorio();
        }
    }

    private void creacionDirectorio() {
        try {
            File carpeta = new File("C:\\Archivos");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
            txtIP.setText("x.x.x.x");
            txtUsuario.setText("Usuario");
            txtContraseña.setText("contraseña");
            if (!carpeta.exists()) {
                JOptionPane.showMessageDialog(this, "Error al crear el directorio");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lo lamento, ah ocurrido un error al crear el directorio");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        labelConfig = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        labelIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexión a la BDD");

        labelTitulo.setText("Configuración al servidor de la BDD:");

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        labelConfig.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        labelConfig.setText("Configuración actual");

        labelUsuario.setText("Usuario:");

        labelContraseña.setText("Contraseña:");

        labelIP.setText("IP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelConfig)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelUsuario)
                                        .addComponent(labelContraseña)
                                        .addComponent(labelIP))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIP, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                        .addComponent(txtContraseña))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(labelTitulo)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConectar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelTitulo)
                .addGap(1, 1, 1)
                .addComponent(labelConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIP))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        try {
            if (UtileriasConexionBDD.comprobarConexionBDD(txtIP.getText(), txtUsuario.getText(), txtContraseña.getText())) {
                guardarConfiguracion();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CofigurarBDD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo conectar al servidor, revise configuración de red: " + ex.getSQLState());//Revisar
        } catch (BadPaddingException ex) {
            //Logger.getLogger(CofigurarBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al tratar de guardar la configuración actual");
            //Logger.getLogger(CofigurarBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    public void guardarConfiguracion() throws IllegalBlockSizeException, BadPaddingException, Exception {
        byte[] contraseña = UtileriasEncriptado.cifra(txtContraseña.getText());
        UtileriasConexionBDD.serializarDatosBDD(txtIP.getText(), txtUsuario.getText(), contraseña);
        JOptionPane.showMessageDialog(this, "Conexión establecida");
        new IniciarSesion().setVisible(true);
        dispose();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CofigurarBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CofigurarBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CofigurarBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CofigurarBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CofigurarBDD().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CofigurarBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConectar;
    private javax.swing.JLabel labelConfig;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
