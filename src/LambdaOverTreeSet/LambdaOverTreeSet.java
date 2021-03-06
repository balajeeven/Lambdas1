package LambdaOverTreeSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by AniruddhaS on 1/22/2016.
 */

class FrameworkForTreeSet{
    private Set<Integer> inputNumbers;
    private Set<Integer> outputFilteredNumbers;
    public FrameworkForTreeSet(){
        inputNumbers=new TreeSet<Integer>(){{
            add(1); add(2); add(2); add(4); add(5); add(6);
            add(8); add(9); add(11); add(15); add(17); add(19);
            add(23); add(27); add(29); add(32); add(33); add(35);
            add(40);
        }};
        outputFilteredNumbers=new TreeSet<Integer>();
    }
    private void filterDataGreater12(){
        inputNumbers.stream().filter(e->e.intValue()>12).forEach(e->{
            outputFilteredNumbers.add(e.intValue());
        });
    }
    public void show(){
        filterDataGreater12();
        showMethodCore();
    }

    private void showMethodCore() {
        inputPrinter();
        outputPrinter();
    }

    private void outputPrinter() {
        System.out.println("Output data that has been filtered");
        outputDataPrinter();
    }

    private void inputPrinter() {
        System.out.println("Input data that has been entered");
        inputDataPrinter();
    }

    private void outputDataPrinter() {
        System.out.print("[");
        outputFilteredNumbers.stream().forEach(e->{
            System.out.print(e.intValue()+",");
        });
        System.out.println("]");
    }

    private void inputDataPrinter() {
        System.out.print("[");
        inputNumbers.stream().forEach(e->{
            System.out.print(e.intValue()+",");
        });
        System.out.println("]\n\n");
    }
}
public class LambdaOverTreeSet {
    public static void main(String args[]){
        FrameworkForTreeSet treeSetObject=new FrameworkForTreeSet();
        treeSetObject.show();
    }
}
