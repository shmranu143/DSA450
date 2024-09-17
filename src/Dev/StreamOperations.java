package Dev;

import Dev.streamsapi.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// r101
public class StreamOperations {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student s = new Student();
            s.setId(i+1);
            s.setfName("shubham"+i+1);
            s.setlName("jaiswal"+i+"ji");
            s.setRefNum(i+11);
            students.add(s);
        }
        Map<Integer,List<Student>> modifiedMap = students.stream().map(student -> {
            if (student.getId()==2)
                student = new Student();
            else student = new Student();
            return student;
        }).collect(Collectors.groupingBy(Student::getId));


        List<Integer> number = Arrays.asList(2,3,4,5,8);

        System.out.println(number.stream().map(s->s+1).collect(Collectors.groupingBy(Integer::shortValue)));

//        System.out.println(myList);
//        System.out.println(sumOfEvenNumbers(number));

        List<String> names = Arrays.asList("shubham","umang","sk","atul","yp","raju","anurag","suraj","saurabh","ravi","sravan");
//        System.out.println(getNamesStartsWith(names,'s'));

//        System.out.println(subtractOneFromAll(number));

//        System.out.println(getSquareOfEvenNumbers(number));

//        System.out.println(getEvenList(number));
    }
    static int sumOfEvenNumbers(List<Integer> list){
        return list.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
    }

    static List<String> getNamesStartsWith(List<String> list , char ch){
        return list.stream().filter(s -> s.startsWith(ch+"")).collect(Collectors.toList());
    }

    static List<Integer> subtractOneFromAll(List<Integer> list){
        return list.stream().map(s->s-1).collect(Collectors.toList());
    }

    static List<Integer> getSquareOfEvenNumbers(List<Integer> list){
        return list.stream().filter(s->s%2==0).map(s->s*s).collect(Collectors.toList());
    }

    static List<Integer> getEvenList(List<Integer> list){
        return list.stream().filter(x->x%2==0).collect(Collectors.toList());
    }



}
