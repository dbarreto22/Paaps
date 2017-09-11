package edu.tecnopotify.swing;

import static edu.tecnopotify.swing.AltaGeneroJInternalFrame.xOffset;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carlox
 */
    public class VentanaPrincipal extends javax.swing.JFrame {

    private Interfaz ctrl;
    private AltaClienteJInternalFrame altaUsuario;
    private AltaGeneroJInternalFrame alatGenero;
    // private JFrame frame = new JFrame();

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();

    }

    protected void createFrameAltaCliente() {
        AltaClienteJInternalFrame frame = new AltaClienteJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void createFrameAltaArtista() {
        AltaArtistaJInternalFrame frame = new AltaArtistaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void createFrameAltaGenero() {
        AltaGeneroJInternalFrame frame = new AltaGeneroJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void createFrameAltaAlbum() {
        AltaAlbumJInternalFrame frame = new AltaAlbumJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void createFrameAgregarFavorito() {
        AgregarFavoritoJInternalFrame frame = new AgregarFavoritoJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createFrameCrearListaReproduccion() {
        CrearListaReproduccionJInternalFrame frame = new CrearListaReproduccionJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarArtistaJInternalFrame() {
        consultarArtistaJInternalFrame frame = new consultarArtistaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarClienteJInternalFrame() {
        consultarClienteJInternalFrame frame = new consultarClienteJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarListaDeReproduccionJInternalFrame() {
        ConsultaListaReproduccionJInternalFrame frame = new ConsultaListaReproduccionJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void pruebaJInternalFrame() {
        pruebaJInternalFrame frame = new pruebaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void publicarListaReproduccionJInternalFrame() {
        PublicarListaJInternalFrame frame = new PublicarListaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultarAlbumJInternalFrame() {
        ConsultarAlbumJInternalFrame frame = new ConsultarAlbumJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarTemaJInternalFrame() {
        agregarTemaJInternalFrame frame = new agregarTemaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearTemaJInternalFrame() {
        crearTemaJInternalFrame frame = new crearTemaJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        
    protected void createFrameSeguirUsuario() {
        SeguirUsuarioJInternalFrame frame = new SeguirUsuarioJInternalFrame();
        frame.setVisible(true);
        this.Desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jMenu12 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuUuarios = new javax.swing.JMenu();
        jMenuCrearCliente = new javax.swing.JMenuItem();
        jMenuCrearArtista = new javax.swing.JMenuItem();
        jMenuConsultarCliente = new javax.swing.JMenuItem();
        jMenuConsultarArtista = new javax.swing.JMenuItem();
        menuGenero = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAlbum = new javax.swing.JMenu();
        jMenuCrearAlbum = new javax.swing.JMenuItem();
        consultarAlbum = new javax.swing.JMenuItem();
        menuFavs = new javax.swing.JMenu();
        SeguirUsuario = new javax.swing.JMenuItem();
        DejarSeguir = new javax.swing.JMenuItem();
        menuGuardarFavorito = new javax.swing.JMenuItem();
        QuitarTema = new javax.swing.JMenuItem();
        menuLista = new javax.swing.JMenu();
        CrearTema = new javax.swing.JMenuItem();
        JMenuCrearListaRep = new javax.swing.JMenuItem();
        agregarTema = new javax.swing.JMenuItem();
        jMenuPublicarLista = new javax.swing.JMenuItem();
        jMenuConsutlarListaRep = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenu12.setText("jMenu12");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frPrincipal"); // NOI18N

        jMenu3.setText("Menu");

        menuUuarios.setText("Usuarios");

        jMenuCrearCliente.setText("Crear Cliente");
        jMenuCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCrearClienteActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuCrearCliente);

        jMenuCrearArtista.setText("Crear Artista");
        jMenuCrearArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCrearArtistaActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuCrearArtista);

        jMenuConsultarCliente.setText("Consultar cliente");
        jMenuConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultarClienteActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuConsultarCliente);

        jMenuConsultarArtista.setText("Consultar artista");
        jMenuConsultarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultarArtistaActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuConsultarArtista);

        jMenu3.add(menuUuarios);

        menuGenero.setText("Generos");

        jMenuItem4.setText("Crear genero");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCrearGeneroActionPerformed(evt);
            }
        });
        menuGenero.add(jMenuItem4);

        jMenu3.add(menuGenero);

        menuAlbum.setText("Albums");
        menuAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAlbumMouseClicked(evt);
            }
        });

        jMenuCrearAlbum.setText("Crear album");
        jMenuCrearAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCrearAlbumMouseClicked(evt);
            }
        });
        jMenuCrearAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCrearAlbumActionPerformed(evt);
            }
        });
        menuAlbum.add(jMenuCrearAlbum);

        consultarAlbum.setText("Consultar album");
        consultarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAlbumActionPerformed(evt);
            }
        });
        menuAlbum.add(consultarAlbum);

        jMenu3.add(menuAlbum);

        menuFavs.setText("Favoritos");
        menuFavs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFavsActionPerformed(evt);
            }
        });

        SeguirUsuario.setText("Seguir usuario");
        SeguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirUsuarioActionPerformed(evt);
            }
        });
        menuFavs.add(SeguirUsuario);

        DejarSeguir.setText("Dejar de seguir");
        menuFavs.add(DejarSeguir);

        menuGuardarFavorito.setText("Guardar tema/lista/album");
        menuGuardarFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarFavoritoActionPerformed(evt);
            }
        });
        menuFavs.add(menuGuardarFavorito);

        QuitarTema.setText("Quitar  tema/lista/album");
        menuFavs.add(QuitarTema);

        jMenu3.add(menuFavs);

        menuLista.setText("Lista de reproduccion");

        CrearTema.setText("Crear tema");
        CrearTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearTemaActionPerformed(evt);
            }
        });
        menuLista.add(CrearTema);

        JMenuCrearListaRep.setText("Crear lista rep.");
        JMenuCrearListaRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuCrearListaRepActionPerformed(evt);
            }
        });
        menuLista.add(JMenuCrearListaRep);

        agregarTema.setText("Agregar/Quitar tema de Lista de Rep.");
        agregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTemaActionPerformed(evt);
            }
        });
        menuLista.add(agregarTema);

        jMenuPublicarLista.setText("Publicar lista");
        jMenuPublicarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPublicarListaActionPerformed(evt);
            }
        });
        menuLista.add(jMenuPublicarLista);

        jMenuConsutlarListaRep.setText("Consultar Lista");
        jMenuConsutlarListaRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsutlarListaRepActionPerformed(evt);
            }
        });
        menuLista.add(jMenuConsutlarListaRep);

        jMenu3.add(menuLista);

        jMenuBar3.add(jMenu3);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("ventanaPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultarClienteActionPerformed
        // TODO add your handling code here:
        consultarClienteJInternalFrame();

    }//GEN-LAST:event_jMenuConsultarClienteActionPerformed

    private void menuAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAlbumMouseClicked

    }//GEN-LAST:event_menuAlbumMouseClicked

    private void jMenuCrearAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCrearAlbumMouseClicked
        //Muestra el panel de altas y lo prepara para el alta de usuarios

    }//GEN-LAST:event_jMenuCrearAlbumMouseClicked

    private void jMenuCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCrearClienteActionPerformed
        // TODO add your handling code here:
        createFrameAltaCliente();
    }//GEN-LAST:event_jMenuCrearClienteActionPerformed

    private void jCrearGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCrearGeneroActionPerformed
        // TODO add your handling code here:
        createFrameAltaGenero();
    }//GEN-LAST:event_jCrearGeneroActionPerformed

    private void jMenuCrearArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCrearArtistaActionPerformed
        // TODO add your handling code here:
        createFrameAltaArtista();
    }//GEN-LAST:event_jMenuCrearArtistaActionPerformed

    private void jMenuCrearAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCrearAlbumActionPerformed
        // TODO add your handling code here:
        createFrameAltaAlbum();
    }//GEN-LAST:event_jMenuCrearAlbumActionPerformed

    private void SeguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirUsuarioActionPerformed
        // TODO add your handling code here:
        createFrameSeguirUsuario();
    }//GEN-LAST:event_SeguirUsuarioActionPerformed

    private void JMenuCrearListaRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuCrearListaRepActionPerformed
        // TODO add your handling code here:
        createFrameCrearListaReproduccion();
    }//GEN-LAST:event_JMenuCrearListaRepActionPerformed

    private void jMenuConsultarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultarArtistaActionPerformed
        // TODO add your handling code here:
        consultarArtistaJInternalFrame();
    }//GEN-LAST:event_jMenuConsultarArtistaActionPerformed

    private void jMenuConsultarListaReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultarListaReproduccionActionPerformed
        // TODO add your handling code here:
        consultarListaDeReproduccionJInternalFrame();
    }//GEN-LAST:event_jMenuConsultarListaReproduccionActionPerformed


    private void agregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTemaActionPerformed
        // TODO add your handling code here:
        agregarTemaJInternalFrame();
    }//GEN-LAST:event_agregarTemaActionPerformed

    private void jMenuConsutlarListaRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsutlarListaRepActionPerformed
        // TODO add your handling code here:
        consultarListaDeReproduccionJInternalFrame();
    }//GEN-LAST:event_jMenuConsutlarListaRepActionPerformed

    private void jMenuPublicarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPublicarListaActionPerformed
        // TODO add your handling code here:
        publicarListaReproduccionJInternalFrame();
    }//GEN-LAST:event_jMenuPublicarListaActionPerformed

    private void consultarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAlbumActionPerformed
        // TODO add your handling code here:
        consultarAlbumJInternalFrame();
    }//GEN-LAST:event_consultarAlbumActionPerformed

    private void CrearTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearTemaActionPerformed
        // TODO add your handling code here:
        crearTemaJInternalFrame();
    }//GEN-LAST:event_CrearTemaActionPerformed

