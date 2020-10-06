/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.JPAUtil;
import static util.JPAUtil.getEntityManager;


/**
 *
 * @author CC04413427955
 */
@Entity
public class Animal implements Serializable{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String nome;
    @Column(length = 10)
    private Double peso;
    @Column(length = 30)
    private String raca;
    @Column(length = 30)
    private Integer idade;
    @Column(length = 30)
    private String especie;
    @ManyToOne
    @JoinColumn(name = "dono")
    private Dono dono;
    
    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consulta;

    private List<String> consultas;
    
    public Animal(){
        id = 0;
        nome = "";
        peso = 0.0;
        raca = "";
        idade = 0;
        especie = "";
        dono = new Dono();
        consulta = new ArrayList();
    }

    public Animal(String nome, Double peso, String raca, Integer idade, String especie, Dono dono) {
        this.nome = nome;
        this.peso = peso;
        this.raca = raca;
        this.idade = idade;
        this.especie = especie;
        this.dono = dono;
    }

    
    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    public List<String> getConsultas() {
        for (int i = 0; i<this.getConsulta().size(); i++){
            SimpleDateFormat s = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
            consultas.add(s.format(consulta.get(i).getData())+ consulta.get(i).getId() +consulta.get(i).getAnimal().nome + consulta.get(i).getMedico().getNome() + consulta.get(i).getProntuario()) ;
        }
        return consultas;
    }

    public void setConsultas(List<String> consultas) {
        this.consultas = consultas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.peso);
        hash = 61 * hash + Objects.hashCode(this.raca);
        hash = 61 * hash + Objects.hashCode(this.idade);
        hash = 61 * hash + Objects.hashCode(this.especie);
        hash = 61 * hash + Objects.hashCode(this.dono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
        if (!Objects.equals(this.dono, other.dono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", peso=" + peso + ", raca=" + raca + ", idade=" + idade + ", especie=" + especie + ", dono=" + dono + '}';
    }

    

    
    
    
}