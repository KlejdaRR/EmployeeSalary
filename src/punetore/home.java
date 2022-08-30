/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punetore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author EMSH
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
            double hoursin = 0;
            double hoursout = 0;
            double rrogaeplote = 0;
            double oreteplota = 0;
            double oreteplotanen = 0;
            double oreteplotambi = 0;
            double a = 0, b=0, c=0, d=0;
             double e = 0, f=0, g=0, j=0;
            
    public home() {
        initComponents();
    }
    public void refresh(){
        jTextField1.setText("");
        jTextField2.setText("");
    }
    
       public void tb_load1(){
        try{ 
            db.mycon();
            PreparedStatement pst;
            pst = db.mycon().prepareStatement("SELECT * FROM users WHERE id = "+"\""+ jTextField1.getText() +"\""+ "");
            ResultSet rs = pst.executeQuery();
           
            
            
            DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
            while(rs.next()){
               
            Vector v = new Vector();
        
            v.add(rs.getString("name"));
            v.add(rs.getString("surname"));
            v.add(jTextField2.getText());
            v.add(b);
            v.add(c);
            v.add(d);
            v.add(a);
        
            dt.addRow(v);
            
         }}
         catch(Exception e){
             System.out.println(e);
         }
    
    }
    public static int sumValues(Vector<Double> vector){
        
        Iterator<Double> it = vector.iterator();
           int sum = 0;
           while(it.hasNext()) {
           sum+=it.next();
    }
           return sum;
    }
  
     
     public static boolean isWeekendd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY)
                || (dayOfWeek == Calendar.SUNDAY);
    }
       public double ditepushimi(double ot, double rrm){
        
        Double rrogamujore = rrm;
        double orettotale = ot;
        Double rrogaperf;
        
        if (orettotale<=8){
                 hoursin = orettotale;
                 rrogaperf = hoursin*(1.5*rrogamujore);
            }
            else{
                
                hoursout = orettotale - 8;
                hoursin = 8;
                rrogaperf = hoursin*(1.5*rrogamujore) + hoursout*(2*rrogamujore);
            }
        return rrogaperf;
    }
