package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee{
  String name;
  int salary;
  String department;
  public Employee(String n, int s, String d){
    name=n;
    salary=s;
    department=d;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Employee{");
    sb.append("name='").append(name).append('\'');
    sb.append(", salary=").append(salary);
    sb.append(", department='").append(department).append('\'');
    sb.append('}');
    return sb.toString();
  }
}


public class PlayWithSteam {

  public static void main(String[] args) {
//    List<Integer> list = Arrays.asList(4,2,1,1,3);
//    printStatiscits(list);

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("A",10000,"IT"));
    employeeList.add(new Employee("B",11000,"HR"));
    employeeList.add(new Employee("C",20000,"IT"));
    employeeList.add(new Employee("D",12000,"AC"));
    employeeList.add(new Employee("E",13000,"HR"));
    employeeList.add(new Employee("F",14000,"IT"));

    printEmployeeStatistics(employeeList);

//    IntStream intStream = IntStream.of(5,2,6,1,8,9,10,3,11);

  }

  private static void printEmployeeStatistics(List<Employee> list){
    System.out.println("Min Salary:"+list.stream().min((e1,e2)->e1.salary-e2.salary).get().name);
    System.out.println("Max Salary:"+list.stream().max((e1,e2) ->e1.salary-e2.salary).get().name);
    System.out.println("IT:"+list.stream().filter((e1)->e1.department.equals("IT")).collect(Collectors.toList()));
    System.out.println("HR:"+list.stream().collect(Collectors.groupingBy(e->e.department)).get("HR"));
  }



   private static void printStatiscits(List<Integer> list){
     System.out.println("Min Value:"+list.stream().min((i1,i2)->i1-i2).get());
     System.out.println("Max Value:"+list.stream().max((i1,i2)->i1-i2).get());
     System.out.println("Avg Value:");
     System.out.println("Sum Value:");
     System.out.println("Distinct Values:"+list.stream().distinct().count());
     System.out.println("Top 2:"+list.stream().sorted((i1,i2)->i2-i1).limit(2).collect(Collectors.toList()));
   }

}
