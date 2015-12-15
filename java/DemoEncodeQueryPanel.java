package org.codegaucho.pidley.Base64Codec ;

import java.awt.Dimension ;
import javax.swing.BorderFactory ;
import javax.swing.Box ;
import javax.swing.BoxLayout ;
import javax.swing.JPanel ;

class DemoEncodeQueryPanel extends JPanel {
private final String LABEL_TEXT   =   "Enter string or filename" ;

   DemoEncodeQueryPanel() {
   
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private final void addComponents() {
      
      try {
         add(Box.createHorizontalGlue());
         add(Box.createRigidArea(new Dimension(0, 6)));
         add(new DemoEncodeTextFieldPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));  
         add(createEncodeButtonPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));
      } catch (Exception e) {
         throw new Base64CodecException("cannot add compoenents") ;
      }
   }
   
   private final void addListeners() {
       
   }
   
   private JPanel createEncodeButtonPanel() {
   JPanel  panel    =   null ;
   
      panel    =   new JPanel() ;
      panel.setName("EncodeButtonPanel") ;
      
      panel.add(new DemoEncodeButton()) ;
      
      return panel ;
   }
   
   private final void setAttributes() {
       
      try {
         setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)) ;
         setBorder(BorderFactory.createTitledBorder(LABEL_TEXT)) ;
      } catch (Exception e) {
         throw new DemoException("cannot set attributes", e) ;
      }
   }
}
