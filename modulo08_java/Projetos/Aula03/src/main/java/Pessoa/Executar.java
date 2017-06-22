/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

/**
 *
 * @author deordines.tomazi
 */
public class Executar {

    public static void main(String[] args) {
        final PessoaDao pessoaDao = new PessoaDaoImpl();

        final Pessoa pessoa = new Pessoa();

        pessoa.setId(1l);
        pessoa.setNome("Carlos");

//        pessoaDao.Insert(pessoa);
        pessoaDao.Delete(pessoa);
    }
}
