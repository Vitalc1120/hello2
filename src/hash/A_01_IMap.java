package hash;

import java.util.Iterator;

public interface A_01_IMap<K, V> {
	/**
	 * ������м�ֵ��
	 */
	void clear();
	
	/**
	 * Key�Ƿ����
	 * @param key
	 * @return
	 */
	boolean containsKey(K key);
	
	/**
	 * value�Ƿ����
	 * @param value
	 * @return
	 */
	boolean containsValue(V value);
	
	/**
	 * ����key��ȡvalue
	 * @param key
	 * @return
	 */
	V get(K key);
	
	/**
	 * map�Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * ����key��ɵ�����
	 * @return
	 */
	A_05_MyHashSet<K> keySet();
	
	/**
	 * ����value��ɵ�����
	 */
	V[] values();
	
	/**
	 * �����ֵ��
	 * @return
	 */
	void put(K key, V value);
	
	/**
	 * ��һ��map�����м�ֵ�Դ��뵱ǰmap
	 * @param map
	 */
	void putAll(A_01_IMap<? extends K, ? extends V> map);
	
	/**
	 * ����keyɾ��һ����ֵ��
	 * @param Key
	 * @return
	 */
	V remove(K Key);
	
	/**
	 * ��ֵ�Եĸ���
	 * @return
	 */
	int size();
	
	@SuppressWarnings("rawtypes")
	Iterator<A_02_MyHashMap.Node> iterator(); 
}
