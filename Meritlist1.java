public class Meritlist
{

	HashMap <Candidate,Integer> meritlist;
	
	
	public void Meritlist()
	{
		meritlist = new HashMap<Candidate,Integer>();
	}
	
	public int rank(Candidate c1)
	{
		return meritlist.get(c1);
	}
	
	public void add(Candidate c1, Integer rank)
	{
		meritlist.put(c1,rank);	
	}
}
