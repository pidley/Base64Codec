package org.codegaucho.pidley.Base64Codec;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

class DemoDecodeFileButton extends JButton implements ActionListener {
private final int   HEIGHT     =   40 ;
private final int   WIDTH      =   40 ;
private File        file       =   null ;
private String      fileName   =   null ;
private int         result     =   -1 ;
//
   DemoDecodeFileButton() {

      super() ;
      setAttributes() ;
      addListeners() ;
   }

   private final void addListeners() {
   
      addActionListener(this) ;
   }
   
   public File getFile() {
   
      return file ;
   }
   
   public int getResult() {
   
      return result ;
   }
   
   public String returnFileName() {
  
      return getFile().getAbsoluteFile().toString();      
   }
   
   private final void setAttributes() {
       
      setMaximumSize(new Dimension(WIDTH, HEIGHT)) ;
      setPreferredSize(new Dimension(WIDTH, HEIGHT)) ;
      setName("FileButton") ;
   }
   
   private void setFile(File newFile) {
   
      file   =   newFile ;
   }
   
   private void setResult(int newResult) {
       
      result   =   newResult ;
   }
   
   private final File openFile() {
   File file   =   null ;
   JFileChooser   fileChooser   =   null ;
   JTextField     textField     =   null ;
   int result = 0 ;

      try {
         fileChooser    =   new JFileChooser() ;
         result         =   fileChooser.showOpenDialog(null) ;
         setResult(result) ;
         if ( getResult() == 0 ) {
            file   =   (fileChooser.getSelectedFile()) ;
         }
      } catch (Exception e) {
         throw new DemoException("file chooser error", e) ;
      }
      
      return file ;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
   File file   =   null ;
   JFileChooser   fileChooser   =   null ;
   JTextField     textField     =   null ;
   int            result        =   0 ;
   
      try {
         file   =   openFile() ;
         if ( !DemoResources.isNull(file) ) {
            setFile(file) ;
            textField   =   (JTextField)DemoResources.findComponent(((JButton)e.getSource()).getParent(), "DecodeTextField") ;
            textField.setText(getFile().getAbsoluteFile().toString()) ;
         } else
            setFile(null) ;
      } catch (Exception ex) {
         throw new Base64CodecException("Cannot open file chooser dialog") ; 
      }
   }
}
