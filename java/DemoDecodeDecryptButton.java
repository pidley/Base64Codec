package org.codegaucho.pidley.Base64Codec;

import javax.swing.JButton ;

public class DemoDecodeDecryptButton extends JButton {
    
   DemoDecodeDecryptButton() {
             
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
    
   private final void addComponents() {
       
   }
   
   private final void addListeners() {
       
      addActionListener(new DemoDecodedButtonPanelListener()) ;       
   }

   private final void setAttributes() {
       
      setText("Decrypt") ;
      setName("DecodeDecryptButton") ;
      setEnabled(false) ;       
   }
}
