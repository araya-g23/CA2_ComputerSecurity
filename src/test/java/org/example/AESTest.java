package org.example;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.print.attribute.AttributeSetUtilities;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AESTest {

    @org.junit.jupiter.api.Test
    void encryptfile() throws Exception {
        AES aes = new AES();
        SecretKey key= AES.genereteKey(128);
        String algorithm = "AES/CBC/PKCS5Padding";
        IvParameterSpec iv = AES.generateIv();
        File inputFile = new File("./plaintext.txt");
        File encryptedFile = new File("./ciphertext.txt");
        AES.encryptFile(algorithm, key, iv, inputFile, encryptedFile);



    }
}