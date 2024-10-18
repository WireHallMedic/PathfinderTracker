package PFTracker;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActorPanel extends JPanel implements ComponentListener
{
	private Actor actor;
   private JTextField nameF;
   private JTextField initF;
   private JCheckBox[] actionCB;
   private JCheckBox reactionCB;
   private JTextField notesF;
   private JPanel actionPanel;


	public Actor getActor(){return actor;}


	public void setActor(Actor a){actor = a;}


   public ActorPanel()
   {
      super();
      actor = new Actor();
      setLayout(null);
      
      nameF = new JTextField("");
      add(nameF);
      
      initF = new JTextField("");
      add(initF);
      
      actionCB = new JCheckBox[3];
      actionPanel = new JPanel();
      actionPanel.setLayout(new GridLayout(1, actionCB.length));
      for(int i = 0; i < actionCB.length; i++)
      {
         actionCB[i] = new JCheckBox();
         actionPanel.add(actionCB[i]);
      }
      add(actionPanel);
      
      reactionCB = new JCheckBox();
      reactionCB.setHorizontalAlignment(SwingConstants.CENTER);
      add(reactionCB);
      
      notesF = new JTextField("");
      add(notesF);
      
      addComponentListener(this);
      
      setVisible(true);
      resizeComponents();
   }
   
   public void resizeComponents()
   {
      int height = getHeight();
      int widthSegment = getWidth() / 15;
      int inset = 0;
      
      nameF.setSize(widthSegment * 4, height);
      nameF.setLocation(widthSegment * 0, 0);
      
      initF.setSize(widthSegment, height);
      initF.setLocation(widthSegment * 4, 0);
      
      actionPanel.setSize(widthSegment, height);
      actionPanel.setLocation(widthSegment * 5, 0);
      
      reactionCB.setSize(widthSegment, height);
      reactionCB.setLocation(widthSegment * 6, 0);
      
      notesF.setSize(widthSegment * 8, height);
      notesF.setLocation(widthSegment * 7, 0);
      repaint();
   }
   
   // update metrics when resized
   public void componentResized(ComponentEvent ce){resizeComponents();}
   public void componentMoved(ComponentEvent ce){}
   public void componentHidden(ComponentEvent ce){}
   public void componentShown(ComponentEvent ce){repaint();}
}