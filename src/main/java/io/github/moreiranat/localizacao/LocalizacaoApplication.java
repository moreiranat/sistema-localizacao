package io.github.moreiranat.localizacao;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import io.github.moreiranat.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
//		salvarCidade();
//		listarCidades();
//		listarCidadesPorNome();
//		listarCidadesPorHabitantes();
		listarCidadesPorNome();
	}

	void listarCidadesPorNome() {
//		cidadeRepository.findByNome("Porto Velho").forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
//		cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
//		cidadeRepository.findByNomeEndingWith("za").forEach(System.out::println);
		cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
	}

	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(78787900L).forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
	}

	@Transactional
	void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo",12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println); //para cada cidade, vai ser executado esse metodo
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
