package org.codegaucho.pidley.Base64Codec ;


import java.awt.image.BufferedImage ;
import java.awt.image.VolatileImage ;
import java.io.ByteArrayInputStream ;
import java.io.ByteArrayOutputStream ;
import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileOutputStream ;
import java.io.InputStream ;
import java.net.URL ;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder ;
import sun.misc.BASE64Encoder ;
import java.awt.*;


/**
 * The <b>Base64Codec</b> class is a <i>convenience</i> class providing functionality for Base64 encoding and
 * decoding of information.  According to Wikipedia [http://en.wikipedia.org/wiki/Base64], <font face="courier new">
 * <b>Base64</b> is a group of encoding schemes that represent binary data in an ASCII string format by translating
 * it into a radix-64 representation. The Base64 term originates from a specific MIME content transfer encoding.
 * </font> <p>
 * This particular codec is based on the proprietary Sun classes <font face="courier new">
 * sun.misc.BASE64Encoder/Decoder</font>. Users of these classes are warned that as proprietary classes, their
 * content cannot be assured as compatible with new releases of the SDK.  These classes were chosen because they
 * are available within the SDK (no third-party classes needed) and having been available since version 1.4, it
 * is unlikely that Sun would change the meaning of what could be volumes of its own code by changing
 * the classes.  However, if issues are encountered, the Apache classes can be substituted.
 * <p>
 * All methods of this class are static meaning that all methods can be used without proper instantiation of an
 * object of the type Base64Codec.
 *
 * @author R.L. E C K M A N
 * @version 1.0
 */
public class Base64Codec {

  /**
   * Default constructor - does nothing
   */
   public Base64Codec() {}

   /**
    * Decodes the <font face="courier new">encodedString</font> into the file <font face="courier new">file</font>.
    * @param fileName name of file to create into which the decoded information will be placed
    * @param encodedString string containing Base64 encoded information
    */
   public static void decode(String fileName, String encodedString) throws Base64CodecException {
   File               outputFile     =   null ;

      if ( (fileName != null) && (encodedString != null) ) {
         if ( (!fileName.isEmpty()) && (!encodedString.isEmpty()) )
            try {
               outputFile        =   new File(fileName) ;
               outputFile.createNewFile() ;
               decode(outputFile, encodedString) ;
            } catch (Exception e) {
               throw new Base64CodecException("Attempt to decode encoded string into file failed") ;
            }
      } else
        throw new Base64CodecException("Attempt to decode encoded string failed; illegal value passed as parameter") ;
   }

  /**
    * Decodes the <font face="courier new">encodedString</font> into the file <font face="courier new">file</font>.
    * @param file a Java file instance into which the decoded information will be placed.  File must exist
    * @param encodedString string containing Base64 encoded information
    * @throws Base64CodecException  
    */
   public static void decode(File file, String encodedString) throws Base64CodecException {
   BufferedImage           image          =   null ;
   ByteArrayInputStream    inputStream    =   null ;
   FileOutputStream        outputStream   =   null ;
   String                  fileType       =   null ;
   byte[]                  byteArray      =   null ;

      if ( (file != null) && (encodedString != null) ) {
         if ( (!encodedString.isEmpty()) && (file.isFile()) )
            try {
               byteArray         =   decode(encodedString) ;
               if ( isSupportedGraphicFileType(file.getName()) ) {
                  inputStream    =   new ByteArrayInputStream(byteArray) ;
                  image          =   ImageIO.read(inputStream) ;
                  fileType       =   returnFileType(file.getName()) ;
                  ImageIO.write(image, fileType, file) ;
               } else {
                  outputStream   =   new FileOutputStream(file) ;
                  outputStream.write(byteArray);
                  outputStream.flush() ;
                  outputStream.close() ;
               }
            } catch (Exception e) {
               throw new Base64CodecException("Attempt to decode encoded string failed") ;
            }
         else
            throw new Base64CodecException("Attempt to decode encoded string to file failed; file does not exist") ;
      } else
        throw new Base64CodecException("Attempt to decode encoded string to file failed; illegal value passed as parameter") ;
   }

