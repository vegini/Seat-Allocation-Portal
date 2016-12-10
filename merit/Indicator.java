import java.util.*;

public class Indicator
{
	ArrayList<Double> values;

	public Indicator()
	{
		values = new ArrayList<Double>();
	}

	public void add(Double value)
	{
		values.add(value);
	}

	public Integer size()
	{
		return values.size();
	}
}