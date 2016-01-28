package LambdaOverHashAndTreeMap;

import java.util.*;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class LambdaOverHashAndTreeFrame{
    private Map<String,Integer> nameAgeMap;
    private Map<String,Integer> nameAgeMapFilteredAndSorted;
    public LambdaOverHashAndTreeFrame(){
        nameAgeMap=new LinkedHashMap<String,Integer>(){{
            put("Aniruddha", 23);
            put("Balajee", 23);
            put("Vaijnath", 21);
            put("Khote", 23);
            put("Akanksha", 23);
            put("Brajesh", 24);
            put("Kundan Singh", 25);
            put("Amarendra Chitale", 70);
            put("Vivek Prasad",40);
            put("Imtiyaaz Khan",36);
        }};
        nameAgeMapFilteredAndSorted=new TreeMap<String,Integer>(Collections.reverseOrder());

    }

    private void filterAndAdd(){
        nameAgeMap.entrySet().parallelStream().filter(e->e.getValue().intValue()>21).forEach(e->{
           nameAgeMapFilteredAndSorted.put(e.getKey().toString(),e.getValue().intValue());
        });
    }

    public void show(){
        filterAndAdd();
        inputMapPrinter();
        System.out.println("============\n\r============\n");
        outputMapPrinter();
    }

    private void outputMapPrinter() {
        System.out.println("output map");
        HeaderFormatter();
        nameAgeMapFilteredAndSorted.entrySet().stream().forEach(e->{
            System.out.println(e.getKey()+"\t"+e.getValue());
        });
    }

    private void HeaderFormatter() {
        System.out.println();
        System.out.println("Name"+"\t\t"+"Age");
    }

    private void inputMapPrinter() {
        System.out.println("input map");
        HeaderFormatter();
        nameAgeMap.entrySet().stream().forEach(e->{
            System.out.println(e.getKey()+"\t"+e.getValue());
        });
    }
}
public class LambdaOverHashAndTreeMap {
    public static void main(String args[]){
        LambdaOverHashAndTreeFrame lambdaOperatedObject=new LambdaOverHashAndTreeFrame();
        lambdaOperatedObject.show();
    }
}
