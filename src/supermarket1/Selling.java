/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author AKARID
 */
public class Selling extends javax.swing.JFrame {

    /**
     * Creates new form Selling
     */
    public Selling() {
        initComponents();
        SelectSeller();
        getCat();
    }
private Connection con = null;
Statement  st = null;
ResultSet rs = null;
public void SelectSeller() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SupermarketDb", "root", "ilhamaka2002");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM supermarketdb.producttb");

            // Convert ResultSet to DefaultTableModel
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(rs.getMetaData().getColumnLabel(columnIndex));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = rs.getObject(columnIndex);
                }
                model.addRow(row);
            }

            // Set the model to the JTable
            ProductTable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally block
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
 }
int PrId,NewQte;
public void update()
{
    try
            {
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/SupermarketDb","root","ilhamaka2002");
            
            String query = "update supermarketdb.producttb set ProductQte ="+NewQte+""+" where ProductId="+PrId;
          
            Statement add = con.createStatement();
            add.executeUpdate(query);
            //JOptionPane.showMessageDialog(this,"Product Updated");
            SelectSeller();
                
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
}
 public void getCat()
    {
         try { 
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SupermarketDb", "root", "ilhamaka2002");
        st = con.createStatement();
        String query = "SELECT * FROM supermarketdb.categorytb";
        rs = st.executeQuery(query);
        
        // Clear existing items from the ComboBox
        CategoryProd.removeAllItems();
        
        // Add items from the ResultSet to the ComboBox
        while (rs.next()) {
            String categoryName = rs.getString("CatName");
            CategoryProd.addItem(categoryName);
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally block
            try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Billid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ProductName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ProductQte = new javax.swing.JTextField();
        CategoryProd = new javax.swing.JComboBox<>();
        PrintBill = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTxt = new javax.swing.JTextArea();
        Grdtotbl = new javax.swing.JLabel();
        FilterBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel2.setText("PRODUCT LIST");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("BILLID");

        Billid.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Billid.setForeground(new java.awt.Color(102, 153, 255));
        Billid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("NAME");

        ProductName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductName.setForeground(new java.awt.Color(102, 153, 255));
        ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("QUANTITY");

        ProductQte.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductQte.setForeground(new java.awt.Color(102, 153, 255));
        ProductQte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductQteActionPerformed(evt);
            }
        });

        CategoryProd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CategoryProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryProdMouseClicked(evt);
            }
        });
        CategoryProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryProdActionPerformed(evt);
            }
        });

        PrintBill.setBackground(new java.awt.Color(0, 0, 0));
        PrintBill.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        PrintBill.setForeground(new java.awt.Color(255, 255, 255));
        PrintBill.setText("Print");
        PrintBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBillMouseClicked(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(0, 0, 0));
        addBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add To Bill");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(0, 0, 0));
        clearBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });

        RefreshBtn.setBackground(new java.awt.Color(0, 0, 0));
        RefreshBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        RefreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        RefreshBtn.setText("Refresh");
        RefreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RefreshBtnMouseEntered(evt);
            }
        });

        ProductTable.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY ", "PRICE", "CATEGORY"
            }
        ));
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        ProductTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel8.setText("BILLING POINT");

        BillTxt.setColumns(20);
        BillTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BillTxt.setRows(5);
        jScrollPane2.setViewportView(BillTxt);

        Grdtotbl.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        Grdtotbl.setText("RS");

        FilterBtn.setBackground(new java.awt.Color(0, 0, 0));
        FilterBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        FilterBtn.setForeground(new java.awt.Color(255, 255, 255));
        FilterBtn.setText("Filter");
        FilterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FilterBtnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductQte, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(addBtn)
                        .addGap(40, 40, 40)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 181, 181)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Billid, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(336, 336, 336)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(185, 185, 185)
                                        .addComponent(CategoryProd, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(FilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RefreshBtn)))
                                .addContainerGap(40, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Grdtotbl)
                                .addGap(319, 319, 319))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryProd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshBtn)
                            .addComponent(FilterBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Billid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProductQte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(Grdtotbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrintBill)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 2, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Logout");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BillidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillidActionPerformed

    private void ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameActionPerformed

    private void ProductQteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductQteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductQteActionPerformed

    private void CategoryProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryProdActionPerformed

    private void PrintBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBillMouseClicked
              try
              {
                  BillTxt.print();
              }catch(Exception e)
              {
              }        
    }//GEN-LAST:event_PrintBillMouseClicked
