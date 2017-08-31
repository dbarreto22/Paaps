/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

/**
 *
 * @author diego-lucia
 */
public class JInternalFrameAltaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameAltaCliente
     */
    //In the constructor of MyInternalFrame, a JInternalFrame subclass:
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public JInternalFrameAltaCliente() {
        super("Alta usuario" + (++openFrameCount),
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...

        //Set the window's location.
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameSelectorArchivos = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelNickName = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelFNac = new javax.swing.JLabel();
        jTextFieldFNac = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        jButtonSImagen = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jFrameSelectorArchivos.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jFrameSelectorArchivosLayout = new javax.swing.GroupLayout(jFrameSelectorArchivos.getContentPane());
        jFrameSelectorArchivos.getContentPane().setLayout(jFrameSelectorArchivosLayout);
        jFrameSelectorArchivosLayout.setHorizontalGroup(
            jFrameSelectorArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameSelectorArchivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jFrameSelectorArchivosLayout.setVerticalGroup(
            jFrameSelectorArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameSelectorArchivosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setClosable(true);
        setResizable(true);
        setVisible(true);

        jButtonConfirmar.setText("Confirmar");

        jLabelNickName.setText("NickName");

        jLabelNombre.setText("Nombre");

        jLabelApellido.setText("Apellido");

        jLabelMail.setText("Mail");

        jLabelFNac.setText("Fecha de nacimiento");

        jLabelImagen.setText("Imagen");

        jButtonSImagen.setText("Subir imagen");
        jButtonSImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSImagenMouseClicked(evt);
            }
        });
        jButtonSImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSImagenActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNickName)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelApellido, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelMail))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNick, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldApellido)
                            .addComponent(jTextFieldMail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFNac)
                            .addComponent(jLabelImagen))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButtonSImagen)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldFNac, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickName)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMail))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFNac)
                    .addComponent(jTextFieldFNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelImagen)
                    .addComponent(jButtonSImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSImagenActionPerformed
        // TODO add your handling code here:
         jFrameSelectorArchivos.setVisible(true);
        // https://www.discoduroderoer.es/como-usar-el-componente-jfilechooser-en-una-aplicacion-grafica-en-java/
    }//GEN-LAST:event_jButtonSImagenActionPerformed

    private void jButtonSImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSImagenMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButtonSImagenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSImagen;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrameSelectorArchivos;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelFNac;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNickName;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldFNac;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNick;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
