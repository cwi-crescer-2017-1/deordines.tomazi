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
public interface PessoaDao extends Dao<Pessoa> {
    
    void Insert(Pessoa p);
    void Update(Pessoa p);
    void Delete(Pessoa p);
}
