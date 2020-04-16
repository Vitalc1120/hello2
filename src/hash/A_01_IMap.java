package hash;

import java.util.Iterator;

public interface A_01_IMap<K, V> {
	/**
	 * 清除所有键值对
	 */
	void clear();
	
	/**
	 * Key是否存在
	 * @param key
	 * @return
	 */
	boolean containsKey(K key);
	
	/**
	 * value是否存在
	 * @param value
	 * @return
	 */
	boolean containsValue(V value);
	
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 */
	V get(K key);
	
	/**
	 * map是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 所有key组成的数组
	 * @return
	 */
	A_05_MyHashSet<K> keySet();
	
	/**
	 * 所有value组成的数组
	 */
	V[] values();
	
	/**
	 * 存入键值对
	 * @return
	 */
	void put(K key, V value);
	
	/**
	 * 把一个map的所有键值对存入当前map
	 * @param map
	 */
	void putAll(A_01_IMap<? extends K, ? extends V> map);
	
	/**
	 * 根据key删除一个键值对
	 * @param Key
	 * @return
	 */
	V remove(K Key);
	
	/**
	 * 键值对的个数
	 * @return
	 */
	int size();
	
	@SuppressWarnings("rawtypes")
	Iterator<A_02_MyHashMap.Node> iterator(); 
}
