/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Application.java
 *
 * Created on Mar 30, 2012, 12:14:46 PM
 */
package com.assign2.view;

import com.assign2.Utils;
import com.assign2.data.CustomerAccess;
import com.assign2.business.Customer;
import java.awt.Dialog.ModalExclusionType;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jason Recillo
 */
public class Application extends JApplet {
    /**
     * This applet can be run as an application!
     * If run in a browser, the main method will be ignored,
     * whereas if run as an executable, the main method will execute.
     * @param args 
     */
    public static void main(String[] args) {
        JApplet applet = new Application();
        applet.init();
        applet.start();

        JFrame window = new JFrame();
        window.setContentPane(applet);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Applet Methods">
    /** Initializes the applet Application */
    @Override
    public void init() {
        //<editor-fold defaultstate="collapsed" desc="Set Windows look and feel">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Create and display the applet">
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    clearStatusBarText();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //</editor-fold>
    }
    //</editor-fold>

    public void setStatusBarText(String text) {
        lblStatusBarText.setText(String.format("  %s", text));
    }

    public void clearStatusBarText() {
        setStatusBarText("");
    }

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings ("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        barStatusBar = new javax.swing.JPanel();
        lblStatusBarText = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        frmWelcome = new javax.swing.JPanel();
        frmCustomer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerList = new javax.swing.JTable();
        btnLoadCustomers = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        frmItem = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        frmOrders = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mnuMainMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        itmNewCustomer = new javax.swing.JMenuItem();
        itmExit = new javax.swing.JMenuItem();
        mnuView = new javax.swing.JMenu();
        mnuFont = new javax.swing.JMenu();
        itmDefault = new javax.swing.JMenuItem();
        itmSegoeUI = new javax.swing.JMenuItem();
        itmLucida = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(240, 240, 240));
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        barStatusBar.setPreferredSize(new java.awt.Dimension(595, 22));

        lblStatusBarText.setFont(getFont());
        lblStatusBarText.setText("  jLabel1");
        lblStatusBarText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout barStatusBarLayout = new javax.swing.GroupLayout(barStatusBar);
        barStatusBar.setLayout(barStatusBarLayout);
        barStatusBarLayout.setHorizontalGroup(
            barStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatusBarText, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        barStatusBarLayout.setVerticalGroup(
            barStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatusBarText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmWelcomeLayout = new javax.swing.GroupLayout(frmWelcome);
        frmWelcome.setLayout(frmWelcomeLayout);
        frmWelcomeLayout.setHorizontalGroup(
            frmWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        frmWelcomeLayout.setVerticalGroup(
            frmWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Welcome", frmWelcome);

        jLabel1.setText("reminder: a listing of customers will go here");

        tblCustomerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C ID", "First Name", "Last Name", "Address", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCustomerList);
        tblCustomerList.getColumnModel().getColumn(0).setResizable(false);
        tblCustomerList.getColumnModel().getColumn(0).setPreferredWidth(32);
        tblCustomerList.getColumnModel().getColumn(1).setResizable(false);
        tblCustomerList.getColumnModel().getColumn(1).setPreferredWidth(72);
        tblCustomerList.getColumnModel().getColumn(2).setResizable(false);
        tblCustomerList.getColumnModel().getColumn(2).setPreferredWidth(88);
        tblCustomerList.getColumnModel().getColumn(3).setResizable(false);
        tblCustomerList.getColumnModel().getColumn(3).setPreferredWidth(261);
        tblCustomerList.getColumnModel().getColumn(4).setResizable(false);
        tblCustomerList.getColumnModel().getColumn(4).setPreferredWidth(87);

        btnLoadCustomers.setText("Load Customers");
        btnLoadCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCustomersActionPerformed(evt);
            }
        });

        jButton1.setText("test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmCustomerLayout = new javax.swing.GroupLayout(frmCustomer);
        frmCustomer.setLayout(frmCustomerLayout);
        frmCustomerLayout.setHorizontalGroup(
            frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addGroup(frmCustomerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(55, 55, 55)
                        .addComponent(btnLoadCustomers)))
                .addContainerGap())
        );
        frmCustomerLayout.setVerticalGroup(
            frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLoadCustomers)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer", frmCustomer);

        jLabel3.setText("reminder: a listing of products will go here. similar to the customer tab.");

        javax.swing.GroupLayout frmItemLayout = new javax.swing.GroupLayout(frmItem);
        frmItem.setLayout(frmItemLayout);
        frmItemLayout.setHorizontalGroup(
            frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        frmItemLayout.setVerticalGroup(
            frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Products", frmItem);

        jLabel4.setText("reminder: same thing here");

        javax.swing.GroupLayout frmOrdersLayout = new javax.swing.GroupLayout(frmOrders);
        frmOrders.setLayout(frmOrdersLayout);
        frmOrdersLayout.setHorizontalGroup(
            frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(427, Short.MAX_VALUE))
        );
        frmOrdersLayout.setVerticalGroup(
            frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orders", frmOrders);

        mnuFile.setMnemonic('f');
        mnuFile.setText("File");

        itmNewCustomer.setMnemonic('u');
        itmNewCustomer.setText("New Customer");
        itmNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNewCustomerActionPerformed(evt);
            }
        });
        mnuFile.add(itmNewCustomer);

