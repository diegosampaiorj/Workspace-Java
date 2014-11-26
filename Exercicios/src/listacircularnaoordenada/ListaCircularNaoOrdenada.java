package listacircularnaoordenada;
 
import java.util.Scanner;
 
public class ListaCircularNaoOrdenada {
 
    //Definindo a classe que representará cada elemento da lista
    private static class LISTA {
 
        public int num;
        public LISTA prox;
    }
 
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // a lista está vazia, logo, objeto inicio têm o valor null, o objeto inicio conterá o endereço do primeiro elemento da lista
        LISTA inicio = null;
        // o objeto fim conterá o endereço do último elemento da lista
        LISTA fim = null;
        // o objeto aux é um objeto auxiliar
        LISTA aux;
        // o objeto anterior é um objeto auxiliar
        LISTA anterior;
        // apresenta o memnu de opções
        int op, numero, achou;
        do {
            System.out.println("\nMENU DE OPÇÕES\n");
            System.out.println("1 - Inserir no início da lista");
            System.out.println("2 - Inserir no fim da lista");
            System.out.println("3 - Consultar toda a lista");
            System.out.println("4 - Remover da lista");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Sair");
            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();
            if (op < 1 || op > 6) {
                System.out.println("Opção inválida!!");
            } else {
                if (op == 1) {
                    System.out.println("Digite o número a ser inserido no início da lista");
                    LISTA novo = new LISTA();
                    novo.num = entrada.nextInt();
                    if (inicio == null) {
                        // a lista esta vazia e o elemento inserido será o primeiro e o último da lista
                        inicio = novo;
                        fim = inicio;
                        fim.prox = inicio;
                    } else {
                        // a lista já cont[em elementos e o novo elemento será inserido no início da lista
                        novo.prox = inicio;
                        inicio = novo;
                        fim.prox = inicio;
                    }
                    System.out.println("Número inserido no início da lista!!");
                }
                if (op == 2) {
                    System.out.println("Digite o número a ser inserido no fim da lista: ");
                    LISTA novo = new LISTA();
                    novo.num = entrada.nextInt();
                    if (inicio == null) {
                        // a lista estava vazia e o elemento inserido será o primeiro e o último
                        inicio = novo;
                        fim = novo;
                        fim.prox = inicio;
                    } else {
                        // a lista já contém elementos e o novo elemento será inserido no fim da lista
                        fim.prox = novo;
                        fim = novo;
                        fim.prox = inicio;
                    }
                    System.out.println("Número inserido no fim da lista!!");
                }
                if (op == 3) {
                    if (inicio == null) {
                        // a lista está vazia
                        System.out.println("Lista vazia!!");
                    } else {
                        // a lista contém elementos e estes serão mostrados do início ao fim
                        System.out.println("\nConsultando toda a lista\n");
                        aux = inicio;
                        do {
                            System.out.print(aux.num + " ");
                            aux = aux.prox;
                        } while (aux != inicio);
                    }
                }
                if (op == 4) {
                    if (inicio == null) {
                        // a lista está vazia
                        System.out.println("Lista vazia!!");
                    } else {
                        // a lista contém elementos e o elmento a ser removido deve ser digitado
                        System.out.print("\nDigite o elemento a ser removido: ");
                        numero = entrada.nextInt();
                        // todos as ocorrências da lista, iguais ao número digitado serão removidas
                        anterior = null;
                        achou = 0;
 
                        // descobrindo a quantidade de elementos da lista
                        int quantidade = 0;
                        aux = inicio;
                        do {
                            quantidade = quantidade + 1;
                            aux = aux.prox;
                        } while (aux != inicio);
                        int elemento = 1;
                        do {
                            // se a lista possui apenas um elemento
                            if (inicio == fim && inicio.num == numero) {
                                inicio = null;
                                achou = achou + 1;
                            } else {
                                if (aux.num == numero) {
                                    // o número digitado foi encontrado na lista e será removido
                                    achou = achou + 1;
                                    if (aux == inicio) {
                                        // o número a ser removido é o primeiro da lista
                                        inicio = aux.prox;
                                        fim.prox = inicio;
                                        aux = inicio;
                                    } else if (aux == fim) {
                                        // o número a ser removido é o último da lista
                                        fim = anterior;
                                        fim.prox = inicio;
                                        aux = aux.prox;
                                    } else {
                                        // o número a ser removido está no meio da lista
                                        anterior.prox = aux.prox;
                                        aux = aux.prox;
                                    }
                                } else {
                                    anterior = aux;
                                    aux = aux.prox;
                                }
                                elemento = elemento + 1;
                            }
                        } while (elemento <= quantidade);
 
                        if (achou == 0) {
                            System.out.println("Número não encontrado");
                        } else if (achou == 1) {
                            System.out.println("Número removido 1 vez");
                        } else {
                            System.out.println("Numero removido " + achou + " vezes");
                        }
                    }
                }
                if (op == 5) {
                    if (inicio == null) {
                        // a lista está vazia
                        System.out.println("Lista vazia!!");
                    } else {
                        // a lista será esvaziada
                        inicio = null;
                        System.out.println("Lista esvaziada");
                    }
                }
 
            }
 
        } while (op != 6);
    }
}