<<<<<<< HEAD
    private void menuGuardarFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarFavoritoActionPerformed
        // TODO add your handling code here:
        createFrameAgregarFavorito();
    }//GEN-LAST:event_menuGuardarFavoritoActionPerformed
=======
    private void menuFavsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFavsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuFavsActionPerformed
>>>>>>> 23de3fbb962baa34c4aca42bc419750b1688fc68

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CrearTema;
    private javax.swing.JMenuItem DejarSeguir;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem JMenuCrearListaRep;
    private javax.swing.JMenuItem QuitarTema;
    private javax.swing.JMenuItem SeguirUsuario;
    private javax.swing.JMenuItem agregarTema;
    private javax.swing.JMenuItem consultarAlbum;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuConsultarArtista;
    private javax.swing.JMenuItem jMenuConsultarCliente;
    private javax.swing.JMenuItem jMenuConsutlarListaRep;
    private javax.swing.JMenuItem jMenuCrearAlbum;
    private javax.swing.JMenuItem jMenuCrearArtista;
    private javax.swing.JMenuItem jMenuCrearCliente;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuPublicarLista;
    private javax.swing.JMenu menuAlbum;
    private javax.swing.JMenu menuFavs;
    private javax.swing.JMenu menuGenero;
    private javax.swing.JMenuItem menuGuardarFavorito;
    private javax.swing.JMenu menuLista;
    private javax.swing.JMenu menuUuarios;
    // End of variables declaration//GEN-END:variables

    private static class Interfaz {

        public Interfaz() {
        }
    }
}
