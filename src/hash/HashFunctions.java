package hash;

/**
 * hashº¯Êý
 * @author Vitalc
 *
 */
public class HashFunctions {
	static int hash1(Object x, int prime) {
		return x.hashCode() % prime;
	}
	
	static int add(Object key, int prime) {
		String str = key.toString();
		int hash = str.length();
		for (int i = 0; i < str.length(); i++) {
			hash += str.charAt(i);
		}
		return (hash % prime);
	}
}
