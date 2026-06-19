package com.example.libaryapi2.controller;

import com.example.libaryapi2.model.Autor;
import com.example.libaryapi2.repository.AutorRespository;
import com.example.libaryapi2.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {
  @Autowired
  AutorService autorService;

  @PostMapping
  ResponseEntity<Void> salvar(@RequestBody AutorDTO autorDTO){
    Autor autor = autorDTO.toEntity();
    this.autorService.salvar(autor);
    URI localtion= ServletUriComponentsBuilder.fromCurrentRequest().
      path("/{id}").
      buildAndExpand(autor.getId()).
      toUri();

    return ResponseEntity.created(localtion).build();
  }
  @GetMapping("/{id}")
  ResponseEntity<AutorDTO> obterAutor(@PathVariable("id") String id){
    Optional<Autor> autor=this.autorService.ObterAutorById(id);
    if (autor.isPresent()){
      AutorDTO autorDTO= new AutorDTO(autor.get().getId(), autor.get().getNome(),
        autor.get().getData(),autor.get().getNacionalidade());
      return ResponseEntity.ok(autorDTO);
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> deleteBy(@PathVariable("id") String id){
    Optional<Autor>autor=this.autorService.deleteByid(id);
    if (autor.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
  }
  @GetMapping
  ResponseEntity<List<AutorDTO>> pesquisar(@RequestParam("nome") String nome, @RequestParam("nacionalidade")String nacionalidade){


  }
}
