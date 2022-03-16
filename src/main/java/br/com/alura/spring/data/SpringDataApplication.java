package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
@EntityScan("br.com.alura.spring.data.orm")
public class SpringDataApplication implements CommandLineRunner{

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadesTrabahoService;

	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, 
		CrudFuncionarioService funcionarioService, 
		CrudUnidadeTrabalhoService unidadeTrabalhoService) 
		{
			this.cargoService = cargoService;
			this.funcionarioService = funcionarioService;
			this.unidadesTrabahoService = unidadeTrabalhoService;
		}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - funcionário");
			System.out.println("3 - unidade de trabalho");

			int action = scanner.nextInt();
			if(action == 1){
				cargoService.inicial(scanner);
			} else if(action == 2){
				funcionarioService.inicial(scanner);
			} else if(action == 3){
				unidadesTrabahoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	}

}