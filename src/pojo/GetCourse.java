package pojo;

public class GetCourse {

	private String Url;
	private String Services;
	private String Expertise;
	private String LinkedIn;
	private Courses Courses;
	private String Instructor;
	
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getServices() {
		return Services;
	}
	public void setServices(String services) {
		Services = services;
	}
	public String getExpertise() {
		return Expertise;
	}
	public void setExpertise(String expertise) {
		Expertise = expertise;
	}
	public String getLinkedIn() {
		return LinkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}
	public pojo.Courses getCourses() {
		return Courses;
	}
	public void setCourses(pojo.Courses courses) {
		Courses = courses;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	
}
