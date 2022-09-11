package io.github.moreiranat.localizacao;

import io.github.moreiranat.localizacao.domain.entity.Cidade;
import io.github.moreiranat.localizacao.domain.repository.CidadeRepository;
import io.github.moreiranat.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
//		salvarCidade();
//		listarCidades();
//		listarCidadesPorNome();
//		listarCidadesPorHabitantes();
//		listarCidadesPorNome();
//		cidadeService.listarCidadesPorQuantidadeHabitantes();
//		cidadeService.listarCidadesPorNome();

//		var cidade = new Cidade(null,"porto", null);
//		cidadeService.filtroDinamico(cidade).forEach(System.out::println);

//		cidadeService.listarCidadesByNomeSpec();

//		var cidade = new Cidade(1L,"São Paulo", 100L);
//		cidadeService.listarCidadesSpecsFiltroDinamico(cidade);

		cidadeService.listarCidadesPorNomeSql();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
