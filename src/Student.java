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
		System.out.println("依次输入学生的姓名 性别 年龄 英语成绩 数学成绩 计算机成绩");
		this.name = sc.next();
		this.gender = sc.next();
		this.age = sc.nextInt();
		this.english = sc.nextInt();
		this.math = sc.nextInt();
		this.computer = sc.nextInt();
		sc.close();
	}
	
	public void showStuInfo() {
		System.out.println("该学生的姓名是:" + this.name);
		System.out.println("该学生的性别是:" + this.gender);
		System.out.println("该学生的年龄是:" + this.age);
		System.out.println("该学生的英语成绩是:" + this.english);
		System.out.println("该学生的数学成绩是:" + this.math);
		System.out.println("该学生的计算机成绩是:" + this.computer);
	}

	public int getSum() {
		return this.english + this.math + this.computer; 
	}
	
	public double getAverage() {
		return getSum() / 3;
	}
}
