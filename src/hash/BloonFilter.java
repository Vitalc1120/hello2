package hash;

import java.math.BigInteger;

/**
 * �򻯰�Ĳ�¡��������ʵ��
 * @author Vitalc
 *
 */
public class BloonFilter {
	public static final int NUM_SLOTS = 1024* 1024 * 8;//λͼ�ĳ���
	public static final int NUM_HASH = 8;//hash�����ĸ�����һ��hash�����Ľ�����ڱ��һ��λ
	private BigInteger bitmap = new BigInteger("0");//λͼ
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 1.hash1(msg)��עһ��λ     hash��ֵ��0~NUM_SLOTS-1
	 * @param message
	 */
	public void addElement(String message) {
		for (int i = 0; i < NUM_HASH; i++) {
			int hashcode = hash(message, i);//������hash1,hash2...hash8
			
			//���ڱ�עλͼ�ĸ�λΪ1
			if (!bitmap.testBit(hashcode)) {//�����Ϊ1, �ͱ�Ϊ1
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
