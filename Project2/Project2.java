import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project2
{

	public static UnsortedCandleList unsortedCandles = new UnsortedCandleList();
	public static SortedCandleList sortedCandles = new SortedCandleList();
	public static int count = 0;

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner candleInput = new Scanner(new File("input.txt"));
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
				Candle newCandle = new Candle(h,w,p);
				
				unsortedCandles.add(newCandle);
				sortedCandles.add(newCandle);
				count++;
			}
			else System.out.println("Incomplete candle's information: " + line);
		}

	
		CandleGUI gui = new CandleGUI(unsortedCandles, sortedCandles, count);
		gui.show();
		{
			candleInput.close();
		}
}
}