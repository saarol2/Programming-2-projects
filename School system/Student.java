package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
	private int id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
	private int startYear = 2023;
	private int graduationYear;
	private List<Degree> degrees = new ArrayList<>(3); {
		degrees.add(new Degree());
		degrees.add(new Degree());
		degrees.add(new Degree());
		}
	public Student(String lastName, String firstName) {
		super(lastName, firstName);
		setId(id);
		}
	
	public void setId(final int id) {
		if (id > 0 && id <= 100){
			this.id = id;
		}
	}
	
	public int getId() {
		return this.id;
	}
		
	public void setstartYear(final int startYear) {
		if (startYear > 2000 && startYear <= 2023) {
		this.startYear = startYear;
		}
	}
	public int getstartYear() {
		return this.startYear;
	}
	
	private boolean canGraduate() {
		if (degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS && degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS) {
			if (degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE) {
				return true;
			}
		}
		return false;
	}
	
	public String setGraduationYear(final int graduationYear) {
		if (!canGraduate()) {
	        return "Check amount of required credits";
	    } else if (graduationYear < startYear || graduationYear > 2023) {
	        return "Check graduation year";
	    } else {
	        this.graduationYear = graduationYear;
	        return "Ok";
		}
	}
				
	public int getGraduationYear() {
		return this.graduationYear;
	}
	
	public boolean hasGraduated() {
		return graduationYear != 0 && graduationYear <= 2023;
	}
	
	public int getStudyYears() {
		if (hasGraduated()) {
		return graduationYear - startYear;
		}
		else {
			return 2023 - startYear;
		}
	}
	
	public void setDegreeTitle(final int i, String dName) {
		if (i >= 0 && i < degrees.size()) {
			if (dName != null) {
				degrees.get(i).setDegreeTitle(dName);
			}
		}
	}
	
	public boolean addCourse(final int i, StudentCourse course) {
	    if (i >= 0 && i < degrees.size()) {
	        if (course != null) {
	            if (degrees.get(i).addStudentCourse(course)) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    } 
	    return false;
	}
	
	public int addCourses(final int i, List<StudentCourse> course) {
        int added = 0;
        if (i >= 0 && i < degrees.size()) {
	        if (course != null) {
	        	for (int j = 0; j < course.size(); j++) {
	        		if (course.get(j) != null && degrees.get(i).countCourses() < 50) {
	        			addCourse(i, course.get(j));
	        			added++;
	        			}
	        		}
	        	}
	       	}
        return added;
    }
	
	public void setTitleOfThesis(final int i, String title) {
		if (i >= 0 && i < degrees.size()) {
	        if (title != null) {
			degrees.get(i).setTitleOfThesis(title);
	        }
		}
	}
	
	public void printCourses() { 
	    for (int i = 0; i < degrees.size(); i++) {
	        	degrees.get(i).printCourses();
	    	}
	    }
	
	 public void printDegrees() {
	        for (int i = 0; i < degrees.size(); i++) {
	        	System.out.println(degrees.get(i));
	        }
	 	}	
	
	 private double missingBC() {
		 double BC = ConstantValues.BACHELOR_CREDITS;
		 if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS){
			 BC -= degrees.get(0).getCredits();
		 }
		 return BC;
	 }
	 
	 private double missingMC() {
		 double MC = ConstantValues.MASTER_CREDITS;
		 if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS){
			 MC -= degrees.get(1).getCredits();
		 }
		 return MC;
	 }
	 private double combinedCredits() {
		 double cr = degrees.get(0).getCredits() + degrees.get(1).getCredits();
		 return cr;
	 }
	 
	 public String getIdString() {
		 return "Student id: " + id;
	 }
	 
	 public double combinedGPA() {
		 double gpa = 0.0;
		 gpa += degrees.get(0).getGPA(2).get(2) * degrees.get(0).countCourses();
		 gpa += degrees.get(1).getGPA(2).get(2) * degrees.get(1).countCourses();
		 gpa /= (degrees.get(0).countCourses() + degrees.get(1).countCourses());
		 return gpa;
	 }
	 
	public String toString() {
		String toString = getIdString() + "\n	First name: " + getFirstName() + ", Last name: " + getLastName() 
				+ "\n	Date of birth: " + getBirthDate() + "\n	Status: ";
		if (hasGraduated()) {
			toString += "The student has graduated in " + graduationYear;
		}
		else {
			toString += "The student has not graduated, yet";
			}
		toString += "\n	Start year: " + startYear + "(Studies have lasted for " + getStudyYears() + " years)"
				+ "\n	Total credits: " + combinedCredits() + " [GPA = " + String.format("%.2f", combinedGPA()) + "]" + "\n	Bachelor credits: " + degrees.get(0).getCredits();
		if (degrees.get(0).getCredits() < 180) {
			toString += "\n		Missing bachelors credits " + missingBC() + " (" + degrees.get(0).getCredits() + "/180.0)";
		}
		else {
			toString += "\n		Total bachelor credits completed: (" + degrees.get(0).getCredits() + "/180.0)";
		}
		toString += "\n		All mandatory bachelor credits completed: (" + degrees.get(0).getCreditsByType(1) + "/150.0)";
		toString += "\n		GPA of Bachelor studies: " + String.format("%.2f", degrees.get(0).getGPA(2).get(2));
		toString += "\n		Title of BSc thesis: " + degrees.get(0).getTitleOfThesis()+ "\n	Master Credits: " + degrees.get(1).getCredits();
		
		if (degrees.get(1).getCredits() < 120) {
			toString += "\n		Missing master's credits " + missingMC() + " (" + degrees.get(1).getCredits() + "/120.0)";
		}
		else {
			toString += "\n		Total master's credits completed: (" + degrees.get(1).getCredits() + "/120.0)";
		}
		toString += "\n		All mandatory master credits completed: (" + degrees.get(1).getCreditsByType(1) + "/50.0)";
		toString += "\n		GPA of Master studies: " + String.format("%.2f", degrees.get(1).getGPA(2).get(2));
		toString += "\n		Title of MSc thesis: " + degrees.get(1).getTitleOfThesis();
		
				return toString;
			}
		}
