/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aluno
 */
public class Mensalista extends Funcionario{

    @Override
    public void setSalario(double salario) {
        super.setSalario(salario); 
    }

    @Override
    public double getSalario() {
        return this.salario;
    }

    @Override
    public double descontoVR() {
        return getSalario()*20d/100d;
    }
}
