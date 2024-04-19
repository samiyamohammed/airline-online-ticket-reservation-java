/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airline;

//7654567890-import com.mysql.cj.xdevapi.Statement;
import com.mysql.cj.xdevapi.*;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sam
 */
public class BookTicket extends javax.swing.JFrame {

    /**
     * Creates new form BookTicket
     */
    public BookTicket() {
        initComponents();
        GetPassenger();
        GetPassengerData();
        PassNameTb.setEditable(false);
        PassNumTb1.setEditable(false);    
        PGenCb.setEditable(false);  
        PCodeCb.setEditable(false);  
       GetFlights();
       DisplayBooking();
        
    }

    @SuppressWarnings("unchecked")
    java.sql.Connection con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    java.sql.Statement St = null,St1 = null;
    int PassId = 0;
    int Key = 0;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PassNameTb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AmountTb = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BookBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        PGenCb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PCodeCb = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookingTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        PassIdCb = new javax.swing.JComboBox<>();
        PassNumTb1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Passenger Name");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 255));
        jLabel5.setText("Gender");

        PassNameTb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 255));
        jLabel7.setText("Passport Number");

        AmountTb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        AmountTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountTbActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 255));
        jLabel8.setText("Amount");

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        jLabel9.setText("Top Flight");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BookBtn.setBackground(new java.awt.Color(204, 204, 204));
        BookBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        BookBtn.setForeground(new java.awt.Color(0, 204, 255));
        BookBtn.setText("Book");
        BookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookBtnMouseClicked(evt);
            }
        });
        BookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookBtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(204, 204, 204));
        ResetBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(0, 204, 255));
        ResetBtn.setText("Reset");
        ResetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetBtnMouseClicked(evt);
            }
        });

        BackBtn.setBackground(new java.awt.Color(204, 204, 204));
        BackBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(0, 204, 255));
        BackBtn.setText("Back");
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 255));
        jLabel11.setText("Book Ticket");

        PGenCb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        PGenCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PGenCbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Flight Code");

        PCodeCb.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        PCodeCb.setForeground(new java.awt.Color(0, 204, 255));
        PCodeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ET193", "ET160", "ET187", "ET190", "ET145", "ET157", "ET134", "ET175" }));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 255));
        jLabel12.setText("Passenger Id");

        BookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        BookingTable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        BookingTable.setShowGrid(true);
        BookingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookingTable);

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 204, 255));
        jLabel13.setText("Bookings");

        PassIdCb.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        PassIdCb.setForeground(new java.awt.Color(0, 204, 255));
        PassIdCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        PassIdCb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassIdCbMouseClicked(evt);
            }
        });
        PassIdCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassIdCbActionPerformed(evt);
            }
        });

        PassNumTb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        PassNumTb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassNumTb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(PassIdCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PassNameTb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BookBtn)
                        .addGap(81, 81, 81)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(PCodeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PGenCb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(PassNumTb1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AmountTb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ResetBtn)
                        .addGap(121, 121, 121)
                        .addComponent(BackBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PGenCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCodeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassIdCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassNumTb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookBtn)
                    .addComponent(ResetBtn)
                    .addComponent(BackBtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void GetPassenger(){
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","root");
        St = con.createStatement();
        String Query = "Select * from PassengersTbl";
        Rs = St.executeQuery(Query);
       while(Rs.next()){
            String PId = String.valueOf(Rs.getInt("PId")); 
            PassIdCb.addItem(PId);
       }
        }catch(Exception e){
            
        }
            
    }
    private void GetFlights(){
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","root");
        St = con.createStatement();
        String Query = "Select * from FlightTbl";
        Rs = St.executeQuery(Query);
       while(Rs.next()){
            String FlCode = Rs.getString("FlCode"); 
            PCodeCb.addItem(FlCode);
       }
        }catch(Exception e){
            
        }
            
    }
    private void GetPassengerData(){
       // String Query = "select * from PassengersTbl where PId ="+PassIdCb.getSelectedItem().toString();
        Statement St;
        ResultSet Rs;
        try{
            /*Class.forName("com.mysql.jdbc.Driver").newInstance();
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","root");
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
           */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","root");
           St =con.createStatement();
           String Query = "select * from PassengersTbl where PId ="+PassIdCb.getSelectedItem().toString();
            Rs = St.executeQuery(Query);
           if(Rs.next()){
                PassNameTb.setText(Rs.getString("PName"));
                PGenCb.setText(Rs.getString("PGen"));
                PassNumTb1.setText(Rs.getString("PPass"));
                //AmountTb.setText(Rs.getString("Amount"));
                  
            }
        }catch(Exception e){
            
        }
    }
    private void AmountTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountTbActionPerformed

    private void PGenCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PGenCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PGenCbActionPerformed

    private void BookingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingTableMouseClicked
       
    }//GEN-LAST:event_BookingTableMouseClicked
     private void DisplayBooking(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","root");
            St = con.createStatement();
            Rs = St.executeQuery("select * from BookingTbl");
            //FlightsTable.setModel(dataModel);
           BookingTable.setModel(DbUtils.resultSetToTableModel(Rs));
        }catch(Exception e){
        } 
    }
     int TId = 0;
      private void CountFlights()
    {
        try{
            St1 = con.createStatement();
            Rs = St1.executeQuery("select max (TicketId) from BookingTbl");
            Rs.next();
            TId = Rs.getInt(1)+1;
        }catch(Exception e){
            
        }
    }
      private void Clear(){
          PCodeCb.setSelectedIndex(-1);
         PassIdCb.setSelectedIndex(-1);
         PassNameTb.setText("");
         PassNumTb1.setText("");
         PGenCb.setText("");
         AmountTb.setText("");
      }
    private void BookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookBtnMouseClicked
       if(PassIdCb.getSelectedIndex()==-1 || PCodeCb.getSelectedIndex()==-1 || AmountTb.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"missing information");
        }else{
            try{
                CountFlights();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedb","root","root");
                PreparedStatement Add = con.prepareStatement("insert into BookingTbl values (?,?,?,?,?,?)");
                Add.setInt(1,TId );
                Add.setString(2,PassNameTb.getText());
                Add.setString(3,PCodeCb.getSelectedItem().toString());
                Add.setString(4,PGenCb.getText());
                Add.setString(5,PassNumTb1.getText());
                Add.setInt(6,Integer.valueOf(AmountTb.getText()));
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this,"Ticket Booked");
                DisplayBooking();
                Clear();
                con.close();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e);

            }
        }
    }//GEN-LAST:event_BookBtnMouseClicked

    private void PassIdCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassIdCbActionPerformed
       GetPassengerData();
    }//GEN-LAST:event_PassIdCbActionPerformed

    private void PassIdCbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassIdCbMouseClicked
       
    }//GEN-LAST:event_PassIdCbMouseClicked

    private void PassNumTb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassNumTb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassNumTb1ActionPerformed

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
       new MainForm().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void ResetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetBtnMouseClicked
       Clear();
    }//GEN-LAST:event_ResetBtnMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
         System.exit(0);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void BookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookBtnActionPerformed

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
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTb;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton BookBtn;
    private javax.swing.JTable BookingTable;
    private javax.swing.JComboBox<String> PCodeCb;
    private javax.swing.JTextField PGenCb;
    private javax.swing.JComboBox<String> PassIdCb;
    private javax.swing.JTextField PassNameTb;
    private javax.swing.JTextField PassNumTb1;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
