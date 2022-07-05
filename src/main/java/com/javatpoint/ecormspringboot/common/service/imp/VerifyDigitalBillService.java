package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.OrderEntity;
import com.javatpoint.ecormspringboot.common.model.AsymmetricAlgorithm;
import com.javatpoint.ecormspringboot.common.util.FileUtils;
import com.javatpoint.ecormspringboot.common.util.constance.SystemContance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

@Service
public class VerifyDigitalBillService {

    @Value("${DigitalBillPath}")
    private String digitalBillPath;

    @Autowired
    private OrderService orderService;

    public String decryption(String cipherString, String privateKeyPath, AsymmetricAlgorithm asAlgo, String option)
            throws IOException {
        String algorithmName = asAlgo.getAlgorithmName();
        String mode = asAlgo.getMode();
        String padding = asAlgo.getPadding();
        byte[] keyBytes = FileUtils.readKey(privateKeyPath);
        byte[] keyBytesDecode = SystemContance.decoder.decode(keyBytes);
        KeyFactory kf = null;
        PrivateKey privateKey = null;
        try {
            kf = KeyFactory.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
        }
        try {
            privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(keyBytesDecode));
        } catch (InvalidKeySpecException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Cipher cipher = FileUtils.getCipherInstance(algorithmName, mode, padding);
        try {
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
        } catch (InvalidKeyException e) {
        }
        byte[] cipherText = null;
        byte[] plainText = null;
        String result = null;
        if (option.equals(SystemContance.TEXT_TYPE)) {
            cipherText = SystemContance.decoder.decode(cipherString);
            try {
                plainText = cipher.doFinal(cipherText);
                return new String(plainText, SystemContance.UNICODE_FORMAT);
            } catch (IllegalBlockSizeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BadPaddingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public Path findDigitalBillPath(String filename) {
        Path path = Paths.get(digitalBillPath);
        Path foundPath = path.resolve(filename);
        return foundPath;
    }

    public String checksum(String textOrFilePath, String algorithmName, String option) {
        MessageDigest md = null;
        byte[] hashTextBytes = null;
        try {
            md = MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
        }
        if (option.equals("text")) {
            byte[] texts = textOrFilePath.getBytes();
            hashTextBytes = md.digest(texts);
            /* Convert to 16 */
        } else if (option.equals("file")) {
            File f = new File(textOrFilePath);
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(f);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            DigestInputStream dis = new DigestInputStream(fis, md);
            byte[] buffer = new byte[(int) f.length()];
            try {
                dis.read(buffer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            hashTextBytes = dis.getMessageDigest().digest();
        }
        /* Convert to 16 */
        BigInteger number = new BigInteger(1, hashTextBytes);
        String hashText = number.toString(16);
        return hashText;
    }

    public boolean verifyDigitalBill(String encryptedHashFile, String filename, long shopId) {
        try {
            Path privateKeyPath = Paths.get(digitalBillPath).resolve(shopId + "private.txt");
            AsymmetricAlgorithm asymmetricAlgorithm = new AsymmetricAlgorithm("RSA", "ECB", "PKCS1PADDING");
            String decryptedHash = this.decryption(encryptedHashFile, privateKeyPath.toString(), asymmetricAlgorithm, "text");
            Path digitalBillPath = this.findDigitalBillPath(filename + "digitalBill.txt");
            String digitalBillHash = this.checksum(digitalBillPath.toString(), "SHA-256", "file");
            if(decryptedHash.equals(digitalBillHash)){
                OrderEntity orderEntity = this.orderService.findOne(Long.parseLong(filename));
                Path digitalBillHashPath = Paths.get(this.digitalBillPath).resolve(filename + "digitalBillHash.txt");
                File digitalBillHashFile = digitalBillHashPath.toFile();
                FileOutputStream fos = new FileOutputStream(digitalBillHashFile);
                fos.write(decryptedHash.getBytes());
                orderEntity.setDigitalBillHash(digitalBillHash);
                orderEntity.setDigitalBillHash(digitalBillHashPath.getFileName().toString());
                this.orderService.save(orderEntity);
                return true;
            }else{
                return false;
            }
        } catch (IOException e) {
            return false;
        }catch (NullPointerException e) {
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
