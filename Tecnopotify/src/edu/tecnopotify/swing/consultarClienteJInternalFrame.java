package edu.tecnopotify.swing;

import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataFecha;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego-lucia
 */
public class consultarClienteJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaClienteJInternalFrame
     */
    //In the constructor of MyInternalFrame, a JInternalFrame subclass:
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private String path;
    IControlador crl;

    public consultarClienteJInternalFrame() {
        super("Consultar Cliente",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...

        //Set the window's location.
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        initComponents();
        this.setTitle("Consultar cliente");

        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
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

        jFrameSelectorArchivos = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelNickName = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelFNac = new javax.swing.JLabel();
        jTextFieldDia = new javax.swing.JTextField();
        jLabelImagen = new javax.swing.JLabel();
        jTextFieldMes = new javax.swing.JTextField();
        jTextFieldAnio = new javax.swing.JTextField();
        jComboBoxNickname = new javax.swing.JComboBox();
        jimagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSeguidos = new javax.swing.JTable();
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

        jTableSeguidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NickName", "Nombre", "Mail"
            }
        ));
        jScrollPane1.setViewportView(jTableSeguidos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFNac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImagen)
                                .addGap(64, 64, 64)
                                .addComponent(jimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNickName)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelApellido, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelMail))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jTextFieldApellido)
                            .addComponent(jTextFieldMail)
                            .addComponent(jComboBoxNickname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickName)
                    .addComponent(jComboBoxNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmar))
                .addGap(15, 15, 15)
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
                    .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImagen)
                    .addComponent(jimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        //Obtengo datos de los controles Swing
        String nick = jComboBoxNickname.getSelectedItem().toString();
        Cliente cliente = crl.seleccionarCliente(nick);
        jTextFieldNombre.setText(cliente.getNombre());
        jTextFieldApellido.setText(cliente.getApellido());
        jTextFieldMail.setText(cliente.getMail());
        int d = cliente.getF_nac().getDia();
        int m = cliente.getF_nac().getMes();
        int a = cliente.getF_nac().getAnio();
        jTextFieldDia.setText(String.valueOf(d));
        jTextFieldMes.setText(String.valueOf(m));
        jTextFieldAnio.setText(String.valueOf(a));

        ImageIcon i = new ImageIcon(cliente.getImagen());
        this.jimagen.setIcon(i);
        
        List<Usuario> seguidos = cliente.getLstSeguidos();
        Iterator<Usuario> it = seguidos.iterator();
         Object rowDataT[] = new Object[3];
         DefaultTableModel model = (DefaultTableModel) jTableSeguidos.getModel();
        while(it.hasNext()){
            rowDataT[0] = it.next().getNickname();
            rowDataT[1] = it.next().getNombre();
            rowDataT[2] = it.next().getMail();
            model.addRow(rowDataT);          
        }
        
        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxNickname;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrameSelectorArchivos;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelFNac;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNickName;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSeguidos;
    private javax.swing.JTextField jTextFieldAnio;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JLabel jimagen;
    // End of variables declaration//GEN-END:variables
}
