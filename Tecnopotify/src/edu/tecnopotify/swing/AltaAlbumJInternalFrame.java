/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.datatypes.dataAlbum;
import edu.tecnopotify.datatypes.dataTemas;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import static edu.tecnopotify.swing.AltaClienteJInternalFrame.openFrameCount;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author diego-lucia
 */
public class AltaAlbumJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaAbumJInternalFrame
     */
    private Fabrica fab = Fabrica.getInstance();
    private IControlador ctrl = fab.getInstancia();

    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private String path;//Guarda el link a la imagen
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel model;
    DefaultMutableTreeNode node;
    private Genero genero;
    String pathTema;

    public AltaAlbumJInternalFrame() {
        super("Alta Album",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...

        //Set the window's location.
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        initComponents();
        jPanel1.setVisible(false);
        List<Artista> a = ctrl.listarArtistas();
        Iterator<Artista> it = a.iterator();
        while (it.hasNext()) {
            jComboNombreArtista.addItem(it.next().getNickname());
        }

        //********Arbol***************
        model = (DefaultTreeModel) treeGenero.getModel();
        rootNode = (DefaultMutableTreeNode) model.getRoot();
        Genero genero = ctrl.buscarGenero("Genero");
        List<Genero> lstGeneros = genero.getListHijos();
        iniciarTree(lstGeneros, rootNode);
        model.reload(rootNode);

        /*List<Genero> generos = ctrl.listarGeneros();
        Iterator<Genero> itG = generos.iterator();
        
        this.iniciarTree(generos, node);*/
    }

    private void iniciarTree(List<Genero> lstGeneros, DefaultMutableTreeNode padre) {
        Genero oGenero;
        DefaultMutableTreeNode hijo;
        if (!lstGeneros.isEmpty()) {//Si mi lista tiene al menos un elemento
            //lo asigno en oGenero
            oGenero = lstGeneros.get(0);
            //lo creo como nodo hijo
            hijo = new DefaultMutableTreeNode(oGenero.getNombre());
            //lo agrago en el modelo del arbol
            model.insertNodeInto(hijo, padre, model.getChildCount(padre));
            if (!oGenero.getListHijos().isEmpty()) { //Reviso si tiene hijos
                //llamo a la funcion con la lista de hijos
                iniciarTree(oGenero.getListHijos(), hijo);
            }
            //Sigo con el proximo hermano
            iniciarTree(lstGeneros.subList(1, lstGeneros.size()), padre);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabelGenero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeGenero = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNombreTema = new javax.swing.JTextField();
        jTextFieldDuracion = new javax.swing.JTextField();
        jTextFieldPos = new javax.swing.JTextField();
        jButtonAddTema = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTemas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonArchivo = new javax.swing.JButton();
        jPanelAlbum = new javax.swing.JPanel();
        jLabelNombre1 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAñoCreacion = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jComboNombreArtista = new javax.swing.JComboBox();
        jTextNombreAlbum = new javax.swing.JTextField();
        jTextAnioCreado = new javax.swing.JTextField();
        jButtonImagen = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta Album");
        setMinimumSize(new java.awt.Dimension(200, 300));
        setVisible(true);

        jLabelGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGenero.setText("Genero");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Genero");
        treeGenero.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(treeGenero);

        jButtonAddTema.setText("Agregar tema");
        jButtonAddTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTemaActionPerformed(evt);
            }
        });

        jLabel1.setText("Temas");

        jLabel4.setText("Posicion");

        jLabel3.setText("Duracion");

        jLabel2.setText("Nombre");

        jButtonArchivo.setText("Subir archivo");
        jButtonArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreTema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldPos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButtonArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAddTema))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldNombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddTema)
                    .addComponent(jButtonArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabelNombre1.setText("Nombre del Artista");

        jLabelNombre.setText("Nombre");

        jLabelAñoCreacion.setText("Año Creaciòn");

        jLabelImagen.setText("Imagen");

        jComboNombreArtista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboNombreArtistaItemStateChanged(evt);
            }
        });
        jComboNombreArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboNombreArtistaActionPerformed(evt);
            }
        });

        jTextNombreAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreAlbumActionPerformed(evt);
            }
        });

        jButtonImagen.setText("Subir Imagen");
        jButtonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagenActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Crear Album");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlbumLayout = new javax.swing.GroupLayout(jPanelAlbum);
        jPanelAlbum.setLayout(jPanelAlbumLayout);
        jPanelAlbumLayout.setHorizontalGroup(
            jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagen)
                    .addComponent(jLabelAñoCreacion)
                    .addComponent(jLabelNombre)
                    .addComponent(jLabelNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboNombreArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextNombreAlbum)
                        .addComponent(jTextAnioCreado)
                        .addComponent(jButtonImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAlbumLayout.setVerticalGroup(
            jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre1)
                    .addComponent(jComboNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAñoCreacion)
                    .addComponent(jTextAnioCreado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagen)
                    .addComponent(jButtonImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanelAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagenActionPerformed
        // TODO add your handling code here:
        //https://www.discoduroderoer.es/como-usar-el-componente-jfilechooser-en-una-aplicacion-grafica-en-java/
        //Creo un panel interno para agregar el file chooser
        JInternalFrame internal = new JInternalFrame();
        //Lo hago visible
        internal.setVisible(true);
        try {
            internal.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AltaAlbumJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Creo un file chooser
        JFileChooser fileChooser = new JFileChooser();
        //Lo agrego a mi panel interno
        internal.add(fileChooser);
        //Permito que se seleccionen archivos y directorios
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Creo un filtro de tipos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg", "*.PNG", "png");
        fileChooser.setFileFilter(filtro);
        //guardo la opcion del usuario
        int seleccion = fileChooser.showOpenDialog(internal);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            this.path = archivo.getAbsolutePath();
        } else {
            this.path = "";
        }
    }//GEN-LAST:event_jButtonImagenActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        node = (DefaultMutableTreeNode) treeGenero.getLastSelectedPathComponent();
        int anio = Integer.parseInt(jTextAnioCreado.getText());
        dataAlbum odataAlbum = new dataAlbum(jTextNombreAlbum.getText(), anio, path);
        //desplegar nombres de artistas
        String nickArtista = this.jComboNombreArtista.getSelectedItem().toString();
        try {
            odataAlbum.getListGeneros().add(ctrl.buscarGenero(node.toString()));
            ctrl.crearAlbum(nickArtista, odataAlbum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jPanel1.setVisible(true);
        jComboNombreArtista.setEnabled(false);
        jTextNombreAlbum.setEnabled(false);
        jTextAnioCreado.setEnabled(false);
        jButtonImagen.setEnabled(false);
        jButtonAceptar.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Album creado con éxito", "Crear Album", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTextNombreAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreAlbumActionPerformed

    private void jComboNombreArtistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboNombreArtistaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboNombreArtistaItemStateChanged

    private void jComboNombreArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboNombreArtistaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboNombreArtistaActionPerformed

    private void jButtonAddTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTemaActionPerformed
        // TODO add your handling code here:
        dataTemas odatatema = null;
        String nickArtista = this.jComboNombreArtista.getSelectedItem().toString();
        if (!jTextFieldNombreTema.getText().isEmpty()) {
            int pos = Integer.parseInt(jTextFieldPos.getText());
            odatatema = new dataTemas(jTextFieldNombreTema.getText(),
                    jTextFieldDuracion.getText(), pos, pathTema);
            ctrl.altaTema(odatatema, jTextNombreAlbum.getText());
            jComboBoxTemas.addItem(odatatema.getNombre());
        }
        this.jTextFieldNombreTema.setText("");
        this.jTextFieldDuracion.setText("");
        this.jTextFieldPos.setText("");
    }//GEN-LAST:event_jButtonAddTemaActionPerformed

    private void jButtonArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArchivoActionPerformed
        // TODO add your handling code here:
        JInternalFrame internal = new JInternalFrame();
        internal.setVisible(true);
        try {
            internal.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AltaAlbumJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser fileChooser = new JFileChooser();
        internal.add(fileChooser);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.mp3", "mp3", "*.wma", "wma");
        fileChooser.setFileFilter(filtro);
        int seleccion = fileChooser.showOpenDialog(internal);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            this.path = archivo.getAbsolutePath();
        }
    }//GEN-LAST:event_jButtonArchivoActionPerformed

    private void treeGenero() {
//        treeModel.addTreeModelListener(new MyTreeModelListener());
        treeGenero = new JTree(model);
        treeGenero.setEditable(true);
        treeGenero.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeGenero.setShowsRootHandles(true);
        JScrollPane pane = new JScrollPane(treeGenero);
        this.add(pane);
        pane.setViewportView(treeGenero);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAddTema;
    private javax.swing.JButton jButtonArchivo;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JComboBox<String> jComboBoxTemas;
    private javax.swing.JComboBox<String> jComboNombreArtista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAñoCreacion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAlbum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAnioCreado;
    private javax.swing.JTextField jTextFieldDuracion;
    private javax.swing.JTextField jTextFieldNombreTema;
    private javax.swing.JTextField jTextFieldPos;
    private javax.swing.JTextField jTextNombreAlbum;
    private javax.swing.JTree treeGenero;
    // End of variables declaration//GEN-END:variables
}
