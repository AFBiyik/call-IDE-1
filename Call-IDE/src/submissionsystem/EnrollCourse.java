package submissionsystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Abdullah Talayhan
 */
public class EnrollCourse extends JFrame {

    Client client;
    String cKey;
    /**
     * Creates new form EnrollCourse
     */
    public EnrollCourse(Client pclient) {
        client = pclient;
        client.sendUTFDataToServer("ENROLL_COURSE");
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classPrpLabel = new javax.swing.JLabel();
        cKeyField = new javax.swing.JTextField();
        enrollBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enroll Course");

        classPrpLabel.setText("Enter Class Key: ");

        enrollBtn.setText("Enroll");
        enrollBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enrollBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(classPrpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classPrpLabel)
                    .addComponent(cKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enrollBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enrollBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("test");
        
        cKey = cKeyField.getText();
        client.sendUTFDataToServer(cKey);
        
        String ans = client.getUTFDataFromServer();
        
        if(ans.equals("ENROLLED")) {
            System.out.println("Enrolled");
            String courseCode = client.getUTFDataFromServer();
            //informLabel.setText("Class Key for: " + courseCode + " , Enrollment Complete." );
            JOptionPane.showMessageDialog(this, "Class Key for: " + courseCode ,  "Enrollment Complete" , JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        }
        else {
            JOptionPane.showMessageDialog(this, "Either Class Key is invalid or you are already enrolled", "Call-IDE Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_enrollBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cKeyField;
    private javax.swing.JLabel classPrpLabel;
    private javax.swing.JButton enrollBtn;
    // End of variables declaration//GEN-END:variables
}