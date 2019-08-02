package easy;

public class Solution128 {
	public int hashCode(char[] key, int HASH_SIZE) {
//		int hash = 0;
//		for(int i=0;i<key.length;i++) {
//			hash += key[i]*Math.pow(33, key.length-1-i);
//		}
//		hash %= HASH_SIZE;
//		return hash;
		
//		BigDecimal sum=new BigDecimal(0);
//		for(int i=0;i<key.length;i++) {
//			BigDecimal ba = new BigDecimal((int)key[i]);
//			BigDecimal bb = new BigDecimal(33);
//			BigDecimal bc = bb.pow(key.length-1-i);
//			sum.add(ba.multiply(bc));
//		}
//		
//		BigDecimal hash = sum.remainder(new BigDecimal(HASH_SIZE));
//		
//        return hash.intValue();
		if (key == null || key.length == 0) return 0;

        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum = 33 * hashSum + key[i];
            hashSum %= HASH_SIZE;
        }

        return (int)hashSum;
    }

	public static void main(String[] args) {
		Solution128 s = new Solution128();
		char[] key = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		System.out.println(s.hashCode(key, 2607));
	}

}
