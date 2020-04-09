
public abstract class CandleList
{
	protected CandleNode first;
	protected CandleNode last;
	protected int length;

	public CandleList()
	{
		first = new CandleNode(null);
		last = first;
		length = 0;
	}

	public void append(Candle n)
	{
		CandleNode newnode = new CandleNode(n);
		last.next = newnode;
		last = newnode;
		length++;
	}

}
