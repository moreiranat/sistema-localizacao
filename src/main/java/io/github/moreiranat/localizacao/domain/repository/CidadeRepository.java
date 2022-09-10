package io.github.moreiranat.localizacao.domain.repository;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //busca pelo nome like
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)") //para resolver o problema do case sensitive do like
    List<Cidade> findByNomeLike(String nome);

    //busca pelo nome comecando por aquele pedaco
    List<Cidade> findByNomeStartingWith(String nome);

    //busca pelo nome terminando por aquele pedaco
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelo nome contendo aquele pedaco
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
}
