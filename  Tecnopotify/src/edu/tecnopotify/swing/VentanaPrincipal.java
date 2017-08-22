package edu.tecnopotify.swing;

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

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setSize(550, 550);
        
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
        panelAltas = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAltas = new javax.swing.JTable();
        lblPanelAltaTipo = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuUuarios = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        menuGenero = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAlbum = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        menuFavs = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        menuLista = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenu12.setText("jMenu12");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frPrincipal"); // NOI18N

        panelAltas.setClosable(true);
        panelAltas.setResizable(true);
        panelAltas.setTitle("Alta album");
        panelAltas.setVisible(true);

        tablaAltas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tablaAltas);

        lblPanelAltaTipo.setText("jLabel1");

        javax.swing.GroupLayout panelAltasLayout = new javax.swing.GroupLayout(panelAltas.getContentPane());
        panelAltas.getContentPane().setLayout(panelAltasLayout);
        panelAltasLayout.setHorizontalGroup(
            panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAltasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPanelAltaTipo)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelAltasLayout.setVerticalGroup(
            panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAltasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPanelAltaTipo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jMenu3.setText("Menu");

        menuUuarios.setText("Usuarios");

        jMenuItem1.setText("Crear usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuItem1);

        jMenuItem3.setText("Consultar cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuUuarios.add(jMenuItem3);

        jMenuItem14.setText("Consultar artista");
        menuUuarios.add(jMenuItem14);

        jMenu3.add(menuUuarios);

        menuGenero.setText("Generos");

        jMenuItem4.setText("Crear genero");
        menuGenero.add(jMenuItem4);

        jMenu3.add(menuGenero);

        menuAlbum.setText("Albums");
        menuAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAlbumMouseClicked(evt);
            }
        });

        jMenuItem5.setText("Crear album");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        menuAlbum.add(jMenuItem5);

        jMenuItem15.setText("Consultar album");
        menuAlbum.add(jMenuItem15);

        jMenu3.add(menuAlbum);

        menuFavs.setText("Favoritos");

        jMenuItem10.setText("Seguir usuario");
        menuFavs.add(jMenuItem10);

        jMenuItem11.setText("Dejar de seguir");
        menuFavs.add(jMenuItem11);

        jMenuItem12.setText("Guardar tema/lista/album");
        menuFavs.add(jMenuItem12);

        jMenuItem13.setText("Quitar  tema/lista/album");
        menuFavs.add(jMenuItem13);

        jMenu3.add(menuFavs);

        menuLista.setText("Lista de reproduccion");

        jMenuItem6.setText("Crear lista rep.");
        menuLista.add(jMenuItem6);

        jMenuItem7.setText("Agregar tema");
        menuLista.add(jMenuItem7);

        jMenuItem8.setText("Quitar tema");
        menuLista.add(jMenuItem8);

        jMenuItem9.setText("Publicar lista");
        menuLista.add(jMenuItem9);

        jMenuItem16.setText("Consultar lista");
        menuLista.add(jMenuItem16);

        jMenu3.add(menuLista);

        jMenuBar3.add(jMenu3);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("ventanaPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAlbumMouseClicked

    }//GEN-LAST:event_menuAlbumMouseClicked

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
       //Muestra el panel de altas y lo prepara para el alta de usuarios
        panelAltas.setVisible(true);
        panelAltas.setTitle("Alta Album");
        lblPanelAltaTipo.setText("Elegir artista");
    }//GEN-LAST:event_jMenuItem5MouseClicked

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
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPanelAltaTipo;
    private javax.swing.JMenu menuAlbum;
    private javax.swing.JMenu menuFavs;
    private javax.swing.JMenu menuGenero;
    private javax.swing.JMenu menuLista;
    private javax.swing.JMenu menuUuarios;
    private javax.swing.JInternalFrame panelAltas;
    private javax.swing.JTable tablaAltas;
    // End of variables declaration//GEN-END:variables

    private static class Interfaz {

        public Interfaz() {
        }
    }
}
