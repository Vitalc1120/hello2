package linear;

/**
 * Õ∞≈≈–Ú
 * @author Vitalc
 * e*len / max+1
 */
public class BucketSort {
	public static void main(String[] args) {
		int[] arr = {1,3,5,14,7,8,25};
		int len = arr.length;
		int max = arr[0];
		for (int i = 1; i < len; i++) {
			max = Math.max(max, arr[i]);
		}
		ListNode[] buckets = new ListNode[len];
		for (int i = 0; i < len; i++) {
			int hash = hash(arr[i], len, max);
			if (buckets[hash] == null) {
				buckets[hash] = new ListNode(arr[i]);
			} else {
				insert(buckets, hash, arr[i]);
			}
		}
		ListNode p = null;
		int k = 0;
		for (int i = 0; i < len; i++) {
			if (buckets[i] != null) {
				p = buckets[i];
				while (p != null && k < len) {
					arr[k++] = (int)p.data;
					p = p.next;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void insert(ListNode[] buckets, int hash, int data) {
		ListNode bucket = buckets[hash];
		ListNode newNode = new ListNode(data);
		if (data < (int)bucket.data) {
			newNode.next = bucket;
			buckets[hash] = newNode;
			return;
		}
		ListNode pre = bucket;
		ListNode p = bucket.next;
		while (p != null && data < (int)p.data) {
			pre = p;
			p = p.next;
		}
		if (p == null) {
			pre.next = newNode;
		} else {
			pre.next = newNode;
			newNode.next = p;
		}
	}

	public static int hash(int i, int len, int max) {
		return i * len / (max + 1);
	}
}
