/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globalhome;

import java.awt.Image;
import java.awt.Toolkit;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import static java.awt.SystemColor.window;
import java.sql.Connection;
import javax.swing.WindowConstants;
import servicios.ConnectionFactory;


/**
 *
 * @author eliss
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        
        
        initComponents();
        //this.setVisible(true);
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/escudo_fi_color.png"));
        Icon fondo1 =new ImageIcon(imagen1.getImage().getScaledInstance(I.getWidth(),I.getHeight(),Image.SCALE_DEFAULT));
        I.setIcon(fondo1);
        this.repaint();
        this.setTitle("GLOBAL HOME");
        this.setLocationRelativeTo(login.this);
        this.setExtendedState(WIDTH);
        Image ico= Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/escudo_fi_color.png"));
        this.setIconImage(ico);
        
        this.setSize(new Dimension(1340, 860));
        //setBounds(50,50,1237,905);
        
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/login.jpg"));
        Icon fondo2 =new ImageIcon(imagen2.getImage().getScaledInstance(IE.getWidth(),IE.getHeight(),Image.SCALE_DEFAULT));
        IE.setIcon(fondo2);
        toFront();
        this.repaint();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Evitamos que la ventana se cierre al ejecutarse el programa.
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        I = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        registrarse = new javax.swing.JButton();
        ingresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JTextField();
        IE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(I);
        I.setBounds(1050, 80, 190, 170);

        usuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 18)); // NOI18N
        getContentPane().add(usuario);
        usuario.setBounds(480, 230, 430, 50);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 150, 160, 60);

        registrarse.setBackground(new java.awt.Color(0, 153, 255));
        registrarse.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 36)); // NOI18N
        registrarse.setText("Registrarse");
        registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseActionPerformed(evt);
            }
        });
        getContentPane().add(registrarse);
        registrarse.setBounds(710, 560, 270, 110);

        ingresar.setBackground(new java.awt.Color(0, 153, 255));
        ingresar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 36)); // NOI18N
        ingresar.setForeground(new java.awt.Color(51, 51, 51));
        ingresar.setText("Ingresar");
        getContentPane().add(ingresar);
        ingresar.setBounds(240, 560, 230, 110);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 310, 200, 43);

        Contraseña.setFont(new java.awt.Font("Yu Gothic", 3, 18)); // NOI18N
        getContentPane().add(Contraseña);
        Contraseña.setBounds(490, 380, 430, 50);
        getContentPane().add(IE);
        IE.setBounds(0, 0, 1340, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseActionPerformed
         Registrarse r=new Registrarse();
         r.setVisible(true);
         toFront();
         this.dispose(); 
    }//GEN-LAST:event_registrarseActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                //Connection connection = ConnectionFactory.getConnection();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contraseña;
    private javax.swing.JLabel I;
    private javax.swing.JLabel IE;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton registrarse;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
