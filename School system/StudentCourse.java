package dev.m3s.programming2.homework3;
public class StudentCourse extends Course{
	private Course course;
	private int gradeNum;
	private int yearCompleted;
	
	public StudentCourse() {
	}
	public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
		setCourse(course);
		setGrade(gradeNum);
		setYear(yearCompleted);
	}
	
	protected void setGrade(int gradeNum) {
	    if (isNumericGrade()) {
	        if (checkGradeValidity(gradeNum)) {
	            this.gradeNum = gradeNum;
	        }
	    } else {
	        if (checkGradeValidity((char) gradeNum)) {
	            this.gradeNum = (char) gradeNum;
	        }
	    }
	    if (yearCompleted == 0) {
	        yearCompleted = 2023;
	    }
	}

	private boolean checkGradeValidity(final int gradeNum) {
	    boolean Validity = false;
	    if (course.isNumericGrade() == true) {
	    	if(gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE) {
	    		Validity = true;
	    	}
	    }
	    else if (course.isNumericGrade() == false) {
	    	if (gradeNum == 'F' || gradeNum == 'A') {
	    		Validity = true;
	    	}
	    }
	    return Validity;
	}
	
	public boolean isPassed() {
		return !(gradeNum == 0 || gradeNum == 'F');
	}
	
	public Course getCourse() {
		return this.course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getGradeNum() {
		return this.gradeNum;
	}
	
		
	
	public int getYear() {
		return this.yearCompleted;
	}
	public void setYear(final int year) {
		if (year > 2000 && year <= 2023) {
			this.yearCompleted = year;
		}
	}
	public String toString() {
	    if (gradeNum == 0) {
	        return course + " Year: " + yearCompleted + ", Grade: \"Not graded\".]";
	    }
		if (gradeNum == 70) {
	        return course + " Year: " + yearCompleted + ", Grade: " + ConstantValues.GRADE_FAILED + ".]";
		}
		if (gradeNum == 65) {
	        return course + " Year: " + yearCompleted + ", Grade: " + ConstantValues.GRADE_ACCEPTED + ".]";
		}
		else{
	        return course + " Year: " + yearCompleted + ", Grade: " +  gradeNum+ ".]";
		}
	}
	}


