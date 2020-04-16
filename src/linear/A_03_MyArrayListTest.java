package linear;

import org.junit.Test;

public class A_03_MyArrayListTest {

	@Test
	public final void testAdd() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("1");
		list.add("2");
		System.out.println(list);
	}

	@Test
	public final void testDeleteObject() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.delete("1");
		System.out.println(list);
	}

	@Test
	public final void testDeleteInt() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.delete(4);
		System.out.println(list);
	}

	@Test
	public final void testUpdate() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.update(4, "2");
		System.out.println(list);
	}

	@Test
	public final void testContains() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("0");
		list.add(1);
		list.add("3");	
		System.out.println(list.contains(0));
	}

	@Test
	public final void testIndexOf() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("0");
		list.add(1);
		list.add("3");	
		System.out.println(list.indexOf(1));
	}

	@Test
	public final void testAt() {
		A_02_MyArrayList list = new A_02_MyArrayList();
		list.add("1");
		list.add("2");
		list.add("3");	
		System.out.println(list.at(3));
	}

}
