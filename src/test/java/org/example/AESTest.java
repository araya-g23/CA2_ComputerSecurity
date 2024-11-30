package org.example;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.print.attribute.AttributeSetUtilities;

import java.io.File;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class AESTest {

    @org.junit.jupiter.api.Test
    void encryptfile() throws Exception {
        File inputFile = new File("./src/assets/plaintext.txt.txt");


        AES aes = new AES();
        SecretKey key= AES.genereteKey(256);
        String algorithm = "AES/CBC/PKCS5Padding";
        //IvParameterSpec iv = AES.generateIv();
        //File inputFile = new File("plaintext.txt");
        File encryptedFile = new File("ciphertext.txt");
        AES.encryptFile(algorithm, key, inputFile, encryptedFile);
        assertTrue(inputFile.exists(),"it exist ");




    }
}