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
public class Confianca extends Mensalista {

    private double bonus;

    @Override
    public double getSalario() {
        return super.getSalario() * bonus / 100;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double descontoVR() {
        return 1D;
    }

}
