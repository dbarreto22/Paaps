/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;


import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;



public class dejarUsuarioJInternalFrame extends javax.swing.JInternalFrame {
   
    /**
     * Creates new form SeguirUsuarioJInternalFrame
     */
    Fabrica fabrica = Fabrica.getInstance();
    IControlador  crl = fabrica.getInstancia();
    private String nick;
    public dejarUsuarioJInternalFrame() {
        initComponents();
        this.setFocusable(true);
    }
    
        public dejarUsuarioJInternalFrame(String nickName) {
        initComponents();
        this.moveToFront();
        nick = nickName;
        Cliente cli  = crl.getCli(nickName);
        

        
        List<Usuario> seguidos = cli.getLstSeguidos();
        Iterator<Usuario> it = seguidos.iterator();
        while (it.hasNext()) {
            jComboBoxSeguidos.addItem(it.next().getNickname());
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

        jLabelClientes = new javax.swing.JLabel();
        jComboBoxSeguidos = new javax.swing.JComboBox();
        jButtonDejarSeguir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabelClientes.setText("Seguidos");

        jComboBoxSeguidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeguidosActionPerformed(evt);
            }
        });

        jButtonDejarSeguir.setText("Dejar Seguir Usuario");
        jButtonDejarSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDejarSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelClientes)
                .addGap(56, 56, 56)
                .addComponent(jComboBoxSeguidos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDejarSeguir)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClientes)
                    .addComponent(jComboBoxSeguidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButtonDejarSeguir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSeguidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeguidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSeguidosActionPerformed

    private void jButtonDejarSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDejarSeguirActionPerformed
        // TODO add your handling code here:
        if (jComboBoxSeguidos.getSelectedItem()!=null) {
            crl.dejarDeSeguirUsuario(nick,jComboBoxSeguidos.getSelectedItem().toString()); 
            JOptionPane.showMessageDialog(this,"Operacion realizada","Dejar de Seguir Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un seguidor");
        }
    }//GEN-LAST:event_jButtonDejarSeguirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDejarSeguir;
    private javax.swing.JComboBox<String> jComboBoxSeguidos;
    private javax.swing.JLabel jLabelClientes;
    // End of variables declaration//GEN-END:variables
}
