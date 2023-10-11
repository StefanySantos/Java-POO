import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listPF = new ArrayList<>(); //salvar a lista de pessoa fisica para o que sistema possa acessar as informacoes
        PessoaFisica metodoPf = new PessoaFisica(); //metodo global para chamar no informacoes

        ArrayList<PessoaJuridica> listPJ = new ArrayList<>();
        PessoaJuridica metodoPJ = new PessoaJuridica();

        System.out.println("Sem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");

        Scanner teclado = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Escolha uma opcao: 1 - pessoa Fisica/ 2 - Pessoa Juridica/ 0 - Sair");
            opcao = teclado.nextLine();

            switch (opcao){
                case "1":
                    //System.out.println("case 1");
                    String opcaoPF;
                    do {
                        System.out.println("digite uma opcao: 1 -Cadastra PF /2- Listar/ 0- Voltar");
                        opcaoPF = teclado.nextLine();

                        switch (opcaoPF){
                            case "1":
                                //System.out.println("Cadastrar PF");

                                PessoaFisica novaPF = new PessoaFisica(); //instancia do novo opcao
                                Endereco novoEndPF = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPF.nome = teclado.next(); //nao cria uma variavel acessa a variavel atraves do objeto

                                System.out.println("Digite o cpf: ");
                                novaPF.cpf = teclado.next();

                                System.out.println("Digite o rendimento:");
                                novaPF.rendimento = teclado.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPF.dataNasc = LocalDate.parse(teclado.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPF.dataNasc, LocalDate.now()); //pega o intervalo entre as datas para saber a idade da pessoa
                                if (idade.getYears() > 18){
                                    System.out.println("idade valida");
                                }else {
                                    System.out.println("idade invalida");
                                    break; //nao cadastra o objeto
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPF.lougradouro = teclado.next();

                                System.out.println("Digite o numero: ");
                                novoEndPF.numero = teclado.nextInt();

                                System.out.println("Este endereco e comercial? S/N: ");
                                String endCom = teclado.next();
                                if (endCom.equals("S") || endCom.equals("s"))
                                {
                                    novoEndPF.endComercial = true;
                                }else {
                                    novoEndPF.endComercial = false;
                                }

                                //passa objeto para dentro do outro atributo do objeto
                                novaPF.endereco = novoEndPF;

                                listPF.add(novaPF); //adicionando o objeto nova pessoas

                                System.out.println("Cadastro realizado com sucesso");

                                break;



                            case "2":
                                //System.out.println("Lista PF");
                                if (listPF.size() >0 ){
                                    for (PessoaFisica cadaPF : listPF){ //nome do atributo que esta pegando cada elemento
                                        System.out.println("Nome: " + cadaPF.nome);
                                        System.out.println("CPF: " + cadaPF.cpf);
                                        System.out.println("Data de Nascimento: " + cadaPF.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(cadaPF.rendimento));
                                        System.out.println("Endereco: " + cadaPF.endereco.lougradouro + "-" + cadaPF.endereco.numero);
                                        System.out.println("Numero: " + cadaPF.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar: ");
                                        teclado.nextLine();

                                    }
                                }else
                                {
                                    System.out.println("Lista vazia");
                                }

                                break;

                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opcao invalida");
                                break;
                        }

                    }while (!opcaoPF.equals("0"));

                    break;


                case "2":
                    String opcaoPJ;

                    do {
                        System.out.println("digite uma opcao: 1 -Cadastra PJ /2- Listar/ 0- Voltar");
                        opcaoPJ = teclado.nextLine();

                        switch (opcaoPJ){
                            case "1":
                                //System.out.println("feito cadastro PJ");

                                PessoaJuridica novaPJ = new PessoaJuridica(); //instancia do novo opcao
                                Endereco novoEndPJ = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPJ.nome = teclado.next();

                                System.out.println("Digite a razão Social: ");
                                novaPJ.razaoSocial = teclado.next();

                                System.out.println("Digite seu cnpj: ");
                                novaPJ.cnpj = teclado.nextLine();

                                System.out.println("Digite seu rendimento: ");
                                novaPJ.rendimento = teclado.nextFloat();

                                System.out.println("Digite o logradouro: ");
                                novoEndPJ.lougradouro = teclado.nextLine();

                                System.out.println("Digite o numero: ");
                                novoEndPJ.numero = teclado.nextInt();

                                System.out.println("Este endereco e comercial? S/N: ");
                                String endCom = teclado.next();
                                if (endCom.equals("S") || endCom.equals("s"))
                                {
                                    novoEndPJ.endComercial = true;
                                }else {
                                    novoEndPJ.endComercial = false;
                                }

                                novaPJ.endereco = novoEndPJ;

                                listPJ.add(novaPJ); //adicionando o objeto nova pessoas

                                System.out.println("Cadastro realizado com sucesso");

                                break;



                            case "2":
                                //System.out.println("feito listar PJ");
                                if (listPJ.size() >0 ){
                                    for (PessoaJuridica cadaPJ : listPJ){ //nome do atributo que esta pegando cada elemento
                                        System.out.println("Nome: " + cadaPJ.razaoSocial);
                                        System.out.println("CNPJ: " + cadaPJ.cnpj);
                                        System.out.println("Imposto a ser pago: " + metodoPJ.CalcularImpostoPJ(cadaPJ.rendimento));
                                        System.out.println("Endereco: " + cadaPJ.endereco.lougradouro + "-" + cadaPJ.endereco.numero);
                                        System.out.println("Numero: " + cadaPJ.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar: ");
                                        teclado.nextLine();

                                    }
                                }else
                                {
                                    System.out.println("Lista vazia");
                                }

                                break;

                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opcao invalida");
                                break;
                        }

                    }while (!opcaoPJ.equals("0"));

                    break;



                case "0":
                    System.out.println("case 0");
                    break;

                default:
                    System.out.println("default");
                    break;
            }

        }while (!opcao.equals("0"));
    }
}