package dev.m3s.programming2.homework3;
public class DesignatedCourse extends MonthlyPayment{
	private Course course;
	private boolean responsible;
	private int year;
	
	public DesignatedCourse() {
	}
	
	public DesignatedCourse(Course course, boolean responsible, int year) {
		setCourse(course);
		setResponsible(responsible);
		setYear(year);
	}
	
	public Course getCourse() {
		return this.course;
	}
	public void setCourse(Course course) {
		if(course != null) {
			this.course = course;
		}
	}
	public boolean isResponsible() {
		if (getResponsible()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setResponsible(boolean responsible) {
		this.responsible = responsible;
	}
	public boolean getResponsible() {
		return this.responsible;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		if (year >= 2000 &&  year <= 2024) {
			this.year = year;
		}
	}
	
	public String toString() {
		return "[Course= " + course + ", year=" + year + "]";
	}
}
