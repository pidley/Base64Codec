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
import java.util.Arrays;
import javax.swing.JButton ;
import javax.swing.JPanel ;
import javax.swing.JTextField ;

class DemoDecodeButton extends JButton implements ActionListener {
    
   DemoDecodeButton() {
      
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

      DemoResources.enableComponent(container, "DecodeClearButton");
      DemoResources.enableComponent(container, "DecodeSaveButton");
   }
   
   private final void setAttributes() {

      setText("Decode") ;
      setName("DecodeButton") ;
   }
   
   private final void setTextPanel(String encodedString) {
   JPanel textPanel   =   null ;
   
      textPanel   =   (JPanel)DemoResources.findComponent(this, "DecodedContentPanel") ;
      textPanel.removeAll() ;
      textPanel.add(new DemoDecodedTextArea(encodedString)) ;
      textPanel.revalidate() ;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
   Component textField       =   null ;
   File      file            =   null ;
   String    fileName        =   null ;
   String    decodedString   =   null ;
   byte[]    byteArray       =   null ;
 
      textField      =   DemoResources.findComponent(this, "DecodeTextField") ;
      fileName       =   ((JTextField)textField).getText() ;
      if ( fileName != null ) {
         file            =   new File(fileName) ;
         //get string from file
         byteArray   =   Base64Codec.decode(file) ; 
         //setTextPanel(byteArray) ;
         setTextPanel("test") ;
         enableButtons(this.getParent()) ;
      }
   }
}

