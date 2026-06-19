package com.example.libaryapi2.service;

import com.example.libaryapi2.model.Autor;
import com.example.libaryapi2.repository.AutorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {
  @Autowired
  AutorRespository autorRespository;

  public Autor salvar(Autor autor){
    return autorRespository.save(autor);
  }

  public Optional<Autor> ObterAutorById(String uuid){
    return this.autorRespository.findById(UUID.fromString(uuid));
  }

  public Optional<Autor> deleteByid(String uuid){
    UUID id= UUID.fromString(uuid);
    java.util.Optional<Autor> autor =this.autorRespository.findById(id);
    if (autor.isPresent()){
      this.autorRespository.delete(autor.get());
      return autor;
    }
    return autor;
  }
}
