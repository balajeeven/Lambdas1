package WtihArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class AdvancedFrame{
    private List<String> numbers;
    public AdvancedFrame(){
        numbers= Arrays.asList("u12","u34","u33","d21","d56","d69","u52","d22","u11","d77");
    }
    public void filter(){
        numbers.stream().filter(e->e.startsWith("u")).sorted(Collections.reverseOrder()).forEach(e->{
            System.out.println(e.toUpperCase());
        });
    }
}
public class AdvancedLambdaOverArrayList {
    public static void main(String args[]){

        AdvancedFrame frame=new AdvancedFrame();
        frame.filter();
    }
}
