package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
    private Boolean system = true;
    private final FuncionarioRepository funcionarioRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual ação de funcionario deseja execultar");
            System.out.println("0 - sair");
            System.out.println("1 - salvar");
            System.out.println("2 - atualizar");
            System.out.println("3 - vizualizar");
            System.out.println("4 - deletar");

            int action = scanner.nextInt();

            switch(action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar(scanner);
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Nome do funcionário");
        String nome = scanner.next();
        System.out.println("CPF do funcionário");
        String cpf = scanner.next();
        System.out.println("Sálario do funcionário");
        Float salario = scanner.nextFloat();
        System.out.println("Data de Contratação");
        String dataContratacao = scanner.next();
        System.out.println("Cargo do funcionário");
        

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Nome do funcionário");
        String nome = scanner.next();
        System.out.println("CPF do funcionário");
        String cpf = scanner.next();
        System.out.println("Sálario do funcionário");
        Float salario = scanner.nextFloat();
        System.out.println("Data de Contratação");
        String dataContratacao = scanner.next();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        funcionarioRepository.save(funcionario);
        System.out.println("Atualizado");
    }

    private void visualizar(Scanner scanner){
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }

    private void deletar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado");
    }
}
