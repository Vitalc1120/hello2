package linear;

import org.junit.Test;

public class A_07_DoubleLinkListTest {

	static A_06_DoubleLinkList list = new A_06_DoubleLinkList();
	
	@Test
	public final void testAdd() {
		list.add("1");
		list.add("2");
		System.out.println(list);
	}

	@Test
	public final void testDeleteObject() {
		list.add("1");
		list.add("2");
		list.add("3");
		list.delete("3");
		System.out.println(list);
	}

	@Test
	public final void testDeleteInt() {
		list.add("1");
		list.add("2");
		list.add("3");
		list.delete(2);
		System.out.println(list);
	}

	@Test
	public final void testUpdate() {
		list.add("1");
		list.add("2");
		list.add("3");
		list.update(3, "x");
		System.out.println(list);
	}

	@Test
	public final void testContains() {
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list.contains("1"));
		System.out.println(list.contains("x"));
	}

	@Test
	public final void testIndexOf() {
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list.indexOf("1"));
		System.out.println(list.indexOf("2"));
		System.out.println(list.indexOf("3"));
		System.out.println(list.indexOf("x"));
	}

	@Test
	public final void testAt() {
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list.at(2));
	}
	
	@Test
	public final void iter() {
		list.add("1");
		list.add("2");
		list.add("3");
		while (list.hasNext()) {
			System.out.println(list.next());
		}
	}

}
