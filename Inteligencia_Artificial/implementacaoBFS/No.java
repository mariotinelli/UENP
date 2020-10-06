
package implementacaoBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Mario
 */
public class No {

    int custoTotal = 0;
    private String nome;
    private No noPai;
    private List<No> nosFilhos = new ArrayList();
    private Set<Aresta> arestas = new HashSet<Aresta>();
    private boolean visitado;

    public No(String nome) {
        this.nome = nome;
        visitado = false;
    }
    
    public No(){
        
    }
    
    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    public String getNome() {
        return nome;
    }

    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(int custoTotal) {
        this.custoTotal = custoTotal;
    }

    public List<No> getNosFilhos() {
        return nosFilhos;
    }

    public void setNosFilhos(List<No> nosFilhos) {
        this.nosFilhos = nosFilhos;
    }

    

    public int getCusto(){
        int custo = 0;
        for (Aresta aresta: arestas){
            if (aresta.getPara() == this.getNoPai()){
                custo = aresta.getCusto();
            }
        }
        return custo;
    }

    public String imprimeArestas() {
        String values = "";
        for (Aresta aresta: arestas){
            values += "  " + aresta.getDe().nome + "----------" + aresta.getCusto() + "-----------" + aresta.getPara().nome;
        }
        return values;
    }
    
    public No [] getArestas(){
        No [] aux = new No[arestas.size()];
        int i = 0;
        for (Aresta aresta: arestas){
            aux[i] = aresta.getPara();
            i++;
        }
        return aux;
    }
//    
//    public Aresta getterAresta(){
//        
//    }

    public Boolean setArestas(No para, int custo) {   
        Aresta aresta = new Aresta(this, para, custo);
        aresta.arestaInserida = true;
        return arestas.add(aresta);
    }

//    @Override
//    public String toString() {
//        return "No{" + "nome=" + nome + ", noPai=" + noPai + ", nosFilhos=" + nosFilhos + ", arestas=" + this.getArestas() + '}';
//    }

    
    


    
    
    
    
}
