package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student andrea = new Student(1, "Andrea", "Zorzi", "1234", 2019);
        Student alberto = new Student(2, "Alberto", "Licari", "12345", 2020);
        Student mariangela = new Student(3, "Mariangela", "Abbati", "123456", 2021);

        // 2)Creare 2 docenti a piacere
        Professor giorgio = new Professor(11, "Giorgio", "Sempione", "2233", new String[]{"Matematica", "Italiano"});
        Professor luca = new Professor(12, "Luca", "Bianchi", "22334", new String[]{"Informatica", "Fisica"});

        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom aula1 = new ExamRoom(100, "Aula capiente", true, true);
        ExamRoom aula2 = new ExamRoom(80, "Aula meno capiente", false, true);

        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam exam1 = new Exam(1, 10, "Matematica", giorgio, aula1, new Student[10]);
        Exam exam2 = new Exam(2, 2, "Informatica", luca, aula2, new Student[2]);

        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(andrea);
        exam1.registerStudent(alberto);
        exam1.registerStudent(mariangela);


        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1);
        System.out.println(exam2);
    }
}
