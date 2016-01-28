package LambdaOverMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class FrameworkForHashMap {
    private Map<String, Integer> nameAgeMap;

    public FrameworkForHashMap() {
        nameAgeMap = new HashMap<String, Integer>() {{
            put("Aniruddha", 23);
            put("Balajee", 23);
            put("Vaijnath", 21);
            put("Khote", 23);
            put("Akanksha", 23);
            put("Brajesh", 24);
            put("Kundan Singh", 25);
            put("Amarendra Chitale", 70);
        }};
    }

    public void filterByValue() {
        nameAgeMap.entrySet().stream().filter(e -> e.getValue() > 23).forEach(e -> {
            System.out.println("Name:" + e.getKey() + "\t" + "Age" + e.getValue());
        });
    }
}
public class LambdaOverHashMap {
    public static void main(String args[]){
        FrameworkForHashMap nameAgeFilteredObject=new FrameworkForHashMap();
        nameAgeFilteredObject.filterByValue();
    }
}

