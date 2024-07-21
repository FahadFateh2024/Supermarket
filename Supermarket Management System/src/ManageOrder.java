/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author FAHAD FATEH
 */
import javax.swing.table.TableModel;
import dao.ConnectionProvider;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import dao.InverntoryUtils;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import common.openPdf;
import java.io.FileOutputStream;


public class ManageOrder extends javax.swing.JFrame {

    private int customer_pk = 0;
    private int product_pk = 0;
    private int finalTotalPrice = 0;
    private String orderId = "";

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        product_pk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCard = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1200, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Orders");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText(" Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        tableCustomer.setBackground(new java.awt.Color(153, 153, 153));
        tableCustomer.setForeground(new java.awt.Color(255, 255, 255));
        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 133, 406, 283));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        tableProduct.setBackground(new java.awt.Color(153, 153, 153));
        tableProduct.setForeground(new java.awt.Color(255, 255, 255));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 133, 417, 283));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 90, -1, -1));

        tableCard.setBackground(new java.awt.Color(153, 153, 153));
        tableCard.setForeground(new java.awt.Color(255, 255, 255));
        tableCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tableCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCardMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCard);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 133, -1, 283));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Selected Customer");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 444, 159, -1));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 474, 37, -1));

        txtCustomerName.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 494, 406, -1));

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Mobile Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 101, -1));

        txtCustomerMobileNumber.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 582, 406, -1));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 37, -1));

        txtCustomerEmail.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 406, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Selected Product");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 444, 147, -1));

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Product Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 474, 89, -1));

        txtProductName.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 494, 423, -1));

        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Product Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 528, 97, -1));

        txtProductPrice.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 548, 423, -1));

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Product Description");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 588, 480, -1));

        txtProductDescription.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 608, 423, -1));

        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Product Quantity");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 654, 105, -1));

        txtOrderQuantity.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 674, 423, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 255, 0));
        jButton1.setText("ADD TO CARD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 741, 423, 38));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Total Amount :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 454, 164, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(255, 153, 0));
        lblFinalTotalPrice.setText("0");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1232, 454, 72, -1));

        btnSaveOrderDetails.setBackground(new java.awt.Color(0, 0, 0));
        btnSaveOrderDetails.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSaveOrderDetails.setForeground(new java.awt.Color(255, 153, 0));
        btnSaveOrderDetails.setText("SAVE ORDER DETAILS");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 494, 452, 42));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 153, 0));
        jButton3.setText("RESET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 580, 452, 42));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 153, 0));
        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 660, 449, 41));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png"))); // NOI18N
        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 710, 1650, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});
            }

            rs = st.executeQuery("select * from product inner join category on product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_formComponentShown

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(6);
    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();
        String id = model.getValueAt(index, 0).toString();
        customer_pk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);

        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        product_pk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);

        String productDescription = model.getValueAt(index, 4).toString();
        txtProductDescription.setText(productDescription);
    }//GEN-LAST:event_tableProductMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals("")) {
            String productName = txtProductName.getText();
            String productDescription = txtProductDescription.getText();
            String productPrice = txtProductPrice.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(productPrice);
            int checkStock = 0;
            int checkProductAlreadyExistInCard = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product where product_pk = " + product_pk + "");

                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product is out of stock. Only " + rs.getInt("quantity") + " left");
                    }
                }

            } catch (Exception e) {

            }

            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCard.getModel();
                if (tableCard.getRowCount() != 0) {
                    for (int i = 0; i < tableCard.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == product_pk) {
                            checkProductAlreadyExistInCard = 1;
                            JOptionPane.showMessageDialog(null, "Product already exist in the cart!");
                        }
                    }
                }
                if (checkProductAlreadyExistInCard == 0) {
                    model.addRow(new Object[]{product_pk, productName, noOfUnits, productPrice, productDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added Successfully!");
                }
                clearProductFields();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a product to add to your cart!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCardMouseClicked
        // TODO add your handling code here:
        int index = tableCard.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this item from the cart?", "Select", JOptionPane.YES_NO_OPTION);

        if (a == 0) {
            TableModel model = tableCard.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCard.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tableCardMouseClicked

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        // TODO add your handling code here:
        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCard.getModel();
            if (tableCard.getRowCount() != 0) {
                for (int i = 0; i < tableCard.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update product set quantity = quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + "  where product_pk = " + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into orderDetail(orderId, customer_fk, orderDate, totalPaid) VALUES (?, ?, ?, ?)");
                ps.setString(1, orderId);
                ps.setInt(2, customer_pk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, finalTotalPrice);
                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            // Creating document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();

                PdfWriter.getInstance(doc, new FileOutputStream(InverntoryUtils.billPath + "" + orderId + ".pdf"));
                doc.open();
                Paragraph projectName = new Paragraph("                                                          FATEH SUPER MARKET\n                                                 INVENTORY MANAGEMENT SYSTEM\n");
                doc.add(projectName);
                Paragraph starLine = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tOrder ID : " + orderId + "\nDate : " + myFormat.format(cal.getTime()) + "\nTotal Paid : " + finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tbl = new PdfPTable(5);
                PdfPCell nameCell = new PdfPCell(new Phrase("Product Name"));
                PdfPCell descriptionCell = new PdfPCell(new Phrase("Product Description"));
                PdfPCell priceCell = new PdfPCell(new Phrase("Price/Unit"));
                PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalPriceCell = new PdfPCell(new Phrase("Sub Total Price"));
                
                BaseColor backgroundColor = new BaseColor(255, 204, 51);
                nameCell.setBackgroundColor(backgroundColor);
                descriptionCell.setBackgroundColor(backgroundColor);
                priceCell.setBackgroundColor(backgroundColor);
                quantityCell.setBackgroundColor(backgroundColor);
                subTotalPriceCell.setBackgroundColor(backgroundColor);

                tbl.addCell(nameCell);
                tbl.addCell(descriptionCell);
                tbl.addCell(priceCell);
                tbl.addCell(quantityCell);
                tbl.addCell(subTotalPriceCell);
                
                for(int i=0; i < tableCard.getRowCount(); i++){
                   tbl.addCell(tableCard.getValueAt(i, 1).toString());
                   tbl.addCell(tableCard.getValueAt(i, 4).toString());
                   tbl.addCell(tableCard.getValueAt(i, 3).toString());
                   tbl.addCell(tableCard.getValueAt(i, 2).toString());
                   tbl.addCell(tableCard.getValueAt(i, 5).toString());
                }
                
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph("Thank you very much for choosing Fateh Super Market.\nAlways you are welcomed here!");
                doc.add(thanksMsg);
                openPdf.openById(orderId);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Please add some product to cart and select a customer!");
        }
    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCard;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
