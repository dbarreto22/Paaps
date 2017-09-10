/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.controladores.GeneroJpaController;
import edu.tecnopotify.datatypes.dataGenero;
import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import static edu.tecnopotify.swing.AltaClienteJInternalFrame.openFrameCount;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author diego-lucia
 */
public class AltaGeneroJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaGeneroJInternalFrame
     */
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    IControlador crl;
    DefaultTreeModel model;
    GeneroJpaController genCtrl;

    public AltaGeneroJInternalFrame() {

        super("Alta Genero",
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
        genCtrl = new GeneroJpaController(crl.getEntityManagerFactory());
        //********ARBOL**********
        //Genera el nodo raiz y lo agrega en el arbol
        model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode rootNode= (DefaultMutableTreeNode) model.getRoot();
        List<Genero> lstGeneros = crl.listarGeneros();
        ListIterator<Genero> it=lstGeneros.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next().getNombre());
        }
        iniciarTree(lstGeneros, rootNode);
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

        jButtonAceptar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        tree = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jTextPadre = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jButtonAceptar.setText("Agregar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabelNombre.setText("Ingresar Genero");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Genero");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        jLabel1.setText("Si desea ingrese carpeta Padre ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tree, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jTextPadre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tree, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        dataGenero oDtGenero;
        DefaultMutableTreeNode selectedNode,rootNode;
        selectedNode =  (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
        rootNode = (DefaultMutableTreeNode)(DefaultMutableTreeNode) model.getRoot();
        if (selectedNode != null) {  //Si hay un genero padre seleccionado
            //Creo el nodo con el texto ingresado
            selectedNode.insert(new DefaultMutableTreeNode(jTextFieldNombre.getText()), 0);
            oDtGenero = new dataGenero(jTextFieldNombre.getText(), selectedNode.toString());
        } else {
            rootNode.insert(new DefaultMutableTreeNode(jTextFieldNombre.getText()),0);
            oDtGenero=new dataGenero(jTextFieldNombre.getText(),"");
        }
        System.out.println("apadre: "+ oDtGenero.getPadre()+ " nombre: "+ oDtGenero.getNombre());
        //persiste el genero ingresado
        crl.altaGenero(oDtGenero);
        model.reload(rootNode);
        jTextFieldNombre.setText("");
        jTextPadre.setText("");
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void iniciarTree(List<Genero> lstGeneros, DefaultMutableTreeNode padre) {
        Genero oGenero;
        DefaultMutableTreeNode hijo;
        ListIterator<Genero> it=lstGeneros.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next().getNombre());
        }
        if (!lstGeneros.isEmpty()) {//Si mi lista tiene al menos un elemento
            //lo asigno en oGenero
            oGenero=lstGeneros.get(0);
            //lo creo como nodo hijo
            hijo= new DefaultMutableTreeNode(oGenero.getNombre());
            //lo agrago en el modelo del arbol
            model.insertNodeInto(hijo, padre, model.getChildCount(padre));
            if (!oGenero.getListHijos().isEmpty()) { //Reviso si tiene hijos
                //llamo a la funcion con la lista de hijos
                iniciarTree(oGenero.getListHijos(),hijo);                
            }
            //Sigo con el proximo hermano
            iniciarTree(lstGeneros.subList(1, lstGeneros.size()),padre);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextPadre;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
