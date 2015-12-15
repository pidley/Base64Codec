package org.codegaucho.pidley.Base64Codec;

import javax.swing.JButton ;

public class DemoDecodeSaveButton extends JButton {
    
   DemoDecodeSaveButton() {
             
      super() ;
      setAttributes() ;
      addListeners() ;
   }
   
   private final void setAttributes() {
       
      setText("Save") ;
      setName("DecodeSaveButton") ;
      setEnabled(false) ;       
   }
   
   private final void addListeners() {
       
      addActionListener(new DemoDecodedButtonPanelListener()) ;       
   }
}
