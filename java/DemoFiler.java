package org.codegaucho.pidley.Base64Codec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DemoFiler {
    
   static String makeDecodedFileName(String fileName) {
   String directory   =   null ;

      if ( DemoResources.isTextValid(fileName) ) {
         if ( fileName.toUpperCase().endsWith(".B64") ) {
            try {
               directory   =   System.getProperty("user.dir") ;
               fileName    =   returnFileName(fileName) ;
               fileName    =   fileName.substring(0, fileName.lastIndexOf('.')) ;
               fileName    =   fileName.replace("_", ".") ;
               fileName    =   directory + File.separator + fileName ;
            } catch (Exception e) {
               throw new Base64CodecException("error making encoded file name", e) ; 
            }
         }
      }
         
      return  fileName ;
   }
   
   static String makeEncodedFileName(String fileName, String extension) {
   String directory   =   null ;

      if ( (DemoResources.isTextValid(fileName)) && (DemoResources.isTextValid(extension)) ) {
         try {
            directory   =   System.getProperty("user.dir") ;
            fileName    =   returnFileName(fileName) ;
            fileName    =   fileName.replace(".", "_") + extension ;
            fileName    =   directory + File.separator + fileName ;
         } catch (Exception e) {
            throw new Base64CodecException("error making encoded file name", e) ; 
         }
      }
      return  fileName ;
   }
   
   static String returnFileName(String path) {
   String[]   pathComponents   =   null ;
   
      pathComponents   =   path.split(Pattern.quote(File.separator)) ;
      
      return pathComponents[(pathComponents.length - 1)] ;
   }
/*
public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
   
   */
   static void writeBinaryFile(File file, String textFieldValue) {
   FileInputStream   inputStream   =   null ;
   FileOutputStream  outputStream  =   null ;
   //File              file          =   null ;
   byte[]            byteArray     =   null ;
   int               bytesRead     =   -1 ;
   
      try {
          
         if ( file.isFile() ) System.out.println("File is file") ;
         byteArray      =   Base64Codec.decode(file) ;
         inputStream    =   new FileInputStream(textFieldValue) ;
         outputStream   =   new FileOutputStream(file.getName()) ;

         System.out.println("input " + textFieldValue + " output " + file.getName());
         
         outputStream.write(byteArray) ;
         outputStream.flush() ;
         outputStream.close() ;
         
         inputStream.close() ;
      } catch (Exception e) {
         System.out.println(" Error writing file: " + e.getMessage()) ;
      }
   }
   
   static void writeTextFile(File file, String content) {
   BufferedWriter writer      =   null ;
   
      try {
         writer   =   Files.newBufferedWriter(file.toPath(), Charset.forName("US-ASCII")) ;
           
         writer.write(content, 0, content.length()) ;
         writer.flush() ;
         writer.close() ;
      } catch (Exception e) {
         System.out.println("Error writing file") ;
      }
   }
   
   static String formatJavaClass(String fileName, String content) {
   char c ;
   String lineSeparator   =   null ;
   //String className       =   null ;
   String fileExt         =   null ;
   String javaClass       =   null ;

      if ( !DemoResources.isNull(fileName) && !DemoResources.isNull(content) ) {
         lineSeparator   =   System.getProperty("line.separator") ;
         if ( fileName.indexOf('.') != -1 ) {
             fileExt     =   fileName.substring(fileName.indexOf('.')) ;
             fileName    =   fileName.replace(".", "_") ;
         } 
         
         c               =   fileName.charAt(0) ;
         c               =   Character.toUpperCase(c) ;
         fileName        =   fileName.replaceFirst(Character.toString(fileName.charAt(0)), Character.toString(c)) ;
         
         javaClass       =  "class " + fileName + " {   " + lineSeparator ;
         javaClass      +=  "private String fileExt = \"" + fileExt + "\" ; " +lineSeparator ;
         javaClass      +=  "private String fileName = \"" + fileName + "\" ; " + lineSeparator ;
         javaClass      +=  "private String content  = \"" + content + "\" ; " + lineSeparator + lineSeparator ;
         javaClass      +=  "   public String getContent() {" + lineSeparator + lineSeparator ;
         javaClass      +=  "      return content ;" + lineSeparator ; 
         javaClass      +=  "   } " + lineSeparator + lineSeparator ;
         javaClass      +=  "   public String getFileExt() {" + lineSeparator + lineSeparator ;
         javaClass      +=  "      return fileExt ;" + lineSeparator ;
         javaClass      +=  "   }" + lineSeparator ;
         javaClass      +=  "   public String getFileName() {" + lineSeparator + lineSeparator ;
         javaClass      +=  "      return fileName ;" + lineSeparator ;
         javaClass      +=  "   }" + lineSeparator ;
         javaClass      +=  "}" ;
      }
      
      return javaClass ;
   }

}
