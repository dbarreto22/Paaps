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
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
        model = (DefaultTreeModel) tree.getModel();
        genCtrl = new GeneroJpaController(crl.getEntityManagerFactory());

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
     DefaultMutableTreeNode selectedNode;
     String padre;
    Genero g;
    Genero gH;
    List<Genero> genHijos;
    dataGenero genero;
    dataGenero generoO;
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
       
            if (selectedNode != null) {
                selectedNode.insert(new DefaultMutableTreeNode(jTextFieldNombre.getText()), 0);
                model.reload(selectedNode);
                genero = new dataGenero(jTextFieldNombre.getText(), jTextPadre.getText());
                crl.altaGenero(genero);
            } else {
                if(!jTextPadre.getText().isEmpty()){
                    generoO = new dataGenero(jTextFieldNombre.getText(), jTextPadre.getText());
                    g = genCtrl.findGenero(jTextPadre.getText());
                    gH = new Genero(generoO);
                    g.getGenerosHijos().add(gH);
              
                selectedNode.insert(new DefaultMutableTreeNode(jTextFieldNombre.getText()), selectedNode.getIndex(selectedNode.getLastChild()) + 1);
                padre= tree.getLastSelectedPathComponent().toString();
            }
        
           // JOptionPane.showMessageDialog(this,e.getMessage(), "Genero", JOptionPane.INFORMATION_MESSAGE);
        }

      //  genero = new dataGenero(jTextFieldNombre.getText(), jTextPadre.getText());
        

        //jTextPadre.setText(tree.getLastSelectedPathComponent().toString());
        /*        if (selectedNode == null && !"".equals(jTextPadre.getText())) {
        selectedNode.insert(new DefaultMutableTreeNode(jTextFieldNombre.getText()), selectedNode.getChildCount()+1);
        model.reload(selectedNode);
        
        /*generoO = new dataGenero(jTextFieldNombre.getText(), jTextPadre.getText());
        crl.altaGenero(genero);
        g = genCtrl.findGenero(jTextPadre.getText());
        gH = genCtrl.findGenero(jTextFieldNombre.getText());
        genHijos = g.getGenerosHijos();
        if (!genHijos.contains(gH)) {
        genHijos.add(gH);
        }
    }*/
        jTextFieldNombre.setText("");
        jTextPadre.setText("");
     
    }//GEN-LAST:event_jButtonAceptarActionPerformed


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
