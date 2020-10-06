/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Tutor;

/**
 *
 * @author CC04413427955
 */
@ManagedBean (name="novoTutor")
@ViewScoped
public class NovoTutor implements Serializable{
    
    private Tutor tutor;
    private DAO<Tutor> dao;

    public NovoTutor() {
        tutor = new Tutor();
        dao = new DAO(Tutor.class);
    }
    
    public void salvar(){
        dao.inserir(tutor);
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public DAO<Tutor> getDao() {
        return dao;
    }

    public void setDao(DAO<Tutor> dao) {
        this.dao = dao;
    }

    
    
    
    
}
