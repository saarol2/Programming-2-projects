package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher, Payment {
	private List<DesignatedCourse> courses = new ArrayList<>();
	
	public AssistantTeacher(String lastName, String firstName) {
		super(lastName, firstName);
	}
	
	public String getEmployeeIdString() {
		return "OY_ASSISTANT_";
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
	
	public String getCourses() {
	    StringBuilder sb = new StringBuilder();
	    for (DesignatedCourse course : courses) {
	        sb.append(course.toString()).append("\n");
	    }
	    return sb.toString();
	}
	
	
	public String toString() {
		return "Teacher id: " + getIdString() + "\n	First name: " + getFirstName() + ", Last name: " + getLastName()
		+ "\n	Birthdate: " + getBirthDate() + "\n	Salary: " + String.format("%.2f", calculatePayment()) +  "\n	Assistant for courses: \n	"
		+ getCourses();
	}
}
