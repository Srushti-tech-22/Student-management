package models;

public class CourseModel {
    // Attributes
    public String courseId;
    public String courseName;
    public String courseDuration;

    // Methods
    public CourseModel(String courseId, String courseName, String courseDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }
}
