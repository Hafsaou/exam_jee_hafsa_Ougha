package beans;

import dao.EmployeDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import models.Employe;
import services.EmployeDaoImp;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean
public class EmployeBean {
    public Long id;
    public String name;
    public String email; 
    public List<String> skills;
    public List<String> projects;
    public List<Employe> employes = new ArrayList<Employe>();
    public Employe employe;
    public EmployeBean() {
    }
    public EmployeBean(Long id, String name, String email, List<String> skills, List<String> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.projects = projects;
    }



    @PostConstruct
    public void init() {
   employes = new EmployeDaoImp().getEmployes();
   employe= new Employe();
        for(String n : new EmployeDaoImp().getEmployeNames())
        {
            name=name+n;
        }

        for(String project : new EmployeDaoImp().getEmployeProjects())
        {
            projects=projects+project;
        }



    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    public List<String> getProjects() {
        return projects;
    }
    public void setProjects(List<String> projects) {
        this.projects = projects;
    }


    public void deleteEmp(Employe emp) {
        new EmployeDaoImp().deleteEmploye(emp);
    }
   

}
