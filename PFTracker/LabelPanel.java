package PFTracker;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelPanel extends JPanel implements ComponentListener
{
   private JLabel nameL;
   private JLabel initL;
   private JLabel actionsL;
   private JLabel reactionL;
   private JLabel notesL;



   public LabelPanel()
   {
      super();
      setLayout(null);
      
      nameL = new JLabel("Name", SwingConstants.CENTER);
      add(nameL);
      
      initL = new JLabel("Init", SwingConstants.CENTER);
      add(initL);
      
      actionsL = new JLabel("Actions", SwingConstants.CENTER);
      add(actionsL);
      
      reactionL = new JLabel("Reaction", SwingConstants.CENTER);
      add(reactionL);
      
      notesL = new JLabel("Notes", SwingConstants.CENTER);
      add(notesL);
      
      addComponentListener(this);
      
      setVisible(true);
      resizeComponents();
   }
   
   public Font getFont()
   {
      return new Font(new JTextField().getFont().getFontName(), Font.PLAIN, getHeight() / 3);
   }
   
   public void resizeComponents()
   {
      int height = getHeight();
      int widthSegment = getWidth() / 15;
      int inset = 0;
      Font newFont = getFont();
      
      nameL.setSize(widthSegment * 4, height);
      nameL.setLocation(widthSegment * 0, 0);
      nameL.setFont(newFont);
      
      initL.setSize(widthSegment, height);
      initL.setLocation(widthSegment * 4, 0);
      initL.setFont(newFont);
      
      actionsL.setSize(widthSegment, height);
      actionsL.setLocation(widthSegment * 5, 0);
      actionsL.setFont(newFont);
      
      reactionL.setSize(widthSegment, height);
      reactionL.setLocation(widthSegment * 6, 0);
      reactionL.setFont(newFont);
      
      notesL.setSize(widthSegment * 8, height);
      notesL.setLocation(widthSegment * 7, 0);
      notesL.setFont(newFont);
      repaint();
   }
   
   // update metrics when resized
   public void componentResized(ComponentEvent ce){resizeComponents();}
   public void componentMoved(ComponentEvent ce){}
   public void componentHidden(ComponentEvent ce){}
   public void componentShown(ComponentEvent ce){repaint();}
}