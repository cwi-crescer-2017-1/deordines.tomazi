/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Interfaces;

import MapeamentoCidades.Entidades.Estado;

/**
 *
 * @author deordines.tomazi
 */
public interface EstadoDao extends Dao<Estado> {
    
    void Insert(Estado e);
    void Update(Estado e);
    void Delete(Estado e);
}
