package org.example;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.util.Base64;
import java.util.Scanner;

//website i used
//https://medium.com/@deepak.sirohi9188/java-aes-encryption-and-decryption-1b30c9a5d900

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("Menu:");
            System.out.println("[1]. Encrypt a File");
            System.out.println("[2]. Decrypt a File");
            System.out.println("[3]. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        encryptFile();
                        break;
                    case 2:
                        decryptFile();
                        break;
                    case 3:
                        menu = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
            catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                input.nextLine();
            }
        }
    }

    private static void encryptFile() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the file to encrypt (e.g., input.txt): ");//./src/assets/plaintext.txt
            String inputFilePath = input.nextLine();
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.out.println("Error: Input file does not exist.");
                return;
            }

            System.out.print("Enter the path to save the encrypted file (filename.txt) : ");
            String outputFilePath = input.nextLine();
            File outputFile = new File(outputFilePath);

            SecretKey key = AES.genereteKey(256);

            AES.encryptFile("AES/CBC/PKCS5Padding", key, inputFile, outputFile);

            System.out.println("File encrypted successfully!");
            System.out.println("Encryption Key (base64): " + Base64.getEncoder().encodeToString(key.getEncoded()));
        }
        catch (Exception e) {
            System.out.println("Error: Unable to encrypt the file. " );
        }
    }

    private static void decryptFile() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the encrypted file name: (filename.txt) ");
            String inputFilePath = input.nextLine();
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.out.println("Error: Encrypted file does not exist.");
                return;
            }

            System.out.print("Enter the path to save the decrypted file (e.g., decrypted.txt): ");
            String outputFilePath = input.nextLine();
            File outputFile = new File(outputFilePath);

            System.out.print("Enter the encryption key (base64): ");
            String keyString = input.nextLine();
            byte[] decodedKey = Base64.getDecoder().decode(keyString);
            SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            AES.decryptFile("AES/CBC/PKCS5Padding", key, inputFile, outputFile);

            System.out.println("File decrypted successfully!");
            System.out.println("Decrypted content saved to: " + outputFilePath);
        }
        catch (Exception e) {
            System.out.println("Error: Unable to decrypt the file. " );
        }
    }
}
