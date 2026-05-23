class Student {

    // È buona pratica mettere i campi in testa alla classe
    String name;
    String surname;
    int id;
    int matriculationYear;

    void build(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Name: " + this.name + "\nSurname: " + this.surname +
            "\nid: " + this.id + "\nMatriculation Year: " + this.matriculationYear
        );
    }
}
