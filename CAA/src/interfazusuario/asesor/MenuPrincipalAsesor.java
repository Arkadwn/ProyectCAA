package interfazusuario.asesor;

import interfazusuario.IniciarSesion;
import reglasnegocio.asesor.IAsesorDAO;
import reglasnegocio.entidades.Asesor;

/**
 *
 * @author Miguel Leonardo Jiménez Jiménez
 * @author Adrian Bustamante Zarate
 */
public class MenuPrincipalAsesor extends javax.swing.JFrame {
    
        
    private Asesor asesor;
    private IAsesorDAO asesorDAO;

    /**
     * Crea una nueva ventana del menu principal del coordinador
     */
    public MenuPrincipalAsesor() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public MenuPrincipalAsesor(String nombreUsuario){
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        labelFondo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        opcionSeguimiento = new javax.swing.JMenuItem();
        opcionActividades = new javax.swing.JMenuItem();
        opcionAvisos = new javax.swing.JMenuItem();
        opcionCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoProyectoCAA.jpg"))); // NOI18N

        escritorio.setLayer(labelFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(escritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelFondo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(escritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelFondo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 600));

        menu.setText("Menu Principal");

        opcionSeguimiento.setText("Seguimiento usuario autonomo");
        menu.add(opcionSeguimiento);

        opcionActividades.setText("Consultar actividades");
        opcionActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionActividadesActionPerformed(evt);
            }
        });
        menu.add(opcionActividades);

        opcionAvisos.setText("Avisos");
        opcionAvisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAvisosActionPerformed(evt);
            }
        });
        menu.add(opcionAvisos);

        opcionCerrar.setText("Cerrar sesion");
        opcionCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCerrarActionPerformed(evt);
            }
        });
        menu.add(opcionCerrar);

        barraMenu.add(menu);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionActividadesActionPerformed
        ConsultarActividades consultarActividades = new ConsultarActividades(escritorio);
        escritorio.add(consultarActividades);
        consultarActividades.show();
    }//GEN-LAST:event_opcionActividadesActionPerformed

    private void opcionAvisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAvisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionAvisosActionPerformed

    private void opcionCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCerrarActionPerformed
        new IniciarSesion().setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAsesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalAsesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem opcionActividades;
    private javax.swing.JMenuItem opcionAvisos;
    private javax.swing.JMenuItem opcionCerrar;
    private javax.swing.JMenuItem opcionSeguimiento;
    // End of variables declaration//GEN-END:variables
}
