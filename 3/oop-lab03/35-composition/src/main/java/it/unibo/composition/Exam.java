package it.unibo.composition;

public class Exam {
    private int id;
    private int maxStudents;
    private String courseName;
    private Professor professor;
    private ExamRoom examRoom;
    private Student[] students;

    Exam(int id, int maxStudents, String courseName, Professor professor, ExamRoom examRoom, Student[] students) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.courseName = courseName;
        this.professor = professor;
        this.examRoom = examRoom;
        this.students = students;
    }

    // iscrive los tudente all'appello, qualora si sia raggiunto il limite massimo non fa nulla
    public void registerStudent(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                return;
            }
        }
    }

    // metodo to string che usare Array.toStirng() per una visualizzazione formato string di un array
    @Override
    public String toString() {
        return "Exam: " + this.courseName + " Professor: " + this.professor.getUsername() + " Exam Room: " + this.examRoom.getDescription() + " Students: " + java.util.Arrays.toString(this.students);
    }

    public int getId() {
        return this.id;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }
    
    public String getCourseName() {
        return this.courseName;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public ExamRoom getExamRoom() {
        return this.examRoom;
    }

    public Student[] getStudents() {
        return this.students;
    }
}
