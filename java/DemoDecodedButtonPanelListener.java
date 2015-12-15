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

class DemoDecodedButtonPanelListener implements ActionListener {
    
   private void clearTextArea(Container parentComponent) {
   JTextArea textArea   =   null ;
   
      if ( parentComponent != null ) {
         try {
            textArea   =   (JTextArea)DemoResources.findComponent(parentComponent, "DecodedTextArea") ;
            textArea.setText(null) ;
            textArea.revalidate() ;
         } catch (Exception e) {
            throw new IllegalArgumentException("clearTextArea()", e) ;
         }
      } else 
         throw new DemoException("cannot clear text area") ;
   }
   
   private String deconstructFileName(String textFieldValue) {
   String[] fileNameComponents   =   null ;
   String   fileName             =   null ;
   
      if ( DemoResources.isTextValid(textFieldValue) ) 
         if ( textFieldValue.toUpperCase().endsWith(".B64") ) {
            try {
               fileNameComponents   =   textFieldValue.split(".") ;
               fileName             =   fileNameComponents[0].replace('_', '.') ;
            } catch (Exception e) {
               throw new DemoException("cannot deconstruct file name", e) ;
            }
         } else
            fileName             =   textFieldValue ;
   
      return fileName ;
   }
   
   private void disableButtons(Container parentComponent) {

      DemoResources.disableComponent(parentComponent, "DecodeClearButton") ;
      DemoResources.disableComponent(parentComponent, "DecodeEncryptButton") ;
      DemoResources.disableComponent(parentComponent, "DecodeSaveButton") ;
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
   
      if ( DemoResources.isTextValid(path) )
         extension   =   path.substring(path.lastIndexOf('.')) ;
      else
         throw new IllegalArgumentException("path name is null") ;
      
      return extension ;
   }
   
   private String returnFileName(String path) {
   String[]   pathComponents   =   null ;
   String     fileName         =   null ;
   
      if ( DemoResources.isTextValid(path) ) {
         try {
            pathComponents   =   path.split(Pattern.quote(File.separator)) ;
            fileName         =   pathComponents[(pathComponents.length - 1)] ;
         } catch (Exception e) {
            throw new DemoException("cannot return file name", e) ;
         }         
      }
      
      return fileName ;
   }
   
   private String returnTextAreaValue(Component component) {
   JTextArea textArea      =   null ;
   String    returnValue   =   null ;
   
      if ( !DemoResources.isNull(component) )
         try {
            textArea      =   (JTextArea)DemoResources.findComponent((Container)component, "DecodedTextArea") ;
            returnValue   =   textArea.getText() ;
         } catch (Exception e) {
            throw new DemoException("cannot return test area", e) ;
         }   
      
      return returnValue ;
   }
   
   private String returnTextFieldValue(Component component) {
   JTextField textField     =   null ;
   String     returnValue   =   null ;
   
      if ( !DemoResources.isNull(component) )
         try {
            textField     =   (JTextField)DemoResources.findComponent((Container)component, "DecodeTextField") ;
            returnValue   =   textField.getText() ;
         } catch (Exception e) {
            throw new DemoException("cannot return text field value") ;
         }
      
      return returnValue ;
   }
   
   private void saveDecodedInformation(int selection, String textFieldValue, String textAreaValue) {
       
      switch(selection) {
          case DemoSaveDialog.JAVA_CLASS:   saveJavaClass(textFieldValue, textAreaValue) ;
                                            break ;
          case DemoSaveDialog.FILE:         saveFile(textFieldValue) ;
                                            break ;
          case DemoSaveDialog.HTML5:        saveHTML5(textFieldValue, textAreaValue) ;
                                            break ;
          default:
      }
   }
   
   private void saveFile(String textFieldValue) {
   File         file                =   null ;
   JFileChooser fileChooser         =   null ;
   String[]     fileNameComponent   =   null ;
   String       fileName            =   null ;
   int          result              =   -1 ;
   

      try {
         fileChooser   =   new JFileChooser() ;
         
         if ( DemoResources.isTextValid(textFieldValue) ) {
            fileName   =   DemoFiler.makeDecodedFileName(textFieldValue) ;
            fileChooser.setSelectedFile(new File(fileName)) ;
         }
         
         if ( (result = fileChooser.showSaveDialog(null)) == 0 ) {
            file       =   (fileChooser.getSelectedFile()) ;
            DemoFiler.writeBinaryFile(file, textFieldValue) ; //may be null
         }
      } catch (Exception e) {
         throw new DemoException("Saving decoded file failed.", e) ;
      }
   }
   
   private void saveHTML5(String textFieldValue, String textAreaValue) {
       
   }
   
   private void saveJavaClass(String textFieldValue, String textAreaValue) {
   File         file          =   null ;
   JFileChooser fileChooser   =   null ;
   String       fileName      =   null ;
   int          result        =   -1 ;
   
      if ( DemoResources.isTextValid(textFieldValue) && DemoResources.isTextValid(textAreaValue) ) {
         try {
            fileName      =   DemoFiler.makeEncodedFileName(textFieldValue, ".java") ;
      
            fileChooser   =   new JFileChooser() ;
            fileChooser.setSelectedFile(new File(fileName)) ;
            result        =   fileChooser.showSaveDialog(null) ;
            if ( result == 0 ) {
               file       =   (fileChooser.getSelectedFile()) ;
               DemoFiler.writeTextFile(file, DemoFiler.formatJavaClass(DemoFiler.returnFileName(textFieldValue), textAreaValue)) ;
            }
         } catch (Exception e) {
            throw new DemoException("cannot save java class ", e) ;
         }
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
      if ( component.getName().equals("DecodeClearButton") ) {
         clearTextArea(component.getParent()) ;    
         disableButtons(component.getParent()) ;
      }
      if ( component.getName().equals("DecodeSaveButton") ) {
         selection   =   displaySaveDialog(component) ;
         if ( (selection >= 0) && (selection <= 2) ) {
             textFieldValue   =   returnTextFieldValue(component.getParent()) ;
             textAreaValue    =   returnTextAreaValue(component.getParent()) ;
             saveDecodedInformation(selection, textFieldValue, textAreaValue) ;
         }
      }
   }
   
}
