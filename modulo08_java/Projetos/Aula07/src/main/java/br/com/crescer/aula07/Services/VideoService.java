/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Services;

import br.com.crescer.aula07.Entidades.Video;
import br.com.crescer.aula07.Repositories.VideoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deordines
 */
@Service
public class VideoService {
    
    @Autowired
    VideoRepositorio repositorio;
    
    public Iterable<Video> listar () {
        return repositorio.findAll();
    }
    
    public Video criar(Video video) {
        return repositorio.save(video);
    }
    
    public Video buscarPorId(Long id) {
        return repositorio.findOne(id);
    }
    
    public void remover(Long id) {
        repositorio.delete(id);
    }
}