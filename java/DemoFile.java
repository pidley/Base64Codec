package org.codegaucho.pidley.Base64Codec;

import java.io.File ;
import java.net.URI ;

public class DemoFile extends File {
private String fileName         =   null ;
private String fileExtension    =   null ;
private int fileTypeIndicator   =   -1 ;

    DemoFile(File parent, String child) {
        
       super(parent, child) ;
    }
    
    DemoFile(String pathName) {
        
       super(pathName) ;
    }
    
    DemoFile(String parent, String child) {
        
       super(parent, child) ;
    }
    
    DemoFile(URI uri) {
        
       super(uri) ;
    }
    
    String getFileExtension() {
        
       return fileExtension ;
    }
    
    String getFileName() {
    
       return fileName ;
    }
    
    int getFileTypeIndicator() {
       
       return fileTypeIndicator ;
    }
    
    boolean isTextFile() {
    boolean result   =   true ;
    
       
       return result ;
    }
    
    void setFileExtension(String newFileExtension) {
    
       if ( !DemoResources.isNull(newFileExtension) ) 
          fileExtension   =   newFileExtension ;
    }
    
    void setFileName(String newFileName) {
        
       if ( !DemoResources.isNull(newFileName) ) 
          fileName   =   newFileName ;        
    }
    
    void setFileTypeIndicator(int newFileTypeIndicator) {
        
       fileTypeIndicator   =   newFileTypeIndicator ;
    }
}
