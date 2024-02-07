/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dafenova;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class inventario extends javax.swing.JFrame {
         conexion co=new conexion(); // -> instanica la clase de conexion
    Connection conet;  // -> interfas conecta metodo con el driver
    DefaultTableModel modelo; 
    Statement st; // -> inserta a la base de datos
    ResultSet rs; // -> consulta a la base de datos
    
    int idc;

    /**
     * Creates new form inventario
     */
    public inventario() {
        initComponents();
        consultar();
    }
    
    public void consultar(){
        String sql = "select * from inventario";
        
        try{
        conet = co.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        Object [] item_pedido = new Object [5];
        modelo = (DefaultTableModel) j_inventario.getModel();
        while(rs.next()){
            item_pedido [0] = rs.getInt("id_prenda"); 
            item_pedido [1] = rs.getString("nombre");
            item_pedido [2] = rs.getString("color");
            item_pedido [3] = rs.getString(("talla"));
            item_pedido [4] = rs.getInt(("cantidad"));
            modelo.addRow(item_pedido);
        }
        j_inventario.setModel(modelo);
        
        }catch(Exception e){
            System.out.println("tenemos un error:  "+ e);
        }
    }
    
    public void limpiar_campos(){
        txt_id_prenda.setText("");
        txt_nombre.setText("");
        txt_color.setSelectedItem("elija un color");
        txt_talla.setSelectedItem("elija una talla");
        txt_cantidad.setText("");
    }
    
    public void limpiar_tabla(){
        modelo.getDataVector().removeAllElements();
        j_inventario.updateUI();
        }
    
    public void agregar(){
        int id_prenda = Integer.parseInt(txt_id_prenda.getText());
        String nombre = txt_nombre.getText();
        String colorr = txt_color.getSelectedItem().toString();
        String talla = txt_talla.getSelectedItem().toString();
        int cantidad = Integer.parseInt(txt_cantidad.getText());
        
        if(txt_nombre.getText().equals("") || txt_id_prenda.getText().equals("")){
            JOptionPane.showMessageDialog(null,"llene todos los campos ");
        } else {
            try{
        String sql = "insert into inventario(id_prenda,nombre,color,talla,cantidad)" +
                "values ('"+id_prenda+"','"+nombre+"','"+colorr+"','"+talla+"','"+cantidad+"')";
        conet = co.getConnection();
        st = conet.createStatement();
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"se ha realizado el registro ");
        
        limpiar_campos();
        limpiar_tabla();
        consultar();
        
    }catch(Exception e){
        System.err.println("tenemos un error:  "+ e);
    }
     }
    }
    
    public void actualizar(){
        String nombre = txt_nombre.getText();
        String colorr = txt_color.getSelectedItem().toString();
        String talla = txt_talla.getSelectedItem().toString();
        int cantidad = Integer.parseInt(txt_cantidad.getText());
        
    try{
        String sql = "update inventario set nombre='"+nombre+"',color='"+colorr+"',talla='"+talla+
                "',cantidad='"+cantidad+"'where id_prenda='"+j_inventario.getValueAt(j_inventario.getSelectedRow(),0)+"';";
        conet = co.getConnection();
        st = conet.createStatement();
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"se ha actualizado el registro ");
        limpiar_campos();
        limpiar_tabla();

    }catch(Exception e){
        
        
    }
    consultar();
    }
    
     public void eliminar(){
       int fila = j_inventario.getSelectedRow();
       try{
           if (fila<0){
               JOptionPane.showMessageDialog(null,"seleccione una fila");
           }else{
               String sql = "delete from inventario where id_prenda = '"+j_inventario.getValueAt(j_inventario.getSelectedRow(),0)+"';";
               conet = co.getConnection();
               st = conet.createStatement();
               st.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"se ha eliminado el registro ");
               
               limpiar_campos();
               limpiar_tabla();
               consultar();
           }
       
       }catch(Exception e){
           
           
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
        jScrollPane1 = new javax.swing.JScrollPane();
        j_inventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_prenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_color = new javax.swing.JComboBox<>();
        txt_talla = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        j_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "nombre", "color", "talla", "cantidad"
            }
        ));
        j_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_inventario);

        jButton1.setBackground(new java.awt.Color(244, 154, 154));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\atras.png")); // NOI18N
        jButton1.setText("atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(175, 239, 179));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\agregar.png")); // NOI18N
        jButton2.setText("añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(162, 175, 242));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 70));

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        jLabel1.setText("inventario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setText("id prenda");

        txt_id_prenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_prendaActionPerformed(evt);
            }
        });

        jLabel3.setText("nombre");

        color.setText("color");

        jLabel5.setText("talla");

        txt_color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elija un color", "rojo", "azul", "verde", "blanco" }));

        txt_talla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elija una talla", "S", "M", "L", "XL" }));

        jLabel7.setText("cantidad");

        jButton3.setBackground(new java.awt.Color(244, 154, 154));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\limpiar.png")); // NOI18N
        jButton3.setText("limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(175, 239, 179));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\actualizar.png")); // NOI18N
        jButton4.setText("actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(244, 154, 154));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\dafenova\\src\\main\\recursos\\img\\elimiar.png")); // NOI18N
        jButton5.setText("eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(color)
                                    .addComponent(jLabel7))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_color, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_talla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_id_prenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addComponent(jButton2))
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(79, 79, 79)))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_prenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(color)
                            .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_talla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
menu();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_id_prendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_prendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_prendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        if(txt_nombre.getText().equals("") || txt_id_prenda.getText().equals("") 
                || txt_color.getSelectedItem().equals("elija un color") || 
                txt_talla.getSelectedItem().equals("elija una tall") || txt_cantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"llene todos los campos ");
        } else {
           agregar();  
        }
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
limpiar_campos();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void j_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_inventarioMouseClicked
txt_id_prenda.setEditable(false);
   int fila = j_inventario.getSelectedRow();
   if (fila ==-1){
       JOptionPane.showMessageDialog(null,"seleccione una fila");
   }else{
       idc = Integer.parseInt((String)j_inventario.getValueAt(fila,0).toString());
       String nombre = (String) j_inventario.getValueAt(fila, 1);
       String colorr = (String) j_inventario.getValueAt(fila, 2);
       String talla = (String) j_inventario.getValueAt(fila, 3);
       int cantidad = Integer.parseInt((String) j_inventario.getValueAt(fila, 4).toString());
       txt_id_prenda.setText("" + idc);
       txt_nombre.setText(nombre);
       txt_color.setSelectedItem(colorr);
       txt_talla.setSelectedItem(talla);
       txt_cantidad.setText("" + cantidad);
   }        // TODO add your handling code here:
    }//GEN-LAST:event_j_inventarioMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int fila = j_inventario.getSelectedRow();
           if (fila<0){
               JOptionPane.showMessageDialog(null,"seleccione una fila");
           }else{
             actualizar();
           }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel color;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_inventario;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JComboBox<String> txt_color;
    private javax.swing.JTextField txt_id_prenda;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JComboBox<String> txt_talla;
    // End of variables declaration//GEN-END:variables
}
