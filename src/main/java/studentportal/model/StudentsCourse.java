package studentportal.model;

import java.util.Date;

public class StudentsCourse {

	private int studentId;
	private CourseStatus status;
	private Date doj;
	private String degree;
	private String name;
	private int durationInMonths;
	private CourseMode mode;
	private int fee;
	private CourseType type;
	
	public StudentsCourse(){
		
	}
	
	public StudentsCourse(int studentId, CourseStatus status, Date doj, String degree, String name,
			int durationInMonths, CourseMode mode, int fee, CourseType type) {
		super();
		this.studentId = studentId;
		this.status = status;
		this.doj = doj;
		this.degree = degree;
		this.name = name;
		this.durationInMonths = durationInMonths;
		this.mode = mode;
		this.fee = fee;
		this.type = type;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public CourseStatus getStatus() {
		return status;
	}
	public void setStatus(CourseStatus status) {
		this.status = status;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
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
	public CourseType getType() {
		return type;
	}
	public void setType(CourseType type) {
		this.type = type;
	}
	
}
