package org.codegaucho.pidley.Base64Codec;

import java.awt.Font;
import javax.swing.JTextArea ;

public class DemoEncodedTextArea extends JTextArea {
    
   DemoEncodedTextArea(String text) {
       
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
         setName("EncodedTextArea") ;
         setFont(new Font("Courier New", Font.PLAIN, 12)) ;
      } catch (Exception e) {
         throw new DemoException("EncodedTextArea cannot set attributes.", e) ;
      }
   }
}
