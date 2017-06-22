/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Interfaces;

import MapeamentoCidades.Entidades.Pais;

/**
 *
 * @author deordines.tomazi
 */
public interface PaisDao extends Dao<Pais> {

    void Insert(Pais p);
    void Update(Pais p);
    void Delete(Pais p);
}
