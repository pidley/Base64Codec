package org.codegaucho.pidley.Base64Codec ;

import java.awt.Component ;
import java.awt.Container ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.File ;
import java.util.regex.Pattern ;
import javax.swing.JDialog ;
import javax.swing.JFileChooser ;
import javax.swing.JFrame ;
import javax.swing.JTextArea ;
import javax.swing.JTextField ;
import javax.swing.SwingUtilities ;

class DemoEncodedButtonPanelListener implements ActionListener {
    
   private void clearTextArea(Container parentComponent) {
   JTextArea textArea   =   null ;
   
      textArea   =   (JTextArea)DemoResources.findComponent(parentComponent, "EncodedTextArea") ;
      textArea.setText(null) ;
      textArea.revalidate() ;
   }
   
   private void disableButtons(Container parentComponent) {

      DemoResources.disableComponent(parentComponent, "EncodeClearButton") ;
      DemoResources.disableComponent(parentComponent, "EncodeEncryptButton") ;
      DemoResources.disableComponent(parentComponent, "EncodeSaveButton") ;
   }
   
   private int displaySaveDialog(Component component) {
   DemoSaveDialog saveDialog   =   null ;
   int            selection    =   -9 ;
   
      saveDialog   =   new DemoSaveDialog((JFrame)SwingUtilities.getRoot(component), "Save", true) ;
      selection    =   saveDialog.showDialog() ;
      
      return selection ;
   }
   
   private String returnFileExtension(String path) {
   String extension   =   null ;
   
      return extension ;
   }
   
   private String returnFileName(String path) {
   String[]   pathComponents   =   null ;
   
      pathComponents   =   path.split(Pattern.quote(File.separator)) ;
      return pathComponents[(pathComponents.length - 1)] ;
   }
   
   private String returnTextAreaValue(Component component) {
   JTextArea textArea   =   null ;
   
      textArea   =   (JTextArea)DemoResources.findComponent((Container)component, "EncodedTextArea") ;
      
      return textArea.getText() ;
   }
   
   private String returnTextFieldValue(Component component) {
   JTextField textField   =   null ;
   
      textField = (JTextField)DemoResources.findComponent((Container)component, "EncodeTextField") ;
      
      return textField.getText() ;
   }
   
   private void saveEncodedInformation(int selection, String textFieldValue, String textAreaValue) {
       
      switch(selection) {
          case DemoSaveDialog.JAVA_CLASS:   saveJavaClass(textFieldValue, textAreaValue) ;
                                            break ;
          case DemoSaveDialog.FILE:         saveFile(textFieldValue, textAreaValue) ;
                                            break ;
          case DemoSaveDialog.HTML5:        saveHTML5(textFieldValue, textAreaValue) ;
                                            break ;
          default:
      }
   }
   
   private void saveFile(String textFieldValue, String textAreaValue) {
   File         file          =   null ;
   JFileChooser fileChooser   =   null ;
   String       fileName      =   null ;
   int          result        =   -1 ;
   
      fileName       =   DemoFiler.makeEncodedFileName(textFieldValue, ".B64") ;
      
      fileChooser    =   new JFileChooser() ;
      fileChooser.setSelectedFile(new File(fileName)) ;
      result         =   fileChooser.showSaveDialog(null) ;
      if ( result == 0 ) {
         try {
            file     =   (fileChooser.getSelectedFile()) ;
            DemoFiler.writeTextFile(file, textAreaValue) ;
         } catch (Exception x) {
            System.err.format("IOException: %s%n", x) ;
         }
      }
            
   }
   
   private void saveHTML5(String textFieldValue, String textAreaValue) {
       
   }
   
   private void saveJavaClass(String textFieldValue, String textAreaValue) {
   File         file          =   null ;
   JFileChooser fileChooser   =   null ;
   String       fileName      =   null ;
   int          result        =   -1 ;
   
      fileName       =   DemoFiler.makeEncodedFileName(textFieldValue, ".java") ;
      
      fileChooser    =   new JFileChooser() ;
      fileChooser.setSelectedFile(new File(fileName)) ;
      result         =   fileChooser.showSaveDialog(null) ;
      if ( result == 0 ) {
         file     =   (fileChooser.getSelectedFile()) ;
         System.out.println(fileName) ;
         DemoFiler.writeTextFile(file, DemoFiler.formatJavaClass(DemoFiler.returnFileName(textFieldValue), textAreaValue)) ;
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
   Component component        =   null ;
   JDialog   saveDialog       =   null ;
   String    textAreaValue    =   null ;
   String    textFieldValue   =   null ;
   int       selection        =   0 ;
   
      component   =   (Component)e.getSource() ;
      if ( component.getName().equals("EncodeClearButton") ) {
         clearTextArea(component.getParent()) ;    
         disableButtons(component.getParent()) ;
      }
      if ( component.getName().equals("EncodeSaveButton") ) {
         selection   =   displaySaveDialog(component) ;
         if ( (selection >= 0) && (selection <= 2) ) {
             textFieldValue   =   returnTextFieldValue(component.getParent()) ;
             textAreaValue    =   returnTextAreaValue(component.getParent()) ;
             saveEncodedInformation(selection, textFieldValue, textAreaValue) ;
         }
      }
   }
   
}
