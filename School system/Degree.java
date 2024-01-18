package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;
public class Degree extends StudentCourse {
	private static final int MAX_COURSES = 50;
	private String degreeTitle = ConstantValues.NO_TITLE;
	private String titleOfThesis = ConstantValues.NO_TITLE;
	private List<StudentCourse> myCourses = new ArrayList<>(MAX_COURSES);
	
	public List<StudentCourse>  getCourses() {
		return this.myCourses;
	}
	
	public void addStudentCourses(List<StudentCourse> courses ) {
	if (courses != null) {
		for (StudentCourse course : courses) {
			addStudentCourse(course);
			}
		}
	}
	
	public boolean addStudentCourse(StudentCourse course) {
		if (course == null) {
			return false;
		}
		if (countCourses() < MAX_COURSES) {
			if (myCourses == null) {
				myCourses = new ArrayList<>(MAX_COURSES);
			}
			myCourses.add(course);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Double> getGPA(int type){
		List<Double> gpa = new ArrayList<>();
		double sum = 0.0;
		double counter = 0.0;
		double average = 0.0;
		if (type == ConstantValues.OPTIONAL) {
			for (int i = 0; i < myCourses.size(); i++) {
				if (myCourses.get(i).getCourse().isNumericGrade() && myCourses.get(i).getCourse().getCourseType() == 0) {
		       		sum += myCourses.get(i).getGradeNum();
		       		counter++;
				}
			}
		}
		else if (type == ConstantValues.MANDATORY) {
			for (int i = 0; i < myCourses.size(); i++) {
				if (myCourses.get(i).getCourse().isNumericGrade() && myCourses.get(i).getCourse().getCourseType() == 1) {
		       		sum += myCourses.get(i).getGradeNum();
		       		counter++;
				}
		    }
		}
		else if (type == ConstantValues.ALL) {
		   	for (int i = 0; i < myCourses.size(); i++) {
		   		if (myCourses.get(i).getCourse().isNumericGrade()) {
		       		sum += myCourses.get(i).getGradeNum();
		       		counter++;
		   		}
		   	}
		}
		average += (sum / counter);
		gpa.add(sum);
		gpa.add(counter);
		gpa.add(average);
		return gpa;
	}
		
	public int countCourses() {
		int courses = 0;
		for (int i = 0; i < myCourses.size(); i++) {
			if(myCourses.get(i) != null) {
				courses++;
			}
		}
		return courses;
	}
	
	public String getDegreeTitle() {
		return this.degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		if (degreeTitle != null) {
			this.degreeTitle = degreeTitle;
		}
	}
	public String getTitleOfThesis() {
		return this.titleOfThesis;
	}
	public void setTitleOfThesis(String titleOfThesis) {
		if (titleOfThesis != null) {
			this.titleOfThesis = titleOfThesis;
		}
	}
	public double getCreditsByBase(Character base) {
		double courseCredits = 0.0;
		for (int i = 0; i < myCourses.size(); i++) {
			if (myCourses.get(i) != null) {
				if (isCourseCompleted(myCourses.get(i))) {
					if (myCourses.get(i).getCourse().getCourseBase() == base) {
						courseCredits += myCourses.get(i).getCourse().getCredits();
					}
				}
			}
		}
		return courseCredits;
	}

	public double getCreditsByType(final int courseType) {
		double courseCredits = 0.0;
		for (int i = 0; i < myCourses.size(); i++) {
			if (myCourses.get(i) != null) {
				if (isCourseCompleted(myCourses.get(i))) {
					if (myCourses.get(i).getCourse().getCourseType() == courseType) {
						courseCredits += myCourses.get(i).getCourse().getCredits();
					}
				}
			}
		}
		return courseCredits;
	}
	public double getCredits() {
		double completed = 0.0;
		for (int i = 0; i < myCourses.size(); i++) {
			if (myCourses.get(i) != null) {
				if (isCourseCompleted(myCourses.get(i))) {
					completed += myCourses.get(i).getCourse().getCredits();
				}
			}
		}
		return completed;
	}
	
	private boolean isCourseCompleted(StudentCourse course) {
		return course.isPassed();
	}

	public void printCourses() { 
	    for(int i = 0; i < myCourses.size(); i++) {
	    	if (myCourses.get(i) != null) {
	    		System.out.println(myCourses.get(i));
	    	}
	    }
	}

	public String coursesToString(){
		int N = 1;
		String allCourses = "";
		for (int i = 0; i < myCourses.size(); i++){
			if (myCourses.get(i) != null) {
	            allCourses += Integer.toString(N) + ". " + myCourses.get(i) + "\n";
	            N++;
	        }
	    }
	    return allCourses;
	}

	public String toString() {
		return "Degree [Title: " + degreeTitle + " (courses: " + countCourses() + ")\n" + "Thesis title: " + titleOfThesis + "]\n" + coursesToString();
	}
}

