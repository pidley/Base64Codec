package org.codegaucho.pidley.Base64Codec;

import javax.swing.JButton ;

class DemoDecodeClearButton extends JButton {
    
   DemoDecodeClearButton() {
      
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private final void addComponents() {
       
   }  
   
   private final void addListeners() {
       
      try {
         addActionListener(new DemoDecodedButtonPanelListener()) ;       
      } catch (Exception e) {
         throw new DemoException("Listener not added to clear button.", e) ;
      }
   }
   
   private final void setAttributes() {
       
      setText("Clear") ;
      setName("DecodeClearButton") ;
      setEnabled(false) ;       
   }
}
