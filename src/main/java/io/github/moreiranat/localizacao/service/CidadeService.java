package io.github.moreiranat.localizacao.service;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import io.github.moreiranat.localizacao.domain.repository.CidadeRepository;
import static io.github.moreiranat.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    void salvarCidade() {
        var cidade = new Cidade(1L, "São Paulo",12396372L);
        cidadeRepository.save(cidade);
    }

    public void listarCidadesPorQuantidadeHabitantes() {
//		cidadeRepository.findByHabitantesLessThan(1000001L).forEach(System.out::println);
//		cidadeRepository.findByHabitantesGreaterThan(1000001L).forEach(System.out::println);
//		cidadeRepository.findByHabitantesLessThanEqual(1000000L).forEach(System.out::println);
        cidadeRepository.findByHabitantesLessThanAndNomeLike(1000001L, "Br%").forEach(System.out::println);
    }

    public void listarCidadesPorNome() {
//		cidadeRepository.findByNome("Porto Velho").forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
//		cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
//		cidadeRepository.findByNomeEndingWith("za").forEach(System.out::println);
//		cidadeRepository.findByNomeContaining("a").forEach(System.out::println);

//		cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);
//		cidadeRepository.findByNomeLike("%za").forEach(System.out::println);
//      cidadeRepository.findByNomeLike("Porto%", Sort.by("habitantes")).forEach(System.out::println);

        Pageable pageable = PageRequest.of(1, 2);
        cidadeRepository.findByNomeLike("%%%%", pageable).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        cidadeRepository.findByHabitantes(78787900L).forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
    }

    void listarCidades() {
        cidadeRepository.findAll().forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }

    public void listarCidadesByNomeSpec() {

        cidadeRepository
                .findAll(nomeEqual( "São Paulo").and(idEqual(1L)))
                .forEach(System.out::println);
    }
}
