package MapWithUserDefinedKeyValue;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class StudentKey{
    private String registrationNumber;
    public StudentKey(String registrationNumber){
        this.registrationNumber=registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
class StudentValue{
    private String name;
    private int age;
    public StudentValue(String name,int age){
        this.age=age;
        this.name=name;

    public int getAge() {
        return age;
    }
}
class LambdaMapFrame{
    private Map<StudentKey,StudentValue> studentData;
    public LambdaMapFrame(){
        studentData=new HashMap<StudentKey,StudentValue>(){{
            put(new StudentKey("1101"),new StudentValue("Aniruddha",23));
            put(new StudentKey("1110"),new StudentValue("Balajee",23));
            put(new StudentKey("1103"),new StudentValue("Vaijnath",22));
            put(new StudentKey("1105"),new StudentValue("Khote",23));
            put(new StudentKey("1116"),new StudentValue("Akanksha",23));
        }};
    }
    public void sortAndShowData(){
        studentData.entrySet().parallelStream()
                .sorted(Collections.reverseOrder(Comparator.comparing(e->e.getValue().getName())))
                .forEachOrdered(e->{
                    System.out.println(e.getKey().getRegistrationNumber()+" "+e.getValue().getName()+" "+e.getValue().getAge());
                });
    }
}
public class MapWithUserDefinedKeyValues {
    public static void main(String args[]){
        LambdaMapFrame fr=new LambdaMapFrame();
        fr.sortAndShowData();
    }
}
