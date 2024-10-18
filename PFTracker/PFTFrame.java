package PFTracker;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PFTFrame extends JFrame
{
   private ActorPanel[] panel;
   private LabelPanel labelPanel;
   private ButtonPanel buttonPanel;
   private static final int ACTOR_ROWS = 12;
   
   public PFTFrame()
   {
      super();
      setSize(1600, 800);
      setLayout(new GridLayout(ACTOR_ROWS + 2, 1));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      labelPanel = new LabelPanel();
      add(labelPanel);
      
      panel = new ActorPanel[ACTOR_ROWS];
      for(int i = 0; i < ACTOR_ROWS; i++)
      {
         panel[i] = new ActorPanel();
         add(panel[i]);
      }
      
      buttonPanel = new ButtonPanel(this);
      add(buttonPanel);
      
      setVisible(true);
   }
   
   public void newTurn()
   {
   
   }
   
   public void sort()
   {
   
   }
   
   public static void main(String[] args)
   {
      PFTFrame frame = new PFTFrame();
   }
}