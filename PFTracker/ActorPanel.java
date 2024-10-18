package PFTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ActorPanel extends JPanel implements ComponentListener, ActionListener, DocumentListener
{
	private Actor actor;
   private JButton clearB;
   private JTextField nameF;
   private JTextField initF;
   private JCheckBox[] actionCB;
   private JCheckBox reactionCB;
   private JTextField notesF;
   private JPanel actionPanel;
   private boolean updateF;


	public Actor getActor(){return actor;}


	public void setActor(Actor a){actor = a; setFormFromActor();}


   public ActorPanel()
   {
      super();
      actor = new Actor();
      setLayout(null);
      updateF = true;
      
      clearB = new JButton("X");
      clearB.setFocusable(false);
      clearB.addActionListener(this);
      add(clearB);
      
      nameF = new JTextField("");
      nameF.getDocument().addDocumentListener(this);
      add(nameF);
      
      initF = new JTextField("");
      initF.getDocument().addDocumentListener(this);
      add(initF);
      
      actionCB = new JCheckBox[3];
      actionPanel = new JPanel();
      actionPanel.setLayout(new GridLayout(1, actionCB.length));
      for(int i = 0; i < actionCB.length; i++)
      {
         actionCB[i] = new JCheckBox();
         actionCB[i].setHorizontalAlignment(SwingConstants.CENTER);
         actionCB[i].setFocusable(false);
         actionCB[i].addActionListener(this);
         actionPanel.add(actionCB[i]);
      }
      add(actionPanel);
      
      reactionCB = new JCheckBox();
      reactionCB.setHorizontalAlignment(SwingConstants.CENTER);
      reactionCB.setFocusable(false);
      reactionCB.addActionListener(this);
      add(reactionCB);
      
      notesF = new JTextField("");
      notesF.getDocument().addDocumentListener(this);
      add(notesF);
      
      addComponentListener(this);
      
      setVisible(true);
      resizeComponents();
   }
   
   public int getInitiative()
   {
      int init = Actor.NULL_INIT;
      try
      {
         init = Integer.parseInt(initF.getText());
      }
      catch(Exception ex){}
      return init;
   }
   
   public int getActionsSpent()
   {
      int actions = 0;
      for(int i = 0; i < actionCB.length; i++)
         if(actionCB[i].isSelected())
            actions++;
      return actions;
   }
   
   public void setActorFromForm()
   {
       actor.setName(nameF.getText());
       actor.setInitiative(getInitiative());
       actor.setActionsSpent(getActionsSpent());
       actor.setReactionSpent(reactionCB.isSelected());
       actor.setNotes(notesF.getText());
   }
   
   private void setFormFromActor()
   {
      updateF = false;
      
      nameF.setText(actor.getName());
      initF.setText(actor.getInitiative() + "");
      for(int i = 0; i < actionCB.length; i++)
      {
         if(i < actor.getActionsSpent())
            actionCB[i].setSelected(true);
         else
            actionCB[i].setSelected(false);
      }
      reactionCB.setSelected(actor.isReactionSpent());
      notesF.setText(actor.getNotes());
      
      updateF = true;
   }
   
   public void resizeComponents()
   {
      int height = getHeight();
      int widthSegment = getWidth() / 15;
      int inset = 0;
      
      clearB.setSize(widthSegment, height);
      clearB.setLocation(widthSegment * 0, 0);
      
      nameF.setSize(widthSegment * 3, height);
      nameF.setLocation(widthSegment * 1, 0);
      
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
   
   public void actionPerformed(ActionEvent aeRef)
   {
      if(aeRef.getSource() == clearB)
      {
         actor = new Actor();
      }
      setActorFromForm();
   }
   public void changedUpdate(DocumentEvent e){setActorFromForm();}
   public void insertUpdate(DocumentEvent e){setActorFromForm();}
   public void removeUpdate(DocumentEvent e){setActorFromForm();}
}