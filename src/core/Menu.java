/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import entidades.Comissionado;
import entidades.Confianca;
import entidades.Dependente;
import entidades.Funcionario;
import entidades.Horista;
import entidades.Mensalista;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = null;
        System.out.println("1 - Funcionário Mensalista");
        System.out.println("2 - Funcionário Horista");
        System.out.println("3 - Funcionário Comissionado");
        System.out.println("4 - Funcionário Cargo de Confiança");
        int tipoFuncionario = scanner.nextInt();
        switch (tipoFuncionario) {
            case 1:
                funcionario = new Mensalista();
                break;
            case 2:
                funcionario = new Horista();
                break;
            case 3:
                funcionario = new Comissionado();
                break;
            case 4:
                funcionario = new Confianca();
                break;
        }
        perguntasFuncionario(funcionario);
        if (funcionario instanceof Mensalista) {
            perguntasMensalista((Mensalista) funcionario);
        }
        if (funcionario instanceof Horista) {
            perguntasHoristas((Horista) funcionario);
        }
        if (funcionario instanceof Comissionado) {
            perguntasComissionado((Comissionado) funcionario);
        }
        if (funcionario instanceof Confianca) {
            perguntasConfianca((Confianca) funcionario);
        }
        
        System.out.println(funcionario.toString());

    }

    private static void perguntasFuncionario(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu nome:");
        funcionario.setNome(scanner.nextLine());
        System.out.println("Digite o seu CPF:");
        funcionario.setCpf(scanner.nextLine());
        System.out.println("Digite sua matricula:");
        funcionario.setMatricula(scanner.nextLine());
        String op;
        do {
            System.out.println("Deseja adicionar dependentes? \"S\"-Sim \"N\"-Não  ");
            op = scanner.nextLine().toUpperCase();
            if (op.equals("S")) {
                Dependente dependente = new Dependente();
                System.out.println("CPF do dependente");
                dependente.setCpf(scanner.nextLine());
                System.out.println("Nome do dependente");
                dependente.setNome(scanner.nextLine());
                System.out.println("Idade do dependente");
                dependente.setIdade(scanner.nextInt());
                scanner.nextLine();
                funcionario.getDependentes().add(dependente);
            }
        } while (!op.equals("N"));
    }

    private static void perguntasMensalista(Mensalista funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu salário");
        funcionario.setSalario(scanner.nextDouble());
    }

    private static void perguntasHoristas(Horista funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor da sua hora trabalhada");
        funcionario.setValorHora(scanner.nextDouble());
        System.out.println("Quantas horas você trabalhou");
        funcionario.setHoras(scanner.nextInt());
    }

    private static void perguntasConfianca(Confianca funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor de bonus");
        funcionario.setBonus(scanner.nextDouble());
    }

    private static void perguntasComissionado(Comissionado funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor da sua comissão");
        funcionario.setComissao(scanner.nextDouble());
    }
}
