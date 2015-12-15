package org.codegaucho.pidley.Base64Codec;

import javax.swing.JButton ;

public class DemoEncodeEncryptButton extends JButton {
    
   DemoEncodeEncryptButton() {
             
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
    
   private final void addComponents() {
       
   }
   
   private final void addListeners() {
       
      addActionListener(new DemoEncodedButtonPanelListener()) ;       
   }

   private final void setAttributes() {
       
      setText("Encrypt") ;
      setName("EncodeEncryptButton") ;
      setEnabled(false) ;       
   }
}
