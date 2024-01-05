package systemDesignBasics.bloomFilter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    public static int getHashValue(int index, String s) throws NoSuchAlgorithmException {
        switch (index) {
            case 0:
                return getHash1(s, "MD5");
            case 1:
                return getHash1(s, "SHA-1");
        }
        throw new IndexOutOfBoundsException();
    }

    private static int getHash1(String s, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] messageDigest = md.digest(s.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        StringBuilder md5Hash = new StringBuilder(no.toString(16));

        // Pad the hash string with leading zeros to ensure it has 32 characters
        while (md5Hash.length() < 32) {
            md5Hash.insert(0, "0");
        }

        return new BigInteger(md5Hash.toString(), 16).intValue();
    }
}
