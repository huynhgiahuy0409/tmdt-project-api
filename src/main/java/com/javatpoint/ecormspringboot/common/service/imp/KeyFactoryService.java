package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.util.constance.SystemContance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

@Service
public class KeyFactoryService {

    @Autowired
    private IUserService userService;

    public boolean generativeKeyPair(String algorithm, int keySize, long userId) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
            if (keySize != -1) {
                keyPairGenerator.initialize(keySize);
            }
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            byte[] publicKeyEncoded = publicKey.getEncoded();
            byte[] privateKeyEncoded = privateKey.getEncoded();
            String publicKeyFileName = userId + SystemContance.PUBLIC_KEY_FILE_NAME;
            String privateKeyFileName = userId + SystemContance.PRIVATE_KEY_FILE_NAME;
            UserEntity foundUser = this.userService.findById(userId);
            foundUser.setPublicKeyFilename(publicKeyFileName);
            this.userService.save(foundUser);
            File publicKeyFile = new File("C:\\digital-bill\\" + userId + SystemContance.PUBLIC_KEY_FILE_NAME);
            File privateKeyFile = new File("C:\\digital-bill\\" + "\\" + userId + SystemContance.PRIVATE_KEY_FILE_NAME);
            if (!publicKeyFile.exists()) {
                publicKeyFile.createNewFile();
            }
            if (!privateKeyFile.exists()) {
                privateKeyFile.createNewFile();
            }
            FileOutputStream publicKeyFos = new FileOutputStream(publicKeyFile);
            FileOutputStream privateKeyFos = new FileOutputStream(privateKeyFile);

            publicKeyFos.write(SystemContance.encoder.encode(publicKeyEncoded));
            privateKeyFos.write(SystemContance.encoder.encode(privateKeyEncoded));
            publicKeyFos.close();
            privateKeyFos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