        itmExit.setMnemonic('x');
        itmExit.setText("Exit");
        itmExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itmExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itmExitMouseExited(evt);
            }
        });
        itmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExitActionPerformed(evt);
            }
        });
        mnuFile.add(itmExit);

        mnuMainMenu.add(mnuFile);

        mnuView.setMnemonic('v');
        mnuView.setText("View");

        mnuFont.setText("Change Font");
        mnuFont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mnuFontMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mnuFontMouseExited(evt);
            }
        });

        itmDefault.setText("Default");
        mnuFont.add(itmDefault);

        itmSegoeUI.setText("Segoe UI");
        mnuFont.add(itmSegoeUI);

        itmLucida.setText("Lucida Grande");
        mnuFont.add(itmLucida);

        mnuView.add(mnuFont);

        mnuMainMenu.add(mnuView);

        setJMenuBar(mnuMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Event Handlers">

    private void mnuFontMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuFontMouseEntered
        setStatusBarText("Changes the current font.");
    }//GEN-LAST:event_mnuFontMouseEntered

    private void mnuFontMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuFontMouseExited
        clearStatusBarText();
    }//GEN-LAST:event_mnuFontMouseExited

    private void itmExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmExitMouseEntered
        setStatusBarText("Exits the appliation.");
    }//GEN-LAST:event_itmExitMouseEntered

    private void itmExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmExitMouseExited
        clearStatusBarText();
    }//GEN-LAST:event_itmExitMouseExited

    private void itmNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNewCustomerActionPerformed
        JInternalFrame frame = new JInternalFrame();
        frame.setContentPane(new NewCustomerForm());
        frame.setLocation(5, 5);
        frame.setSize(frame.getContentPane().getSize());
        frame.setVisible(true);
    }//GEN-LAST:event_itmNewCustomerActionPerformed

    private void itmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itmExitActionPerformed

    private void btnLoadCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCustomersActionPerformed
        try {
            Customer[] list = CustomerAccess.getCustomers();
            
            DefaultTableModel model = (DefaultTableModel) tblCustomerList.getModel();
            for(Customer c : list){
                ArrayList<Object> cust = new ArrayList<Object>();
                cust.add(c.getCustomerId());
                cust.add(c.getFirstName());
                cust.add(c.getLastName());
                cust.add(c.getAddress());
                cust.add(Utils.formatPhoneNumber(c));
                //add customers to table here
                model.addRow(cust.toArray());
            }
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
        }
    }//GEN-LAST:event_btnLoadCustomersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("Customer");
        frame.setContentPane(new NewCustomerForm());
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barStatusBar;
    private javax.swing.JButton btnLoadCustomers;
    private javax.swing.JPanel frmCustomer;
    private javax.swing.JPanel frmItem;
    private javax.swing.JPanel frmOrders;
    private javax.swing.JPanel frmWelcome;
    private javax.swing.JMenuItem itmDefault;
    private javax.swing.JMenuItem itmExit;
    private javax.swing.JMenuItem itmLucida;
    private javax.swing.JMenuItem itmNewCustomer;
    private javax.swing.JMenuItem itmSegoeUI;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblStatusBarText;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuFont;
    private javax.swing.JMenuBar mnuMainMenu;
    private javax.swing.JMenu mnuView;
    private javax.swing.JTable tblCustomerList;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
