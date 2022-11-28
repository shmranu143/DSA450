package ComparatorAndComparable;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Student implements Comparable<Student> {
     String name;
     int hight;
     int weight;
     int marks;
     Student(String name, int hight, int weight, int marks){
         this.name=name;
         this.hight=hight;
         this.weight=weight;
         this.marks=marks;
     }
     public String toString(){
         return this.name+" -> ["+this.hight +","+this.weight+","+this.marks+"]";
     }
     @Override
     public int compareTo(Student o) {
        return this.hight-o.hight;
     }

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0]= new Student("A",162,55,84);
        students[1]= new Student("B",159,78,46);
        students[2]= new Student("C",172,80,50);
        students[3]= new Student("D",168,70,60);
        students[4]= new Student("E",170,66,75);

        PriorityQueue<Student> pqHieght = new PriorityQueue<>();
        PriorityQueue<Student> pqWeight = new PriorityQueue<>(new StudentWeightComparator());
        PriorityQueue<Student> pqMarks = new PriorityQueue<>(new StudentMarksComparator());
        for (Student student:students){
            pqHieght.add(student);
            pqWeight.add(student);
            pqMarks.add(student);
        }
        // print on basis of height
        System.out.println("on the basis of height");
        while (pqHieght.size()>0){
            System.out.println(pqHieght.remove());
        }
        // print on basis of weight
        System.out.println("on the basis of height");
        while (pqWeight.size()>0){
            System.out.println(pqWeight.remove());
        }
        // print on basis of marks
        System.out.println("on the basis of height");
        while (pqMarks.size()>0){
            System.out.println(pqMarks.remove());
        }
    }

}
class StudentWeightComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.weight-o2.weight;
    }
}
class StudentMarksComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.marks-o2.marks;
    }
}
