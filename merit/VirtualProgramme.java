import java.util.*;

public class VirtualProgramme
{
	private String name;
	private String code;
	private String category;
	private boolean PD_status;
	private int quota;
	ArrayList<Candidate> alloted;
	Meritlist merit;


	public VirtualProgramme()
	{
		alloted = new ArrayList<Candidate>();


	}

	public void set_category(String nm, String cd, String cat)
	{
		name = nm;
		code = cd;
		if (cat.equals("GE")) category = "GE";			
		else if (cat.equals("OBC")) category = "OBC";			
		else if (cat.equals("SC")) category = "SC";
		else if (cat.equals("ST")) category = "ST";
		else if (cat.equals("DS")) category = "DS";
		else if (cat.equals("F")) category = "F";
		else 
		{
			System.out.println("Invalid Category");
		}
	}

	public void set_quota(int quota1)
	{
		quota = quota1;
	}

	

	public void set_pd_status(String pd)
	{
		if (pd.equals("Y")) PD_status = true;
		else if (pd.equals("N")) PD_status = false;
		else 
		{
			System.out.println("Invalid PD status");
		}
	}

	public String get_code()
	{
		return code;
	}

	public String get_category()
	{
		return category;
	}

	public boolean get_pd_status()
	{
		return PD_status;
	}

	public void apply(Candidate c1)
	{
		if (alloted.size()<quota) alloted.add(c1);
		else
		{
			if(merit.rank(c1)<=merit.rank(alloted.get(alloted.size()-1)) && c1.get_category.equals(alloted.get(alloted.size()-1).get_category())) alloted.add(c1);
			else c1.rejected();
		} 


	}
	

	

}
