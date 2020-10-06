package controle;

import dao.DAO;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Medico;

@ManagedBean
@ViewScoped
public class MedicoControle implements Serializable {

    private Medico medico;
    private DAO<Medico> dao;
    private List<Medico> lista;
    private boolean popupNovoMedico;
    private boolean popupAltera;

    public MedicoControle() {
        medico = new Medico();
        dao = new DAO(Medico.class);
        lista = dao.listarTodos();
        popupNovoMedico = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovoMedico() {
        medico = new Medico();
        this.popupNovoMedico = true;
    }

    public void fecharPopupNovoMedico() {
        this.popupNovoMedico = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

//    public void converter() {
//        medico.setLogin(medico.getLogin().toUpperCase());
//    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
        dao.inserir(medico);
        lista = dao.listarTodos();
        medico = new Medico();  // apenas para limpar os campos
        fecharPopupNovoMedico();

    }

    
    public void alterarMedico() {
        dao.alterar(medico);
        lista = dao.listarTodos(); // atualiza a lista
        medico = new Medico(); 
        fecharPopupAltera();
    }
    
    public void excluir(Medico medico){
        dao.excluir(medico.getId());
        lista.remove(medico);
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

    public List<Medico> getLista() {
        return lista;
    }

    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovoMedico() {
        return popupNovoMedico;
    }

    public void setPopupNovoMedico(boolean popupNovoMedico) {
        this.popupNovoMedico = popupNovoMedico;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

}