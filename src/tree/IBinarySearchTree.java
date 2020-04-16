package tree;

import java.util.List;
import java.util.function.Consumer;

public interface IBinarySearchTree<K, V> {
	/**
	 * �������
	 * @param k
	 * @param v
	 * @return
	 */
	BinarySearchTree<K, V>.Node<K, V> insert(K k, V v);
	
	/**
	 * �������
	 * @param con �������������ÿ��Ԫ�صĺ���
	 */
	void inorder(Consumer<K> con);
	
	/**
	 * ����Ԫ��
	 * @param key
	 * @return
	 */
	V lookupValue(K key);
	
	/**
	 * ��ȡ��С�ؼ���
	 * @return
	 */
	K min();
	
	/**
	 * ��ȡ���ؼ���
	 * @param key
	 */
	K max();
	
	/**
	 * �Ƴ��ؼ��ֶ�Ӧ�Ľ��
	 * @param key
	 */
	void remove(K key);
	
	/**
	 * x�ĺ�̡�����x��ĵ�һ��Ԫ��
	 * 1.��������������Сֵ
	 * 2.û����������������׷�ݣ�ֱ��ĳ�����Ƚ�������ӣ�����������Ƚ��ĸ���㣬������x�ĺ��
	 * @param x
	 * @return
	 */
	K successor(K x);
	
	/**
	 * ǰ��
	 * @param x
	 * @return
	 */
	K predecessor(K x);
	
	/**
	 * �ж��ǲ���ƽ����
	 * @return
	 */
	boolean isBalance();
	
	/**
	 * 
	 * @return
	 */
	int getSize();
	
	/**
	 * 
	 * @return
	 */
	int getHeight();
	
	List<List<BinarySearchTree<K, V>.Node<K, V>>> leverOrder();
}
