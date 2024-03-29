package services;

import dao.EmployeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.Employe;

import java.util.List;

public class EmployeDaoImp implements EmployeDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-eclipselink");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public void addEmploye(Employe employe) {
        
    }

    @Override
    public List<Employe> getEmployes() {

        tx.begin();

        List<Employe> emp = em.createQuery("SELECT e FROM Employe e").getResultList();
        tx.commit();
        em.close();
        emf.close();
        return emp;
    }

    @Override
    public Employe getEmploye(Long id) {
        return null;
    }

    @Override
    public String deleteEmploye(Employe emp) {
 
        tx.begin();
        em.remove(em.find(Employe.class, emp.getId()));
        tx.commit();
        em.close();
        emf.close();
 
        return "index.xhtml?faces-redirect=true";
    }

    @Override
    public List<String> getEmployeNames() { 
        List<String> names = em.createQuery("SELECT e.name FROM Employe e").getResultList(); 
        em.close();
        emf.close();
        return names;
    }

    @Override
    public List<String> getEmployeProjects() { 
        List<String> projects = em.createQuery("SELECT e.projects FROM Employe e").getResultList();
        em.close();
        emf.close();
        return projects;
    }
}
 