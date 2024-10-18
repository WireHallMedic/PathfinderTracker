package PFTracker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener
{
   private JButton clearB;
   private JButton sortB;
   private JButton saveB;
   private JButton loadB;
   private PFTFrame parent;
   
   public ButtonPanel(PFTFrame p)
   {
      super();
      parent = p;
      setLayout(new GridLayout(1, 5));
      
      clearB = new JButton("Clear Actions");
      clearB.addActionListener(this);
      add(clearB);
      
      sortB = new JButton("Sort");
      sortB.addActionListener(this);
      add(sortB);
      
      add(new JPanel());
      
      saveB = new JButton("Save");
      saveB.addActionListener(this);
      add(saveB);
      
      loadB = new JButton("Load");
      loadB.addActionListener(this);
      add(loadB);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == clearB)
         parent.newTurn();
      else if(ae.getSource() == sortB)
         parent.sort();
      else if(ae.getSource() == saveB)
         parent.save();
      else if(ae.getSource() == loadB)
         parent.load();
   }
}