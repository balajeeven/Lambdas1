package LoopReplacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class FrameForArrayList{
    private List<Integer> numbers;
    public FrameForArrayList(){
        numbers= Arrays.asList(12,13,15,8,19,22,32,43,1,2,4,5,6,7);
    }
    public void filterNumbersAndCalculateAverage(){
        numbers.parallelStream().filter(e->e.intValue()<15)
                .forEach(System.out::println);
    }
}
public class ReplacingTheForLoopII {
    public static void main(String args[]){
        FrameForArrayList frame=new FrameForArrayList();
        frame.filterNumbersAndCalculateAverage();
    }
}
