package LambdaOverArrayList;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by AniruddhaS on 1/21/2016.
 */
public class LambdaOverArrayListII {

    public static void main(String args[]){
        ArrayList<Integer> numbers=new ArrayList<Integer>(){{
            add(12);
            add(2);
            add(3);
            add(4);
            add(10);
            add(8);
            add(13);
            add(14);
        }};
        ArrayList<Integer> x=new ArrayList<Integer>();
      numbers.stream().filter(e->e.intValue()>5).forEach(e->{
                    x.add(e);
              });
        x.stream().forEach(e->{
            System.out.println(e);
        });
    }
}
