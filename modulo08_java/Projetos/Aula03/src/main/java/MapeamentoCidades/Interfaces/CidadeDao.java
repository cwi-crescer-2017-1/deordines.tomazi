/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Interfaces;

import MapeamentoCidades.Entidades.Cidade;

/**
 *
 * @author deordines.tomazi
 */
public interface CidadeDao extends Dao<Cidade> {
    
    void Insert(Cidade c);
    void Update(Cidade c);
    void Delete(Cidade c);
}
