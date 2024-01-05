package systemDesignBasics.bloomFilter;

import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class BloomFilter {
    private final int m;
    private final int k;
    private final BitSet bitSet;

    BloomFilter() {
        m = 4;
        k = 2;
        bitSet = new BitSet(m);
    }

    public void insert(String s) throws NoSuchAlgorithmException {
        for (int i = 0; i < k; i++) {
            int hash = HashGenerator.getHashValue(i, s);
            while(hash < 0) {
                hash += m;
                hash %= m;
            }
            bitSet.set(hash);
        }
    }

    public boolean search(String s) throws NoSuchAlgorithmException {
        for (int i = 0; i < k; i++) {
            int hash = HashGenerator.getHashValue(i, s);
            while(hash < 0) {
                hash += m;
                hash %= m;
            }
            if (bitSet.get(hash)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.insert("Hello");

        if (bloomFilter.search("Bloom")) {
            System.out.println("may or may not be there");
        } else {
            System.out.println("is not there");
        }
        bloomFilter.insert("Bloom");

        if (bloomFilter.search("kapila")) {
            System.out.println("may or may not be there");
        } else {
            System.out.println("is not there");
        }
        bloomFilter.insert("kapila");

        if (bloomFilter.search("tripoda")) {
            System.out.println("may or may not be there");
        } else {
            System.out.println("is not there");
        }
        bloomFilter.insert("tripoda");
        if (bloomFilter.search("tripoda")) {
            System.out.println("may or may not be there");
        } else {
            System.out.println("is not there");
        }
    }
}
