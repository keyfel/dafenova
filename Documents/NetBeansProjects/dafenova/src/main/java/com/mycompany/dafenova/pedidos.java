/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dafenova;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class pedidos extends javax.swing.JFrame {
    conexion co=new conexion(); // -> instanica la clase de conexion
    Connection conet;  // -> interfas conecta metodo con el driver
    DefaultTableModel modelo; 
    Statement st; // -> inserta a la base de datos
    ResultSet rs; // -> consulta a la base de datos
    
    String idc;
    /**
     * Creates new form pedidos
     */
    public pedidos() {
        initComponents();
        consultar();
    } 
    
    public void limpiar(){
        modelo.getDataVector().removeAllElements();
        j_pedidos.updateUI();
        }
    
    public void consultar(){
        String sql = "select * from pedidos";
        
        try{
        conet = co.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        Object [] item_pedido = new Object [5];
        modelo = (DefaultTableModel) j_pedidos.getModel();
        while(rs.next()){
            item_pedido [0] = rs.getInt("id_pedido");
            item_pedido [1] = rs.getString("usuario_vendedor");
            item_pedido [2] = rs.getString("fecha");
            item_pedido [3] = rs.getString("estado");
            item_pedido [4] = rs.getInt("valor_total");
            modelo.addRow(item_pedido);
        }
        j_pedidos.setModel(modelo);
        
        }catch(Exception e){
            System.out.println("tenemos un error:  "+ e);
        }
    }
    
    public void buscar(){
        String buscar = txt_buscar.getText();
        String filtro = txt_filtro.getSelectedItem().toString();
        if(buscar.equals("") || filtro.equals("elija un filtro")){
            JOptionPane.showMessageDialog(null,"ingrese algun dato");
        }else{     
            if(filtro.equals("nombre")){
                limpiar();
            String sql = "select * from pedidos where usuario_vendedor = '"+buscar+"';";
             try{
        conet = co.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        Object [] item_pedido = new Object [5];
        modelo = (DefaultTableModel) j_pedidos.getModel();
        while(rs.next()){
            item_pedido [0] = rs.getInt("id_pedido");
            item_pedido [1] = rs.getString("usuario_vendedor");
            item_pedido [2] = rs.getString("fecha");
            item_pedido [3] = rs.getString("estado");
            item_pedido [4] = rs.getInt("valor_total");
            modelo.addRow(item_pedido);
        }
        j_pedidos.setModel(modelo);
        
        }catch(Exception e){
            System.out.println("tenemos un error:  "+ e);
        }   
            }else{
                if(filtro.equals("codigo")){
                limpiar();
            String sql = "select * from pedidos where id_pedido = '"+buscar+"';";
             try{
        conet = co.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        Object [] item_pedido = new Object [5];
        modelo = (DefaultTableModel) j_pedidos.getModel();
        while(rs.next()){
            item_pedido [0] = rs.getInt("id_pedido");
            item_pedido [1] = rs.getString("usuario_vendedor");
            item_pedido [2] = rs.getString("fecha");
            item_pedido [3] = rs.getString("estado");
            item_pedido [4] = rs.getInt("valor_total");
            modelo.addRow(item_pedido);
        }
        j_pedidos.setModel(modelo);
        
        }catch(Exception e){
            System.out.println("tenemos un error:  "+ e);
        }   
            }else{
                if(filtro.equals("estado")){
                limpiar();
            String sql = "select * from pedidos where estado = '"+buscar+"';";
             try{
        conet = co.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        Object [] item_pedido = new Object [5];
        modelo = (DefaultTableModel) j_pedidos.getModel();
        while(rs.next()){
            item_pedido [0] = rs.getInt("id_pedido");
            item_pedido [1] = rs.getString("usuario_vendedor");
            item_pedido [2] = rs.getString("fecha");
            item_pedido [3] = rs.getString("estado");
            item_pedido [4] = rs.getInt("valor_total");
            modelo.addRow(item_pedido);
        }
        j_pedidos.setModel(modelo);
        
        }catch(Exception e){
            System.out.println("tenemos un error:  "+ e);
        }   
            }else{
                
            }
            }
            }
            
        }
    }
    
    public void menu(){
        this.dispose();
        menu m = new menu();
        m.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_pedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt_filtro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\buscarr.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\filtrar.png")); // NOI18N

        j_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numero", "usuario", "fecha", "estado", "valor"
            }
        ));
        j_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_pedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_pedidos);

        jButton1.setBackground(new java.awt.Color(244, 154, 154));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\atras.png")); // NOI18N
        jButton1.setText("atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(162, 175, 242));
        jPanel2.setPreferredSize(new java.awt.Dimension(324, 84));

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        jLabel1.setText("pedidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(207, 207, 207))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(163, 181, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\revisar.png")); // NOI18N
        jButton3.setText("revisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(163, 181, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\nuevo_pedido.png")); // NOI18N
        jButton4.setText("nuevo pedido");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txt_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elija un filtro", "nombre", "codigo", "estado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(71, 71, 71)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
menu();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
buscar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int fila = j_pedidos.getSelectedRow();
   if (fila ==-1){
       JOptionPane.showMessageDialog(null,"seleccione una fila");
   }else{
       JOptionPane.showMessageDialog(null,"esta ventana aun no esta terminada");
      /* this.dispose();
        pedido p = new pedido();
        p.setDato(txt_buscar.getText());
        p.setVisible(true);*/
   }
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void j_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_pedidosMouseClicked
int fila = j_pedidos.getSelectedRow();
       idc = ((String) j_pedidos.getValueAt(fila,1));
       txt_buscar.setText("" + idc);
       
   
// TODO add your handling code here:
    }//GEN-LAST:event_j_pedidosMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       JOptionPane.showMessageDialog(null,"esta ventana aun no esta terminada");
        /* this.dispose();
        nuevo_pedido np = new nuevo_pedido();
        np.setVisible(true); */        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_pedidos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JComboBox<String> txt_filtro;
    // End of variables declaration//GEN-END:variables
}
