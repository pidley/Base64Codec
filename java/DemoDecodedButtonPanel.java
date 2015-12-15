package org.codegaucho.pidley.Base64Codec;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel ;

public class DemoDecodedButtonPanel extends JPanel {
    
   DemoDecodedButtonPanel() {
       
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private void addComponents() {
       
      add(new DemoDecodeClearButton()) ;
      add(Box.createRigidArea(new Dimension(10, 0)));
      add(new DemoDecodeDecryptButton()) ;
      add(Box.createRigidArea(new Dimension(10, 0)));
      add(new DemoDecodeSaveButton()) ;
   }
   
   private void addListeners() {
       
   }
   
   private void setAttributes() {
       
      setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS)) ;
   }
}
