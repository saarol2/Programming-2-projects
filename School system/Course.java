package dev.m3s.programming2.homework3;
public class Course {
	private String name = ConstantValues.NO_TITLE;
	private String courseCode = ConstantValues.NOT_AVAILABLE;
	private Character courseBase = ' ';
	private int courseType;
	private int period;
	protected double credits;
	private boolean numericGrade;
	
	public Course() {
}
	public Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
		setName(name);
	    setCourseType(type);
	    setPeriod(period);
	    setCredits(credits);
	    setNumericGrade(numericGrade);
	    setCourseCode(code, courseBase);
	}
	
	public Course(Course course) {
	    this.setName(course.getName());
	    this.setCourseCode(Integer.parseInt(course.getCourseCode().substring(0,6)), course.getCourseBase());
	    this.setCourseType(course.getCourseType());
	    this.setPeriod(course.getPeriod());
	    this.setCredits(course.getCredits());
	    this.setNumericGrade(course.isNumericGrade());
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}
	
	public String getCourseTypeString() {
		if (courseType == 0) {
			return "Optional";
			}
		else {
				return "Mandatory";
			}
	}
	
	public int getCourseType() {
		if (courseType == 0) {
			return 0;
		}
		return 1;
		}
	
	public void setCourseType(final int type) {
		if (type == 0) {
			this.courseType = 0; 
		}
		if (type == 1) {
			this.courseType = 1;
		}
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(final int courseCode, Character courseBase) {
		if ((courseCode < 1000000 && courseCode > 0) && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')) {
	        this.courseBase = courseBase;
	        this.courseCode = Integer.toString(courseCode) + courseBase;
		}
	}
	
	public Character getCourseBase() {
		return this.courseBase;
	}
	
	public int getPeriod() {
		return this.period;
	}
	
	public void setPeriod(final int period) {
		if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD) {
			this.period = period;
		}
	}
	
	public double getCredits() {
		return this.credits;
	}
	
	private void setCredits(final double credits) {
		if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
			this.credits = credits;
		}
	}
	
	public boolean isNumericGrade() {
		return this.numericGrade;
	}
	
	public void setNumericGrade(boolean numericGrade) {
		this.numericGrade = numericGrade;
	}
	
	public String toString() {
		if (courseType == 0) {
	    return "[" + courseCode + " ( " + String.format("%.2f", credits) + " cr), \"" + name + "\". "
	    		+ "Optional"+ ", period: " + period + ".]";
	}
		else {
			return "[" + courseCode + " ( " + String.format("%.2f", credits) + " cr), \"" + name + "\". "
		    		+ "Mandatory"+ ", period: " + period + ".]";
		}
	}
}

