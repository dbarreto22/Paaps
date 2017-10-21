/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author menan
 */
public class SuscripcionJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form SuscripcionJInternalFrame
     * 
     * El caso de uso consiste en actualizar el estado de una suscripción existente
en el sistema. El Sistema lista las suscripciones realizadas por los clientes.
El Administrador tendrá la opción de modificar desde el estado
“Pendiente” a "Vigente" o  ̈Cancelada ̈, registrándose la fecha
correspondiente (según la decha del sistema). En otro caso no se puede
realizar la modificación. Cabe destacar que el pasaje de  ̈Vigente ̈ a
 ̈Vencida ̈ se realiza automáticamente acorde a la fecha del sistema y el
tipo de suscripción contratada (semanal, mensual o anual).
     */
    
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private IControlador crl;
    
    public SuscripcionJInternalFrame() {
        super("Modificar suscripcion",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        initComponents();
        
        this.jComboBoxPago.setVisible(false);
        this.jTextFieldPago.setVisible(false);

        rellenarElCoso();
        //tengo q ver estado de suscripción del primer cliente y cargar el combo según eso
        this.jComboBoxEstadoSuscripcion.addItem("PENDIENTE");
        //this.jComboBoxEstadoSuscripcion.addItem("VENCIDA");
        this.jComboBoxEstadoSuscripcion.addItem("VIGENTE");
        this.jComboBoxEstadoSuscripcion.addItem("CANCELADA");
        
        this.jComboBoxPago.addItem("SEMANAL");
        this.jComboBoxPago.addItem("MENSUAL");
        this.jComboBoxPago.addItem("ANUAL");
       
    }

    private void rellenarElCoso() {

        List<Cliente> clientes = crl.listarClientes();
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            jComboBoxNickname.addItem(it.next().getNickname());
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

        jLabelCliente = new javax.swing.JLabel();
        jComboBoxNickname = new javax.swing.JComboBox();
        jLabelCliente1 = new javax.swing.JLabel();
        jComboBoxEstadoSuscripcion = new javax.swing.JComboBox();
        jButtonCambiarEstadoSusc = new javax.swing.JButton();
        jLabelCliente2 = new javax.swing.JLabel();
        jTextFieldSuscripcionActual = new javax.swing.JTextField();
        jTextFieldPago = new javax.swing.JTextField();
        jComboBoxPago = new javax.swing.JComboBox();

        jLabelCliente.setText("Cliente");

        jComboBoxNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNicknameActionPerformed(evt);
            }
        });

        jLabelCliente1.setText("Suscripción nueva:");

        jComboBoxEstadoSuscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoSuscripcionActionPerformed(evt);
            }
        });

        jButtonCambiarEstadoSusc.setText("Cambiar estado");
        jButtonCambiarEstadoSusc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarEstadoSuscActionPerformed(evt);
            }
        });

        jLabelCliente2.setText("Suscripción actual:");

        jTextFieldPago.setText("Pago:");

        jComboBoxPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jComboBoxNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCliente1)
                            .addComponent(jLabelCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldSuscripcionActual)
                                .addComponent(jButtonCambiarEstadoSusc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxEstadoSuscripcion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSuscripcionActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstadoSuscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jButtonCambiarEstadoSusc)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNicknameActionPerformed
        // TODO add your handling code here:
        String nick = this.jComboBoxNickname.getSelectedItem().toString();
        String estado = crl.obtenerEstadoSuscripcion(nick);
        this.jTextFieldSuscripcionActual.setText(estado);

        //tomo los estados posibles para la suscripción a partir del estado actual
        if (estado.equals("PENDIENTE")) {
            this.jComboBoxEstadoSuscripcion.removeItem("VENCIDA");
        }
        if (estado.equals("VIGENTE")) {
            this.jComboBoxEstadoSuscripcion.removeItem("PENDIENTE");
            this.jComboBoxEstadoSuscripcion.removeItem("CANCELADA");
            this.jComboBoxEstadoSuscripcion.addItem("VENCIDA");
        }
        if (estado.equals("VENCIDA")) {
            this.jComboBoxEstadoSuscripcion.removeItem("PENDIENTE");
        }
        if (estado.equals("CANCELADA")) {
            this.jComboBoxEstadoSuscripcion.removeItem("VENCIDA");
            this.jComboBoxEstadoSuscripcion.removeItem("VIGENTE");
        }

    }//GEN-LAST:event_jComboBoxNicknameActionPerformed

    private void jComboBoxEstadoSuscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoSuscripcionActionPerformed
        // TODO add your handling code here:
        String suscrip = this.jComboBoxEstadoSuscripcion.getSelectedItem().toString();

        if (suscrip.equals("VIGENTE")) {
            //si la suscripción se va a cambiar a pendiente se considera la forma de pago
            this.jComboBoxPago.setVisible(true);
            this.jTextFieldPago.setVisible(true);
        } else {
            this.jComboBoxPago.setVisible(false);
            this.jTextFieldPago.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxEstadoSuscripcionActionPerformed

    private void jButtonCambiarEstadoSuscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarEstadoSuscActionPerformed
        // TODO add your handling code here:
        String nick = this.jComboBoxNickname.getSelectedItem().toString();
        String suscrip = this.jComboBoxEstadoSuscripcion.getSelectedItem().toString();
        String pago = this.jComboBoxPago.getSelectedItem().toString();
        this.crl.modificarSuscripcion(nick, suscrip, pago);
        
        JOptionPane.showMessageDialog(this, "Suscripción con éxito", "Modificar Suscripción", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCambiarEstadoSuscActionPerformed

    private void jComboBoxPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCambiarEstadoSusc;
    private javax.swing.JComboBox<String> jComboBoxEstadoSuscripcion;
    private javax.swing.JComboBox<String> jComboBoxNickname;
    private javax.swing.JComboBox<String> jComboBoxPago;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelCliente1;
    private javax.swing.JLabel jLabelCliente2;
    private javax.swing.JTextField jTextFieldPago;
    private javax.swing.JTextField jTextFieldSuscripcionActual;
    // End of variables declaration//GEN-END:variables
}
