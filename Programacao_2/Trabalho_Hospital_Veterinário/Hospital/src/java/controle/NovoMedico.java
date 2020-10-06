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
import modelo.Medico;

/**
 *
 * @author CC04413427955
 */
@ManagedBean (name="novoMedico")
@ViewScoped
public class NovoMedico implements Serializable{
    
    private Medico medico;
    private DAO<Medico> dao;

    public NovoMedico() {
        medico = new Medico();
        dao = new DAO(Medico.class);
    }
    
    public void salvar(){
        dao.inserir(medico);
        System.out.println("Medico cadastrado");
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public DAO<Medico> getDao() {
        return dao;
    }

    public void setDao(DAO<Medico> dao) {
        this.dao = dao;
    }

    

    
    
    
    
}
