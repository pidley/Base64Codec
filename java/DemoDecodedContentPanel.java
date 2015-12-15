package org.codegaucho.pidley.Base64Codec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class DemoDecodedContentPanel extends JPanel {
private final String LABEL_TEXT   =   "Decoded content" ;

   DemoDecodedContentPanel() {

      super() ;
      try {
         setAttributes() ;
         addComponents() ;
         addListeners() ;
      } catch (Exception e) {
         throw new DemoException("DecodedContentPanel Instantiation Exception") ;
      }
   }
   
   private final void addComponents() {
 
      try {
         add(Box.createHorizontalGlue());
         add(Box.createRigidArea(new Dimension(0, 6)));
         add(createDecodedScrollPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));
         add(new DemoDecodedButtonPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));
      } catch (Exception e) {
         throw new DemoException("Cannot add panel components") ;
      }
   }
      
   private final void addListeners() {
       
   }
   
   private final JPanel createContentPanel() {
   JPanel contentPanel   =   null ;
   
      try {
         contentPanel   =   new JPanel() ;
         contentPanel.setName("DecodedContentPanel") ;
         contentPanel.setBackground(Color.WHITE) ;
      } catch (Exception e) {
         throw new DemoException("cannot create decodedcontentpanel") ;
      }
      
      return contentPanel ;
   }
   
   private final JScrollPane createScrollPane(JPanel contentPanel) {
   JScrollPane scrollPane   =   null ;
   
      try {
         scrollPane   =   new JScrollPane(contentPanel) ;
         scrollPane.setName("DecodedScrollPane") ;
      } catch (Exception e) {
         throw new DemoException("Cannot create decoded scroll pane") ;
      }
      
      return scrollPane ;
   }

   private final JPanel createScrollPanel(JScrollPane scrollPane) {
   JPanel scrollPanel   =   null ;
   
      try {
         scrollPanel   =   new JPanel() ;
         scrollPanel.setName("DecodedScrollPanel") ;
         scrollPanel.setLayout(new BorderLayout());
         scrollPanel.add(scrollPane, BorderLayout.CENTER);
      } catch (Exception e) {
         throw new DemoException("Cannot create decoded scroll pane") ;
      }
      
      return scrollPanel ;
   }
   
   private JPanel createDecodedScrollPanel() {
   JPanel        scrollPanel    =   null ;
   JPanel        contentPanel   =   null ;
   JScrollPane   scrollPane     =   null ;
   
      try {
         contentPanel   =   createContentPanel() ;
         scrollPane     =   createScrollPane(contentPanel) ;
         scrollPanel    =   createScrollPanel(scrollPane) ;
      } catch (Exception e) {
         throw new DemoException("Cannot create encoded content panel") ;
      }
      return scrollPanel ;
   }
   
   private final void setAttributes() {
       
      try {
         setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)) ;
         setBorder(BorderFactory.createTitledBorder(LABEL_TEXT)) ;
      } catch (Exception e) {
         throw new DemoException("Cannot set attributes") ;
      }
   }
}
