package Dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,3,4,5,8);
        System.out.println(sumOfEvenNumbers(number));

        List<String> names = Arrays.asList("shubham","umang","sk","atul","yp","raju","anurag","suraj","saurabh","ravi","sravan");
        System.out.println(getNamesStartsWith(names,'s'));

        System.out.println(subtractOneFromAll(number));

        System.out.println(getSquareOfEvenNumbers(number));
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

}
