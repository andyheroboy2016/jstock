/*
 * OptionsSellAdvisorJPanel.java
 *
 * Created on August 31, 2008, 3:55 AM
 */

package org.yccheok.jstock.gui;

import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author  yccheok
 */
public class OptionsSellAdvisorJPanel extends javax.swing.JPanel implements JStockOptionsObserver {

    /** Creates new form OptionsSellAdvisorJPanel */
    public OptionsSellAdvisorJPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.swingx.JXHeader jXHeader1 = new org.jdesktop.swingx.JXHeader();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = getPercentageJFormattedTextField();

        setLayout(new java.awt.BorderLayout());

        jXHeader1.setDescription("Provide you advice during your sell transaction, in order to maximize your profit.");
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/32x32/jabber_protocol.png"))); // NOI18N
        jXHeader1.setTitle("Advisor");
        add(jXHeader1, java.awt.BorderLayout.NORTH);

        jLabel1.setText("Expected profit percentage (%)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private JFormattedTextField getPercentageJFormattedTextField() {
        NumberFormat format= NumberFormat.getNumberInstance();
        NumberFormatter formatter= new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(null);
        formatter.setValueClass(Double.class);
        JFormattedTextField field= new JFormattedTextField(formatter);
        
        return field;
    }
    
    private void commitEdit() {
        try {
            jFormattedTextField1.commitEdit();
        } catch (ParseException ex) {
            log.error("", ex);
        }
    }
    
    public void set(JStockOptions jStockOptions) {
        jFormattedTextField1.setValue(new Double(jStockOptions.getExpectedProfitPercentage()));
        commitEdit();
    }

    public boolean apply(JStockOptions jStockOptions) {
        commitEdit();
        jStockOptions.setExpectedProfitPercentage((Double)jFormattedTextField1.getValue());
        return true;
    }
    
    private static final Log log = LogFactory.getLog(OptionsSellAdvisorJPanel.class);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JFormattedTextField jFormattedTextField1;
    // End of variables declaration//GEN-END:variables

}
