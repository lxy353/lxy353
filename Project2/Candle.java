
public class Candle
{
	private int height;
	private int width;
	private float price;
	private boolean lit;

	public Candle(int height, int width, float price)
	{ // constructor
		super();
		this.height = height;
		this.width = width;
		this.price = price;
		this.lit = false;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public boolean isLit()
	{
		return lit;
	}

	public void setLit(boolean lit)
	{
		this.lit = lit;
	}

	public String toString()
	{ // using the toString method to get h w and p
		return height + "," + width + "," + price;
	}

}
