package linear;

import org.junit.Assert;
import org.junit.Test;

public class A_05_SingleLinkListTest {

	@Test
	public final void testAdd() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("1");
		System.out.println(list);
	}

	@Test
	public final void testDeleteObject() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.delete("1");
		System.out.println(list);
	}

	@Test
	public final void testDeleteInt() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.delete(0);
		//System.out.println(list);
		Assert.assertEquals("[2,3,4]", list.toString());
	}

	@Test
	public final void testUpdate() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.update(4, "5");
		System.out.println(list);
	}

	@Test
	public final void testContains() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		//System.out.println(list.contains("t"));
		Assert.assertEquals(false, list.contains("d"));
		Assert.assertEquals(true, list.contains("1"));
	}

	@Test
	public final void testIndexOf() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list.indexOf("1"));
	}

	@Test
	public final void testAt() {
		A_04_SingleLinkList list = new A_04_SingleLinkList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list.at(0));
	}
	
}
