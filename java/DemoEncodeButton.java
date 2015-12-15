/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.codegaucho.pidley.Base64Codec;

import java.awt.Component ;
import java.awt.Container ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.File ;
import javax.swing.JButton ;
import javax.swing.JPanel ;
import javax.swing.JTextField ;

class DemoEncodeButton extends JButton implements ActionListener {
    
   DemoEncodeButton() {
      
      super() ;
      setAttributes() ;
      addComponents() ;
      addListeners() ;
   }
   
   private final void addComponents() {
   
   }
   
   private final void addListeners() {
       
      addActionListener(this) ;
   }

   private final void enableButtons(Container container) {

      DemoResources.enableComponent(container, "EncodeClearButton");
      DemoResources.enableComponent(container, "EncodeSaveButton");
   }
   
   private final void setAttributes() {

      setText("Encode") ;
      setName("EncodeButton") ;
   }
   
   private final void setTextPanel(String encodedString) {
   JPanel textPanel   =   null ;
   
      textPanel   =   (JPanel)DemoResources.findComponent(this, "EncodedContentPanel") ;
      textPanel.removeAll() ;
      textPanel.add(new DemoEncodedTextArea(encodedString)) ;
      textPanel.revalidate() ;
   }
      
   @Override
   public void actionPerformed(ActionEvent e) {
   Component textField       =   null ;
   File      file            =   null ;
   String    fileName        =   null ;
   String    encodedString   =   null ;
 
      textField          =   DemoResources.findComponent(this, "EncodeTextField") ;
      fileName           =   ((JTextField)textField).getText() ;
      if ( fileName != null ) {
         file            =   new File(fileName) ;
         encodedString   =   Base64Codec.encode(file) ; 
         setTextPanel(encodedString) ;
         enableButtons(this.getParent()) ;
      }
   }
}

