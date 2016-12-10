import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.*;

public class Mapping{

		static HashMap <String,String> map;
		static HashMap <String,Country> countries;
		


	public Mapping()
	{
		map = new HashMap<String,String>();
		countries = new HashMap<String,Country>();
		try
        {
        	Scanner sc = new Scanner(new File("/Users/apple/Downloads/CS_251/merit/countries_id_map.txt"));
         	

         	
        
        while(sc.hasNextLine())
        { 
        	String s;          
            s = sc.nextLine();
            Scanner scan = new Scanner(s);
            scan.useDelimiter("\t");

            while(scan.hasNext())
            {
                String i = scan.next();
                String c = scan.next();

                map.put(c,i);
                countries.put(i,new Country(i,c));
                               
            }            
        }

        //System.out.println(map.size());

        } catch (IOException e)
			{
				System.out.println(e);
				
			}	


		try
        {
        	Scanner sc = new Scanner(new File("/Users/apple/Downloads/CS_251/merit/kb-facts-train_SI.tsv"));
         	

         	
        
        while(sc.hasNextLine())
        { 
        	String s;          
            s = sc.nextLine();
            Scanner scan = new Scanner(s);
            scan.useDelimiter("\t");

            while(scan.hasNext())
            {
                String id = scan.next();
                Double value = scan.nextDouble();
                String ind = scan.next();

                if(countries.get(id).map.containsKey(ind))
                {
                	countries.get(id).map.get(ind).add(value);
                }

                else
                {
                	Indicator a = new Indicator();
                	a.add(value);
                	countries.get(id).map.put(ind,a);
                	
                }
                               
            }            
        }



        } catch (IOException e)
			{
				System.out.println(e);
				
			}				
	}

	public static void main(String[] args)
	{
		Mapping a = new Mapping();
		//System.out.println(countries.get("/m/05qhw").map.get("NY.GDP.MKTP.CD").size());


		try{

		Scanner sc = new Scanner(new File("/Users/apple/Downloads/CS_251/merit/sentences.tsv"));
		sc.useDelimiter("\n");

		
		while (sc.hasNext())
		{
			String s = sc.next();
			Scanner s1 = new Scanner(s);
			s1.useDelimiter("\t");



			while(s1.hasNext())
			{
				String s_id = s1.next();
				String s_sent = s1.next();
				String entities = s1.next();
				String countries1 = s1.next();

				


				Sentence a1 = new Sentence(s_id,s_sent);

				//System.out.println(a1.get_string());

				Scanner s2 = new Scanner(entities);
				s2.useDelimiter(", ");

				//System.out.println(s2.next());

				while(s2.hasNext())
				{
					Double ent = s2.nextDouble();
					a1.entities.add(ent);
					//System.out.println(ent);
				}

				Scanner s3 = new Scanner(countries1);
				s3.useDelimiter(" , ");

				

				while(s3.hasNext())
				{
					String t = s3.next();
					a1.country.add(t);
					//System.out.println(t);
					
				}

				try
				{


					File file = new File("/Users/apple/Downloads/CS_251/merit/output.txt");
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);

				for(int i=0;i<a1.country.size();i++)
				{
					for(int j=0;j<a1.entities.size();j++)
					{
						Double lower_range = a1.entities.get(j)-(a1.entities.get(j)*0.15);
						Double higher_range = a1.entities.get(j)+(a1.entities.get(j)*0.15);

						if(a.map.containsKey(a1.country.get(i)))
						{
						
						Set x1 = a.countries.get(a.map.get(a1.country.get(i))).map.keySet();
						Iterator<String> x = x1.iterator();
						//System.out.println(x1);
						
						//x.getClass().getName();
						//x.getClass().getName();
						while(x.hasNext())
						{
							String gh = x.next();
							ListIterator<Double> it = a.countries.get(a.map.get(a1.country.get(i))).map.get(gh).values.listIterator();


							Double count = 0.0;
							while (it.hasNext())
							{
								Double val = it.next();
								if (val<=higher_range && val>=lower_range)
								{
									count++;
								}
							}

							Double r = count/a.countries.get(a.map.get(a1.country.get(i))).map.get(gh).size();

							Double confidance_score = r*100.0;


								String content = "";

								if(confidance_score != 0.00) 
								{
									content = s_id+"\t"+a1.country.get(i)+"\t"+gh+"\t"+a1.entities.get(j)+"\t"+confidance_score;
									System.out.println(content);
									bw.write(content);
									bw.newLine();
								}	 

								

							
						}

						}


					}
				}

				bw.close();

			} catch (IOException e){
					System.out.println(e);
				}



			}
		}

	} catch (IOException e)
			{
				System.out.println(e);
				
			}	

		
	}



}

