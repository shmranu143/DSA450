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
        return this.name.compareTo(o.name);
     }
    static class StudentWeightComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.weight-o2.weight;
        }
    }
    static class StudentMarksComparator implements Comparator<Student>{
         @Override
        public int compare(Student o1,Student o2){
             return o1.marks-o2.marks;
         }
    }
    static class StudentHeightComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.hight-o2.hight;
        }
    }
    static class ReverseWeightComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.weight-o1.weight;
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0]= new Student("A",162,55,84);
        students[1]= new Student("B",159,78,46);
        students[2]= new Student("C",172,80,50);
        students[3]= new Student("D",168,70,60);
        students[4]= new Student("E",170,66,75);

        MyGenericPriorityQueue<Student> pqName = new MyGenericPriorityQueue<>();
        MyGenericPriorityQueue<Student> pqWeight = new MyGenericPriorityQueue<>(new StudentWeightComparator());
        MyGenericPriorityQueue<Student> pqRevWeight = new MyGenericPriorityQueue<>(new ReverseWeightComparator());
        MyGenericPriorityQueue<Student> pqMarks = new MyGenericPriorityQueue<>(new StudentMarksComparator());
        MyGenericPriorityQueue<Student> pqHieght = new MyGenericPriorityQueue<>(new StudentHeightComparator());
        for (Student student:students){
            pqHieght.add(student);
            pqWeight.add(student);
            pqMarks.add(student);
            pqName.add(student);
            pqRevWeight.add(student);
        }
        // print on basis of height
        System.out.println("on the basis of height");
        while (pqHieght.size()>0){
            System.out.println(pqHieght.remove());
        }
        // print on basis of weight
        System.out.println("on the basis of weight");
        while (pqWeight.size()>0){
            System.out.println(pqWeight.remove());
        }
        // print on basis of weight
        System.out.println("on the basis of reverse weight");
        while (pqRevWeight.size()>0){
            System.out.println(pqRevWeight.remove());
        }
        // print on basis of marks
        System.out.println("on the basis of marks");
        while (pqMarks.size()>0){
            System.out.println(pqMarks.remove());
        }
        System.out.println("on the basis of name");
        while (pqName.size()>0){
            System.out.println(pqName.remove());
        }
    }

}

