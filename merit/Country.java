import java.util.*;
public class Country 
    {
        private String id;
        private String name;
        HashMap <String,Indicator> map;
        

        public Country(String country_id,String name_id)
        {
            id = country_id;
            name = name_id;
            map = new HashMap<String,Indicator>();
        }

        public String get_id()
        {
            return id;
        }

    

    }