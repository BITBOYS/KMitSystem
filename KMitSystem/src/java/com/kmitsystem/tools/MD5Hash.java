package com.kmitsystem.tools;


import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Malte
 */
public class MD5Hash {

    public static String encript(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));

            //converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }

            digest = sb.toString();

        } catch (UnsupportedEncodingException ex) {
            ErrorHandler.handle(Errors.ENCODING_NOT_POSSIBLE, MD5Hash.class.getSimpleName());
        } catch (NoSuchAlgorithmException ex) {
            ErrorHandler.handle(Errors.ENCODING_NOT_FOUND, MD5Hash.class.getSimpleName());

        }
        return digest;
    }

    public static Boolean compare(String hash1, String hash2) {
        if (hash1.equals(hash2)) {
            return true;
        } else {
            return false;
        }
    }

}
