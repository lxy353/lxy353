import java.awt.GridLayout;

import javax.swing.*;

public class CandleGUI
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
	public CandleGUI(UnsortedCandleList a, SortedCandleList b, int c)
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

	// Display the contents of arrays of candles in GUI
	public void show()
	{
		JFrame frame = new JFrame("Candles");
		GridLayout layout = new GridLayout(1, 2);
		frame.add(unsortedCandles);
		frame.add(sortedCandles);
		frame.setLayout(layout);
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // Display the window.
		frame.setVisible(true);
	}

}