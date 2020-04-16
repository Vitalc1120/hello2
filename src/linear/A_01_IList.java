package linear;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface A_01_IList extends Iterator {
	/**
	 * ���һ��Ԫ��
	 * @param element
	 */
	void add(Object element);
	
	/**
	 * ɾ��һ��Ԫ��
	 * @param element
	 */
	void delete(Object element);
	
	/**
	 * ͨ���±�ɾ��һ��Ԫ��
	 * @param index
	 */
	void delete(int index);
	
	/**
	 * �滻һ��Ԫ��
	 * @param index
	 * @param element
	 */
	void update(int index, Object element);
	
	/**
	 * �ж�targetԪ���Ƿ����
	 * @param target
	 * @return
	 */
	boolean contains(Object target);
	
	/**
	 * ����Ԫ�ص��±꣬�Ҳ�������-1
	 * @param element
	 * @return
	 */
	int indexOf(Object element);
	
	/**
	 * ͨ���±����Ԫ��
	 * @param index
	 * @return
	 */
	Object at(int index);
}
