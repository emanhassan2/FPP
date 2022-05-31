package Lesson7;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Employee {




    //Constructor
    public static int ObjCounter =0;

    public Employee() {
        ObjCounter++;
        System.out.println("You have " + ObjCounter +" Objects");
    }
    public Employee(String name,float salary) {
        this.Name = name;
        this.Salary = salary;
    }
    //Global variables can be accessed by any method in the class
    private String Name = "";
    private float Salary = 0f;
    public static float tax = 0f;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");


    public void setName(String _Name) {
        Name = _Name;
    }
    public String getName() {
        return Name;
    }

    public void setSalary(float _Salary) {
        Salary = _Salary;
    }
    public float getSalary() {
        return Salary;

    }

    public void PrintInfo() {
        //you only have to do changes once using OOP
        System.out.println("Your name is " + Name + ", your salary is "+ Salary + "$");

    }

    public void PrintInfoWithTax() {
        int x=0;
        float tax = Salary * 0.25f;
        System.out.println("Your name is " + Name + ", your salary is "+ Salary + "$, you sould pay "+ tax + " as taxes");

    }


    public  Period calculateAge(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today); // Return periods as Year, Month and Days
    }

    public  LocalDate getBirthday() {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthday;
        while (true) {
            System.out.println("Please enter your birthday " + "in yyyy-MM-dd format (e.g. 1980-9-28): ");
            String input = scanner.nextLine();
            try {
                birthday = LocalDate.parse(input, formatter);

                return birthday;

            } catch (DateTimeParseException e) {
                System.out.println("Error! Please try again");
            }
        }
    }


}
