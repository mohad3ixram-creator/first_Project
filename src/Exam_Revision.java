import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_Revision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student c1 [];
        Doctor c2 [];
        int choose;

        do {
            System.out.println("1.Student\n2.Doctor\n3.Exit");
            choose = input.nextInt();
            input.nextLine();

            switch (choose){
                case 1:
                    System.out.println("how many Students:");
                    int count = input.nextInt();
                    input.nextLine();
                    c1 = new Student[count];

                    for (int x=0 ; x < c1.length ; x++){
                        System.out.printf("enter name for Student number %d:%n",(x+1));
                        String name = input.nextLine();

                        System.out.printf("enter ID for Student number %d:%n",(x+1));
                        String id = input.nextLine();

                        System.out.printf("enter GPA for Student number %d:%n",(x+1));
                        float gpa = input.nextFloat();
                        input.nextLine();
                        c1[x] = new Student(name,id,gpa);
                    }
                    System.out.println("================================");
                    for (int x = 0 ; x<c1.length ; x++){
                        int hourse = 0;
                        System.out.printf("Student %d which course you want ",(x+1));
                        System.out.printf("%n=====%nOOP%n=====%nC++%n=====%nPython%n");
                        String course = input.nextLine();

                        try {
                            System.out.printf("How Many hourse this Semister");
                            hourse = input.nextInt();
                            input.nextLine();
                        }
                        catch (InputMismatchException e) {
                            System.out.println(e.getMessage()+" "+e.toString());
                            input.nextLine();
                        }
                        c1[x].addCourse(course,hourse);
                    }
                    System.out.print("================================");
                    for (int x = 0 ; x < c1.length ; x++){
                        c1[x].printInfo();
                    }
                    System.out.println("Total Students: "+Student.getStudentnumber());
                    break;

                case 2:
                    System.out.println("how many Doctors:");
                    int count2 = input.nextInt();
                    input.nextLine();
                    c2 = new Doctor[count2];

                    for (int x=0 ; x < c2.length ; x++){
                        System.out.printf("enter name for Doctor number %d:%n",(x+1));
                        String name = input.nextLine();

                        System.out.printf("enter ID for Doctor number %d:%n",(x+1));
                        String id = input.nextLine();


                        c2[x] = new Doctor(name,id);
                    }
                    for (int x = 0 ; x < c2.length ; x++){
                        System.out.printf("Doctor %d which course you want ",(x+1));
                        System.out.printf("%n=====%nOOP%n=====%nC++%n=====%nPython%n======%n");
                        String course = input.nextLine();

                        c2[x].addCourse(course);
                    }
                    System.out.printf("================================%n");
                    for (int x = 0 ; x < c2.length ; x++){
                        c2[x].printInfo();
                    }
                    System.out.println("Total Doctors: "+Doctor.getDoctornumber());
                    break;
            }

        }while (choose != 3);


    }
}

abstract class College
{
    String id;
    String name;
    String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void printInfo();
}


class Student extends College
{

    private float gpa;
    private int hours;
    private static int studentnumber;


    public Student(String name,
                   String id,
                   float gpa){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        studentnumber++;
    }

    public static int getStudentnumber() {
        return studentnumber;
    }

    public void addCourse(String course, int hours){
        this.course = course;
        this.hours = hours;
    }

    public void printInfo(){
        System.out.printf("Name: %s%nid: %s%nCourse: %s%nHourse: %d%nGPA: %.2f%n",name,id,course,hours,gpa);
    }
}


class Doctor extends College
{
    static int doctornumber;
    private String doctorcourse;
    public Doctor(String name, String id){
        this.name = name;
        this.id = id;
        doctornumber++;
    }

    public static int getDoctornumber() {
        return doctornumber;
    }

    public void addCourse(String course) {
        this.doctorcourse = course;
    }

    public void printInfo(){
        System.out.printf("Name: %s%nid: %s%nCourse: %s%n%n",name,id,doctorcourse);

    }
}