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

  public void salvar(Autor autor){
    autorRespository.save(autor);
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

  public List<Autor> Obterautores(String nacionalidade,  String nome){
    if(nacionalidade!=null && nome!=null){
      return this.autorRespository.findByNacionalidadeAndNome(nacionalidade,nome);
    }
    else if(nome!=null){
      return this.autorRespository.findByNome(nome);
    }else if(nacionalidade!=null){
      return  this.autorRespository.findByNacionalidade(nacionalidade);
    }else{
      return this.autorRespository.findAll();
    }

  }
}
