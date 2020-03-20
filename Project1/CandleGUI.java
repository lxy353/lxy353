import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

public class CandleGUI
{
	public void creatdAndShow(Candle[] unsorted, Candle[] sorted, int count)
	{ // set the window what can we see
		// Create and set up the window.
		JFrame frame = new JFrame("Candles");
		GridLayout layout = new GridLayout(1, 2);
		TextArea myTextArea = new TextArea("unsorted" + "\n");
		TextArea mySubscripts = new TextArea("sorted" + "\n");
		for (int i = 0; i < count; i++)
		{
			myTextArea.append(unsorted[i].toString());
		}
		for (int i = 0; i < count; i++)
		{
			mySubscripts.append(sorted[i].toString());
		}
		Container con = frame.getContentPane();
		con.add(myTextArea);
		con.add(mySubscripts);
		frame.setLayout(layout);
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // Display the window.
		frame.setVisible(true);
	}

}
