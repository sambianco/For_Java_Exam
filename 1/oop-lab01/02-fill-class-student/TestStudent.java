class TestStudent {

    public static void main(String[] args) {
        Student Alex = new Student();
        Alex.build("Alex", "Balducci", 1015, 2019);
        Alex.printStudentInfo();
        Student Angel = new Student();
        Angel.build("Angel", "Bianchi", 1016, 2018);
        Angel.printStudentInfo();
        Student Andrea = new Student();
        Andrea.build("Andrea", "Bracci", 1017, 2017);
        Andrea.printStudentInfo();
    }
}
