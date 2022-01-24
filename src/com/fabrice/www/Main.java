package com.fabrice.www;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lispCode;
        System.out.println("Please, input your LISP code");
        lispCode = scan.nextLine();
        System.out.println(validatingLisp(lispCode));
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
                    if (!bracketDeque.isEmpty() && (bracketDeque.peekFirst() == '(' && ch == ')')) {
                        bracketDeque.removeFirst();
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
