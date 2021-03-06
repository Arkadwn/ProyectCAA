package interfazusuario.coordinador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import reglasnegocio.entidadesDAO.ActividadCatalogoDAO;
import reglasnegocio.entidadesDAO.ExperEduDAO;
import reglasnegocio.entidadesDAO.IdiomaDAO;
import reglasnegocio.entidades.ActividadCatalogo;
import reglasnegocio.entidades.ExperienciaEducativa;
import reglasnegocio.entidades.Idioma;

/**
 * Muestra la ventana referente al CU-20 Administrar catalogo de actividades
 *
 * @author Adrian Bustamante Zarate
 * @author Miguel Leonardo Jimnez
 */
public class CatalogoActividades extends javax.swing.JInternalFrame {

    private String idActividad;

    /**
     * Construye la ventana de Administración de catalogo de catalogo de
     * actividades, inicializa componentes y ejecuta un metodo de carga de
     * idiomas.
     */
    public CatalogoActividades() {
        initComponents();
        cargarIdiomas(comboIdioma);
    }

    /**
     * Carga los idiomas actuales implementando metodos de la capa inferior, los
     * resultados se aplican al combobox que se envia.
     *
     * @param combo Objeto de tipo JComboBox en este se haran los cambios segun
     * los resultados encontrados
     */
    private void cargarIdiomas(JComboBox combo) {
        IdiomaDAO DAO = new IdiomaDAO();
        Idioma idioma;
        List<Idioma> listaIdiomas;
        combo.removeAllItems();

        try {
            listaIdiomas = DAO.mostrarIdiomasActuales();
            combo.addItem("Ninguno");
            while (!listaIdiomas.isEmpty()) {
                idioma = listaIdiomas.remove(0);
                combo.addItem(idioma.getIdIdioma() + "-" + idioma.getNombreIdioma());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar los idiomas actuales, revise conexión a red y reinicie el sistema.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }
    }

    /**
     * Carga todas las EE segun el idIdioma seleccionado previamente
     *
     * @param idIdioma Objeto de tipo String que contiene el id del Idioma a
     * fitrar para obtener las EE
     * @param combo Objeto de tipo JComboBox en este se haran los cambios segun
     * los resultados de las EE concordantes con el Idioma seleccionado
     */
    private void cargarEEs(String idIdioma, JComboBox combo) {
        ExperEduDAO DAO = new ExperEduDAO();
        ExperienciaEducativa EE;
        combo.removeAllItems();
        try {
            List<ExperienciaEducativa> listaEEs = DAO.mostrarEEPorIdioma(idIdioma);
            if (listaEEs.isEmpty()) {
                combo.addItem("Ninguno");
            }
            while (!listaEEs.isEmpty()) {
                EE = listaEEs.remove(0);
                combo.addItem(EE.getIdExperEdu() + "-" + EE.getNombreEE());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar las experiencias educativas, revise conexión a red y reinicie el sistema.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        comboIdioma = new javax.swing.JComboBox<>();
        comboEE = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtBusquedaEdit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        radioNombreEdit = new javax.swing.JRadioButton();
        radioEEEdit = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEdit = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboEEEdit = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripEdit = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        txtNombreEdit = new javax.swing.JTextField();
        btnGuardarEdit = new javax.swing.JButton();
        btnSalirEditar = new javax.swing.JButton();
        btnBuscarEdit = new javax.swing.JButton();
        comboTipoEdit = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listBorrar = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtBusquedaBorrar = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        radioNombreBorrar = new javax.swing.JRadioButton();
        radioEEBorrar = new javax.swing.JRadioButton();
        labelNombreBorrar = new javax.swing.JLabel();
        labelTipoBorrar = new javax.swing.JLabel();
        labelEEBorrar = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnSalirBorrar = new javax.swing.JButton();
        btnBuscarBorrar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcionBorrar = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnMostrarDetalles = new javax.swing.JButton();
        btnSalirConsul = new javax.swing.JButton();
        radioNombreConsultar = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        listConsultar = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        txtBusquedaConsultar = new javax.swing.JTextField();
        radioEEConsultar = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelNombreConsul = new javax.swing.JLabel();
        labelTipoConsul = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDescripConsul = new javax.swing.JTextArea();
        labelEEConsul = new javax.swing.JLabel();
        btnBuscarConsultar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Catalogo de actividades");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Idioma:");

        jLabel3.setText("EE:");

        jLabel7.setText("Descripción: ");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        comboIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdiomaActionPerformed(evt);
            }
        });

        comboEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEEActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel34.setText("Tipo:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Conversación", "Taller", "Asesorias" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel34))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboIdioma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboEE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar))
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Crear", jPanel1);

        jLabel10.setText("Buscar:");

        buttonGroup1.add(radioNombreEdit);
        radioNombreEdit.setSelected(true);
        radioNombreEdit.setText("Nombre");

        buttonGroup1.add(radioEEEdit);
        radioEEEdit.setText("EE");
        radioEEEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEEEditActionPerformed(evt);
            }
        });

        listEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listEditMouseClicked(evt);
            }
        });
        listEdit.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEditValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listEdit);

        jLabel11.setText("Nombre:");

        jLabel13.setText("EE:");

        comboEEEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEEEditActionPerformed(evt);
            }
        });

        txtDescripEdit.setColumns(20);
        txtDescripEdit.setRows(5);
        jScrollPane3.setViewportView(txtDescripEdit);

        jLabel19.setText("Descripción:");

        btnGuardarEdit.setText("Guardar");
        btnGuardarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEditActionPerformed(evt);
            }
        });

        btnSalirEditar.setText("Salir");
        btnSalirEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirEditarActionPerformed(evt);
            }
        });

        btnBuscarEdit.setText("Buscar");
        btnBuscarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEditActionPerformed(evt);
            }
        });

        comboTipoEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Conversación", "Taller", "Asesorias" }));

        jLabel12.setText("Tipo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaEdit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioEEEdit)
                            .addComponent(radioNombreEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarEdit))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEdit)
                            .addComponent(comboEEEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnSalirEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarEdit)
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarEdit)
                            .addComponent(comboEEEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTipoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(radioNombreEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioEEEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalirEditar)
                    .addComponent(btnGuardarEdit))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Editar", jPanel2);

        listBorrar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBorrarValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listBorrar);

        jLabel20.setText("Nombre:");

        jLabel22.setText("Descripción:");

        jLabel23.setText("Tipo:");

        jLabel24.setText("EE:");

        txtBusquedaBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaBorrarActionPerformed(evt);
            }
        });

        jLabel26.setText("Buscar:");

        buttonGroup2.add(radioNombreBorrar);
        radioNombreBorrar.setSelected(true);
        radioNombreBorrar.setText("Nombre");

        buttonGroup2.add(radioEEBorrar);
        radioEEBorrar.setText("EE");

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalirBorrar.setText("Salir");
        btnSalirBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirBorrarActionPerformed(evt);
            }
        });

        btnBuscarBorrar.setText("Buscar");
        btnBuscarBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBorrarActionPerformed(evt);
            }
        });

        txtDescripcionBorrar.setEditable(false);
        txtDescripcionBorrar.setColumns(20);
        txtDescripcionBorrar.setRows(5);
        jScrollPane5.setViewportView(txtDescripcionBorrar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaBorrar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioEEBorrar)
                            .addComponent(radioNombreBorrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarBorrar)
                        .addGap(33, 33, 33))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel22)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btnSalirBorrar)
                            .addGap(69, 69, 69)
                            .addComponent(btnBorrar))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel23)
                                .addComponent(jLabel20))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNombreBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(labelTipoBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEEBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(radioNombreBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioEEBorrar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBuscarBorrar)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(labelNombreBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTipoBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(labelEEBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel22)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalirBorrar)
                            .addComponent(btnBorrar))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Borrar", jPanel3);

        btnMostrarDetalles.setText("Mostrar detalles");

        btnSalirConsul.setText("Salir");
        btnSalirConsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirConsulActionPerformed(evt);
            }
        });

        buttonGroup3.add(radioNombreConsultar);
        radioNombreConsultar.setSelected(true);
        radioNombreConsultar.setText("Nombre");

        listConsultar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listConsultarValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(listConsultar);

        jLabel4.setText("Buscar:");

        buttonGroup3.add(radioEEConsultar);
        radioEEConsultar.setText("EE:");
        radioEEConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEEConsultarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre: ");

        jLabel6.setText("Tipo:");

        jLabel8.setText("EE:");

        jLabel9.setText("Descrición: ");

        txtDescripConsul.setEditable(false);
        txtDescripConsul.setColumns(20);
        txtDescripConsul.setRows(5);
        jScrollPane7.setViewportView(txtDescripConsul);

        btnBuscarConsultar.setText("Buscar");
        btnBuscarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(radioEEConsultar)
                            .addComponent(radioNombreConsultar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarConsultar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTipoConsul, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(labelNombreConsul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEEConsul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBusquedaConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSalirConsul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMostrarDetalles))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBuscarConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioNombreConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioEEConsultar)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBusquedaConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNombreConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(labelTipoConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(labelEEConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarDetalles)
                    .addComponent(btnSalirConsul))
                .addGap(63, 63, 63))
        );

        jTabbedPane1.addTab("Consultar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioEEEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEEEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioEEEditActionPerformed

    private void radioEEConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEEConsultarActionPerformed

    }//GEN-LAST:event_radioEEConsultarActionPerformed

    private void comboIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdiomaActionPerformed
        cargarEEs(comboIdioma.getItemAt(comboIdioma.getSelectedIndex()).substring(0, 2), comboEE);
    }//GEN-LAST:event_comboIdiomaActionPerformed

    private void comboEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEEActionPerformed

    }//GEN-LAST:event_comboEEActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ActividadCatalogoDAO DAO = new ActividadCatalogoDAO();
        try {
            if (verificarDatosCrear()) {
                if (DAO.guardarActividadCatal(comboEE.getItemAt(comboEE.getSelectedIndex()).substring(0, 2), comboTipo.getItemAt(comboTipo.getSelectedIndex()), txtNombre.getText(), txtDescripcion.getText())) {
                    JOptionPane.showMessageDialog(this, "Se ha guardado correctamente la actividad en el catalogo");
                    vaciarComponentes();
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "guardar una actividad, revise conexión a red.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    /**
     * Retorna un DefaultListModel resultado de la busqueda de una actividad en
     * la capa inferior de negocio, extrae el resultado y lo guarda en un modelo
     *
     * @param criterio Criterio de busqueda para la consulta
     * @param buscando Lo que sera comparado con el criterio de busqueda
     * @return DefaultlistModel resultado de la busqueda
     */
    private DefaultListModel busquedaActividades(String criterio, String buscando) {

        ActividadCatalogoDAO DAO = new ActividadCatalogoDAO();
        List<ActividadCatalogo> listaActividades = new ArrayList<>();
        DefaultListModel modeloLista = new DefaultListModel();

        try {
            listaActividades = DAO.buscarActividades(criterio, buscando);
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        for (int i = 0; i < listaActividades.size(); i++) {
            modeloLista.addElement(listaActividades.get(i).getIdActividad() + " - " + listaActividades.get(i).getNombre());
        }

        return modeloLista;
    }
    private void btnBuscarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEditActionPerformed
        if (radioNombreEdit.isSelected()) {
            mostrarResultadosBusqueda(listEdit, txtBusquedaEdit, true);
        } else if (radioEEEdit.isSelected()) {
            mostrarResultadosBusqueda(listEdit, txtBusquedaEdit, false);
        }
    }//GEN-LAST:event_btnBuscarEditActionPerformed

    private void btnBuscarBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBorrarActionPerformed
        if (radioNombreBorrar.isSelected()) {
            mostrarResultadosBusqueda(listBorrar, txtBusquedaBorrar, true);
        } else if (radioEEBorrar.isSelected()) {
            mostrarResultadosBusqueda(listBorrar, txtBusquedaBorrar, false);
        }
    }//GEN-LAST:event_btnBuscarBorrarActionPerformed
    /**
     * Muestra los resultados de la busqueda en el JList que se le envia, segun
     * sea los resultados de la busqueda.
     *
     * @param list JList en donde sera mostrados los resultados de la busqueda
     * @param txt jTextField del que se tomara la busqueda
     * @param esNombre establece el criterio de busqueda
     */
    private void mostrarResultadosBusqueda(JList list, JTextField txt, boolean esNombre) {
        if (esNombre) {
            list.setModel(busquedaActividades("actividadcatalogo.nombreActividad", txt.getText()));
            list.updateUI();
            if (list.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(this, "No se ha encontrado ningun resultado concordante");
            }
        } else {
            list.setModel(busquedaActividades("ee.nombre", txt.getText()));
            list.updateUI();
            if (list.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(this, "No se ha encontrado ningun resultado concordante");
            }
        }
    }
    private void txtBusquedaBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaBorrarActionPerformed

    }//GEN-LAST:event_txtBusquedaBorrarActionPerformed

    private void btnBuscarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConsultarActionPerformed
        if (radioNombreConsultar.isSelected()) {
            mostrarResultadosBusqueda(listConsultar, txtBusquedaConsultar, true);
        } else if (radioEEConsultar.isSelected()) {
            mostrarResultadosBusqueda(listConsultar, txtBusquedaConsultar, false);
        }
    }//GEN-LAST:event_btnBuscarConsultarActionPerformed

    private void listEditValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEditValueChanged
        ActividadCatalogoDAO DAOActivi = new ActividadCatalogoDAO();
        ExperEduDAO DAOEE = new ExperEduDAO();
        List<String> nombresEE = new ArrayList<>();
        ActividadCatalogo actividadSelec = new ActividadCatalogo();
        String[] idActividad = listEdit.getSelectedValue().split(" ");
        this.idActividad = idActividad[0];

        try {
            actividadSelec = DAOActivi.mostrarDetallesActiv(this.idActividad);
            nombresEE = DAOEE.obtenerEEmismoIdioma(actividadSelec.getExperEdu());
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "mostrar los detalles de la actividad, por favor revise conexión a red.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
            }

        rellenarCamposEdit(actividadSelec, nombresEE);

    }//GEN-LAST:event_listEditValueChanged
    /**
     * Rellena todos los campos correspondientes a la edición de una Actividad
     *
     * @param actividad Parametro de tipo ActividadCatalogo, objeto de donde se
     * obtendra toda la información sobre una actividad previamente elegida para
     * para que los campos sea rellenados con ella.
     * @param nombresEE Lista de String's que contiene los nombres de las EE
     * concordantes con el mismo idioma de la EE de la actividad
     */
    private void rellenarCamposEdit(ActividadCatalogo actividad, List<String> nombresEE) {
        comboEEEdit.removeAllItems();
        txtNombreEdit.setText(actividad.getNombre());
        txtDescripEdit.setText(actividad.getDescripcion());

        while (!nombresEE.isEmpty()) {
            comboEEEdit.addItem(nombresEE.remove(0));
        }

        int c = 0;
        while (true) {
            if (actividad.getExperEdu().equals(comboEEEdit.getItemAt(c).substring(0, 2))) {
                break;
            }
            c++;
        }
        comboEEEdit.setSelectedIndex(c);

        c = 0;
        while (true) {
            if (actividad.getTipoActividad().equals(comboTipoEdit.getItemAt(c))) {
                break;
            }
            c++;
        }
        comboTipoEdit.setSelectedIndex(c);
    }
    private void btnSalirBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirBorrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirBorrarActionPerformed

    private void btnSalirConsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConsulActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirConsulActionPerformed

    private void btnSalirEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirEditarActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirEditarActionPerformed

    private void listEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEditMouseClicked

    }//GEN-LAST:event_listEditMouseClicked

    private void comboEEEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEEEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEEEditActionPerformed

    private void btnGuardarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEditActionPerformed
        ActividadCatalogoDAO DAO = new ActividadCatalogoDAO();
        ActividadCatalogo activiCatalModif = new ActividadCatalogo();

        if (listEdit.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una actividad antes de guardar cambios");
        } else if (verificarDatosEdit()) {
            activiCatalModif.setDescripcion(txtDescripEdit.getText());
            activiCatalModif.setExperEdu(comboEEEdit.getItemAt(comboEEEdit.getSelectedIndex()).substring(0, 2));
            activiCatalModif.setIdActividad(idActividad);
            activiCatalModif.setNombre(txtNombreEdit.getText());
            activiCatalModif.setTipoActividad(comboTipoEdit.getItemAt(comboTipoEdit.getSelectedIndex()));

            try {
                if (DAO.editarActividadCatal(activiCatalModif)) {
                    vaciarComponentesEdit();
                    JOptionPane.showMessageDialog(this, "Se ha editado correctamente la actividad");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "guardar las modificaciones, revise conexión a red");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
            }
        }
    }//GEN-LAST:event_btnGuardarEditActionPerformed

    private void listBorrarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listBorrarValueChanged
        ActividadCatalogoDAO DAOActivi = new ActividadCatalogoDAO();
        ActividadCatalogo actividadSelec = new ActividadCatalogo();
        String[] nombreActividad = listBorrar.getSelectedValue().split(" ");
        idActividad = nombreActividad[0];

        try {
            actividadSelec = DAOActivi.mostrarDetallesActiv(this.idActividad);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "mostrar los detalles de la actividad, revise conexión a red.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }

        rellenarCamposBorrado(actividadSelec);
    }//GEN-LAST:event_listBorrarValueChanged

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        ActividadCatalogoDAO DAO = new ActividadCatalogoDAO();

        if (listBorrar.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero debe seleccionar una actividad de la lista de busqueda");
        } else {
            try {
                if (DAO.borrarActiviCatal(idActividad)) {
                    vaciarComponentesBorrar();
                    JOptionPane.showMessageDialog(this, "Se ha borrado la actividad correctamente");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "borrar la actividad, por favor revise conexión a red.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                        + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void listConsultarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listConsultarValueChanged
        ActividadCatalogoDAO DAOActivi = new ActividadCatalogoDAO();
        ActividadCatalogo actividadSelec = new ActividadCatalogo();
        String[] nombreActividad = listConsultar.getSelectedValue().split(" ");
        idActividad = nombreActividad[0];

        try {
            actividadSelec = DAOActivi.mostrarDetallesActiv(this.idActividad);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "por favor mostrar los detalles de la actividad, revise conexión a red.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }

        rellenarCamposConsultar(actividadSelec);
    }//GEN-LAST:event_listConsultarValueChanged
    /**
     * Rellena los campos correspondientes a la consulta de una actividad
     *
     * @param actividad Parametro de tipo ActividadCatalogo, objeto que tendrá
     * toda la información que se mostrará al usario segun su elección
     */
    private void rellenarCamposConsultar(ActividadCatalogo actividad) {
        ExperEduDAO DAO = new ExperEduDAO();
        txtDescripConsul.setText(actividad.getDescripcion());

        try {
            labelEEConsul.setText(DAO.retornarEEPorIdEE(actividad.getExperEdu()).getNombreEE());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "mostrar la información completa de esta actividad, revise conexión a red y reinicie el sistema.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }

        labelNombreConsul.setText(actividad.getNombre());
        labelTipoConsul.setText(actividad.getTipoActividad());
    }

    /**
     * Rellena los campos correspondientes a la eliminación de una actividad
     *
     * @param actividad Parametro de tipo ActividadCatalogo, objeto que tendrá
     * toda la información que se mostrará al usario segun su elección
     */
    private void rellenarCamposBorrado(ActividadCatalogo actividad) {
        ExperEduDAO DAO = new ExperEduDAO();
        txtDescripcionBorrar.setText(actividad.getDescripcion());

        try {
            labelEEBorrar.setText(DAO.retornarEEPorIdEE(actividad.getExperEdu()).getNombreEE());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "mostrar la información completa de esta actividad, revise conexión a red y reinicie el sistema.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Oops a ocurrido un error al tratar de "
                    + "cargar el archivo de configuración de conexión a la BDD, reinicie el sistema.");
        }

        labelNombreBorrar.setText(actividad.getNombre());
        labelTipoBorrar.setText(actividad.getTipoActividad());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarBorrar;
    private javax.swing.JButton btnBuscarConsultar;
    private javax.swing.JButton btnBuscarEdit;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarEdit;
    private javax.swing.JButton btnMostrarDetalles;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirBorrar;
    private javax.swing.JButton btnSalirConsul;
    private javax.swing.JButton btnSalirEditar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comboEE;
    private javax.swing.JComboBox<String> comboEEEdit;
    private javax.swing.JComboBox<String> comboIdioma;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> comboTipoEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelEEBorrar;
    private javax.swing.JLabel labelEEConsul;
    private javax.swing.JLabel labelNombreBorrar;
    private javax.swing.JLabel labelNombreConsul;
    private javax.swing.JLabel labelTipoBorrar;
    private javax.swing.JLabel labelTipoConsul;
    private javax.swing.JList<String> listBorrar;
    private javax.swing.JList<String> listConsultar;
    private javax.swing.JList<String> listEdit;
    private javax.swing.JRadioButton radioEEBorrar;
    private javax.swing.JRadioButton radioEEConsultar;
    private javax.swing.JRadioButton radioEEEdit;
    private javax.swing.JRadioButton radioNombreBorrar;
    private javax.swing.JRadioButton radioNombreConsultar;
    private javax.swing.JRadioButton radioNombreEdit;
    private javax.swing.JTextField txtBusquedaBorrar;
    private javax.swing.JTextField txtBusquedaConsultar;
    private javax.swing.JTextField txtBusquedaEdit;
    private javax.swing.JTextArea txtDescripConsul;
    private javax.swing.JTextArea txtDescripEdit;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextArea txtDescripcionBorrar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEdit;
    // End of variables declaration//GEN-END:variables
    /**
     * Verifica que todos los datos introducidos en la creación de una actividad
     * sea correctos.
     *
     * @return true si los datos son correctos si no es así retorna falso
     */
    private boolean verificarDatosCrear() {
        boolean datosCorrectos = true;
        if (txtNombre.getText().length() > 32 || txtNombre.getText().length() < 3) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "El tamaño del nombre no debe superar los 64 digitos y con un minimo de 5 digitos");
        } else if (txtDescripcion.getText().length() > 128 || txtDescripcion.getText().length() < 16) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "El tamaño de la descripción no debe superar los 128 digitos y con un minimo de 20 digitos");
        } else if (comboEE.getSelectedIndex() == 0 || comboEE.getSelectedIndex() == -1) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar una EE");
        } else if (comboTipo.getSelectedIndex() == 0 || comboEE.getSelectedIndex() == -1) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar un tipo de actividad");
        }

        return datosCorrectos;
    }

    /**
     * Verifica que todos los datos introducidos en la edición de una actividad
     * sea correctos.
     *
     * @return true si los datos son correctos si no es así retorna falso
     */
    private boolean verificarDatosEdit() {
        boolean datosCorrectos = true;
        if (txtNombreEdit.getText().length() > 32 || txtNombre.getText().length() < 3) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "El tamaño del nombre no debe superar los 64 digitos y con un minimo de 5 digitos");
        } else if (txtDescripEdit.getText().length() > 128 || txtDescripcion.getText().length() < 16) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "El tamaño de la descripción no debe superar los 128 digitos y con un minimo de 20 digitos");
        } else if (comboEEEdit.getSelectedIndex() == 0 || comboEE.getSelectedIndex() == -1) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar una EE");
        } else if (comboTipoEdit.getSelectedIndex() == 0 || comboEE.getSelectedIndex() == -1) {
            datosCorrectos = false;
            JOptionPane.showMessageDialog(this, "Se ha de seleccionar un tipo de actividad");
        }

        return datosCorrectos;
    }

    /**
     * Vacia los componentes correspondientes a la creación de una actividad; se
     * usa cuando la creación fue realizada.
     */
    private void vaciarComponentes() {
        comboIdioma.setSelectedIndex(0);
        txtNombre.setText("");
        txtDescripcion.setText("");
        comboTipo.setSelectedIndex(0);
    }

    /**
     * Vacia los componentes correspondientes a la edición de una actividad; se
     * usa cuando la edición fue realizada.
     */
    private void vaciarComponentesEdit() {
        comboEEEdit.removeAllItems();
        txtNombreEdit.setText("");
        txtDescripEdit.setText("");
        comboTipoEdit.setSelectedIndex(0);
    }

    /**
     * Vacia los componentes correspondientes al borrado de una actividad; se
     * usa cuando la eliminación fue realizada.
     */
    private void vaciarComponentesBorrar() {
        labelNombreBorrar.setText("");
        labelEEBorrar.setText("");
        txtDescripcionBorrar.setText("");
        labelTipoBorrar.setText("");
    }
}
