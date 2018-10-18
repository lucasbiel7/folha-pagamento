/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumeradores;

import entidades.Limite;
import java.util.Arrays;

/**
 *
 * @author aluno
 */
public enum INSS {
    CATEGORIA1(new Limite(0, 1_903.98),8),
    CATEGORIA2(new Limite(1_903.99, 2_822.90),9),
    CATEGORIA3(new Limite(2_822.91, 5_645.80),11);
    
    private final Limite limite;
    private final double aliquota;

    private INSS(Limite limite, double aliquota) {
        this.limite = limite;
        this.aliquota = aliquota;
    }

    public Limite getLimite() {
        return limite;
    }

    public double getAliquota() {
        return aliquota;
    }
    
    public INSS categoria(double salario){
        return Arrays.asList(values()).stream().filter(t -> t.getLimite().getMinimo()<=salario && t.getLimite().getMaximo()>=salario).findFirst().orElse(null);
    }
    
}
