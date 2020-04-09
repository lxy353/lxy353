
public class SortedCandleList extends CandleList
{
	public SortedCandleList()
	{
		super();
	}

	public void add(Candle c)
	{
		CandleNode newnode = new CandleNode(c);
		CandleNode a = first.next;

		if (a == null || c.getPrice() >= last.candle.getPrice())
		{
			append(c);
			return;
		}

		else if (c.getPrice() <= a.candle.getPrice())
		{
			newnode.next = a;
			first.next = newnode;
		}
		else
		{
			while (a != null)
			{
				if (a.candle.getPrice() <= c.getPrice() && a.next.candle.getPrice() >= c.getPrice())
				{
					newnode.next = a.next;
					a.next = newnode;
					break;
				}
				else
				{
					a = a.next;
				}
			}
		}
		length++;
	}
}