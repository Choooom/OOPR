package toadinone;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransTOADInOne extends JFrame {

    private JPanel jPanel;
    private JPanel jPanel_eLibrary;
    private JLabel jLabel_eLibrary;
    private JPanel jPanel_Logout;
    private JButton Logout;
    private JPanel jPanel_Nav;
    private JLabel jLabel_Nav;
    private JPanel jPanel_DSTCMP;
    private JButton Dashboard;
    private JButton SManagement;
    private JButton Transaction;
    private JButton Calendar;
    private JButton Shelves;
    private JButton PDetails;
    private JLabel jLabel_Calendar;
    private JLabel jLabel_SM;
    private JLabel jLabel_Transaction;
    private JLabel jLabel_Cal;
    private JLabel jLabel_Shelves;
    private JLabel jLabel_PD;
    private JPanel jPanel_Main;
    private JLabel jLabel_TEXTDASHBOARD;
    private JLabel jLabel1;
    private JPanel Books_listed;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel jLabel2;
    private JPanel Times_returned;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel Registered_user;
    private JLabel jLabel9;
    private JLabel jLabel11;
    private JLabel jLabel12;

    public TransTOADInOne() {
        initComponents();
    }

    private void initComponents() {
        jPanel = new JPanel();
        jPanel_eLibrary = new JPanel();
        jLabel_eLibrary = new JLabel();
        jPanel_Logout = new JPanel();
        Logout = new JButton();
        jPanel_Nav = new JPanel();
        jLabel_Nav = new JLabel();
        jPanel_DSTCMP = new JPanel();
        Dashboard = new JButton();
        SManagement = new JButton();
        Transaction = new JButton();
        Calendar = new JButton();
        Shelves = new JButton();
        PDetails = new JButton();
        jLabel_Calendar = new JLabel();
        jLabel_SM = new JLabel();
        jLabel_Transaction = new JLabel();
        jLabel_Cal = new JLabel();
        jLabel_Shelves = new JLabel();
        jLabel_PD = new JLabel();
        jPanel_Main = new JPanel();
        jLabel_TEXTDASHBOARD = new JLabel();
        jLabel1 = new JLabel();
        Books_listed = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel2 = new JLabel();
        Times_returned = new JPanel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        Registered_user = new JPanel();
        jLabel9 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(102, 102, 102));

        jPanel.setBackground(new Color(204, 204, 204));
        jPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel.setLayout(null);

        jPanel_eLibrary.setBackground(new Color(107, 147, 35));
        jPanel_eLibrary.setLayout(null);

        jLabel_eLibrary.setFont(new Font("SansSerif", Font.BOLD, 19));
        jLabel_eLibrary.setForeground(new Color(255, 255, 255));
        jLabel_eLibrary.setText("eLibrary Soft");
        jPanel_eLibrary.add(jLabel_eLibrary);
        jLabel_eLibrary.setBounds(50, 10, 120, 25);

        jPanel.add(jPanel_eLibrary);
        jPanel_eLibrary.setBounds(0, 0, 230, 50);

        jPanel_Logout.setBackground(new Color(107, 173, 35));
        jPanel_Logout.setLayout(null);

        Logout.setBackground(new Color(107, 173, 35));
        Logout.setFont(new Font("Arial", Font.BOLD, 14));
        Logout.setForeground(new Color(255, 255, 255));
        Logout.setText("LOG OUT");
        Logout.setBorder(null);
        Logout.setFocusable(false);
        jPanel_Logout.add(Logout);
        Logout.setBounds(680, 20, 79, 17);

        jPanel.add(jPanel_Logout);
        jPanel_Logout.setBounds(230, 0, 770, 50);

        jPanel_Nav.setBackground(new Color(28, 35, 42));
        jPanel_Nav.setLayout(null);

        jLabel_Nav.setFont(new Font("SansSerif", 0, 17));
        jLabel_Nav.setForeground(new Color(153, 153, 153));
        jLabel_Nav.setText("MAIN NAVIGATION");
        jPanel_Nav.add(jLabel_Nav);
        jLabel_Nav.setBounds(15, 6, 143, 23);

        jPanel.add(jPanel_Nav);
        jPanel_Nav.setBounds(0, 50, 230, 40);

        jPanel_DSTCMP.setBackground(new Color(33, 46, 48));
        jPanel_DSTCMP.setLayout(null);

        Dashboard.setBackground(new Color(33, 46, 48));
        Dashboard.setFont(new Font("SansSerif", Font.BOLD, 14));
        Dashboard.setForeground(new Color(255, 255, 255));
        Dashboard.setText("Dashboard");
        Dashboard.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Dashboard.setFocusPainted(false);
        Dashboard.addActionListener(evt -> DashboardActionPerformed(evt));
        jPanel_DSTCMP.add(Dashboard);
        Dashboard.setBounds(45, 14, 88, 25);

        SManagement.setBackground(new Color(33, 46, 48));
        SManagement.setFont(new Font("SansSerif", Font.BOLD, 14));
        SManagement.setForeground(new Color(255, 255, 255));
        SManagement.setText("System Management");
        SManagement.setBorder(null);
        jPanel_DSTCMP.add(SManagement);
        SManagement.setBounds(41, 57, 160, 25);

        Transaction.setBackground(new Color(33, 46, 48));
        Transaction.setFont(new Font("SansSerif", Font.BOLD, 14));
        Transaction.setForeground(new Color(255, 255, 255));
        Transaction.setText("Transaction");
        Transaction.setBorder(null);
        Transaction.addActionListener(evt -> TransactionActionPerformed(evt));
        jPanel_DSTCMP.add(Transaction);
        Transaction.setBounds(41, 96, 102, 29);

        Calendar.setBackground(new Color(33, 46, 48));
        Calendar.setFont(new Font("SansSerif", Font.BOLD, 14));
        Calendar.setForeground(new Color(255, 255, 255));
        Calendar.setText("Calendar");
        Calendar.setBorder(null);
        jPanel_DSTCMP.add(Calendar);
        Calendar.setBounds(45, 137, 75, 25);

        Shelves.setBackground(new Color(33, 46, 48));
        Shelves.setFont(new Font("SansSerif", Font.BOLD, 14));
        Shelves.setForeground(new Color(255, 255, 255));
        Shelves.setText("My Shelves");
        Shelves.setBorder(null);
        jPanel_DSTCMP.add(Shelves);
        Shelves.setBounds(45, 174, 92, 31);

        PDetails.setBackground(new Color(33, 46, 48));
        PDetails.setFont(new Font("SansSerif", Font.BOLD, 14));
        PDetails.setForeground(new Color(255, 255, 255));
        PDetails.setText("Personal Details");
        PDetails.setBorder(null);
        jPanel_DSTCMP.add(PDetails);
        PDetails.setBounds(45, 217, 128, 28);

        jLabel_Calendar.setIcon(new ImageIcon(getClass().getResource("Icon/DASHBOARD.png")));
        jPanel_DSTCMP.add(jLabel_Calendar);
        jLabel_Calendar.setBounds(24, 20, 15, 14);

        jLabel_SM.setIcon(new ImageIcon(getClass().getResource("Icon/SM1.png")));
        jPanel_DSTCMP.add(jLabel_SM);
        jLabel_SM.setBounds(24, 61, 14, 15);

        jLabel_Transaction.setIcon(new ImageIcon(getClass().getResource("Icon/TRANSACTION.png")));
        jPanel_DSTCMP.add(jLabel_Transaction);
        jLabel_Transaction.setBounds(24, 100, 15, 15);

        jLabel_Cal.setIcon(new ImageIcon(getClass().getResource("Icon/CALENDAR_1.png")));
        jPanel_DSTCMP.add(jLabel_Cal);
        jLabel_Cal.setBounds(24, 137, 15, 25);

        jLabel_Shelves.setIcon(new ImageIcon(getClass().getResource("Icon/SHELVE.png")));
        jPanel_DSTCMP.add(jLabel_Shelves);
        jLabel_Shelves.setBounds(24, 184, 15, 15);

        jLabel_PD.setIcon(new ImageIcon(getClass().getResource("Icon/PERSONAL-INFORMATION.png")));
        jPanel_DSTCMP.add(jLabel_PD);
        jLabel_PD.setBounds(24, 222, 15, 18);

       jPanel.add(jPanel_DSTCMP);
        jPanel_DSTCMP.setBounds(0, 90, 230, 510);

        jPanel_Main.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Main.setLayout(null);

        jLabel_TEXTDASHBOARD.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel_TEXTDASHBOARD.setForeground(new java.awt.Color(102, 102, 102));
        jLabel_TEXTDASHBOARD.setText("Transaction");
        jPanel_Main.add(jLabel_TEXTDASHBOARD);
        jLabel_TEXTDASHBOARD.setBounds(10, 10, 125, 40);
        jPanel_Main.add(jLabel1);
        jLabel1.setBounds(26, 438, 0, 0);

        Books_listed.setBackground(new java.awt.Color(51, 188, 245));
        Books_listed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Books_listed.setForeground(new java.awt.Color(0, 153, 255));
        Books_listed.setMinimumSize(new java.awt.Dimension(200, 200));
        Books_listed.setPreferredSize(new java.awt.Dimension(200, 200));
        Books_listed.setLayout(null);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 75)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("0");
        Books_listed.add(jLabel3);
        jLabel3.setBounds(30, 10, 80, 120);

        /*
        
        
        dito pre ilagay ung mga code na idadagdag mo dami pa natin kulang tyyy
        
        
        
        
        
        */

        jPanel.add(jPanel_Main);
        jPanel_Main.setBounds(230, 50, 780, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
    }

    private void TransactionActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TransTOADInOne().setVisible(true));
    }
}
