package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Dono;

@ManagedBean
@ViewScoped
public class DonoControle implements Serializable {

    private Dono dono;
    private DAO<Dono> dao;
    private List<Dono> lista;
    private boolean popupNovoDono;
    private boolean popupAltera;

    public DonoControle() {
        dono = new Dono();
        dao = new DAO(Dono.class);
        lista = dao.listarTodos();
        popupNovoDono = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovoDono() {
        dono = new Dono();
        this.popupNovoDono = true;
    }

    public void fecharPopupNovoDono() {
        this.popupNovoDono = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

//    public void converter() {
//        dono.setNome(dono.getNome().toUpperCase());
//    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
//        converter();
//        boolean jaExiste = true;
//        try {
//            Dono temp = new DAOADm().buscaPorLogin(dono.getNome());
//        } catch (ExcecaoObjetoNaoEncontrado e) {
//            jaExiste = false;
//        }
//        if (!jaExiste) {
            dao.inserir(dono);
            lista = dao.listarTodos();
            dono = new Dono();  // apenas para limpar os campos
            fecharPopupNovoDono();
//        } else {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Já existe este LOGIN", null));
//        }

    }

    
    public void alterarDono() {
        dao.alterar(dono);
        lista = dao.listarTodos(); // atualiza a lista
        dono = new Dono(); 
        fecharPopupAltera();
    }
    
    public void excluir(Dono dono){
        dao.excluir(dono.getId());
        lista.remove(dono);
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

    public List<Dono> getLista() {
        return lista;
    }

    public void setLista(List<Dono> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovoDono() {
        return popupNovoDono;
    }

    public void setPopupNovoDono(boolean popupNovo) {
        this.popupNovoDono = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

}