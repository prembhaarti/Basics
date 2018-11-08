package jbasic.java8.generics;

public class ToString<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override public String toString() {
		return t.toString();
	}

	public ToString(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		Employee prem = new Employee("Prem",1);
		Student love = new Student("Love", 2);

		ToString<Employee> entity = new ToString<>(prem);
		ToString<Student> entity2= new ToString<>(love);
		System.out.println(entity);
		System.out.println(entity2);
	}

	static class Employee {
		private String name;
		private int id;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override public String toString() {
			return "Employee{" + "name='" + name + '\'' + ", id=" + id + '}';
		}

		public Employee(String name, int id) {
			this.name = name;
			this.id = id;
		}
	}

	static class Student{
		private String name;
		private int roll;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRoll() {
			return roll;
		}

		public void setRoll(int roll) {
			this.roll = roll;
		}

		@Override public String toString() {
			return "Student{" + "name='" + name + '\'' + ", roll=" + roll + '}';
		}

		public Student(String name, int roll) {
			this.name = name;
			this.roll = roll;
		}
	}
}
