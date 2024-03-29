package dao;

import models.Employe;

import java.util.List;

//write EmployeDao class
public interface EmployeDao {


    public void addEmploye(Employe employe);
    public List<Employe> getEmployes();
    public Employe getEmploye(Long id);
    public String deleteEmploye(Employe emp);  
    public List<String> getEmployeNames(); 
    public List<String> getEmployeProjects();
}