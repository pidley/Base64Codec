package org.codegaucho.pidley.Base64Codec ;

/**
 * The <b>Base64CodeException</b> class represents a generic Base64Codec exception.
 *
 * @author beckman
 * @version 1.0
 */
public class Base64CodecException extends RuntimeException {

  /**
   * Default constructor - Instantiates an exception with a default message
   */
   Base64CodecException() {

      super("An error has occurred during Base64Codec processing") ;
   }

 /**
   * Instantiates an exception with a user provided message
   */
   Base64CodecException(String errorMessage) {

      super(errorMessage) ;
   }

 /**
   * Instantiates an exception with a user provided message and cause
   */
   Base64CodecException(String errorMessage, Throwable cause) {

      super(errorMessage, cause) ;
   }

 /**
   * Instantiates an exception with a user provided cause
   */
   Base64CodecException(Throwable cause) {

      super(cause) ;
   }

}