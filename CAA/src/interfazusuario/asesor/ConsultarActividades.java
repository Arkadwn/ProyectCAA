package interfazusuario.asesor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reglasnegocio.asesor.IActividadProgramadaDAO;
import reglasnegocio.asesor.IIdiomaDAOAsesor;
import reglasnegocio.asesor.IListaAsistenciaDAO;
import reglasnegocio.entidades.ActividadProgramada;
import reglasnegocio.entidades.Asesor;
import reglasnegocio.entidades.ExperienciaEducativa;
import reglasnegocio.entidades.Idioma;
import reglasnegocio.entidades.ListaAsistencia;
import reglasnegocio.entidades.UsuarioAutonomo;
import reglasnegocio.entidadesDAO.ActividadProgramadaDAO;
import reglasnegocio.entidadesDAO.ExperEduDAO;
import reglasnegocio.entidadesDAO.IdiomaDAO;
import reglasnegocio.entidadesDAO.ListaAsistenciaDAO;
import reglasnegocio.utilerias.Bitacora;

/**
 * Interfaz grafica del CU-06
 * 
 * @author Miguel Leonardo Jimenez Jimenez
 * @author Adrian Bustamante Zarate
 */
public class ConsultarActividades extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultarActividades
     */
    private DefaultTableModel contenidoTabla;
    private JDesktopPane escritorio;
    private IActividadProgramadaDAO actividadProgramDAO;
    private List<ActividadProgramada> actividades;
    private Asesor asesor;
    private DefaultListModel contenidoLista;
    
    /**
     * Constructor sobre cargado de ConsultarActividades.
     * 
     * @param escritorio jDesktop del menu principal
     * @param asesor datos del aseosr que ha iniciado sesion.
     */
    public ConsultarActividades(JDesktopPane escritorio, Asesor asesor) {
        this.asesor = asesor;
        initComponents();
        this.escritorio = escritorio;
        contenidoLista = new DefaultListModel();
        contenidoTabla = new DefaultTableModel();
        cargarIdioma();
    }
    
    private void cargarIdioma(){
        IIdiomaDAOAsesor idiomaDAO= new IdiomaDAO();
        List<Idioma> idiomas = null;
        
        try {
            idiomas = idiomaDAO.mostrarIdiomasActuales();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "A ocurrido un fallo con la conexion, porfavor verifique su conexion a la red");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }
        
        for(Idioma idioma:idiomas){
            comboIdioma.addItem(idioma.getIdIdioma()+"-"+idioma.getNombreIdioma());
        }
    }
    
    /**
     * Se encarga de rellenar la jTable de las actividades
     */
    private void llenarTabla(){
        String idEE;
        String lapso = "";
        
        if(radioHoy.isSelected()){
            lapso = "Hoy";
        }
        if(radioSemana.isSelected()){
            lapso = "Semana";
        }
        
        contenidoTabla = new DefaultTableModel();
        
        actividadProgramDAO = new ActividadProgramadaDAO();
        
        contenidoTabla.addColumn("Actividad");
        contenidoTabla.addColumn("Fecha");
        contenidoTabla.addColumn("Horario");
        contenidoTabla.addColumn("Salon");
        
        try {
            actividades = actividadProgramDAO.sacarActividadesProgramadas(asesor.getNumeroPersonal(), comboCurso.getItemAt(comboCurso.getSelectedIndex()).substring(0,2), lapso);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"A ocurrido un inconveniente, si persiste porfavor verifique su "
                    + "conexion a red");
            Bitacora.guardarBitacora(ActividadProgramadaDAO.class, "Error", ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
            Bitacora.guardarBitacora(ActividadProgramadaDAO.class, "WARN", ex.getMessage());
        }
        
        List<Object[]> datosTabla = new ArrayList();
        
        for(ActividadProgramada actividad : actividades){
            Object[] fila = new Object[] {actividad.getActividad().getNombre(),actividad.getFechaRealizar(),actividad.getHoraInicio()+"-"+actividad.getHoraFin(),actividad.getSalon().getNombreSalon()};
            datosTabla.add(fila);
        }
        
        for(Object[] fila:datosTabla){
            contenidoTabla.addRow(fila);
        }
        
        tablaActividades.setModel(contenidoTabla);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoLapso = new javax.swing.ButtonGroup();
        scrolTabla = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();
        scrolLista = new javax.swing.JScrollPane();
        listAsistentes = new javax.swing.JList<>();
        btnMostrar = new javax.swing.JButton();
        labelIdioma = new javax.swing.JLabel();
        radioSemana = new javax.swing.JRadioButton();
        radioHoy = new javax.swing.JRadioButton();
        comboIdioma = new javax.swing.JComboBox<>();
        labelCurso = new javax.swing.JLabel();
        comboCurso = new javax.swing.JComboBox<>();
        btnAsistencia = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaActividades = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Fecha", "Horario", "Salon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaActividadesMouseClicked(evt);
            }
        });
        scrolTabla.setViewportView(tablaActividades);
        if (tablaActividades.getColumnModel().getColumnCount() > 0) {
            tablaActividades.getColumnModel().getColumn(0).setResizable(false);
            tablaActividades.getColumnModel().getColumn(1).setResizable(false);
            tablaActividades.getColumnModel().getColumn(2).setResizable(false);
            tablaActividades.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(scrolTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, 531, 233));

        scrolLista.setViewportView(listAsistentes);

        getContentPane().add(scrolLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 270, 370));

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 113, -1, -1));

        labelIdioma.setText("Idioma:");
        getContentPane().add(labelIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 27, -1, -1));

        grupoLapso.add(radioSemana);
        radioSemana.setText("Semana");
        getContentPane().add(radioSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 87, -1, -1));

        grupoLapso.add(radioHoy);
        radioHoy.setSelected(true);
        radioHoy.setText("Hoy");
        getContentPane().add(radioHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 114, -1, -1));

        comboIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------------" }));
        comboIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(comboIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 23, 160, -1));

        labelCurso.setText("Curso:");
        getContentPane().add(labelCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 58, -1, -1));

        comboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------------" }));
        comboCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCursoActionPerformed(evt);
            }
        });
        getContentPane().add(comboCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 54, 160, -1));

        btnAsistencia.setText("Tomar asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 411, 187, -1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 411, 113, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoProyectoCAA.jpg"))); // NOI18N
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 930, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(!contenidoLista.isEmpty()){
            contenidoLista.removeAllElements();
        }
        
        llenarTabla();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        if(tablaActividades.getSelectedRow() > -1){
            
            TomarListaDeAsistencia tomarAsistencia = new TomarListaDeAsistencia(actividades.get(tablaActividades.getSelectedRow()));
            escritorio.add(tomarAsistencia);
            tomarAsistencia.show();
        }
        
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void tablaActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaActividadesMouseClicked
        /*Esta a la espera de click por parte del usuario*/
        if(evt.getClickCount() == 2){
            if(!contenidoLista.isEmpty()){
                contenidoLista.removeAllElements();
            }
            List<UsuarioAutonomo> alumnos = new ArrayList<>();
            IListaAsistenciaDAO listaDAO = new ListaAsistenciaDAO();
            ListaAsistencia lista = null;
            
            /*Revisa que este seleccionada alguna fila de la tabla*/
            if(tablaActividades.getSelectedRow() > -1){
                try {
                    lista = listaDAO.sacarListaAsistencia(actividades.get(tablaActividades.getSelectedRow()).getIdActividadProgramada());
                } catch (SQLException ex) {
                    
                } catch (IOException ex) {
                    
                }
            
                alumnos = lista.getListaAsistencia();
                
                /*Rellena el jList de acuerdo a la fila seleccionada de la jTabla*/
                for(UsuarioAutonomo alumno: alumnos){
                    contenidoLista.addElement(alumno.getMatricula()+"-"+alumno.getNombre()+" "+alumno.getApellidoPaterno()+" "+alumno.getApellidoMaterno());
                }
                listAsistentes.setModel(contenidoLista);
            }
        }
    }//GEN-LAST:event_tablaActividadesMouseClicked

    private void comboCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCursoActionPerformed
        
    }//GEN-LAST:event_comboCursoActionPerformed

    private void comboIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdiomaActionPerformed
        ExperEduDAO DAO = new ExperEduDAO();
        ExperienciaEducativa EE;
        comboCurso.removeAllItems();
        List<ExperienciaEducativa> listaEEs = null;
        
        try {
            listaEEs = DAO.mostrarEEPorIdioma(comboIdioma.getItemAt(comboIdioma.getSelectedIndex()).substring(0,2));
        } catch (SQLException ex) {
            
        } catch (IOException ex) {
            
        }
        if (listaEEs.isEmpty()) {
            comboCurso.addItem("Ninguno");
        }
        while (!listaEEs.isEmpty()) {
            EE = listaEEs.remove(0);
            comboCurso.addItem(EE.getIdExperEdu() + "-" + EE.getNombreEE());
        }
    }//GEN-LAST:event_comboIdiomaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JComboBox<String> comboIdioma;
    private javax.swing.ButtonGroup grupoLapso;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelIdioma;
    private javax.swing.JList<String> listAsistentes;
    private javax.swing.JRadioButton radioHoy;
    private javax.swing.JRadioButton radioSemana;
    private javax.swing.JScrollPane scrolLista;
    private javax.swing.JScrollPane scrolTabla;
    private javax.swing.JTable tablaActividades;
    // End of variables declaration//GEN-END:variables
}
