package ArrayListWithUserDefinedClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by AniruddhaS on 1/22/2016.
 */
class Student{
    private String name;
    private int rollNo;
    private int age;
    public Student(){
    }
    public Student setFields(String name,int rollNo,int age){
        this.name=name;
        this.rollNo=rollNo;
        this.age=age;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }
}
class ArrayListFrame {
    private List<Student> studentList;


    public ArrayListFrame() {
        studentList = new ArrayList<Student>() {{
            add(new Student().setFields("Aniruddha", 06, 23));
            add(new Student().setFields("Akanksha",12,23));
            add(new Student().setFields("Balajee",14,24));
            add(new Student().setFields("Vaijnath",15,21));
            add(new Student().setFields("Rohan Gawfale",19,25));
            add(new Student().setFields("Ajinkya Rahane",19,30));
        }};

    }
    public void show(){
        studentList.stream().sorted(Comparator.comparing(e->e.getName())).forEachOrdered(e->{
            System.out.println(e.getAge()+" "+e.getRollNo()+" "+e.getName());
        });
    }
}
public class ArrayListWWithUserDefined {
    public static void main(String args[]){
        ArrayListFrame newFrame=new ArrayListFrame();
        newFrame.show();
    }
}
