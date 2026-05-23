package it.unibo.composition;

public class Professor implements User{

    private int id;
    private String name;
    private String surname;
    private String password;
    private String courses[];

    Professor(int id, String name, String surname, String password, String courses[]) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = courses;
    }

    public void replaceCourses(String course, int id) {
        this.courses[id] = course;
    }

    public void replaceAllCourses(String courses[], int id) {
        this.courses = courses;
    }
    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getDescription() {
        return "Professor: " + this.name + " " + this.surname + " ID: " + this.id + " Courses: " + this.courses;
    }

}
