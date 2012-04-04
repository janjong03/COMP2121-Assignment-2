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
import com.assign2.business.Item;
import com.assign2.data.ItemAccess;
import com.sun.jmx.snmp.tasks.Task;
import java.beans.PropertyChangeEvent;
import java.lang.Void;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingWorker;
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
    
    public void setProgressBarEnabled(boolean enabled) {
        if (enabled) {
            prgProgressBar.setEnabled(true);
            prgProgressBar.setIndeterminate(true);
        } else {
            prgProgressBar.setEnabled(false);
            prgProgressBar.setIndeterminate(false);
        }
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
        prgProgressBar = new javax.swing.JProgressBar();
        tabTabbedPane = new javax.swing.JTabbedPane();
        frmWelcome = new javax.swing.JPanel();
        frmCustomer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerList = new javax.swing.JTable();
        btnLoadCustomers = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnAddNewCustomer = new javax.swing.JButton();
        lblCustomerSearchLabel = new javax.swing.JLabel();
        txtCustomerSearch = new javax.swing.JTextField();
        frmItem = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemList = new javax.swing.JTable();
        btnLoadItems = new javax.swing.JButton();
        btnEditItem = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        frmOrders = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
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

        barStatusBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        barStatusBar.setMaximumSize(new java.awt.Dimension(32767, 22));
        barStatusBar.setPreferredSize(new java.awt.Dimension(595, 22));

        lblStatusBarText.setFont(getFont());
        lblStatusBarText.setText("  jLabel1");
        lblStatusBarText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout barStatusBarLayout = new javax.swing.GroupLayout(barStatusBar);
        barStatusBar.setLayout(barStatusBarLayout);
        barStatusBarLayout.setHorizontalGroup(
            barStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barStatusBarLayout.createSequentialGroup()
                .addComponent(lblStatusBarText, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(prgProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barStatusBarLayout.setVerticalGroup(
            barStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barStatusBarLayout.createSequentialGroup()
                .addGroup(barStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prgProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(lblStatusBarText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(barStatusBar, java.awt.BorderLayout.SOUTH);

        tabTabbedPane.setPreferredSize(new java.awt.Dimension(667, 410));

        javax.swing.GroupLayout frmWelcomeLayout = new javax.swing.GroupLayout(frmWelcome);
        frmWelcome.setLayout(frmWelcomeLayout);
        frmWelcomeLayout.setHorizontalGroup(
            frmWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );
        frmWelcomeLayout.setVerticalGroup(
            frmWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        tabTabbedPane.addTab("Welcome", frmWelcome);

        tblCustomerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "Phone Number"
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

        btnEditCustomer.setText("Edit Customer");
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnAddNewCustomer.setText("Add New Customer");

        lblCustomerSearchLabel.setText("Search:");

        txtCustomerSearch.setText("Search...");

        javax.swing.GroupLayout frmCustomerLayout = new javax.swing.GroupLayout(frmCustomer);
        frmCustomer.setLayout(frmCustomerLayout);
        frmCustomerLayout.setHorizontalGroup(
            frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmCustomerLayout.createSequentialGroup()
                        .addComponent(btnLoadCustomers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddNewCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditCustomer)
                        .addGap(29, 29, 29)
                        .addComponent(lblCustomerSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                .addContainerGap())
        );
        frmCustomerLayout.setVerticalGroup(
            frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadCustomers)
                    .addComponent(btnAddNewCustomer)
                    .addComponent(btnEditCustomer)
                    .addComponent(lblCustomerSearchLabel)
                    .addComponent(txtCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabTabbedPane.addTab("Customer", frmCustomer);

        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Price", "Description", "Image", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItemList);
        tblItemList.getColumnModel().getColumn(0).setResizable(false);
        tblItemList.getColumnModel().getColumn(0).setPreferredWidth(26);
        tblItemList.getColumnModel().getColumn(1).setResizable(false);
        tblItemList.getColumnModel().getColumn(1).setPreferredWidth(124);
        tblItemList.getColumnModel().getColumn(2).setResizable(false);
        tblItemList.getColumnModel().getColumn(2).setPreferredWidth(87);
        tblItemList.getColumnModel().getColumn(3).setResizable(false);
        tblItemList.getColumnModel().getColumn(3).setPreferredWidth(49);
        tblItemList.getColumnModel().getColumn(4).setResizable(false);
        tblItemList.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblItemList.getColumnModel().getColumn(5).setResizable(false);
        tblItemList.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblItemList.getColumnModel().getColumn(6).setResizable(false);
        tblItemList.getColumnModel().getColumn(6).setPreferredWidth(54);

        btnLoadItems.setText("Load Items");
        btnLoadItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadItemsActionPerformed(evt);
            }
        });

        btnEditItem.setText("Edit Item");
        btnEditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditItemActionPerformed(evt);
            }
        });

        jButton6.setText("Add New Item");

        javax.swing.GroupLayout frmItemLayout = new javax.swing.GroupLayout(frmItem);
        frmItem.setLayout(frmItemLayout);
        frmItemLayout.setHorizontalGroup(
            frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmItemLayout.createSequentialGroup()
                        .addComponent(btnLoadItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditItem)))
                .addContainerGap())
        );
        frmItemLayout.setVerticalGroup(
            frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadItems)
                    .addComponent(jButton6)
                    .addComponent(btnEditItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabTabbedPane.addTab("Products", frmItem);

        jButton3.setText("Load Orders");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Order Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jButton4.setText("Edit Order Details");

        jButton7.setText("Add New Order");

        javax.swing.GroupLayout frmOrdersLayout = new javax.swing.GroupLayout(frmOrders);
        frmOrders.setLayout(frmOrdersLayout);
        frmOrdersLayout.setHorizontalGroup(
            frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frmOrdersLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        frmOrdersLayout.setVerticalGroup(
            frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton7)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabTabbedPane.addTab("Orders", frmOrders);

        getContentPane().add(tabTabbedPane, java.awt.BorderLayout.CENTER);

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
        setStatusBarText("Exits the application.");
    }//GEN-LAST:event_itmExitMouseEntered
    
    private void itmExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itmExitMouseExited
        clearStatusBarText();
    }//GEN-LAST:event_itmExitMouseExited
    
    private void itmNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNewCustomerActionPerformed
        JInternalFrame frame = new JInternalFrame();
        frame.setContentPane(new CustomerForm());
        frame.setLocation(5, 5);
        frame.setSize(frame.getContentPane().getSize());
        frame.setVisible(true);
    }//GEN-LAST:event_itmNewCustomerActionPerformed
    
    private void itmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itmExitActionPerformed
    
    private void btnLoadCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCustomersActionPerformed
        DefaultTableModel table = (DefaultTableModel) tblCustomerList.getModel();
        table.setRowCount(0);
        Thread loadCustomerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    setStatusBarText("Retrieving customers from database...");
                    setProgressBarEnabled(false);
                    Utils.log_info("Retrieving customers from database...");
                    Customer[] list = CustomerAccess.getCustomers();
                    
                    DefaultTableModel model = (DefaultTableModel) tblCustomerList.getModel();
                    for (Customer c : list) {
                        ArrayList<Object> cust = new ArrayList<Object>();
                        cust.add(c.getCustomerId());
                        cust.add(c.getFirstName());
                        cust.add(c.getLastName());
                        cust.add(c.getAddress());
                        cust.add(Utils.formatPhoneNumber(c));
                        //add customers to table here
                        model.addRow(cust.toArray());
                    }
                    setStatusBarText("Done.");
                    setProgressBarEnabled(false);
                    Utils.log_info("Done loading customers.");
                } catch (SQLException ex) {
                    Utils.log_error(ex.getMessage());
                }
            }
        });
        loadCustomerThread.start();
    }//GEN-LAST:event_btnLoadCustomersActionPerformed
    
    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        JFrame frame = new JFrame("Customer");
        frame.setContentPane(new CustomerForm());
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btnEditCustomerActionPerformed
    
    private void btnLoadItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadItemsActionPerformed
        DefaultTableModel table = (DefaultTableModel) tblItemList.getModel();
        table.setRowCount(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    setStatusBarText("Retrieving items from database...");
                    setProgressBarEnabled(true);
                    Utils.log_info("Retrieving items from database...");
                    Item[] list = ItemAccess.getItems();
                    DefaultTableModel model = (DefaultTableModel) tblItemList.getModel();
                    for (Item i : list) {
                        ArrayList<Object> items = new ArrayList<Object>();
                        items.add(i.getItemId());
                        items.add(i.getName());
                        items.add(i.getCategory().getCategoryName());
                        items.add(i.getPrice());
                        items.add(i.getDescription() == null ? "no description" : i.getDescription());
                        items.add(i.getImage() == null ? "no image" : "<binary data>");
                        items.add(i.getQtyInStock());
                        //add items to table here
                        model.addRow(items.toArray());
                    }
                    setStatusBarText("Done.");
                    setProgressBarEnabled(false);
                    Utils.log_info("Done loading items.");
                } catch (SQLException ex) {
                    Utils.log_error(ex.getMessage());
                }
            }
        }, "RetrieveItems");
        thread.start();
    }//GEN-LAST:event_btnLoadItemsActionPerformed
    
    private void btnEditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditItemActionPerformed
        JFrame frame = new JFrame("Customer");
        try {
            frame.setContentPane(new ItemForm(ItemAccess.findItem(ItemAccess.ITEM_ID, "1")));
        } catch (SQLException ex) {
            Utils.log_error(ex.getMessage());
        }
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btnEditItemActionPerformed
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barStatusBar;
    private javax.swing.JButton btnAddNewCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnEditItem;
    private javax.swing.JButton btnLoadCustomers;
    private javax.swing.JButton btnLoadItems;
    private javax.swing.JPanel frmCustomer;
    private javax.swing.JPanel frmItem;
    private javax.swing.JPanel frmOrders;
    private javax.swing.JPanel frmWelcome;
    private javax.swing.JMenuItem itmDefault;
    private javax.swing.JMenuItem itmExit;
    private javax.swing.JMenuItem itmLucida;
    private javax.swing.JMenuItem itmNewCustomer;
    private javax.swing.JMenuItem itmSegoeUI;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCustomerSearchLabel;
    private javax.swing.JLabel lblStatusBarText;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuFont;
    private javax.swing.JMenuBar mnuMainMenu;
    private javax.swing.JMenu mnuView;
    private javax.swing.JProgressBar prgProgressBar;
    private javax.swing.JTabbedPane tabTabbedPane;
    private javax.swing.JTable tblCustomerList;
    private javax.swing.JTable tblItemList;
    private javax.swing.JTextField txtCustomerSearch;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
