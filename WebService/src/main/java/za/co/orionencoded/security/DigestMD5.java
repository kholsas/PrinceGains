package za.co.orionencoded.security;

/**
 * Created by kholofelo on 2016/10/17.
 */

import java.security.MessageDigest;

public class DigestMD5 {

    public static String digest(String valueToDigest) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(valueToDigest.getBytes());

            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}