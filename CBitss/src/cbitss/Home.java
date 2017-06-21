package cbitss;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Shalvi Saxena
 */
public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        batchCre = new javax.swing.JMenuItem();
        courseCre = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        batchRem = new javax.swing.JMenuItem();
        courseRem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        courseEdi = new javax.swing.JMenuItem();
        batchEdi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jMenu1.setText("Create");

        batchCre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        batchCre.setText("Batch");
        batchCre.setOpaque(true);
        batchCre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchCreActionPerformed(evt);
            }
        });
        jMenu1.add(batchCre);

        courseCre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        courseCre.setText("Course");
        courseCre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCreActionPerformed(evt);
            }
        });
        jMenu1.add(courseCre);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Remove");

        batchRem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        batchRem.setText("Batch");
        batchRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchRemActionPerformed(evt);
            }
        });
        jMenu2.add(batchRem);

        courseRem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        courseRem.setText("Course");
        courseRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRemActionPerformed(evt);
            }
        });
        jMenu2.add(courseRem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");

        courseEdi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        courseEdi.setText("Course");
        courseEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseEdiActionPerformed(evt);
            }
        });
        jMenu3.add(courseEdi);

        batchEdi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        batchEdi.setText("Batch");
        jMenu3.add(batchEdi);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

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

    private void batchCreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchCreActionPerformed
        String s=null;
        ArrayList<String> l=new ArrayList<>();     
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("show tables");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {    l.add(rs.getString("Tables_in_cbitss"));   }
                   
           /* for(String kl:l)
            {   System.out.println(kl);    }
             */      
            Object[] options = l.toArray();
                    
            s = (String) JOptionPane.showInputDialog(new JFrame(),"Select The Course\n","Create Batch",
                JOptionPane.PLAIN_MESSAGE,null,options,"");
        }
        catch (ClassNotFoundException ex) 
        {   Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);     }
        catch (SQLException ex)
        {   Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);     }
        if(s.length() > 0)
        {   JTextField timeStart = new JTextField();
            JTextField timeStop = new JTextField();
            JTextField noOfStudents = new JTextField();
            Object[] message = {
                "Time Start    :", timeStart,
                "Time Stop     :", timeStop,
                "No Of Students:", noOfStudents
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Create Batch",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
            try {
                Integer a= Integer.parseInt(timeStart.getText());
                Integer b= Integer.parseInt(timeStop.getText());
                Integer c= Integer.parseInt(noOfStudents.getText());
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
                PreparedStatement pst = (PreparedStatement) con.prepareStatement("Insert into corejava values(?,?,?)");
                pst.setInt(1,a);
                pst.setInt(2,b);
                pst.setInt(3,c);
                pst.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
            else {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted\nTRY AGAIN!!");
            System.out.println("Operation Aborted");
            }
        }
    }//GEN-LAST:event_batchCreActionPerformed

    private void courseCreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCreActionPerformed
        String s=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
            JTextField courseName = new JTextField();
            Object[] message = {
                "Enter Course Name    :", courseName,
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Create Course",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                s= courseName.getText();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement("create table "+s+"( TimeFrom int,"
                        + " TimeTo int, NoOfStudents int, PRIMARY KEY (TimeFrom));");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(new JFrame(), "Course Created");
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted!");
            }
        }
            catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_courseCreActionPerformed

    private void batchRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchRemActionPerformed
        ArrayList<String> l=new ArrayList<>();     
        String s = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("show tables");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {    l.add(rs.getString("Tables_in_cbitss"));   }
                   
            Object[] options = l.toArray();
                    
            s =  (String) JOptionPane.showInputDialog(new JFrame(),"Select The Course\n","Remove Batch",
                JOptionPane.PLAIN_MESSAGE,null,options,"");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted\nTRY AGAIN!!");
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);     }
        if(s.length()>0)
            {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
                PreparedStatement pst = (PreparedStatement) con.prepareStatement("select TimeFrom,TimeTo from "+s);
                ResultSet rs=pst.executeQuery();
                l.clear();
            while(rs.next())
            {    l.add(rs.getString("TimeFrom")+" - "+rs.getString("TimeTo"));   }
                   
            Object[] options = l.toArray();
                    
            s =  (String) JOptionPane.showInputDialog(new JFrame(),"Select The Batch Timings\n","Remove Batch",
                JOptionPane.PLAIN_MESSAGE,null,options,"");
            if(s.length()>0)
            {
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("delete from corejava where TimeFrom="+s.substring(0,4));
                pst1.executeUpdate();
                JOptionPane.showMessageDialog(new JFrame(), "Batch Removed");
            }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted\nTRY AGAIN!!");
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }//GEN-LAST:event_batchRemActionPerformed

    private void courseRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRemActionPerformed
        ArrayList<String> l=new ArrayList<>();     
        String s = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("show tables");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {    l.add(rs.getString("Tables_in_cbitss"));   }
                   
            Object[] options = l.toArray();
                    
            s =  (String) JOptionPane.showInputDialog(new JFrame(),"Select The Course\n","Remove Course",
                JOptionPane.PLAIN_MESSAGE,null,options,"");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted!");
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);     }
        if(s.length()>0)
            {
                int option = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to remove "+s+"?",
                        "Remove Course", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cbitss","root","");
                PreparedStatement pst = (PreparedStatement) con.prepareStatement("drop table "+s+";");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(new JFrame(), "Course Removed");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted!");
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Operation aborted!");
            }
            }
    }//GEN-LAST:event_courseRemActionPerformed

    private void courseEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseEdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseEdiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem batchCre;
    private javax.swing.JMenuItem batchEdi;
    private javax.swing.JMenuItem batchRem;
    private javax.swing.JMenuItem courseCre;
    private javax.swing.JMenuItem courseEdi;
    private javax.swing.JMenuItem courseRem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
