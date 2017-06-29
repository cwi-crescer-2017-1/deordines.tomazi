/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controllers;

import br.com.crescer.aula07.Entidades.Video;
import br.com.crescer.aula07.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deordines
 */
@RestController
public class VideoController {
    
    @Autowired
    private VideoService service;
    
    @GetMapping("/video")
    public Iterable<Video> listar() {
        return service.listar();
    }
    
    @PostMapping("/video")
    public void criar (@RequestBody Video vVideo) {
        service.criar(vVideo);
    }
    
    @GetMapping("/video/{id}")
    public Video getById(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
    @DeleteMapping("/video/{id}")
    public void remove(@PathVariable Long id) {
        service.remover(id);
    }
}