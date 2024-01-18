package dev.m3s.programming2.homework3;

public abstract class Employee extends Person implements Payment{
	private String empId;
	private int startYear = 2023;
	private Payment payment;
	
	public Employee(String lastName, String firstName) {
		super(lastName, firstName);
		setStartYear(startYear);
		this.empId = getEmployeeIdString() + super.getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
	}
	
	public String getIdString() {
		return empId;
	 }
	
	public int getStartYear() {
		return this.startYear;
	}
	
	public void setStartYear(final int startYear) {
		if (startYear > 2000 && startYear <= 2023) {
		this.startYear = startYear;
		}
	}
	
	public Payment getPayment() {
		return this.payment;
	}
	
	public void setPayment(Payment payment) {
		if (payment != null) {
			this.payment = payment;
		}
	}
	
	public double calculatePayment() {
		if (payment != null) {
			return payment.calculatePayment();
		} else {
			return 0.0;
		}
	}
	
	protected abstract String getEmployeeIdString();
	
}
