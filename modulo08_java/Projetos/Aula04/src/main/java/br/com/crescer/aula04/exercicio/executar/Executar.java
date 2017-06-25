/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicio.executar;

import br.com.crescer.aula04.exercicio.dao.AbstractCrudDAO;
import br.com.crescer.aula04.exercicio.dao.ClienteDAO;
import br.com.crescer.aula04.exercicio.dao.FuncionarioDAO;
import br.com.crescer.aula04.exercicio.entidades.Cliente;
import br.com.crescer.aula04.exercicio.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author Deordines
 */
public class Executar {
    
    public static void main (String[] args) {
        
        final AbstractCrudDAO funcionarioDAO = new FuncionarioDAO();
        final AbstractCrudDAO clienteDAO = new ClienteDAO();
        
        // ---------------------------------------------------------------------
        
        /*
        // Funcionario
        
        // Criar
        final Funcionario funcionario = new Funcionario();
        funcionario.setNome("deordines");
        funcionario.setRg("12345678912");
        funcionarioDAO.save(funcionario);
        
        // Remover
        final Funcionario funcionarioRemovido = funcionarioDAO.loadById(1l);
        funcionarioDAO.remove(funcionarioRemovido);
        
        // Procurar
        final Funcionario funcionarioProcurado = (Funcionario) funcionarioDAO.loadById(2l);
        System.out.println(funcionarioProcurado.getNome());
        
        // Listar
        // System.out.println(funcionarioDAO.findAll());
        List<Funcionario> funcionarios = funcionarioDAO.findAll();
        for(Funcionario f : funcionarios) {
            System.out.println(f.getNome());
        }
        */
        
        // ---------------------------------------------------------------------
        
        /*
        // Cliente
        
        // Criar
        final Cliente cliente = new Cliente();
        cliente.setNome("deordines");
        cliente.setCpf("123456789");
        cliente.setRg("12345678912");
        cliente.setCelular("51 9-9999-9999");
        clienteDAO.save(cliente);
        
        // Remover
        final Cliente clienteRemovido = clienteDAO.loadById(5l);
        clienteDAO.remove(clienteRemovido);
        
        // Procurar
        final Cliente clienteProcurado = (Cliente) clienteDAO.loadById(6l);
        System.out.println(clienteProcurado.getNome());
        
        // Listar
        // System.out.println(clienteDAO.findAll());
        List<Cliente> clientes = clienteDAO.findAll();
        for(Cliente c : clientes) {
            System.out.println(c.getNome());
        }
        */
    }
}