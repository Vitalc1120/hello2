package seven;

public class Demo02 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,7,8,9,10,12,13};
		dfs(arr, 0);
	}

	private static void dfs(int[] arr, int k) {
		if (k == arr.length) {
			int a1 = arr[0] + arr[1] + arr[2] + arr[3];
			int a2 = arr[0] + arr[4] + arr[6] + arr[9];
			int a7 = arr[3] + arr[5] + arr[7] + arr[10];
			int a3 = arr[6] + arr[10] + arr[8] + 14;
			int a4 = 14 + arr[4] + arr[1] + 6;
			int a5 = 6 + arr[2] + arr[5] + 11;
			int a6 = 11 + arr[7] + arr[8] + arr[9];
			
			if (a1 == 30 && a2 == 30 && a3 == 30) {
				if (a4 == 30 && a5 == 30 && a6 == 30 && a7 == 30) {
					for (int i = 0; i < arr.length; i++) {
						System.out.print(arr[i] + " ");
					}
					System.out.println();
					//10 3 9 8
				}
			}
			return;
		}
		for (int i = k; i < arr.length; i++) {
			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			dfs(arr, k + 1);
			arr[i] = arr[k];
			arr[k] = temp;
		}
	}
}
