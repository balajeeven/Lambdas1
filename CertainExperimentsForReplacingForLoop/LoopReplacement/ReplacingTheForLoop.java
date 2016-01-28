package LoopReplacement;

import java.util.stream.IntStream;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
public class ReplacingTheForLoop {
    public static void main(String args[]){
        IntStream.range(1,11).filter(e->e%2==0).forEach(System.out::println);
    }
}
