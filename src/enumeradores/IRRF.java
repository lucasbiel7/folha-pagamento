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
public enum IRRF {

    CATEGORIA1(new Limite(0D, 1_903.98), 0, 0),
    CATEGORIA2(new Limite(1_903.99, 2_826.65), 7.5, 142.80),
    CATEGORIA3(new Limite(2_826.66, 3_751.05), 15D, 354.80),
    CATEGORIA4(new Limite(3_751.06, 4_664.68), 22.5, 636.13),
    CATEGORIA5(new Limite(4_664.69, Double.MAX_VALUE), 27.5, 869.36);

    public static final double DESCONTO_DEPENDENTES = 189.59;
    
    private final Limite limite;
    private final double aliquota;
    private final double deducao;

    private IRRF(Limite limite, double aliquota, double deducao) {
        this.limite = limite;
        this.aliquota = aliquota;
        this.deducao = deducao;
    }

    public Limite getLimite() {
        return limite;
    }

    public double getAliquota() {
        return aliquota;
    }

    public double getDeducao() {
        return deducao;
    }

    public static IRRF categoria(double base) {
        return Arrays.asList(values()).stream().filter(t -> t.getLimite().getMinimo() <= base && t.getLimite().getMaximo() >= base).findFirst().orElse(null);
    }
}
