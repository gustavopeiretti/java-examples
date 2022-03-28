package com.gustavopeiretti.cryp.rsa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyPairRSAGeneratorUtil {

    public static void main(String[] args) throws Exception {
        createKeys();
        loadPrivateKey();
        loadPublicKey();
    }

    private static void createKeys() throws NoSuchAlgorithmException, IOException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey aPrivate = kp.getPrivate();
        PublicKey aPublic = kp.getPublic();

        try (FileOutputStream outPrivate = new FileOutputStream("key.priv")) {
            outPrivate.write(aPrivate.getEncoded());
        }

        try (FileOutputStream outPublic = new FileOutputStream("key.pub")) {
            outPublic.write(aPublic.getEncoded());
        }

        System.out.println("Private key: " + aPrivate.getFormat());
        // prints "Private key format: PKCS#8" on my machine

        System.out.println("Public key: " + aPublic.getFormat());
        // prints "Public key format: X.509" on my machine
    }

    private static PrivateKey loadPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        File privateKeyFile = new File("key.priv");
        byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());

        KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey = privateKeyFactory.generatePrivate(privateKeySpec);
        return privateKey;
    }

    private static PublicKey loadPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File publicKeyFile = new File("key.pub");
        byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

        KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = publicKeyFactory.generatePublic(publicKeySpec);
        return publicKey;
    }

}
