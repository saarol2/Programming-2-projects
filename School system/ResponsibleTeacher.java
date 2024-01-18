package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher, Payment {
	private List<DesignatedCourse> courses = new ArrayList<>();
	
	public ResponsibleTeacher(String lastName, String firstName) {
		super(lastName, firstName);
	}
	
	public String getEmployeeIdString() {
		return "OY_TEACHER_";
	}
	
	public String getCourses() {
	    StringBuilder sb = new StringBuilder();
	    for (DesignatedCourse course : courses) {
	    	if (course.isResponsible()) {
	    		sb.append("Responsible teacher: ").append(course.toString()).append("\n");
	    }
	    	else {
	    		sb.append("Teacher: ").append(course.toString()).append("\n");
	    	}
	    }
	    return sb.toString();
	}
	
	
	public void setCourses(List<DesignatedCourse> courses) {
		List<DesignatedCourse> newCourses = new ArrayList<>();
		if (courses != null) {
			for (DesignatedCourse course : courses) {
				newCourses.add(course);
			}
		}
		this.courses = newCourses;
	}
	
	public String toString() {
		return "Teacher id: " + getIdString() + "\n	First name: " + getFirstName() + ", Last name: " + getLastName()
		+ "\n	Birthdate: " + getBirthDate() + "\n	Salary: " + String.format("%.2f", calculatePayment()) +  "\n	Teacher for courses: \n	"
		+ getCourses();
	}
	
}
