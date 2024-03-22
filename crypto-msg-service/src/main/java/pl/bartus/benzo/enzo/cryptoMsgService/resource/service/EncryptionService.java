package pl.bartus.benzo.enzo.cryptoMsgService.resource.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

@Service
public class EncryptionService {
    private static final String ALGORYTM = "AES";
    private SecretKey key;

    public EncryptionService() {
        try {
            key = KeyGenerator.getInstance(ALGORYTM).generateKey();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String encrypt(String dane)  {
        try {
            Cipher cipher = Cipher.getInstance(ALGORYTM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(dane.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }

    public String decrypt(String dane) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORYTM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(dane));
            return new String(original);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
