package PFTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class FileManager
{
   public static final String FILE_NAME = "FateTracker.dat";
   
	public static void write(Vector<String> output)
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


	public static Vector<String> read()
	{
	/*		
		Scanner inFile = null;
      String[] output = new String[TOTAL_LINES];
		
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
		   int index = 0;
			while(inFile.hasNext() == true)
			{
				output[index] = inFile.nextLine();
				index++;
			}
		}
		catch(ArrayIndexOutOfBoundsException arrEx){}

		inFile.close();
		
		return output;*/
      return null;
	}
}