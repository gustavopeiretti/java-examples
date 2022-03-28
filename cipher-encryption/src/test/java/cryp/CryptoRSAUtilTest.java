package cryp;

import com.gustavopeiretti.cryp.rsa.EncryptDecryptRSAUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoRSAUtilTest {

    @Test
    void decode() throws Exception {

        EncryptDecryptRSAUtil cryptoRSAUtil = new EncryptDecryptRSAUtil();
        String textToEncrypt = "I will back";

        String encoded = cryptoRSAUtil.encode(textToEncrypt);
        String decode = cryptoRSAUtil.decode(encoded);

        assertNotEquals(encoded, textToEncrypt);
        assertEquals(decode, textToEncrypt);
    }

}