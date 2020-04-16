package hash;

import java.util.Iterator;

public interface A_04_IHashSet<E> {
	
	/**
	 * 添加一个元素
	 * @param key
	 * @return
	 */
	void add(E key);
	
	/**
	 * 删除一个元素
	 * @param key
	 * @return
	 */
	void remove(E key);
	
	/**
	 * 清楚所有元素
	 */
	void clear();
	
	/**
	 * 判断元素是否存在
	 * @param key
	 * @return
	 */
	boolean contains(E key);
	
	/**
	 * 判断是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 返回HashSet的size
	 * @return
	 */
	int size();
	
	Iterator<E> iterator();
}
