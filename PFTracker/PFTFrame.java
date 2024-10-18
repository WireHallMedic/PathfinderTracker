package PFTracker;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PFTFrame extends JFrame
{
   private ActorPanel[] panel;
   private LabelPanel labelPanel;
   private JPanel buttonPanel;
   
   public PFTFrame()
   {
      super();
      setSize(1600, 800);
      setLayout(new GridLayout(14, 1));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      labelPanel = new LabelPanel();
      add(labelPanel);
      
      panel = new ActorPanel[12];
      for(int i = 0; i < panel.length; i++)
      {
         panel[i] = new ActorPanel();
         add(panel[i]);
      }
      
      setVisible(true);
   }
   
   public static void main(String[] args)
   {
      PFTFrame frame = new PFTFrame();
   }
}