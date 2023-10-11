import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLivros = new ArrayList<>();

        System.out.print("Bem vindo a Biblioteca Virtual!");

        Livro novoLivro = new Livro();
        Autor novoAutor = new Autor();

        Scanner teclado = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Escolha uma opção: \n 1 - Cadastrar livro \n 2 - Listar livros \n 0 - Sair");
            opcao = teclado.nextInt();

            switch (opcao){
                case 1:

                    System.out.print("Digite o nome do livro que deseja cadastrar: ");
                    novoLivro.titulo = teclado.next();

                    System.out.print("Digite o autor do livro que deseja cadastrar: ");
                    novoAutor.nome = teclado.next();

                    System.out.print("Digite o local de nascimento do autor: ");
                    novoAutor.localNasc = teclado.next();

                    System.out.print("Digite o preço do livro: ");
                    novoLivro.preco = teclado.nextFloat();

                    System.out.print("Digite a data de lançamento do livro: ");
                    LocalDate date = LocalDate.parse(teclado.next(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;

                    if(periodo.getYears() > 5){
                        System.out.println("Lançado a mais de 5 anos.");
                    } else{
                        System.out.println("Lançado a menos de 5 anos.");
                        break;
                    }

                    listaLivros.add(novoLivro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    if (listaLivros.isEmpty()) { //Retorna um valor Boolean indicando se um variável foi inicializado
                        System.out.println("Lista vazia");
                    } else {
                        for(Livro cadaLivro : listaLivros){
                            System.out.println();
                            System.out.println("Título do livro: " + cadaLivro.titulo);
                            System.out.println("Autor: " + novoAutor.nome);
                            System.out.println("Preço: R$" + cadaLivro.preco);
                            System.out.println("Data de lançamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();
                        }
                    }

                    System.out.print("Fim da lista.");
                    break;

                case 0:
                    System.out.print("Tchau!");
                    break;

                default:
                    System.out.print("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }
}