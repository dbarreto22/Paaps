package edu.tecnopotify.swing;

import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataFecha;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author diego-lucia
 */
public class AltaClienteJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaClienteJInternalFrame
     */
    //In the constructor of MyInternalFrame, a JInternalFrame subclass:
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private String path;
    IControlador crl;

    public AltaClienteJInternalFrame() {

        super("Alta usuario",
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
        int d = 0;
        int m = 0;
        int a = 1950;
        while (d < 31) {
            d++;
            jComboDia.addItem(String.valueOf(d));
        }
        while (m < 12) {
            m++;
            jComboMes.addItem(String.valueOf(m));
        }
        while (a >= 1950 && a <= 2016) {
            a++;
            jComboAnio.addItem(String.valueOf(a));
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
        jLabelImagen = new javax.swing.JLabel();
        jButtonSImagen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboDia = new javax.swing.JComboBox();
        jComboMes = new javax.swing.JComboBox();
        jComboAnio = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();

        jFrameSelectorArchivos.setMinimumSize(new java.awt.Dimension(200, 200));

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameSelectorArchivosLayout = new javax.swing.GroupLayout(jFrameSelectorArchivos.getContentPane());
        jFrameSelectorArchivos.getContentPane().setLayout(jFrameSelectorArchivosLayout);
        jFrameSelectorArchivosLayout.setHorizontalGroup(
            jFrameSelectorArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameSelectorArchivosLayout.createSequentialGroup()
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
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta Cliente");
        setMinimumSize(new java.awt.Dimension(200, 300));
        setVisible(true);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

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

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDiaActionPerformed(evt);
            }
        });

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jButtonSImagen))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButtonConfirmar))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelImagen)
                            .addComponent(jButtonSImagen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)))
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
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg", "*.PNG", "png");
        fileChooser.setFileFilter(filtro);
        int seleccion = fileChooser.showOpenDialog(internal);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            this.path = archivo.getAbsolutePath();
        }
    }//GEN-LAST:event_jButtonSImagenMouseClicked

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        //Obtengo datos de los controles Swing
        String nickname = this.jTextFieldNick.getText();
        String nombre = this.jTextFieldNombre.getText();
        String apellido = this.jTextFieldApellido.getText();
        String mail = this.jTextFieldMail.getText();
        int dia = Integer.parseInt(this.jComboDia.getSelectedItem().toString());
        int mes = Integer.parseInt(this.jComboMes.getSelectedItem().toString());
        int anio = Integer.parseInt(this.jComboAnio.getSelectedItem().toString());
        dataFecha fecha = new dataFecha(dia, mes, anio);
        String imagen = this.path;
        dataUsuario cli = new dataCliente(nickname, nombre, apellido,
                mail, fecha, imagen);

        //A través de mi interfaz registro a un nuevo usuario en mi Sistema
        crl.crearCliente(cli);
        //Limpio el internal Frame
        this.jTextFieldNick.setText("");
        this.jTextFieldNombre.setText("");
        this.jTextFieldApellido.setText("");
        this.jTextFieldMail.setText("");
        this.jComboDia.setSelectedIndex(0);
        this.jComboMes.setSelectedIndex(0);
        this.jComboAnio.setSelectedIndex(0);
        //Muestro éxito de la operación
        JOptionPane.showMessageDialog(this, "El Cliente se ha creado con éxito", "Registrar Cliente", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        Cliente cli;
        cli = crl.seleccionarCliente(jTextFieldNick.getText());
        jTextFieldNombre.setText(cli.getNombre());

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSImagen;
    private javax.swing.JComboBox<String> jComboAnio;
    private javax.swing.JComboBox<String> jComboDia;
    private javax.swing.JComboBox<String> jComboMes;
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
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNick;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
