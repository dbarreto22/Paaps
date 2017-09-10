/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.datatypes.dataAlbum;
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
    private JTree tree;
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel model;
    DefaultMutableTreeNode node;

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

        List<Artista> a = ctrl.listarArtistas();
        Iterator<Artista> it = a.iterator();
        while (it.hasNext()) {
            jComboNombreArtista.addItem(it.next().getNickname());
        }

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
        jButtonAceptar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAñoCreacion = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jTextAnioCreado = new javax.swing.JTextField();
        jButtonImagen = new javax.swing.JButton();
        jLabelNombre1 = new javax.swing.JLabel();
        jTextNombreAlbum = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jComboNombreArtista = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeGenero = new javax.swing.JTree();

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

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabelNombre.setText("Nombre");

        jLabelAñoCreacion.setText("Año Creaciòn");

        jLabelImagen.setText("Imagen");

        jButtonImagen.setText("Subir Imagen");
        jButtonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagenActionPerformed(evt);
            }
        });

        jLabelNombre1.setText("Nombre del Artista");

        jTextNombreAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreAlbumActionPerformed(evt);
            }
        });

        jLabelGenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGenero.setText("Genero");

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

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeGenero.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(treeGenero);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelImagen)
                            .addComponent(jLabelAñoCreacion)
                            .addComponent(jLabelNombre1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextAnioCreado)
                            .addComponent(jButtonImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextNombreAlbum)
                            .addComponent(jComboNombreArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(4, 4, 4)
                .addComponent(jButtonAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre1)
                    .addComponent(jComboNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextNombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAñoCreacion)
                    .addComponent(jTextAnioCreado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImagen)
                    .addComponent(jLabelImagen))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
        // TODO add your handling code here:
        node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        int anio = Integer.parseInt(jTextAnioCreado.getText());
        Genero g = ctrl.buscarGenero(node.toString());
        dataAlbum odataAlbum = new dataAlbum(jTextNombreAlbum.getText(), anio, path);
        //desplegar nombres de artistas
        String nickArtista = this.jComboNombreArtista.getSelectedItem().toString();
        ctrl.crearAlbum(nickArtista, odataAlbum);
        odataAlbum.getListGeneros().add(g);

        this.jTextAnioCreado.setText("");
        //this.jTextNombreArtista.setText("");
        this.jTextNombreAlbum.setText("");

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

    private void treeGenero() {
//        treeModel.addTreeModelListener(new MyTreeModelListener());
        tree = new JTree(model);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        JScrollPane pane = new JScrollPane(tree);
        this.add(pane);
        pane.setViewportView(tree);

    }

    /*    public DefaultMutableTreeNode addObject(Object child) {
    DefaultMutableTreeNode parentNode = null;
    TreePath parentPath = tree.getSelectionPath();
    
    if (parentPath == null) {
    //There is no selection. Default to the root node.
    parentNode = rootNode;
    } else {
    parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
    }
    
    return addObject(parentNode, child, true);
    }
    
    
    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
    Object child,
    boolean shouldBeVisible) {
    DefaultMutableTreeNode childNode
    = new DefaultMutableTreeNode(child);
    
    treeModel.insertNodeInto(childNode, parent,
    parent.getChildCount());
    
    //Make sure the user can see the lovely new node.
    if (shouldBeVisible) {
    tree.scrollPathToVisible(new TreePath(childNode.getPath()));
    }
    return childNode;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JComboBox<String> jComboNombreArtista;
    private javax.swing.JLabel jLabelAñoCreacion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAnioCreado;
    private javax.swing.JTextField jTextNombreAlbum;
    private javax.swing.JTree treeGenero;
    // End of variables declaration//GEN-END:variables
}
