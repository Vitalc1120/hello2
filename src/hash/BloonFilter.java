package hash;

import java.math.BigInteger;

/**
 * 简化版的布隆过滤器的实现
 * @author Vitalc
 *
 */
public class BloonFilter {
	public static final int NUM_SLOTS = 1024* 1024 * 8;//位图的长度
	public static final int NUM_HASH = 8;//hash函数的个数，一个hash函数的结果用于标记一个位
	private BigInteger bitmap = new BigInteger("0");//位图
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 1.hash1(msg)标注一个位     hash的值域0~NUM_SLOTS-1
	 * @param message
	 */
	public void addElement(String message) {
		for (int i = 0; i < NUM_HASH; i++) {
			int hashcode = hash(message, i);//代表了hash1,hash2...hash8
			
			//用于标注位图的该位为1
			if (!bitmap.testBit(hashcode)) {//如果不为1, 就标为1
				bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
			}
		}
	}
	
	private int hash(String message, int n) {
		
		return 0;
	}

	public boolean check(String message) {
		
		return true;
	}
}
