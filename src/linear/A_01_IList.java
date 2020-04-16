package linear;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface A_01_IList extends Iterator {
	/**
	 * 添加一个元素
	 * @param element
	 */
	void add(Object element);
	
	/**
	 * 删除一个元素
	 * @param element
	 */
	void delete(Object element);
	
	/**
	 * 通过下标删除一个元素
	 * @param index
	 */
	void delete(int index);
	
	/**
	 * 替换一个元素
	 * @param index
	 * @param element
	 */
	void update(int index, Object element);
	
	/**
	 * 判断target元素是否存在
	 * @param target
	 * @return
	 */
	boolean contains(Object target);
	
	/**
	 * 查找元素的下标，找不到返回-1
	 * @param element
	 * @return
	 */
	int indexOf(Object element);
	
	/**
	 * 通过下标查找元素
	 * @param index
	 * @return
	 */
	Object at(int index);
}
