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
      setTitle("Pathfinder Tracker");
      
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
      for(int i = 0; i < ACTOR_ROWS; i++)
      {
         panel[i].newTurn();
      }
   }
   
   public void sort()
   {
      Vector<Actor> actorList = getSortedActorList();
      for(int i = 0; i < actorList.size(); i++)
      {
         panel[i].setActor(actorList.elementAt(i));
      }
   }
   
   public Vector<Actor> getSortedActorList()
   {
      Vector<Actor> listA = new Vector<Actor>();
      Vector<Actor> listB = new Vector<Actor>();
      for(int i = 0; i < ACTOR_ROWS; i++)
         listA.add(panel[i].getActor());
      while(listA.size() > 0)
      {
         int highestVal = listA.elementAt(0).getInitiative();
         int selectedIndex = 0;
         for(int i = 1; i < listA.size(); i++)
         {
            if(listA.elementAt(i).getInitiative() > highestVal)
            {
               highestVal = listA.elementAt(i).getInitiative();
               selectedIndex = i;
            }
         }
         listB.add(listA.elementAt(selectedIndex));
         listA.removeElementAt(selectedIndex);
      }
      return listB;
   }
   
   public static void main(String[] args)
   {
      PFTFrame frame = new PFTFrame();
   }
}