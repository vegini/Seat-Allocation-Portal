import java.util.*;
public class Sentence 
    {
        private String id;
        private String sent;
        ArrayList<String> country;
        ArrayList<Double> entities; 

        

        public Sentence(String sent_id,String sent_string)
        {
            id = sent_id;
            sent = sent_string;
            country = new ArrayList<String>();
            entities = new ArrayList<Double>();

        }

        
        public String get_string()
        {
            return sent;
        }
    

    }