int i=0;
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
            if(ProductQte.getText().isEmpty() || ProductName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else if(AvailQte <= Integer.valueOf(ProductQte.getText()))
        {
            JOptionPane.showMessageDialog(this,"Not enough in the stock");
        }
        else
        {
            i++;
              ProdTotal = Uprice * Double.valueOf(ProductQte.getText());
              GrdTotal=GrdTotal+ProdTotal;
            if(i==1)
            {
                BillTxt.setText(BillTxt.getText()+"              *********Famity Point***********\n"+"  NUM      PRODUCT      PRICE      QUANTITY      TOTAL\n"+i+"         "+ProductName.getText()+"       "+Uprice+"      "+ProductQte.getText()+"        "+ProdTotal+"\n\t");
            }else
            {
                BillTxt.setText(BillTxt.getText()+i+"             "+ProductName.getText()+"       "+Uprice+"        "+ProductQte.getText()+"      "+ProdTotal+"\n"); 
                //BillTxt.setText(BillTxt.getText()+"              *********Famity Point***********\n"+"  NUM      PRODUCT      PRICE      QUANTITY      TOTAL\n"+i+"         "+ProductName.getText()+"       "+Uprice+"      "+ProductQte.getText()+"        "+ProdTotal+"\n\t");
            }
            Grdtotbl.setText("RS"+GrdTotal);
            // SelectSeller();
            
        }       
    }//GEN-LAST:event_addBtnMouseClicked

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        Billid.setText("");
        ProductName.setText("");
        ProductQte.setText("");
        //ProductPrice.setText("");
    }//GEN-LAST:event_clearBtnMouseClicked

    private void RefreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshBtnMouseClicked
            SelectSeller();        
    }//GEN-LAST:event_RefreshBtnMouseClicked
Double  Uprice,ProdTotal=0.0,GrdTotal=0.0;
int AvailQte;
    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
     DefaultTableModel model = (DefaultTableModel)ProductTable.getModel();
    int Myindex = ProductTable.getSelectedRow(); 
    PrId=Integer.valueOf(model.getValueAt(Myindex,0).toString());
    AvailQte= Integer.valueOf(model.getValueAt(Myindex, 2).toString());
    ProductName.setText(model.getValueAt(Myindex,1).toString());
    Uprice = Double.valueOf(model.getValueAt(Myindex, 3).toString());
    
    String productQteText = ProductQte.getText().trim(); // Trim to remove leading/trailing whitespaces
    
    if (!productQteText.isEmpty()) {
        int productQte = Integer.parseInt(productQteText);
        if (productQte <= AvailQte) {
            NewQte = AvailQte - productQte;
            ProdTotal = Uprice * productQte;
        } else {
            JOptionPane.showMessageDialog(this, "Not enough quantity in stock");
            // Handle the case where the quantity to sell exceeds available quantity
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please enter a quantity to sell");
        // Handle the case where quantity field is empty
    }
   
    }//GEN-LAST:event_ProductTableMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void CategoryProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryProdMouseClicked
       
    }//GEN-LAST:event_CategoryProdMouseClicked

    private void RefreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshBtnMouseEntered

    private void FilterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterBtnMouseClicked
               try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SupermarketDb", "root", "ilhamaka2002");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM supermarketdb.producttb where ProductCat='"+CategoryProd.getSelectedItem()+"'");

            // Convert ResultSet to DefaultTableModel
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(rs.getMetaData().getColumnLabel(columnIndex));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = rs.getObject(columnIndex);
                }
                model.addRow(row);
            }

            // Set the model to the JTable
            ProductTable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally block
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }        
    }//GEN-LAST:event_FilterBtnMouseClicked

    private void FilterBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterBtnMouseEntered

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BillTxt;
    private javax.swing.JTextField Billid;
    private javax.swing.JComboBox<String> CategoryProd;
    private javax.swing.JButton FilterBtn;
    private javax.swing.JLabel Grdtotbl;
    private javax.swing.JButton PrintBill;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductQte;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
