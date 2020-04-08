import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CandleGUI extends JFrame
{

	public JTextArea unsortedCandles = new JTextArea();
	public JTextArea sortedCandles = new JTextArea();

	/**
	 * Constructor of CandleGUI append arrays to the JTextAreas
	 * 
	 * @param unsortedCandles2
	 *            the unsorted arrays
	 * @param sortedCandles2
	 *            the sorted arrays
	 * @param c
	 *            the amount of objects
	 */
	public CandleGUI()
	{		
	}
	
	private void showItems(UnsortedCandleList a, SortedCandleList b, int c)
	{
		CandleNode tempa = a.first.next;
		while (tempa != null)
		{
			unsortedCandles.append(tempa.candle.toString() + "\n");
			tempa = tempa.next;
		}
		CandleNode tempb = b.first.next;
		while (tempb != null)
		{
			sortedCandles.append(tempb.candle.toString() + "\n");
			tempb = tempb.next;
		}

		unsortedCandles.setEditable(false);
		sortedCandles.setEditable(false);
	}
	
	private void onOpenMenuClick()
	{
		String fileName="";
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) fileName=chooser.getSelectedFile().getAbsolutePath();
		else 
		{
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
			return;
		}
		
		UnsortedCandleList unsortedCandles = new UnsortedCandleList();
		SortedCandleList sortedCandles = new SortedCandleList();
		int count = 0;
		
		Scanner candleInput=null;
		try
		{
			candleInput = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e)
		{
			return;
		}
		while (candleInput.hasNextLine())
		{
			String line = candleInput.nextLine();
			if (line == null) break;

			StringTokenizer candleTokens = new StringTokenizer(line, ",");
			if (candleTokens.countTokens() == 3)
			{
				int h = Integer.parseInt(candleTokens.nextToken());
				int w = Integer.parseInt(candleTokens.nextToken());
				float p = Float.parseFloat(candleTokens.nextToken());
				Candle newCandle = new Candle(h, w, p);

				unsortedCandles.add(newCandle);
				sortedCandles.add(newCandle);
				count++;
			}
			else System.out.println("Incomplete candle's information: " + line);
		}
		candleInput.close();
		
		showItems(unsortedCandles, sortedCandles, count);
	}

	public class FileMenuHandler implements ActionListener
	{
		JFrame jframe;

		public FileMenuHandler(JFrame jf)
		{
			jframe = jf;
		}

		public void actionPerformed(ActionEvent event)
		{
			String menuName = event.getActionCommand();
			if (menuName.equals("Open")) onOpenMenuClick();
			else if (menuName.equals("Quit")) JOptionPane.showMessageDialog(null, "You clicked on Quit");
		}
	}

	// Display the contents of arrays of candles in GUI
	public void show()
	{
		JFrame frame = new JFrame("Candles");
		GridLayout layout = new GridLayout(1, 2);
		
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu=new JMenu("Menu");
		menuBar.add(menu);
		JMenuItem menuItem1=new JMenuItem("Open");
		menu.add(menuItem1);	
		menuItem1.addActionListener(new FileMenuHandler(frame));
		
		JMenuItem menuItem2=new JMenuItem("Quit");
		menu.add(menuItem2);	
		menuItem2.addActionListener(new FileMenuHandler(frame));
		
		frame.add(unsortedCandles);
		frame.add(sortedCandles);
		frame.setLayout(layout);
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack(); // use pack here will make the window very small
		frame.setVisible(true);
	}

	private void createFileMenu()
	{
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);

		item = new JMenuItem("Open"); // create Open...
		item.addActionListener(fmh);
		fileMenu.add(item); // make "open" to touch the file menu

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(fmh);
		fileMenu.add(item);
		setJMenuBar(menuBar); // set jfram
		menuBar.add(fileMenu);
	} // createMenu

	private void openFile()
	{
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) readSource(chooser.getSelectedFile());
		else JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	}

	private void readSource(File chosenFile)
	{
		String chosenFileName = chosenFile.getName();
		Scanner inFile=null;
		try
		{
			inFile = new Scanner(new File(chosenFileName));
		}
		catch (FileNotFoundException e)
		{
			return;
		}
		String ssn;
		int subscript = 0;
		Container myContentPane = this.getContentPane();
		TextArea myTextArea = new TextArea();
		TextArea mySubscripts = new TextArea();
		myContentPane.add(myTextArea, BorderLayout.EAST);
		myContentPane.add(mySubscripts, BorderLayout.WEST);

		while (inFile.hasNextLine())
		{
			ssn = inFile.nextLine();
			mySubscripts.append(Integer.toString(subscript++) + "\n");
			myTextArea.append(ssn + "\n");
		} // while
		// jframe.setVisible(true);
	}
}
