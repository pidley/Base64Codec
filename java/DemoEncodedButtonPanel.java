package org.codegaucho.pidley.Base64Codec;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel ;

public class DemoEncodedButtonPanel extends JPanel {
    
   DemoEncodedButtonPanel() {
       
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private void addComponents() {
       
      add(new DemoEncodeClearButton()) ;
      add(Box.createRigidArea(new Dimension(10, 0)));
      add(new DemoEncodeEncryptButton()) ;
      add(Box.createRigidArea(new Dimension(10, 0)));
      add(new DemoEncodeSaveButton()) ;
   }
   
   private void addListeners() {
       
   }
   
   private void setAttributes() {
       
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS)) ;
   }
}
