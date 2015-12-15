package org.codegaucho.pidley.Base64Codec;

import java.awt.Color ;
import java.awt.Component;
import java.awt.Container;
import javax.swing.SwingUtilities ;

public class DemoResources {

   public static void disableComponent(Container container, String name) {
   Component component   =   null ;
   
      component   =   findComponent(container, name) ;
      component.setEnabled(false) ;
   }

   public static void enableComponent(Container container, String name) {
   Component component   =   null ;
   
      component   =   findComponent(container, name) ;
      component.setEnabled(true) ;
   }
   
   public static Component findComponent(Container container, String name) {
   Component[] componentCollection   =   null ;
   Component   component             =   null ;
       
      try {
         component   =   SwingUtilities.getRoot(container) ;
         component   =   findContainerComponent((Container)component, name) ;
      } catch (Exception e) {
         throw new Base64CodecException("cannot list components") ;
      }
      
      return component ;
   }
   
   private static Component findContainerComponent(Component component, String name) {
   Component[]   componentCollection   =   null ;
   Component     returnThis            =   null ;
   int           i                     =   0 ;
   
      if ( component.getName() != null) 
         if ( component.getName().equals(name) ) 
            returnThis   =   component ;
         
      if ( returnThis == null) 
         if ( component instanceof Container ) {
            componentCollection   =   ((Container)component).getComponents() ; 
            while ( (returnThis == null) && (i < componentCollection.length) ) {
               returnThis   =   findContainerComponent(componentCollection[i], name) ;
               i++ ;
            } 
         }
      
      return returnThis ;
   }

   public static final boolean isColorValid(Color color) {
   
      return ( (!isNull(color)) ? true : false  ) ;
   }
       
   public static final boolean isColorValid(int red, int green, int blue) {
   
      return ( (isColorComponentValid(red) && isColorComponentValid(green) && isColorComponentValid(blue)) ? true : false  ) ;
   }
   
   public static final boolean isColorComponentValid(int colorComponentValue) {
   
      return ( ((colorComponentValue >= 0) && (colorComponentValue <= 255)) ? true : false ) ;
   }
   
   public static final boolean isNull(Object object) {
       
      return ( (object == null) ? true : false ) ;
   }
   
   public static final boolean isTextValid(String text) {
   
      return ( (!isNull(text) && (!text.isEmpty()) ) ? true : false ) ;     
   }
   
   public static final boolean isTextValid(String text, int maximumLength) {
   
      return ( (isTextValid(text) && (text.length() <= maximumLength)) ? true : false ) ;
   }
   
   public static final boolean isTransparencyValid(int transparency) {
       
      return ( ((transparency >= 0) && (transparency <= 255)) ? true : false ) ;
   }
}
