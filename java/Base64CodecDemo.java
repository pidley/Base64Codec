package org.codegaucho.pidley.Base64Codec ;

import java.awt.BorderLayout ;
import java.awt.Color ;
import java.awt.Component ;
import java.awt.Container ;
import java.awt.Dimension ;
import java.awt.Toolkit;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.event.WindowEvent ;
import java.awt.event.WindowListener ;
import javax.swing.Box ;
import javax.swing.BoxLayout;
import javax.swing.JFrame ;
import javax.swing.JMenu ;
import javax.swing.JMenuBar ;
import javax.swing.JMenuItem ;
import javax.swing.JPanel ;
import javax.swing.JOptionPane ;
import javax.swing.JTabbedPane ;

class MenuFileExitActionListener implements ActionListener {
 
   @Override
   public void actionPerformed(ActionEvent e) {
       
      System.exit(0) ;
   }
}

class MenuHelpAboutActionListener implements ActionListener {
    
   @Override
   public void actionPerformed(ActionEvent e) {
      
      JOptionPane.showMessageDialog(null, "Version 1.0") ;
   }
}

class Base64GUI extends JFrame {
    
   private class Base64CodecDemoWindowListener implements WindowListener {
      @Override public void windowActivated (WindowEvent e) { }
      @Override public void windowClosed (WindowEvent e) { }
      @Override 
      public void windowClosing (WindowEvent e) {
       
         System.exit(0) ;
      }
      @Override public void windowDeactivated (WindowEvent e) { }
      @Override public void windowDeiconified (WindowEvent e) { }
      @Override public void windowIconified (WindowEvent e) { }
      @Override public void windowOpened (WindowEvent e) { }
   }
   
   Base64GUI() {
       
      createGUI() ;
   }
   
   private JMenuItem createFileExitMenuItem() {
   JMenuItem   menuItem   =   null ;
   
      try {
         menuItem   =   DemoMenuFactory.createMenuItem("Exit") ;
         menuItem.addActionListener(new MenuFileExitActionListener()) ;
         menuItem.setMnemonic('x') ;
      } catch (Exception e) {
         throw new DemoException("File Exit not created.", e) ; 
      }
      
      return menuItem ;
   }
   
   private JMenu createFileMenu() {
   JMenu menu   =   null ;
   
      try {
         menu   =   DemoMenuFactory.createMenu("File") ;
         menu.add(createFileExitMenuItem()) ;
      } catch (Exception e) {
         throw new DemoException("File menu not created", e) ;
      }
       
      return menu ;
   }

   private JMenu createHelpMenu() {
   JMenu   menu   =   null ;
   
      try {
         menu   =   DemoMenuFactory.createMenu("Help") ;
         menu.add(createHelpAboutMenuItem()) ;
      } catch (Exception e) {
         throw new DemoException("File menu not created", e) ;
      }
       
      return menu ;
   }
   
   private JMenuItem createHelpAboutMenuItem() {
   JMenuItem   menuItem   =   null ;
   
      try {
         menuItem   =   DemoMenuFactory.createMenuItem("About") ;
         menuItem.addActionListener(new MenuHelpAboutActionListener()) ;
      } catch (Exception e) {
         throw new DemoException("File Exit not created", e) ; 
      }
      
      return menuItem ;
   }

   private final JPanel createDecodePanel() {
   JPanel panel   =   null ;
   
      panel   =   new JPanel() ;
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)) ;
      panel.add(Box.createRigidArea(new Dimension(0, 6)))  ;
      panel.add(new DemoDecodeQueryPanel()) ;
      panel.add(Box.createRigidArea(new Dimension(0, 6))) ;
      panel.add(new DemoDecodedContentPanel()) ;
      
      return panel ;
   }
   
   
   private final JPanel createEncodePanel() {
   JPanel panel   =   null ;
   
      panel   =   new JPanel() ;
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)) ;
      panel.add(Box.createRigidArea(new Dimension(0, 6)))  ;
      panel.add(new DemoEncodeQueryPanel()) ;
      panel.add(Box.createRigidArea(new Dimension(0, 6))) ;
      panel.add(new DemoEncodedContentPanel()) ;
      
      return panel ;
   }
   
   private final void createGUI() {
   JTabbedPane tabbedPane   =   null ;
   
      try {
         setAttributes() ;
         setListeners() ;
         setMenu() ;
         setName("Frame") ;
         tabbedPane   =   new JTabbedPane() ;
         tabbedPane.addTab("Encode", createEncodePanel()) ;
         tabbedPane.addTab("Decode", createDecodePanel()) ;
         add(tabbedPane) ;
         setVisible(true) ;
      } catch (Exception e) {
         throw new DemoException("GUI not created", e) ;
      }
   }
   
   private void setAttributes() {

      try {   
         getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)) ;
         setSize(600, 690) ;
         setTitle("Base64Codec Demonstration") ;
         //pack() ;
         //setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2,(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
         
      } catch (Exception e) {
         throw new DemoException("GUI Attributes cannot be set", e) ;
      } 
   }
   
   private void setListeners() {

      try {
         addWindowListener(new Base64CodecDemoWindowListener()) ;
      } catch (Exception e) {
         throw new DemoException("GUI Listeners cannot be set", e) ;
      }
   }
   
   private void setMenu() {
   JMenuBar menuBar    =   null ;
   
      try {
         menuBar    =   DemoMenuFactory.createMenuBar() ;
         menuBar.add(createFileMenu()) ;
         menuBar.add(createHelpMenu()); 
         getRootPane().setJMenuBar(menuBar) ;
      } catch (Exception e) {
         throw new DemoException("Error in GUI setMenu()", e) ;
      }
   }
}

public class Base64CodecDemo {
    
   public static void main(String[] args) {
   Base64GUI base64GUI   =   null ;
   
      try {
         base64GUI   =   new Base64GUI() ;
      } catch (Exception e) {
          
      }
   
   }
}
