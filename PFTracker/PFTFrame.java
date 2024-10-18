package PFTracker;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PFTFrame extends JFrame
{
   private ActorPanel[] panel;
   
   public PFTFrame()
   {
      super();
      setSize(1000, 600);
      setLayout(new GridLayout(14, 1));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      panel = new ActorPanel[12];
      for(int i = 0; i < panel.length; i++)
      {
         panel[i] = new ActorPanel();
         add(panel[i]);
      }
   }
}