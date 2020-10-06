/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacaoBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Grafo{
    
    public int pos = 0;
    
    public int[] recebeCustos(int ... custos){
        return custos;
    }
    
    public static List<No> inicializaGrafo(){

        No oradea = new No("Oradea"); //g.insereGrafo(new No("Oradea"));// 2, g.recebeCustos(71,151), "Zerind", "Sibiu");
        No zerind = new No("Zerind"); //, 2, g.recebeCustos(71,75), "Oradea", "Arad");
        No arad = new No("Arad"); // , 3, g.recebeCustos(75,118,140), "Zerind", "Timisoara", "Sibiu");
        No timisoara = new No("Timiasoara"); //, 2, g.recebeCustos(118,111), "Arad", "Lugoj");
        No lugoj = new No("Lugoj");//, 2, g.recebeCustos(111,70), "Timisoara", "Mehadia");
        No mehadia = new No("Mehadia"); //, 2, g.recebeCustos(70,75), "Lugoj", "Dobreta");
        No dobreta = new No("Dobreta"); //, 2, g.recebeCustos(75,120), "Mehadia", "Craiova");
        No sibiu = new No("Sibiu"); //, 4, g.recebeCustos(151,140,80,99), "Oradea", "Arad", "Rimnicu Vilcea", "Fagaras");
        No rimnicuVilcea = new No("Rimnicu Vilcea"); //, 3, g.recebeCustos(80,97,146), "Sibiu", "Pitesti", "Craiova");
        No craiova = new No("Craiova"); //, 3, g.recebeCustos(120,146,138), "Dobreta", "Rimnicu Vilcea", "Pitesti");
        No fagaras = new No("Fagaras"); //, 2, g.recebeCustos(99,211), "Sibiu", "Bucharest");
        No pitesti = new No("Pitesti"); //, 3, g.recebeCustos(97,138,101), "Rimnicu Vilcea", "Craiova", "Bucharest");
        No bucharest = new No("Bucharest"); //, 4, g.recebeCustos(211,101,90,85), "Fagaras", "Pitesti", "Giurgiu", "Urziceni");
        No giurgiu = new No("Giurgiu"); //, 1, g.recebeCustos(90), "Bucharest");
        No neamt = new No("Neamt"); //, 1, g.recebeCustos(87), "Iasi");
        No iasi = new No("Iasi"); //, 2, g.recebeCustos(87,92), "Neamt", "Vaslui");
        No vaslui = new No("Vaslui"); //, 2, g.recebeCustos(92,142), "Iasi", "Urziceni");
        No urziceni = new No("Urziceni"); //, 3, g.recebeCustos(85,142,98), "Bucharest", "Vaslui", "Hirsova");
        No hirsova = new No("Hirsova"); //, 2, g.recebeCustos(98,86), "Urziceni", "Eforie");
        No eforie = new No("Eforie"); //, 1, g.recebeCustos(86), "Hirsova");
        oradea.setArestas(zerind, 71); oradea.setArestas(sibiu, 151);
        zerind.setArestas(oradea, 71); zerind.setArestas(arad, 75);
        arad.setArestas(zerind, 75); arad.setArestas(timisoara, 118); arad.setArestas(sibiu, 140);
        timisoara.setArestas(arad, 118); timisoara.setArestas(lugoj, 111);
        lugoj.setArestas(timisoara, 111); lugoj.setArestas(mehadia, 70);
        mehadia.setArestas(lugoj, 70); mehadia.setArestas(dobreta, 75);
        dobreta.setArestas(mehadia, 75); dobreta.setArestas(craiova, 120);
        sibiu.setArestas(oradea, 151); sibiu.setArestas(arad, 140); sibiu.setArestas(rimnicuVilcea, 80); sibiu.setArestas(fagaras, 99);
        rimnicuVilcea.setArestas(sibiu, 80); rimnicuVilcea.setArestas(pitesti, 97); rimnicuVilcea.setArestas(craiova, 146);
        craiova.setArestas(dobreta, 120); craiova.setArestas(rimnicuVilcea, 146); craiova.setArestas(pitesti, 138);
        fagaras.setArestas(sibiu, 99); fagaras.setArestas(bucharest, 211);
        pitesti.setArestas(rimnicuVilcea, 97); pitesti.setArestas(craiova, 138); pitesti.setArestas(bucharest, 101);
        bucharest.setArestas(fagaras, 211); bucharest.setArestas(pitesti, 101); bucharest.setArestas(giurgiu, 90); bucharest.setArestas(urziceni, 85);
        giurgiu.setArestas(bucharest, 90); 
        neamt.setArestas(iasi, 87);
        iasi.setArestas(neamt, 87); iasi.setArestas(vaslui, 92); 
        vaslui.setArestas(iasi, 92); vaslui.setArestas(urziceni, 142);
        urziceni.setArestas(bucharest, 85); urziceni.setArestas(vaslui, 142); urziceni.setArestas(hirsova, 98);
        hirsova.setArestas(urziceni, 98); hirsova.setArestas(eforie, 86); 
        eforie.setArestas(hirsova, 86);
        List<No> listaNos = new ArrayList();
        listaNos.add(oradea);
        listaNos.add(zerind);
        listaNos.add(arad);
        listaNos.add(timisoara);
        listaNos.add(lugoj);
        listaNos.add(mehadia);
        listaNos.add(dobreta);
        listaNos.add(sibiu);
        listaNos.add(rimnicuVilcea);
        listaNos.add(craiova);
        listaNos.add(fagaras);
        listaNos.add(pitesti);
        listaNos.add(bucharest);
        listaNos.add(giurgiu);
        listaNos.add(neamt);
        listaNos.add(iasi);
        listaNos.add(vaslui);
        listaNos.add(urziceni);
        listaNos.add(hirsova);
        listaNos.add(eforie);

        return listaNos;
    }
    
    
    public int buscaExtensao(String raiz, String alvo) throws NullPointerException {
            No temp = new No();
            List<No> filaAdjacente = new ArrayList();
            int custoTotal = 0;
            List<No> listaNos = Grafo.inicializaGrafo();
            No inicio = listaNos.get(0);

            for (No nos: listaNos){
                if (nos.getNome().equals(raiz)){
                    inicio = nos;
                    //System.out.println("No raiz: " + inicio.getNome());
                    //System.out.println(" ");
                }
            }
            filaAdjacente.add(inicio);

        while (!filaAdjacente.isEmpty()){   
            No [] filhos = new No[5];
            No pai = filaAdjacente.get(0);
            No [] aux = filaAdjacente.get(0).getArestas();
//            try {
//                System.out.println(filaAdjacente.get(0).getArestas().length + " " + filaAdjacente.get(0).getNome() + " seu nó pai é: " + filaAdjacente.get(0).getNoPai().getNome());
//            } catch (NullPointerException e) {}

            for (int i = 0; i < aux.length; i++){
                if (aux[i].isVisitado() == false){
                    //System.out.println("Nó pai: " + pai.getNome());
                    filaAdjacente.add(aux[i]);// System.out.println("Add na fila: " + aux[i].getNome());
                    filhos[i] = aux[i]; //System.out.println("Add filho: " + aux[i].getNome() + " no nó Pai: " + pai.getNome());
                    aux[i].setNoPai(pai); //System.out.println("Add pai: " + pai.getNome());
                    //System.out.println(" ");
                    //Thread.sleep(5000);
                }

            }
            filaAdjacente.get(0).setVisitado(true); //System.out.println("Visitado =  " + filaAdjacente.get(0).isVisitado());
            if (filaAdjacente.get(0).getNome().equals(alvo)){
                //System.out.println(" ");
                //System.out.println("Cheguei no estado alvo - " + filaAdjacente.get(0).getNome());
                temp = filaAdjacente.get(0);
                break;
            }
            filaAdjacente.remove(0); 
            } 
        
            while (temp != inicio){
                System.out.println(temp.getNome() + "---------" + temp.getCusto() + "----------" + temp.getNoPai().getNome());
                custoTotal += temp.getCusto();
                temp = temp.getNoPai();
            }

            return custoTotal;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Grafo grafo = new Grafo();
        String raiz;
        String alvo;
        while (true){ 
            System.out.println("Digite # de deseja sair");
            System.out.print("Origem: ");
            raiz = sc.next();
            if (raiz.equals("#")){
                System.exit(0);
            }
            System.out.print("Destino: ");
            alvo = sc.next();

            

            System.out.println("Custo de = " + grafo.buscaExtensao(raiz, alvo));
        }
 
    }
    
    
}
