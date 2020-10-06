package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Consulta;
import modelo.Medico;

@ManagedBean
@ViewScoped
public class ConsultaControle implements Serializable {

    private Consulta consulta;
    private DAO<Consulta> dao;
    private List<Consulta> lista;
    private boolean popupNovoConsulta;
    private boolean popupAltera;
    private DAO<Medico> daoMedico;
    private List<Medico> medicos;
    private DAO<Animal> daoAnimal;
    private List<Animal> animais;
    private String nome;
    private List<Consulta> results;

    public ConsultaControle() {
        consulta = new Consulta();
        dao = new DAO(Consulta.class);
        daoMedico = new DAO (Medico.class);
        medicos = daoMedico.listarTodos();
        daoAnimal = new DAO (Animal.class);
        animais = daoAnimal.listarTodos();
        lista = dao.listarTodos();
        popupNovoConsulta = false;    // fica oculto
        popupAltera = false;  // fica oculto
        nome = "";
        results = dao.listarTodos();

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Consulta> getResults() {
        for (int i=0; i<results.size(); i++){
            results.remove(i);
        }
        for (int i=0; i<lista.size(); i++){
            if (lista.get(i).getAnimal().getNome().contains(nome)){
                results.add(lista.get(i));
            } 
        }
        return results;
    }

    public void setResults(List<Consulta> results) {
        this.results = results;
    }
    
    
    
    public void consultaAnimal() throws ExcecaoObjetoNaoEncontrado{
        
    }
    
    
    public void abrePopupNovoConsulta() {
        consulta = new Consulta();
        this.popupNovoConsulta = true;
    }

    public void fecharPopupNovoConsulta() {
        this.popupNovoConsulta = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

//    public void converter() {
//        consulta.setNome(consulta.getNome().toUpperCase());
//    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
//        converter();
//        boolean jaExiste = true;
//        try {
//            Consulta temp = new DAOADm().buscaPorLogin(consulta.getNome());
//        } catch (ExcecaoObjetoNaoEncontrado e) {
//            jaExiste = false;
//        }
//        if (!jaExiste) {
            dao.inserir(consulta);
            lista = dao.listarTodos();
            consulta = new Consulta();  // apenas para limpar os campos
            fecharPopupNovoConsulta();
//        } else {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Já existe este LOGIN", null));
//        }

    }

    
    public void alterarConsulta() {
        dao.alterar(consulta);
        lista = dao.listarTodos(); // atualiza a lista
        consulta = new Consulta(); 
        fecharPopupAltera();
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

    public List<Consulta> getLista() {
        return lista;
    }

    public void setLista(List<Consulta> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovoConsulta() {
        return popupNovoConsulta;
    }

    public void setPopupNovoConsulta(boolean popupNovoConsulta) {
        this.popupNovoConsulta = popupNovoConsulta;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
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
