package com.fabrice.www;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static boolean exit = false;

    public static void main(String[] args) {
        char choice;
        int choiceInt;
        printMenu();
        while (!exit){
            choice = scan.next().charAt(0);
            scan.nextLine();
            if(!Character.isDigit(choice) || choice != '1'){
                choiceInt = 0;
            }

            else{
                choiceInt = 1;
            }

            if (choiceInt == 1) {
                validate();
            } else {
                exit = true;
            }
        }
    }

    public static boolean validatingLisp(String lispCode) {
        StringBuilder brackets = new StringBuilder();
        int opening = 0;
        int closing = 0;
        if(lispCode.equals("")){
            return false;
        }
        for(char ch : lispCode.toCharArray()){
            if(ch == '('){
                opening++;
               brackets.append(ch);
            }else if(ch == ')'){
                closing++;
                brackets.append(ch);
            }
        }

        System.out.print(brackets + ": ");
        if(opening != closing){
            return false;
        }else {
            Deque<Character> bracketDeque = new LinkedList<>();
            for (char ch : brackets.toString().toCharArray()) {
                if (ch == '(') {
                    bracketDeque.addFirst(ch);
                } else {
                    if (!bracketDeque.isEmpty() && (bracketDeque.peekFirst() == '(')) {
                        bracketDeque.removeFirst();
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void validate(){
        String lispCode;
        System.out.println("Please, input your LISP code");
        lispCode = scan.nextLine();
        System.out.println(validatingLisp(lispCode));
        printMenu();
    }

    public static void printMenu(){
        System.out.println("Please, select an option.");
        System.out.println("1. Validate List Code");
        System.out.println("0. Exit");
    }
}
