package LambdaOverArrayList;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by AniruddhaS on 1/21/2016.
 */
public class LambdaOverArrayList {
    static List<Integer> x=new ArrayList<Integer>();
    public static void transfer(int val){
        x.add(val);
    }
    public static void main(String args[]){
        List<Integer> numbers=new ArrayList<Integer>(){{
            add(12);
            add(2);
            add(3);
            add(4);
            add(10);
            add(8);
            add(13);
            add(14);
        }};

  numbers.stream().filter(e->e.intValue()>5).forEach(e-> transfer(e.intValue()));
        x.stream().forEach(e-> System.out.println(e.intValue()));

    }
}
