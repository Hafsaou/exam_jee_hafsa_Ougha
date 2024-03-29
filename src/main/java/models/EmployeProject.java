package models;


import jakarta.persistence.*;

@Entity
@Table(name = "jpa_student_courses")
public class EmployeProject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double grade;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Project project;


}
