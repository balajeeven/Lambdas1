package Collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeKey{
    private long employeeId;

    public long getEmployeeId() {
        return employeeId;
    }

    public EmployeeKey(long employeeId) {
        this.employeeId = employeeId;
    }
}
class EmployeeValue{
    private String employeeName;
    private int age;

    public EmployeeValue(String employeeName, int age) {
        this.employeeName = employeeName;
        this.age = age;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public int getAge() {
        return age;
    }
}

class EmployeeRecord{
    private Map<EmployeeKey,EmployeeValue> employee;
    private List<String> employeeNames;
    public EmployeeRecord() {
        employee=new HashMap<EmployeeKey, EmployeeValue>(){{
            put(new EmployeeKey(1881l),new EmployeeValue("Aniruddha",23));
            put(new EmployeeKey(462l),new EmployeeValue("Aniruddha",23));
        }};
        employeeNames=new ArrayList<String>();
    }

}