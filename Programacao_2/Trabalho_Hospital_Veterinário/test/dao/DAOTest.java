/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;
import modelo.Consulta;
import modelo.Consulta;
import modelo.Consulta;
import modelo.Consulta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cc04413427955
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        Consulta consulta = new Consulta();
        DAO<Consulta> dao = new DAO (Consulta.class);
        dao.inserir(consulta);
    }
    
    
    
//    @Test
//    public void testListar() {
//        List<Consulta> lista = new DAO(Consulta.class).listarTodos();
//        for (Consulta consulta : lista){
//            System.out.println(consulta);
//        }
//    }
    
    
//    @Test
//    public void testListarConsulta() {
//        List<Consulta> lista = new DAO(Consulta.class).listarTodos();
//        for (Consulta consulta : lista){
//            System.out.println(consulta);
//        }
//    }
    
    
}
