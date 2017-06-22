/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapeamentoCidades.Entidades.Executar;

import MapeamentoCidades.Entidades.Cidade;
import MapeamentoCidades.Entidades.Estado;
import MapeamentoCidades.Entidades.Pais;
import MapeamentoCidades.Implementacao.CidadeDaoImpl;
import MapeamentoCidades.Implementacao.EstadoDaoImpl;
import MapeamentoCidades.Implementacao.PaisDaoImpl;
import MapeamentoCidades.Interfaces.CidadeDao;
import MapeamentoCidades.Interfaces.EstadoDao;
import MapeamentoCidades.Interfaces.PaisDao;

/**
 *
 * @author deordines.tomazi
 */
public class Executar {

    public static void main(String[] args) {
        final PaisDao paisDao = new PaisDaoImpl();
        final EstadoDao estadoDao = new EstadoDaoImpl();
        final CidadeDao cidadeDao = new CidadeDaoImpl();

        final Pais pais = new Pais();
        final Estado estado = new Estado();
        final Cidade cidade = new Cidade();
        
//        pais.setId(2l);
//        pais.setNome("Estados Unidos da América");
//        pais.setSigla("EUA");
//        paisDao.Insert(pais);
//        pessoaDao.Delete(pessoa);

//        estado.setId(28l);
//        estado.setNome("Algum estado");
//        estado.setUf("AE");
//        estado.setIdPais(2l);
//        estadoDao.Insert(estado);
        
//        cidade.setId(5565l);
//        cidade.setNome("Texas");
//        cidade.setIdEstado(28l);
//        cidadeDao.Insert(cidade);
    }
}
