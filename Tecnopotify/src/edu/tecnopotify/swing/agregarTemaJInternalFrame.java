/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.controladores.ListaReproduccionJpaController;
import edu.tecnopotify.datatypes.dataGenero;
import edu.tecnopotify.datatypes.dataTemas;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.entidades.ListaDefecto;
import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Temas;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import static edu.tecnopotify.swing.consultarArtistaJInternalFrame.xOffset;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author diego-lucia
 */
public class agregarTemaJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form agregarTemaJInternalFrame
     */
    /*    El caso de uso comienza cuando el administrador desea agregar
    un nuevo tema a una lista de reproducción. Para ello indica el
    usuario y la lista a la cual se agregará el tema, o sólo el nombre
    de la lista en caso de ser una lista por defecto. Luego, selecciona
    un tema (según sea de una lista propietaria pública, por defecto,
    o de un álbum) y el sistema lo agrega a la lista.*/
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    IControlador crl;
    DefaultTreeModel model;
    DefaultMutableTreeNode listaParticular;
    DefaultMutableTreeNode listaDefecto;

    public agregarTemaJInternalFrame() {
        super("Agregar Tema",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...
        //Set the window's location.

        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        model = (DefaultTreeModel) tree.getModel();
        listaParticular = (DefaultMutableTreeNode) model.getChild(model.getRoot(), 0);
        listaDefecto = (DefaultMutableTreeNode) model.getChild(model.getRoot(), 1);
        //********COMBOS*******
        cargarCombos();
        //********ARBOL**********
        //Genera el nodo raiz y lo agrega en el arbol
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) model.getRoot();
        iniciarTree(listaParticular, listaDefecto);
        model.reload(rootNode);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        jButtonConfirmar = new javax.swing.JButton();
        jComboUsuario = new javax.swing.JComboBox();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jComboTemas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboAlbums = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboArtistas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Listas");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ListaParticular");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ListaPorDefecto");
        treeNode1.add(treeNode2);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(tree);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jComboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsuarioActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jComboTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTemasActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Temas");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuarios");

        jComboAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAlbumsActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Albums");

        jComboArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboArtistasActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Artistas");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Elija Lista a agregar Tema");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Elija Tema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jComboUsuario, 0, 310, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jComboArtistas, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboAlbums, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboTemas, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultMutableTreeNode selectedNode;
    DefaultMutableTreeNode nodeLP;
    DefaultMutableTreeNode nodeLD;
    DefaultMutableTreeNode nodeRaiz;
    List<ListaParticular> lista;
    List<Temas> temas;
    ListaReproduccion lr;

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
    }//GEN-LAST:event_jButtonConfirmarActionPerformed
    
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
        selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNode.insert(new DefaultMutableTreeNode(jComboTemas.getSelectedItem()), 0);
            model.reload(selectedNode);
            lr = crl.getlr(selectedNode.toString());
            try {
                crl.agregarTemaLista(jComboTemas.getSelectedItem().toString(), lr.toDataType());
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
            parent.remove(selectedNode);
            lr = crl.getlr(parent.toString());
            model.reload(parent);
            crl.quitarTemaLista(selectedNode.toString(), lr.toDataType());
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jComboArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboArtistasActionPerformed
        // TODO add your handling code here:
        cargarAlbums();
    }//GEN-LAST:event_jComboArtistasActionPerformed

    private void jComboAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlbumsActionPerformed
        // TODO add your handling code here:
        cargarTemas();
    }//GEN-LAST:event_jComboAlbumsActionPerformed

    private void jComboTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTemasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboTemasActionPerformed

    private void jComboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsuarioActionPerformed
        // TODO add your handling code here:
        iniciarTree(listaParticular, listaDefecto);
    }//GEN-LAST:event_jComboUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboAlbums;
    private javax.swing.JComboBox<String> jComboArtistas;
    private javax.swing.JComboBox<String> jComboTemas;
    private javax.swing.JComboBox<String> jComboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables

    private void iniciarTree(DefaultMutableTreeNode listaParticular, DefaultMutableTreeNode listaDefecto) {
        listaParticular.removeAllChildren();
        listaDefecto.removeAllChildren();
        model.reload((TreeNode) model.getRoot());
        DefaultMutableTreeNode hijo;
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        Cliente oCliente = crl.getCli(jComboUsuario.getSelectedItem().toString());
        //Primero cargo las listas por defecto
        List<ListaDefecto> lstDefecto = crl.listarDefecto();
        if (!lstDefecto.isEmpty()) {//Si mi lista tiene al menos un elemento
            for (ListaDefecto listaD : lstDefecto) {  //Cargo las listas por defecto
                hijo = new DefaultMutableTreeNode(listaD.getNombre());
                model.insertNodeInto(hijo, listaDefecto, listaDefecto.getChildCount());
            }
        }        //Despues cargo las listas del cliente seleccionado
        List<ListaParticular> lstParticular = oCliente.getListasReprParticular();
        if (!lstParticular.isEmpty()) {//Si mi lista tiene al menos un elemento
            for (ListaParticular listaP : lstParticular) {  //Cargo las listas por defecto
                hijo = new DefaultMutableTreeNode(listaP.getNombre());
                model.insertNodeInto(hijo, listaParticular, listaParticular.getChildCount());
            }
        }
    }

    private void cargarCombos() {
    jComboUsuario.removeAllItems();
    jComboArtistas.removeAllItems();
    //Clientes**********************
        List<Cliente> lstCliente = crl.listarClientes();
        Iterator<Cliente> itCliente = lstCliente.iterator();
        while (itCliente.hasNext()) {
            jComboUsuario.addItem(itCliente.next().getNickname());
        }
    //Artistas*****************
        List<Artista> art = crl.listarArtistas();
        Iterator<Artista> itArtista = art.iterator();
        while (itArtista.hasNext()) {
            jComboArtistas.addItem(itArtista.next().getNickname());
        }
//        cargarAlbums();
    }
    
    private void cargarTemas()
    {
        jComboTemas.removeAllItems();
        Album al = crl.seleccionarAlbum(jComboAlbums.getSelectedItem().toString());
        if (al!=null) {
            List<Temas> temas = al.getListTemas();
            Iterator<Temas> itT = temas.iterator();
            while (itT.hasNext()) {
                jComboTemas.addItem(itT.next().getNombre());
            }
        }
    
    }
    
    private void cargarAlbums()
    {
        jComboAlbums.removeAllItems();
        Artista a = crl.seleccionarArtista(jComboArtistas.getSelectedItem().toString());
        if (a!=null) {
            List<Album> album = a.getListAlbum();
            Iterator<Album> itAl = album.iterator();
            while (itAl.hasNext()) {
                jComboAlbums.addItem(itAl.next().getNombre());
            }
        }
//        cargarTemas();
    }
    
}
