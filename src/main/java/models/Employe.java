package models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employes")
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    public Employe(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public List<EmployeProject> getGrades() {
        return grades;
    }

    public void setGrades(List<EmployeProject> grades) {
        this.grades = grades;
    }

    public Employe() {

    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<EmployeProject> grades = new ArrayList<EmployeProject>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
   
