package hash;

import java.util.Iterator;

public interface A_04_IHashSet<E> {
	
	/**
	 * ���һ��Ԫ��
	 * @param key
	 * @return
	 */
	void add(E key);
	
	/**
	 * ɾ��һ��Ԫ��
	 * @param key
	 * @return
	 */
	void remove(E key);
	
	/**
	 * �������Ԫ��
	 */
	void clear();
	
	/**
	 * �ж�Ԫ���Ƿ����
	 * @param key
	 * @return
	 */
	boolean contains(E key);
	
	/**
	 * �ж��Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * ����HashSet��size
	 * @return
	 */
	int size();
	
	Iterator<E> iterator();
}
