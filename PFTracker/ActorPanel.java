package PFTracker;

import java.awt.*;
import javax.swing.*;

public class ActorPanel extends JPanel
{
	private Actor actor;
   private JTextField nameF;
   private JTextField initF;
   private JCheckBox[] actionCB;
   private JCheckBox reactionCB;
   private JTextField notesF;


	public Actor getActor(){return actor;}


	public void setActor(Actor a){actor = a;}


   public ActorPanel()
   {
      super();
   }
}