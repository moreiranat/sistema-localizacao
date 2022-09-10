package io.github.moreiranat.localizacao.service;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import io.github.moreiranat.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
