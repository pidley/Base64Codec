package org.codegaucho.pidley.Base64Codec;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel ;
import javax.swing.JTextField ;

public class DemoEncodeTextFieldPanel extends JPanel {
    
   DemoEncodeTextFieldPanel() {
       
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private final void addComponents() {
       
      add(createTextField()) ;
      add(Box.createRigidArea(new Dimension(10, 0))) ;
      add(new DemoEncodeFileButton()) ;
   }
   
   private final void addListeners() {
       
   }
   
   private JTextField createTextField() {
   JTextField textField   =   null ;
   
      textField   =   new JTextField(20) ;
      textField.setName("EncodeTextField") ;
      
      return textField ;
   }
   
   private final void setAttributes() {
       
      setName("EncodeTextFieldPanel") ;
      setMaximumSize(new Dimension(550, 26)) ;
      setPreferredSize(new Dimension(550, 26)) ;
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS)) ;
   }
}
