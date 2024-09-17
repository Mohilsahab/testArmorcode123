package src;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class StringHashConvertor {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        String input = "dsgdfgdhjtjtrhrherjdhfhhfgfhhfvncngfnrntrthrtrhttffhfndvsdvdfsdgffdfscscsdvddsvdfvdvdvdfvdvsdfbdvdvsvdvdvdvdfvdvf" +
                "ggggggggggggggggggggggggggggdddddddddddddddddddddggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" +
                "hghfghgffghghdffdhgjjjjjjjjjjjjjjjjjjjjjfggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                "ghhhhhhhhhhhhhhhhhhhhhhhhhhhhhh   hhhhhhhhhhhhhhhhhhhhffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "dffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff" +
                "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhlllllllllllllllllllllllllllllllrrrrrrrrrrrrrrr" +
                "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrhhhhhhhhhhhhhhhhhhhhherdfgdsgsgfgdfgdgdhfgdffgdgdsdgdgdggsdfsdfsfdfdfdgdgdgdgdgdgdgdgffffff";
        input = "";

        System.out.println(input.length());

        System.out.println(makeSHA1Hash(input));
        System.out.println(makeSHA256Hash(input));
        System.out.println(makeSHA256Hash(input).length());

    }

    public static String makeSHA256Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                input.getBytes(StandardCharsets.UTF_8));
        return new String(Hex.encode(hash));
    }

    public static String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        byte[] buffer = input.getBytes("UTF-8");
        md.update(buffer);
        byte[] digest = md.digest();

        StringBuilder hexStr = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            hexStr.append(Integer.toString(( digest[i] & 0xff ) + 0x100, 16).substring(1));
        }
        return hexStr.toString();
    }

    private static String calculateRFC2104HMAC(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        return toHexString(mac.doFinal(data.getBytes()));
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String stringToReturn = formatter.toString();

        formatter.flush();
        formatter.close();
        return stringToReturn;
    }
}
