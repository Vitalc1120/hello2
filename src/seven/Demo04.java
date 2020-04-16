package seven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());			
		}
		sc.close();
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			//���ƶ���
			Queue<Integer> q = new LinkedList<Integer>();
			while (q.size() != queue.size()) {
				int poll = queue.poll();
				q.add(poll);
				queue.add(poll);
			}
			//ȷ����ʼλ��
			int j = i;
			while (j > 0) {
				q.add(q.poll());
				j--;
			}			
			//ģ�����
			int cnt = 0;
			int sum = 0;
			while (cnt < n && !q.isEmpty()) {
				cnt++;
				int num = q.poll();
				if (num == cnt) {
					sum += num;
					cnt = 0;
				} else {
					q.add(num);
				}		
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
