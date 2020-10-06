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
import modelo.Dono;

/**
 *
 * @author CC04413427955
 */
@ManagedBean (name="novoDono")
@ViewScoped
public class NovoDono implements Serializable{
    
    private Dono dono;
    private DAO<Dono> dao;

    public NovoDono() {
        dono = new Dono();
        dao = new DAO(Dono.class);
    }
    
    public void salvar(){
        dao.inserir(dono);
        System.out.println("Dono cadastrado");
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public DAO<Dono> getDao() {
        return dao;
    }

    public void setDao(DAO<Dono> dao) {
        this.dao = dao;
    }

    

    
    
    
    
}
