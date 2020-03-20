import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project1
{
	public static Candle unsortedCandles[] = new Candle[100];
	public static Candle sortedCandles[] = new Candle[100];
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
				unsortedCandles[count] = new Candle(h, w, p);
				sortedCandles[count] = new Candle(h, w, p);
				count++;
			}
			else System.out.println("Incomplete candle's information: " + line);
		}

		sortedCandles = selectionSort(sortedCandles);// to sort candles in order
														// of price

		CandleGUI ca = new CandleGUI();
		ca.creatdAndShow(unsortedCandles, sortedCandles, count);
	}

	public static Candle[] selectionSort(Candle[] temp)
	{
		int i, j;
		if (temp.length == 0)
		{
			return temp;
		}
		for (i = 0; i < count; i++)
		{
			for (j = i + 1; j < count; j++)
			{
				if (temp[i].getPrice() > temp[j].getPrice())
				{
					Candle t = temp[j];
					temp[j] = temp[i];
					temp[i] = t;
				}
			}
		}
		return temp;
	}

}