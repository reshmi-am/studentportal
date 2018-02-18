package studentportal.model;

public class CourseInfo {

	CourseInfo(){}
	
	public CourseInfo(String degree, String name, int duration, 
			CourseMode mode, int fee, CourseType type){
		this.degree = degree;
		this.name = name;
		this.durationInMonths = duration;
		this.mode = mode;
		this.fee = fee;
		this.type = type;
	}
	
	private String degree;
	private String name;
	private int durationInMonths;
	private CourseMode mode;
	private int fee;
	private CourseType type;
	
	public CourseType getType() {
		return type;
	}

	public void setType(CourseType type) {
		this.type = type;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	public CourseMode getMode() {
		return mode;
	}

	public void setMode(CourseMode mode) {
		this.mode = mode;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
}
