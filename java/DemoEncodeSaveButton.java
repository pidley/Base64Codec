package org.codegaucho.pidley.Base64Codec;

import javax.swing.JButton ;

public class DemoEncodeSaveButton extends JButton {
    
   DemoEncodeSaveButton() {
             
      super() ;
      setAttributes() ;
      addListeners() ;
   }
   
   private final void setAttributes() {
       
      setText("Save") ;
      setName("EncodeSaveButton") ;
      setEnabled(false) ;       
   }
   
   private final void addListeners() {
       
      addActionListener(new DemoEncodedButtonPanelListener()) ;       
   }
}
