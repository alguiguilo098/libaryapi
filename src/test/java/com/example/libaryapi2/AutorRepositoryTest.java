package com.example.libaryapi2;

import com.example.libaryapi2.model.Autor;
import com.example.libaryapi2.model.GeneroLivro;
import com.example.libaryapi2.model.Livro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.libaryapi2.repository.LivroRepository;
import com.example.libaryapi2.repository.AutorRespository;
import org.springframework.test.annotation.Commit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
  @Autowired
  LivroRepository livroRepository;

  @Autowired
  AutorRespository autorRespository;

  @Test
  void trabalharcomjava(){
    Autor autor =new Autor();
    autor.setData(LocalDate.of(1980,2,12));
    autor.setNome("Guilherme Almeida Lopes");
    autor.setNacionalidade("Brasileiro");
    this.autorRespository.save(autor);

  }
  @Test
  void lauraacordada(){
     Autor autor= this.autorRespository.
       findById(UUID.fromString("2c1b1424-d064-4d41-8b25-992134cd5fef")).orElse(null);

    Livro livro=new Livro();
    livro.setAutor(autor);
    livro.setData_de_publicaçao(LocalDate.of(1980,2,12));
    livro.setGeneroLivro(GeneroLivro.MISTERIO);
    livro.setIsbn("47855526");
    livro.setPreco(BigDecimal.valueOf(622.02));
    livro.setTitulo("AUTOR DO MISTERIO");
    this.livroRepository.save(livro);

  }
  @Test
  void listarlivros(){
  Autor autor= this.autorRespository.
       findById(UUID.fromString("2c1b1424-d064-4d41-8b25-992134cd5fef")).orElse(null);
    if(autor!=null){
      autor.getLista().forEach(System.out::println);
    }
  }

  @Test
  void atualizarAutor(){
    Autor autor= this.autorRespository.
      findById(UUID.fromString("2c1b1424-d064-4d41-8b25-992134cd5fef")).orElse(null);
    if(autor!=null){
      autor.setNacionalidade("italiano");
      this.autorRespository.save(autor);
    }
  }
  @Test
  void deletarautor(){

    Autor autor=this.autorRespository.findById(UUID.fromString("2c1b1424-d064-4d41-8b25-992134cd5fef")).orElse(null);
    if(autor!=null){
      for (int i = 0; i < autor.getLista().size(); i++) {
        this.livroRepository.deleteById(autor.getLista().get(i).getId());
      }
      this.autorRespository.deleteById(UUID.fromString("2c1b1424-d064-4d41-8b25-992134cd5fef"));
    }
  }

}
