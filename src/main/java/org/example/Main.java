package org.example;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
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

    private static void encryptFile() throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("enter the file to encrypt");
        //String inputFiles=input.nextLine();
        File inputFile=new File("plaintext.txt");


        System.out.println("Enter the path to save the encrypted file");
        //String outputFile=input.nextLine();
        File outputFile1=new File("ciphertext.txt");

        SecretKey key = AES.genereteKey(256);
        IvParameterSpec iv =AES.generateIv();

        AES.encryptFile("AES/CBC/PKCS5Padding", key, iv, inputFile, outputFile1);
        System.out.println("File encrypted successfully!");
        System.out.println("Encryption Key (base64): " + java.util.Base64.getEncoder().encodeToString(key.getEncoded()));
        System.out.println("IV (base64): " + java.util.Base64.getEncoder().encodeToString(iv.getIV()));



    }
    private static void decryptFile() {

    }
}