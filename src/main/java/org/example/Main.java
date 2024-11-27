package org.example;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Scanner;
//https://medium.com/@deepak.sirohi9188/java-aes-encryption-and-decryption-1b30c9a5d900
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

        //File inputFile = new File("plaintext.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("enter the file to encrypt");
        String inputFiles=input.nextLine();
        File inputFile=new File(inputFiles);//./src/assets/plaintext.txt.txt


        System.out.println("Enter the path to save the encrypted file");
        String outputFile=input.nextLine();
        File outputFile1=new File(outputFile);//ciphertext.txt

        SecretKey key = AES.genereteKey(256);
        IvParameterSpec iv =AES.generateIv();

        AES.encryptFile("AES/CBC/PKCS5Padding", key, iv, inputFile, outputFile1);
        System.out.println("File encrypted successfully!");
        System.out.println("Encryption Key (base64): " + java.util.Base64.getEncoder().encodeToString(key.getEncoded()));
        System.out.println("IV (base64): " + java.util.Base64.getEncoder().encodeToString(iv.getIV()));



    }
    private static void decryptFile() throws Exception {
       Scanner input=new Scanner(System.in);
        System.out.println("enter the encrypted file name");
        String fileName=input.nextLine();
        File encryptedFile =new File(fileName);


        System.out.println("Enter the output file path for the decrypted data:");
        String decryptedFilePath = input.nextLine();
        File outputFile = new File(decryptedFilePath);


        System.out.println("enter Encryption Key (base64) : ");
        String decryptionKey=input.next();
        byte[] decodedKey = Base64.getDecoder().decode(decryptionKey);
        SecretKey key= new SecretKeySpec(decodedKey,0,decodedKey.length,"AES");


        System.out.println("enter the IV (base64) : ");
        String encryptioniv=input.next();
        byte[] decodeIv=Base64.getDecoder().decode(encryptioniv);
        IvParameterSpec iv =new IvParameterSpec(decodeIv);


        AES.decryptFile("AES/CBC/PKCS5Padding",key,iv,encryptedFile,outputFile);
        System.out.println("Decrypted file successfully!");
        System.out.println("Decrypted content saved to : "+decryptedFilePath);







    }
}