package controller;

import java.util.Scanner;

public class InputReader {
    protected final Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public static String insertName(Scanner scanner){
        System.out.println("Insert your name:");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
    public String insertSurame(){
        System.out.println("Insert your surame:");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
    public String insertBirtdate(){
        System.out.println("Insert your birthdate: (in format \"dd/mm/yyyy\")");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
    public String insertCity(){
        System.out.println("Insert the city where are you born:");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
    public String insertProvincia(){
        System.out.println("Insert the provincia where are you born:");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
    public String insertGender(){
        System.out.println("Insert your gender: (\"Man\" or \"Woman\")");
        String retvalue = scanner.nextLine();
        return retvalue;
    }
}