public double ditenormale(double ot, double rrm){
        
        Double rrogamujore = rrm;
        double orettotale = ot;
        double rrogaperf;
        
        if (orettotale <= 8){
                 hoursin = orettotale;
                 rrogaperf = hoursin*rrogamujore;
            }
            else{
                
                hoursout = orettotale - 8;
                hoursin = 8;
                rrogaperf = hoursin*rrogamujore + hoursout*(1.25*rrogamujore);
            }
          
        return rrogaperf;
    }
    
    public double ditefundjave(double ot, double rrm){
        Double rrogamujore = rrm;
        double orettotale = ot;
        Double rrogaperf;
        
        if (orettotale <= 8){
                 hoursin = orettotale;
                 rrogaperf = hoursin*(1.25*rrogamujore);
            }
        
        else{ 
                hoursout = orettotale - 8;
                hoursin = 8;
                rrogaperf = hoursin*(1.25*rrogamujore) + hoursout*(1.5*rrogamujore);
            }
            
        return rrogaperf;
    }
    public static boolean isPushim(String dataaa)
    {
        String data = dataaa;
        boolean result = false;
        try{
       Statement pst2 = db.mycon().createStatement();
       ResultSet rs2 = pst2.executeQuery("SELECT date FROM off_days WHERE date = '"+ data + "'");
        
       if(rs2.next()){
           result = true;
       }
       else{
           result = false;
       }
        }
        catch(Exception e){
        
    }
        return result;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(51, 204, 255));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emri", "Mbiemri", "Muaji", "Oret nen 8 ore", "Oret mbi 8 ore", "Oret Totale", "Pagesa totale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Shfaq punetor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID e punetorit:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Muaji i punes:");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Shfaq te gjithe");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(55, 55, 55)
                .addComponent(jButton4)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(102, 204, 255));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Fshi rresht");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ruaj pagen mujore");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 255));
        jMenuBar1.setForeground(new java.awt.Color(0, 153, 255));

        jMenu3.setText("Punetoret");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ditet e punes");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setText("Ditet e pushimit");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu6.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu6MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MenuSelected

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        // TODO add your handling code here:
        ditepune dp = new ditepune();
        dp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu4MenuSelected

    private void jMenu6MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu6MenuSelected
        // TODO add your handling code here:
        ditepushimi dpp = new ditepushimi();
        dpp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu6MenuSelected

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try{
            String datekonv = jTextField2.getText();

            db.mycon();
            PreparedStatement pst;
            pst = db.mycon().prepareStatement("SELECT users.name, users.surname, users.salary, working_days.date, working_days.hours FROM users INNER JOIN working_days ON working_days.user_id = users.id WHERE users.id = "+"\""+ jTextField1.getText() +"\""+"AND working_days.date LIKE '%"+ datekonv + "%'");
            ResultSet rs = pst.executeQuery();

            int [][] v5 = new int [2][6];
            Vector v1 = new Vector();
            Vector v2 = new Vector();
            Vector v3 = new Vector();
            Vector v4 = new Vector();
            
             /*if(rs.next() == false){
                  JOptionPane.showMessageDialog(null, "Të dhënat e vendosura nuk ekzistojnë. Ju lutem provoni përsëri.");
                  refresh();
             }*/

            while(rs.next()){

                String datee = rs.getString("date");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = simpleDateFormat.parse(datee);

                String emer = rs.getString("name");
                String mbiemer = rs.getString("surname");
                Double rrogamujore = rs.getDouble("salary");
                Double orettotale = rs.getDouble("hours");

                if((isPushim(datee) == false) && (isWeekendd(date1)==false)){

                    Double rroga = ditenormale(orettotale, rrogamujore);

                    double hi = Double.valueOf(hoursin);
                    double ho = Double.valueOf(hoursout);
                    double oret = Double.valueOf(orettotale);

                    v1.add(rroga);
                    v2.add(hi);
                    v3.add(ho);
                    v4.add(oret);
                }

                else if((isPushim(datee) == false) && (isWeekendd(date1)==true)){
                    //eshte fundjave llogaritja me 125+150

                    Double rrogafundjave = ditefundjave(orettotale, rrogamujore);

                    double hi = Double.valueOf(hoursin);
                    double ho = Double.valueOf(hoursout);
                    double oret = Double.valueOf(orettotale);
                    v1.add(rrogafundjave);
                    v2.add(hi);
                    v3.add(ho);
                    v4.add(oret);
                }

                else if(((isPushim(datee) == true) && (isWeekendd(date1)==true)) || ((isPushim(datee) == true) && (isWeekendd(date1)==false))){
                    //eshte dite pushimi dhe llogaritet me 150 + 200

                    Double rrogapushimi = ditepushimi(orettotale, rrogamujore);

                    double hi = Double.valueOf(hoursin);
                    double ho = Double.valueOf(hoursout);
                    double oret = Double.valueOf(orettotale);
                    v1.add(rrogapushimi);
                    v2.add(hi);
                    v3.add(ho);
                    v4.add(oret);
                }
               
            }
         
                a = sumValues(v1);
                 b = sumValues(v2);
                 c = sumValues(v3);
                 d = sumValues(v4);
    
        }
        catch(Exception e){
            System.out.println(e);
            
        }

            tb_load1();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         try{
             DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
             int rc = dt.getRowCount();
             
             for(int i = 0; i < rc; i++){ 
                 
                 String muaji = dt.getValueAt(i, 2).toString();
                 String hoursinn = dt.getValueAt(i, 3).toString();
                 String hoursoutt = dt.getValueAt(i, 4).toString();
                 String orettotalee = dt.getValueAt(i, 5).toString();
                 String pagamujore = dt.getValueAt(i, 6).toString();
             
                 
                 
             Statement s = db.mycon().createStatement();
             s.executeUpdate("INSERT INTO punetore (muaji, hoursin, hoursout, totalhours, totalsalary, u_id) VALUES('"+muaji+"','"+hoursinn+"','"+hoursoutt+"','"+orettotalee+"','"+pagamujore+"','"+jTextField1.getText()+"')");
}
               JOptionPane.showMessageDialog(null, "Të dhënat u regjistruan.");
        }
        catch(Exception e){
            System.out.println(e);
        }
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          try{ 
            DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
            int rw = jTable1.getSelectedRow();
            
            dt.removeRow(rw);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         try{
                DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
                dt.setRowCount(0);
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM punetore JOIN users WHERE punetore.muaji LIKE '%"+jTextField2.getText()+"%'");
                
                 while(rs.next()){
                     
                Vector v = new Vector();
                v.add(rs.getString("users.name"));
                v.add(rs.getString("users.surname"));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
           
                dt.addRow(v);
            }
            }
            catch(Exception e){
                System.out.println(e);
            }
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
