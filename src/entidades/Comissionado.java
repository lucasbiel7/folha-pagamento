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
public class Comissionado extends Mensalista {

    private double comissao;

    @Override
    public double getSalario() {
        return super.getSalario() * comissao / 100;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double descontoVR() {
        return getSalario() * 15d / 100d;
    }

    @Override
    public String toString() {
        return String.format("%s\n"
                + "Comissão: %.1f\n", super.toString(),getComissao()); 
    }
    
    

}
