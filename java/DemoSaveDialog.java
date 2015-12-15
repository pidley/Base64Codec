package org.codegaucho.pidley.Base64Codec;

import java.awt.Component ;
import java.awt.Dimension ;
import java.awt.Frame ;
import java.awt.Toolkit ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton ;
import javax.swing.JComboBox ;
import javax.swing.JDialog ;
import javax.swing.JPanel ;

public class DemoSaveDialog extends JDialog implements ActionListener {
public final static int SAVE_BUTTON     =   0 ;
public final static int CANCEL_BUTTON   =   1 ;
public final static int JAVA_CLASS      =   0 ;
public final static int FILE            =   1 ;
public final static int HTML5           =   2 ;
private final String    LABEL_TEXT      =   "Select format" ;

private JComboBox comboBox   =   null ;
private int       result     =   0 ;

   DemoSaveDialog(Frame owner, String title, boolean modal) {
       
      super(owner, title, modal) ;
      addComponents() ;
      addListeners() ;
      setAttributes() ;
   } 
   
   private final void addComponents() {
   
      getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)) ;
      getContentPane().add(createComboBoxPanel());
      getContentPane().add(Box.createRigidArea(new Dimension(10, 6)));
      getContentPane().add(createButtonPanel());
      getContentPane().add(Box.createRigidArea(new Dimension(10, 6)));
   }
   
   private final void addListeners() {
       
   }
       
   private final JPanel createButtonPanel() {
   JButton saveButton     =   null ;
   JButton cancelButton   =   null ;
   JPanel  panel          =   null ;
   
      panel   =   new JPanel() ;
      panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS)) ;
      
      saveButton   =   new JButton("Save") ;
      saveButton.setName("DialogSaveButton") ;
      saveButton.addActionListener(this) ;
      
      cancelButton   =   new JButton("Cancel") ;
      cancelButton.setName("DialogCancelButton") ;
      cancelButton.addActionListener(this) ;
      
      panel.add(saveButton) ;
      panel.add(Box.createRigidArea(new Dimension(10, 6)));
      panel.add(cancelButton) ;

      return panel ;
   }
   
   private final JPanel createComboBoxPanel( ) {
   //JComboBox comboBox   =   null ;
   JPanel    panel      =   null ;
   String[] selection   =   { "Java Class", "File", "HTML5 String", "        " } ;
   
      comboBox   =   new JComboBox(selection) ;
      
      panel   =   new JPanel() ;
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)) ;
      panel.setBorder(BorderFactory.createTitledBorder(LABEL_TEXT)) ;
      panel.setName("SaveComboBox") ;
      panel.add(Box.createRigidArea(new Dimension(20, 6)));
      panel.add(comboBox) ;
      panel.add(Box.createRigidArea(new Dimension(20, 6))) ;
              
      return panel ;
   }
   
   JComboBox getComboBox() {
   
      return comboBox ;
   }
   
   int getResult() {
       
      return result ;
   }
   
   private final void setAttributes() {
       
      setPreferredSize(new Dimension(400,138)) ;
      setMinimumSize(new Dimension(400, 138)) ;
      setResizable(false) ;
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE) ;
      pack() ;
      setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2,(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
   }
   
   void setComboBox(JComboBox newComboBox) {
   
      comboBox   =   newComboBox ;
   }
   
   void setResult(int newResult) {
       
      result = newResult ;
   }
   
   public int showDialog() {
       
      setVisible(true) ;
      return getResult() ;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
       
      System.out.print("Name: " + ((Component)e.getSource()).getName()) ;
      if ( ((Component)e.getSource()).getName().equals("DialogSaveButton") ) {
         setResult(getComboBox().getSelectedIndex()) ;
         dispose() ;
      }
      if ( ((Component)e.getSource()).getName().equals("DialogCancelButton") ) {
         setResult(-1) ;
         dispose() ;
      }
   }
}
