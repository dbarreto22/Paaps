/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.swing;

import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Temas;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;
import static edu.tecnopotify.swing.AltaClienteJInternalFrame.openFrameCount;
import static edu.tecnopotify.swing.AltaClienteJInternalFrame.yOffset;
import static edu.tecnopotify.swing.consultarClienteJInternalFrame.xOffset;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author menan
 */
public class AgregarFavoritoJInternalFrame extends javax.swing.JInternalFrame {

    /*El caso de uso comienza cuando el administrador desea marcar
un tema/lista/álbum como favorito para un cliente. Para ello
indica el cliente que desea agregar a sus favoritos uno de los
elementos, así como el tema, lista o álbum que desea agregar.
En caso de que los datos sean correctos, el sistema ingresa el
elemento dentro de las preferencias del cliente. Las listas a
guardar deben ser propietarias públicas o por defecto, y los
temas no se pueden seleccionar de listas privadas.*/
    /**
     * Creates new form AgregarFavoritoJInternalFrame
     */
    private IControlador crl;
    
    public AgregarFavoritoJInternalFrame() {
        super("Agregar Favorito",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable
        //...Create the GUI and put it in the window...
        //...Then set the window size or call pack...

        //Set the window's location.
        setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
        initComponents();
        this.setTitle("Agregar Favorito");
        Fabrica fabrica = Fabrica.getInstance();
        crl = fabrica.getInstancia();
        List<Cliente> clientes = crl.listarClientes();
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            jComboBoxCliente.addItem(it.next().getNickname());
        }
        jComboBoxTemaListaAlbum.addItem("Tema");
        jComboBoxTemaListaAlbum.addItem("Lista");
        jComboBoxTemaListaAlbum.addItem("Album");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxCliente = new javax.swing.JComboBox();
        jLabelNickName = new javax.swing.JLabel();
        jComboBoxTemaListaAlbum = new javax.swing.JComboBox();
        jLabelNickName1 = new javax.swing.JLabel();
        jLabelNickName2 = new javax.swing.JLabel();
        jTextFieldNombreElemento = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jComboBoxElementos = new javax.swing.JComboBox();

        jLabelNickName.setText("NickName");

        jComboBoxTemaListaAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTemaListaAlbumActionPerformed(evt);
            }
        });

        jLabelNickName1.setText("Agregar");

        jLabelNickName2.setText("Nombre del elemento");

        jTextFieldNombreElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreElementoActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldNombreElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAceptar)
                                .addGap(115, 115, 115))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelNickName2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxElementos, 0, 134, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNickName1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTemaListaAlbum, 0, 134, Short.MAX_VALUE)
                                    .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTemaListaAlbum)
                    .addComponent(jLabelNickName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNickName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jTextFieldNombreElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAceptar)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        String nombreElemento = jTextFieldNombreElemento.getText().toString();
        Cliente cliente = crl.seleccionarCliente(jComboBoxCliente.getSelectedItem().toString());

        //eliminarFavorito(boolean tema, boolean lista, boolean album, long idCliente, String idElemento) 
        if (jComboBoxTemaListaAlbum.toString() == "Tema"){
            crl.agregarFavorito(true, false, false, cliente.getNickname(), nombreElemento);
        } else if (jComboBoxTemaListaAlbum.toString() == "Lista"){
            crl.agregarFavorito(false, true, false, cliente.getNickname(), nombreElemento);
        } else if (jComboBoxTemaListaAlbum.toString() == "Album"){
            crl.agregarFavorito(false, false, true, cliente.getNickname(), nombreElemento);
        }

        JOptionPane.showMessageDialog(this, "Favorito agregado con éxito", "Agregar Favorito", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jComboBoxTemaListaAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTemaListaAlbumActionPerformed
        // TODO add your handling code here:
        if(jComboBoxTemaListaAlbum.getSelectedItem().toString().equals("Tema"))
        {cargarTemas();}
        /*   else if(jComboBoxTemaListaAlbum.getSelectedItem().toString().equals("Lista"))
        {cargarListas();}*/
        else if(jComboBoxTemaListaAlbum.getSelectedItem().toString().equals("Album"))
        {cargarAlbum();}
    }//GEN-LAST:event_jComboBoxTemaListaAlbumActionPerformed

    private void jTextFieldNombreElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreElementoActionPerformed
 private void cargarTemas()
 {   Fabrica fabrica = Fabrica.getInstance();
     crl = fabrica.getInstancia();
     List<Temas> lista = crl.listarTemas();
     Iterator<Temas> it = lista.iterator();
     jComboBoxElementos.removeAllItems();
     while (it.hasNext()) {
         jComboBoxElementos.addItem(it.next().getNombre());
     }
 }
 
  private void cargarListas()
 {   Fabrica fabrica = Fabrica.getInstance();
     crl = fabrica.getInstancia();
     List<ListaReproduccion> lista = crl.listarListaRepr();
     Iterator<ListaReproduccion> it = lista.iterator();
     jComboBoxElementos.removeAllItems();
     while (it.hasNext()) {
         jComboBoxElementos.addItem(it.next().getNombre());
     }
 }
  
    private void cargarAlbum()
 {   Fabrica fabrica = Fabrica.getInstance();
     crl = fabrica.getInstancia();
     List<Album> lista = crl.listarAlbum();
     Iterator<Album> it = lista.iterator();
     jComboBoxElementos.removeAllItems();
     while (it.hasNext()) {
         jComboBoxElementos.addItem(it.next().getNombre());
     }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxElementos;
    private javax.swing.JComboBox<String> jComboBoxTemaListaAlbum;
    private javax.swing.JLabel jLabelNickName;
    private javax.swing.JLabel jLabelNickName1;
    private javax.swing.JLabel jLabelNickName2;
    private javax.swing.JTextField jTextFieldNombreElemento;
    // End of variables declaration//GEN-END:variables
}
