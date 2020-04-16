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
			//复制队列
			Queue<Integer> q = new LinkedList<Integer>();
			while (q.size() != queue.size()) {
				int poll = queue.poll();
				q.add(poll);
				queue.add(poll);
			}
			//确定开始位置
			int j = i;
			while (j > 0) {
				q.add(q.poll());
				j--;
			}			
			//模拟操作
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
