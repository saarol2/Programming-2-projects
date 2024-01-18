package dev.m3s.programming2.homework3;
public class MonthlyPayment extends PersonID implements Payment {
	private double salary;
	public double getSalary() {
		return this.salary;
	}
	public void setSalary(double salary) {
		if (salary > 0.0) {
			this.salary = salary;
		}
	}
	public double calculatePayment() {
		return salary;
	}
}
