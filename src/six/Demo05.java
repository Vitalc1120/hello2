package six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Demo05 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();         
        String[] pwd = new String[n];
        for (int i = 0; i < n; i++) {     	
            pwd[i] = sort(sc.next());
        }
        sc.close();
        getResult(str, pwd);
    }
	
    public static void getResult(String str, String[] pwd) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] num = new int[pwd.length];
        for (int i = 0; i < pwd.length; i++) {
            int hash = pwd[i].hashCode();
            if (list.contains(hash)) {
                int j = list.indexOf(hash);
                num[j]++;
            } else {
                list.add(hash);
                num[list.size() - 1]++;
            }
        }
        for (int i = 0; i <= str.length() - 8; i++) {
            String s = str.substring(i, i + 8);
            sort(s);
            int hash = s.hashCode();
            if (list.contains(hash)) {
                int index = list.indexOf(hash);
                count += num[index];
            }
        }
        System.out.println(count);
    }
    
    public static String sort(String s) {
    	char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
