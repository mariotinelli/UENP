/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;



import dao.ExcecaoObjetoNaoEncontrado;


import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Medico;

@ManagedBean
@ViewScoped
public class ConsultaControleAnimal implements Serializable {

    private Consulta consulta;
    private DAO<Consulta> dao;
    private List<Consulta> lista;
    private DAO<Medico> daoMedico;
    private List<Medico> medicos;
    private DAO<Animal> daoAnimal;
    private List<Animal> animais;
    private String nome;
    private List<Consulta> results;


    public ConsultaControleAnimal() {
        consulta = new Consulta();
        dao = new DAO(Consulta.class);
        daoMedico = new DAO (Medico.class);
        medicos = daoMedico.listarTodos();
        daoAnimal = new DAO (Animal.class);
        animais = daoAnimal.listarTodos();
        lista = dao.listarTodos();

    }

    public List<Consulta> getResults() throws ExcecaoObjetoNaoEncontrado {
        return results;
    }

    public void setResults(List<Consulta> results) {
        this.results = results;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void excluir(Consulta consulta){
        dao.excluir(consulta.getId());
        lista.remove(consulta);
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public DAO<Consulta> getDao() {
        return dao;
    }

    public void setDao(DAO<Consulta> dao) {
        this.dao = dao;
    }

    public List<Consulta> getLista(){
        return lista;
    }

    public void setLista(List<Consulta> lista) {
        this.lista = lista;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public DAO<Medico> getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(DAO<Medico> daoMedico) {
        this.daoMedico = daoMedico;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public DAO<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(DAO<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }

    

}
