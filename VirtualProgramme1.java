import java.util.*;

public class VirtualProgramme
{
	private String name;
	private String code;
	private String category;
	private boolean PD_status;
	private int quota;
	ArrayList<Candidate> waitlist_filtered;


	public VirtualProgramme()
	{
		waitlist_filtered = new ArrayList<Candidate>();


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
		if (current_waitlist.size()<quota) current_waitlist.add(c1);
		else if (current_waitlist.size()==quota) 

	}
	public void apply(Candidate c1)
	{
		if(c1.waitlist_index()==-1){

		if(category.equals("DS"))
		{
			if(c1.get_ds_eligibility()==true) applications.add(c1);
		}


		if (category.equals("GE"))
		{
			if (meritlist.containsKey(c1)) applications.add(c1);
		}


		if (category.equals("OBC"))
		{
			
			if(c1.get_category().equals("OBC")) 
			{
				if (meritlist.containsKey(c1)) applications.add(c1);
			}

			else applications.add(c1);


		}

		if (category.equals("SC"))
		{
			
			if(c1.get_category().equals("SC") && (meritlist.containsKey(c1))) 
			{
				applications.add(c1);
			}
			
		}

		if (category.equals("ST"))
		{
			
			if(c1.get_category().equals("ST") && (meritlist.containsKey(c1))) 
			{
				applications.add(c1);
			}
			
		}

		if (PD_status==true)
		{
			if (category.equals("GE"))
			{
				if (meritlist.containsKey(c1)) applications.add(c1);
			}


			if (category.equals("OBC"))
			{
			
				if(c1.get_category().equals("OBC")) 
				{
					if (meritlist.containsKey(c1)) applications.add(c1);
				}

				else applications.add(c1);

			}

			if (category.equals("SC"))
			{
			
				if(c1.get_category().equals("SC") && (meritlist.containsKey(c1)) ) 
				{
					applications.add(c1);
				}
			
			}

			if (category.equals("ST"))
			{
			
				if(c1.get_category().equals("ST") && (meritlist.containsKey(c1)) ) 
				{
					applications.add(c1);
				}
			
			}
		}

	}

	}

	public void filter()
	{
		for(int i=0;i<applications.size();i++)
		{
			boolean filled = false;
			int rank = meritlist.rank(waitlist_filtered.get(i));
			for(int j=0; j<waitlist_filtered.size();j++)
			{
				
				int rank1 = meritlist.rank(waitlist_filtered.get(j));

				if(rank<rank1)
				{
					filled = true;
					waitlist_filtered.add(applications.get(i));
				}


			}

			if(filled==false)
			{
				waitlist_filtered.add(applications.get(i));
			}
		}

		int rank_last = meritlist.rank(waitlist_filtered.get(quota-1));

		for(int k=quota;k<waitlist_filtered.size();k++)
		{
			if(meritlist.rank(waitlist_filtered.get(k))>rank_last) 
			{
				waitlist_filtered.remove(k);
				waitlist_filtered.get(k).rejected();
			}
		}

		applications.clear();

	}

}
