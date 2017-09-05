/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.datatypes.dataArtista;
import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataFecha;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author diego-lucia
 */
public class AltaArtistaJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaArtistaJInternalFrame
     */
    private String path;
    IControlador crl;
    public AltaArtistaJInternalFrame() {
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
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

        jLabelApellido = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelNickName = new javax.swing.JLabel();
        jTextFieldNick = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jLabelFNac = new javax.swing.JLabel();
        jTextFieldLink = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        jButtonSImagen = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelLink = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jLabelBiografia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneBiografia = new javax.swing.JTextPane();
        jTextFieldAnio = new javax.swing.JTextField();
        jTextFieldMes = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta Artista");
        setVisible(true);

        jLabelApellido.setText("Apellido");

        jLabelNombre.setText("Nombre");

        jLabelNickName.setText("NickName");

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

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelLink.setText("Link");

        jLabelBiografia.setText("Biografia");

        jScrollPane1.setViewportView(jTextPaneBiografia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNickName)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelNombre)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelMail)
                                            .addComponent(jLabelApellido))))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jTextFieldApellido)
                                    .addComponent(jTextFieldMail)))
                            .addComponent(jButtonSImagen))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLink)
                                    .addComponent(jLabelBiografia))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLink)
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImagen)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelFNac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNickName)
                    .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMail)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFNac)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagen)
                    .addComponent(jButtonSImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLink))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConfirmar, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabelBiografia)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSImagenMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonSImagenMouseClicked

    private void jButtonSImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSImagenActionPerformed
        // TODO add your handling code here:
                //https://www.discoduroderoer.es/como-usar-el-componente-jfilechooser-en-una-aplicacion-grafica-en-java/
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
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("*.JPG", "jpg", "*.PNG", "png");
        fileChooser.setFileFilter(filtro);
        int seleccion=fileChooser.showOpenDialog(internal);
        if(seleccion == JFileChooser.APPROVE_OPTION)
        {
            File archivo=fileChooser.getSelectedFile();
            this.path=archivo.getAbsolutePath();
        }
    }//GEN-LAST:event_jButtonSImagenActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        String nickname = this.jTextFieldNick.getText();
        String nombre = this.jTextFieldNombre.getText();
        String apellido = this.jTextFieldApellido.getText();
        String mail = this.jTextFieldMail.getText();
        int dia = Integer.parseInt(this.jTextFieldDia.getText());
        int mes = Integer.parseInt(this.jTextFieldMes.getText());
        int anio = Integer.parseInt(this.jTextFieldAnio.getText());
        String link = this.jTextFieldLink.getText();
        String biografia = this.jTextPaneBiografia.getText();
        dataFecha fecha = new dataFecha(dia, mes, anio);
        String imagen = this.path;
        dataUsuario cli =  new dataArtista(link, biografia,nickname,nombre,apellido,
        mail,fecha,imagen);
        
        //A través de mi interfaz registro a un nuevo usuario en mi Sistema
        crl.crearArtista(biografia, link, cli);
        //Limpio el internal Frame
        this.jTextFieldNick.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextFieldApellido.setText("");
        this.jTextFieldMail.setText("");
        this.jTextFieldDia.setText("");
        this.jTextFieldMes.setText("");
        this.jTextFieldAnio.setText("");
        this.jTextFieldLink.setText("");
        this.jTextPaneBiografia.setText("");
        
        
        //Muestro éxito de la operación
        JOptionPane.showMessageDialog(this, "El Artista se ha creado con éxito", "Registrar Cliente", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSImagen;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelBiografia;
    private javax.swing.JLabel jLabelFNac;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelLink;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNickName;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAnio;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldLink;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNick;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextPane jTextPaneBiografia;
    // End of variables declaration//GEN-END:variables
}