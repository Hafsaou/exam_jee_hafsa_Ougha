package models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "projects")
public class Project {
    public List<EmployeProject> getGrades() {
        return grades;
    }

    public void setGrades(List<EmployeProject> grades) {
        this.grades = grades;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double budjet;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<EmployeProject> grades = new ArrayList<EmployeProject>();

    public Project(long id, String name, double budjet) {
        this.id = id;
        this.name = name;
        this.budjet = budjet;
    }

    public Project() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudjet() {
        return budjet;
    }

    public void setBudjet(double budjet) {
        this.budjet = budjet;
    }
}
