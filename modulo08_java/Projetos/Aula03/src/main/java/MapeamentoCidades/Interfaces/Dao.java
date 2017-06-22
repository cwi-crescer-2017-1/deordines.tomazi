/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Interfaces;

/**
 *
 * @author deordines.tomazi
 */
public interface Dao<T> {
    
    void Insert(T t);
    void Update(T t);
    void Delete(T t);
    T LoadBy(Long id);   
}
