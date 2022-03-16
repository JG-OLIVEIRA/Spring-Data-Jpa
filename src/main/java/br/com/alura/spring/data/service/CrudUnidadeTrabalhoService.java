package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
    private Boolean system = true;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository){
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual ação de cargo deseja execultar");
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
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        System.out.println("Endereço");
        String endereco = scanner.next();

        UnidadeTrabalho trabalho = new UnidadeTrabalho();
        trabalho.setDescricao(descricao);
        trabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(trabalho);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Descrição do Cargo");
        String descricao = scanner.next();
        System.out.println("Endereço");
        String endereco = scanner.next();

        UnidadeTrabalho trabalho = new UnidadeTrabalho();
        trabalho.setId(id);
        trabalho.setDescricao(descricao);
        trabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(trabalho);
        System.out.println("Atualizado");
    }

    private void visualizar(Scanner scanner){
        Iterable<UnidadeTrabalho> unidadesTrabalho = unidadeTrabalhoRepository.findAll();
        unidadesTrabalho.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));
    }

    private void deletar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado");
    }
}