  /**
    * Decodes the contents of <font face="courier new">file</font> returning a decoded byte array.
    * @param file whose contents will be decoded
    * @return encoded string
    */
   public static byte[] decode(File file) throws Base64CodecException {
   FileInputStream   inputStream      =   null ;
   String            decodedContent   =   null ;
   byte[]            byteArray        =   null ;
   int               bytesRead        =   0 ;

      if ( file != null ) {
         try {
            inputStream      =   new FileInputStream(file) ;
            byteArray        =   new byte[(int)file.length()] ;
            bytesRead        =   inputStream.read(byteArray) ;
            System.out.println("File length = " + file.length() + " bytes read = " + bytesRead) ;
            byteArray        =   decode(byteArray.toString()) ;
            
            inputStream.close() ; 
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode file contents failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode file contents failed; illegal value passed as parameter") ;

      return byteArray ;
   }
   
  /**
    * Decodes the <font face="courier new">encodedString</font> returning a byte array that should represented the
    * original encoded information.
    * @param encodedString string containing Base64 encoded information
    * @return unencoded information
    * @throws Base64CodecException  
    */
   public static byte[] decode(String encodedString) throws Base64CodecException {
   BASE64Decoder   decoder         =   null ;
   byte[]          decodedString   =   null ;

      if ( (encodedString != null) && (!encodedString.isEmpty()) ) {
         try {
            decoder              =   new sun.misc.BASE64Decoder() ;
            decodedString        =   decoder.decodeBuffer(encodedString) ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to decode encoded string failed") ;
         }
      }  else
         throw new Base64CodecException("Attempt to decode encoded string failed; illegal value passed as parameter") ;

      return decodedString ;
   }

  /**
    * Decodes the <font face="courier new">encodedString</font> returning a byte array that should represented the
    * original encoded information.
    * @param encodedString string containing Base64 encoded information
    * @return unencoded information
    */
   public static void decode(BufferedImage image, String encodedString) throws Base64CodecException {
   ByteArrayInputStream    inputStream    =   null ;
   byte[]                  byteArray      =   null ;

      if ( (encodedString != null) ) {
         if ( (!encodedString.isEmpty()) )
            try {
               byteArray         =   decode(encodedString) ;
               inputStream       =   new ByteArrayInputStream(byteArray) ;
               image             =   ImageIO.read(inputStream) ;
            } catch (Exception e) {
               throw new Base64CodecException("Attempt to decode encoded string failed") ;
            }
         else
            throw new Base64CodecException("Attempt to decode encoded string to file failed; file does not exist") ;
      } else
        throw new Base64CodecException("Attempt to decode encoded string to file failed; illegal value passed as parameter") ;
   }
   
  /**
    * Encodes the <font face="courier new">byteArray</font> returning an encoded String of information.
    * @param byteArray byteArray to be encoded
    * @return encoded string
    */
   public static String encode(byte[] byteArray) throws Base64CodecException {
   BASE64Encoder   encoder         =   null ;
   String          encodedString   =   null ;

      if ( (byteArray != null) && (byteArray.length > 0 ) ) {
         try {
            encoder              =   new sun.misc.BASE64Encoder() ;
            encodedString        =   encoder.encode(byteArray) ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode byte[] variable failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode byte[] variable failed; illegal value passed as parameter") ;

      return encodedString ;
   }

  /**
    * Encodes the contents of <font face="courier new">file</font> returning an encoded String of information.
    * @param file whose contents will be encoded
    * @return encoded string
    */
   public static String encode(File file) throws Base64CodecException {
   FileInputStream   inputStream      =   null ;
   String            encodedContent   =   null ;
   //byte[]            byteArray        =   null ;
   int               bytesRead        =   0 ;
   int               offset           =   0 ;

      if ( file != null ) {
         try {
            inputStream      =   new FileInputStream(file) ;
            encodedContent   =   encodeStream(inputStream, (int)file.length()) ;
            inputStream.close() ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode file contents failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode file contents failed; illegal value passed as parameter") ;

      return encodedContent ;
   }

  /**
    * Encodes the Image <font face="courier new">encodeThis</font> returning an encoded String of information.
    * @param encodeThis the string to be encoded
    * @param imageType type of image (jpg, png, gif)
    * @return encoded string
    */
   public static String encode(Image encodeThis, String imageType) throws Base64CodecException {
   BufferedImage           bufferedImage   =   null ;
   ByteArrayOutputStream   memoryStream    =   null ;
   String                  encodedString   =   null ;

      if ( (encodeThis != null) && (imageType != null) && (imageType.length() > 0) ) {
         try {
            bufferedImage      =   toBufferedImage(encodeThis, BufferedImage.TYPE_BYTE_BINARY) ;
            memoryStream       =   new ByteArrayOutputStream() ;
            ImageIO.write(bufferedImage, imageType, memoryStream) ;
            encodedString      =   encode(memoryStream.toByteArray()) ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode image failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode image failed; illegal value passed as parameter") ;

      return encodedString ;
   }

  /**
    * Encodes the string <font face="courier new">encodeThis</font> returning an encoded String of information.
    * @param encodeThis the string to be encoded
    * @return encoded string
    */
   public static String encode(String encodeThis) throws Base64CodecException {
   String   encodedString   =   null ;

      if ( encodeThis != null ) {
         try {
            encodedString   =   encode(encodeThis.getBytes()) ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode string failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode string failed; illegal value passed as parameter") ;

      return encodedString ;
   }

  /**
    * Encodes the URL<font face="courier new">encodeThis</font> returning an encoded String of information.
    * @param encodeThis URL to be encoded
    * @return encoded string
    * @throws Base64CodecException  
    */
   public static String encode(URL encodeThis) throws Base64CodecException {
   InputStream   inputStream         =   null ;
   String        encodedContent      =   null ;
   //byte[]        byteArray           =   null ;
   int           bytesRead           =   0 ;
   int           offset              =   0 ;

      if ( encodeThis != null ) {
         try {
            inputStream          =   encodeThis.openStream() ;
            encodedContent       =   encodeStream(inputStream, encodeThis.openConnection().getContentLength() ) ;
            inputStream.close() ;
         } catch (Exception e) {
            throw new Base64CodecException("Attempt to encode URL failed") ;
         }
      } else
         throw new Base64CodecException("Attempt to encode URL failed; illegal value passed as parameter") ;

      return encodedContent ;
   }

  /**
    * Encodes a stream of information having the length <font face="courier new">length</font> returning an encoded
    * String of information.
    * @param stream input stream of data to be encoded
    * @param length of stream being encoded
    * @return encoded string
    */
   private static String encodeStream(InputStream stream, int length) throws Base64CodecException {
   String        encodedContent      =   null ;
   byte[]        byteArray           =   null ;
   int           bytesRead           =   0 ;
   int           offset              =   0 ;

      if ( (stream != null) && (length > 0) ) {
         try {
            byteArray        =   new byte[ length ] ;

            while ( (offset < byteArray.length) && (bytesRead = stream.read(byteArray, offset, byteArray.length - offset)) >= 0 )  {
              offset        +=   bytesRead ;
            }

            encodedContent   =   encode(byteArray) ;
         } catch (Exception e) {
            throw new Base64CodecException("Internal error:  encodeStream failed.") ;
         }
      } else
         throw new Base64CodecException("Internal error: attempt to call encodeStream failed; illegal value passed as parameter") ;

      return encodedContent ;
   }

  /**
    * Returns if the extension of <font face="courier new">file</font> is one of the supported graphic types
    * of jpg, png, gif, or bmp.
    * @param file  file to check
    * @return true if file graphic type supported; otherwise, false
    */
   private static boolean isSupportedGraphicFileType(File file) {

       if ( file != null )
          return isSupportedGraphicFileType(file.getName()) ;

       return false ;
   }

  /**
    * Returns if the extension of <font face="courier new">fileName</font> is one of the supported graphic types
    * of jpg, png, gif, or bmp.
    * @param fileName  name of file to check
    * @return true if file graphic type supported; otherwise, false
    */
   private static boolean isSupportedGraphicFileType(String fileName) {
   String[]   supportedTypes      =   { ".png", ".jpg", ".gif", ".bmp" } ;
   boolean    returnValue         =   false ;

       if ( (fileName != null) && (fileName.length() >0) ) {
          for ( int i = 0 ; i < supportedTypes.length ; i++ )
             if ( fileName.toLowerCase().endsWith(supportedTypes[i]))
                returnValue   =   true ;
       }
      return returnValue ;
   }

  /**
    * Returns the extension of <font face="courier new">fileName</font>.
    * @param fileName  name of file
    * @return file extension of the file name or null if the file has no extension; otherwise, a null is
    * returned
    */
   protected static String returnFileType(File file) {

      if ( file != null )
         return returnFileType(file.getName()) ;

      return null ;
   }

  /**
    * Returns the extension of <font face="courier new">fileName</font>.
    * @param fileName  name of file
    * @return file extension of the file name or null if the file has no extension
    */
   protected static String returnFileType(String fileName) {
   String   fileType   =   null ;

      try {
         fileType   =   fileName.substring(fileName.indexOf(".") + 1);
      } catch (Exception e) {
         fileType   =   null ;
      }

      return   fileType ;
   }

  /**
    * Converts a Java instance of Image into a BufferedImage.
    * @param image  instance of Image that will be converted
    * @param imageType graphic image type (jpg, png, or gif) of the image
    * @return the converted buffered image
    */
   private static BufferedImage toBufferedImage(Image image, int imageType) throws Base64CodecException {
   BufferedImage           bufferedImage   =   null ;
   Graphics2D              graphics        =   null ;

      try {
         if ( image instanceof BufferedImage )
            bufferedImage   =   (BufferedImage)image ;
         else if ( image instanceof VolatileImage )
            bufferedImage   =   ((VolatileImage)image).getSnapshot() ;
         else {
            bufferedImage   =   new BufferedImage(image.getWidth(null), image.getHeight(null), imageType) ;
            graphics        =   bufferedImage.createGraphics() ;
            graphics.drawImage(image, null, null) ;
            graphics.dispose() ;
         }
      } catch (Exception e) {
         throw new Base64CodecException("Internal error: attempt to convert image to buffered image failed") ;
      }

      return bufferedImage ;
   }
   
}
