/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Dono;

/**
 *
 * @author CC04413427955
 */
@ManagedBean (name="novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable{
    
    private Animal animal;
    private DAO<Animal> dao;
    private List<Dono> donos;
    private DAO<Dono> daoDono;

    public NovoAnimal() {
        animal = new Animal();
        dao = new DAO(Animal.class);
        daoDono = new DAO (Dono.class);
        donos = daoDono.listarTodos();
    }
    
    public void salvar(){
        dao.inserir(animal);
        System.out.println("Animal cadastrado");
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Dono> getDonos() {
        return donos;
    }

    public void setDonos(List<Dono> donos) {
        this.donos = donos;
    }

    public DAO<Dono> getDaoDono() {
        return daoDono;
    }

    public void setDaoDono(DAO<Dono> daoDono) {
        this.daoDono = daoDono;
    }

   

    
    
    
}