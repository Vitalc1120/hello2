import java.util.Scanner;

public class Student {
	public String name;
	public String gender;
	public int age;	
	public int english;
	public int math;
	public int computer;
	
	public Student(String name, String gender, int age, int english, int math, int computer) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.english = english;
		this.math = math;
		this.computer = computer;
	}

	public Student() {
		super();
	}

	public void setStuInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ѧ�������� �Ա� ���� Ӣ��ɼ� ��ѧ�ɼ� ������ɼ�");
		this.name = sc.next();
		this.gender = sc.next();
		this.age = sc.nextInt();
		this.english = sc.nextInt();
		this.math = sc.nextInt();
		this.computer = sc.nextInt();
		sc.close();
	}
	
	public void showStuInfo() {
		System.out.println("��ѧ����������:" + this.name);
		System.out.println("��ѧ�����Ա���:" + this.gender);
		System.out.println("��ѧ����������:" + this.age);
		System.out.println("��ѧ����Ӣ��ɼ���:" + this.english);
		System.out.println("��ѧ������ѧ�ɼ���:" + this.math);
		System.out.println("��ѧ���ļ�����ɼ���:" + this.computer);
	}

	public int getSum() {
		return this.english + this.math + this.computer; 
	}
	
	public double getAverage() {
		return getSum() / 3;
	}
}
