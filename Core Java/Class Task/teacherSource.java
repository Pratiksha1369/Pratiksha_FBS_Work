class Teacher {
    String name;
    String subject;
    int experience;
    double salary;

    void setName(String name) {
        this.name = name;
    }

    void setSubject(String subject) {
        this.subject = subject;
    }

    void setExperience(int experience) {
        this.experience = experience;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }
} //Teacher ends here

class TeacherTest {
    public static void main(String[] args) {
        Teacher t1;
        t1 = new Teacher();
        t1.setName("Anita Verma");
        t1.setSubject("Mathematics");
        t1.setExperience(12);
        t1.setSalary(55000);

        System.out.println("Name: " + t1.name);
        System.out.println("Subject: " + t1.subject);
        System.out.println("Experience: " + t1.experience + " years");
        System.out.println("Salary: " + t1.salary);
    } //main ends here
} //TeacherTest ends here
