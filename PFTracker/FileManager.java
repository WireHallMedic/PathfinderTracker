package PFTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class FileManager
{
   public static final String FILE_NAME = "PathfinderTracker.dat";
   
   public static void save(ActorPanel[] panelList)
   {
      Vector<String> outputList = new Vector<String>();
      for(ActorPanel panel : panelList)
         outputList.add(panel.getActor().serialize());
      write(outputList);
   }
   
   public static Vector<String> load(ActorPanel[] panelList)
   {
      Vector<String> input = read();
      return input;
   }
   
	private static void write(Vector<String> output)
	{
		PrintWriter outFile = null;
		try
		{
			outFile = new PrintWriter(FILE_NAME);
		}
		catch(Exception ex)
		{
			String errorMessage = "Error: Cannot write to " + FILE_NAME;
			JOptionPane.showMessageDialog(null, errorMessage, "Exception Occured", JOptionPane.ERROR_MESSAGE);
		}
		
		for(String line : output)
			outFile.println(line);
			
		outFile.close();
	}


	private static Vector<String> read()
	{
		Scanner inFile = null;
      Vector<String> output = new Vector<String>();
		
		try
		{
			inFile = new Scanner(new FileReader(FILE_NAME));
		}
		catch(Exception ex)
		{
			String errorMessage = "Error: Cannot read from " + FILE_NAME;
			JOptionPane.showMessageDialog(null, errorMessage, "Exception Occured", JOptionPane.ERROR_MESSAGE);
         return output;
		}
		
		try
		{
			while(inFile.hasNext() == true)
			{
				output.add(inFile.nextLine());
			}
		}
		catch(ArrayIndexOutOfBoundsException arrEx){}

		inFile.close();
		
		return output;
	}
}