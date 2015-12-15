package org.codegaucho.pidley.Base64Codec;

import java.awt.Font;
import javax.swing.JTextArea ;

public class DemoDecodedTextArea extends JTextArea {
    
   DemoDecodedTextArea(String text) {
       
      super(text) ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private final void addComponents() {
       
   }
   
   private final void addListeners() {
       
   }
   
   private final void setAttributes() {
   
      try {
         setName("DecodedTextArea") ;
         setFont(new Font("Courier New", Font.PLAIN, 12)) ;
      } catch (Exception e) {
         throw new DemoException("DecodedTextArea cannot set attributes.", e) ;
      }
   }
}
