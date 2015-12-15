package org.codegaucho.pidley.Base64Codec;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class DemoMenuFactory {

   DemoMenuFactory() { }
   
   static JMenu createMenu(String text) {
   JMenu   menu   =   null;
       
      if ( DemoResources.isTextValid(text) )
        try {
            menu   =   new JMenu(text);
            menu.setMnemonic(text.charAt(0));
         } catch(Exception e) {
            throw new Base64CodecException("GUI Menu cannot be created", e) ;
         }
      else
         throw new IllegalArgumentException();
      
      return menu;
   }
   
   static JMenuBar createMenuBar() {
   JMenuBar   menuBar   =   null;
   
      try {
         menuBar = new JMenuBar();
      } catch(Exception e) {
         throw new DemoException("GUI MenuBar cannot be created", e) ;
      }
      
      return menuBar;
   }
   
   static JMenuItem createMenuItem(String text) {
      JMenuItem menuItem = null;
       
      if ( DemoResources.isTextValid(text) )
         try{
            menuItem = new JMenuItem(text);
            menuItem.setMnemonic(text.charAt(0));
         } catch(Exception e) {
            throw new DemoException("GUI MenuItem cannot be created", e) ;
         } 
      else
         throw new IllegalArgumentException();
      
      return menuItem;
   }
}

