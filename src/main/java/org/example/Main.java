package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu=true;

        while (menu){
            System.out.println("Menu: ");
            System.out.println("[1]. Encrypt a File");
            System.out.println("[2]. Decrypt a File");
            System.out.println("[3]. Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    encryptFile();
                    break;
                case 2:
                    decryptFile();
                    break;
                case 3:
                    menu=false;
                    System.out.println("Goodbye!");
                    break;
                default:
                        System.out.println("Invalid choice!");

            }


        }
    }

    private static void encryptFile() {
    }
    private static void decryptFile() {

    }
}