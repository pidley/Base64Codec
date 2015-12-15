package org.codegaucho.pidley.Base64Codec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class DemoEncodedContentPanel extends JPanel {
private final String LABEL_TEXT   =   "Encoded content" ;

   DemoEncodedContentPanel() {

      super() ;
      try {
         setAttributes() ;
         addComponents() ;
         addListeners() ;
      } catch (Exception e) {
         throw new Base64CodecException("EncodedContentPanel Instantiation Exception") ;
      }
   }
   
   private final void addComponents() {
 
      try {
         add(Box.createHorizontalGlue());
         add(Box.createRigidArea(new Dimension(0, 6)));
         add(createEncodedScrollPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));
         add(new DemoEncodedButtonPanel()) ;
         add(Box.createRigidArea(new Dimension(0, 6)));
      } catch (Exception e) {
         throw new Base64CodecException("Cannot add panel components") ;
      }
   }
      
   private final void addListeners() {
       
   }
   
   private final JPanel createContentPanel() {
   JPanel contentPanel   =   null ;
   
      try {
         contentPanel   =   new JPanel() ;
         contentPanel.setName("EncodedContentPanel") ;
         contentPanel.setBackground(Color.WHITE) ;
      } catch (Exception e) {
         throw new Base64CodecException("cannot create encodedcontentpanel") ;
      }
      
      return contentPanel ;
   }
   
   private final JScrollPane createScrollPane(JPanel contentPanel) {
   JScrollPane scrollPane   =   null ;
   
      try {
         scrollPane   =   new JScrollPane(contentPanel) ;
         scrollPane.setName("EncodedScrollPane") ;
      } catch (Exception e) {
         throw new Base64CodecException("Cannot create encoded scroll pane") ;
      }
      
      return scrollPane ;
   }

   private final JPanel createScrollPanel(JScrollPane scrollPane) {
   JPanel scrollPanel   =   null ;
   
      try {
         scrollPanel   =   new JPanel() ;
         scrollPanel.setName("EncodedScrollPanel") ;
         scrollPanel.setLayout(new BorderLayout());
         scrollPanel.add(scrollPane, BorderLayout.CENTER);
      } catch (Exception e) {
         throw new Base64CodecException("Cannot create encoded scroll pane") ;
      }
      
      return scrollPanel ;
   }
   
   private JPanel createEncodedScrollPanel() {
   JPanel        encodedScrollPanel    =   null ;
   JPanel        encodedContentPanel   =   null ;
   JScrollPane   encodedScrollPane     =   null ;
   
      try {
         encodedContentPanel   =   createContentPanel() ;
         encodedScrollPane     =   createScrollPane(encodedContentPanel) ;
         encodedScrollPanel    =   createScrollPanel(encodedScrollPane) ;
      } catch (Exception e) {
         throw new Base64CodecException("Cannot create encoded content panel") ;
      }
      return encodedScrollPanel ;
   }
   
   private final void setAttributes() {
       
      try {
         setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)) ;
         setBorder(BorderFactory.createTitledBorder(LABEL_TEXT)) ;
      } catch (Exception e) {
         throw new Base64CodecException("Cannot set attributes") ;
      }
   }
}
