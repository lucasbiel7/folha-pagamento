/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import enumeradores.INSS;
import enumeradores.IRRF;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Gabriel
 */
public abstract class Funcionario {

    private String matricula;
    private String nome;
    private String cpf;
    protected double salario;

    private List<Dependente> dependentes;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected void setSalario(double salario) {
        this.salario = salario;
    }

    protected abstract double getSalario();

    public List<Dependente> getDependentes() {
        if(dependentes==null){
            dependentes=new ArrayList<>();
        }
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public double descontoVT() {
        return getSalario() * 0.06;
    }

    public abstract double descontoVR();
    
    public double descontoINSS(){
        INSS categoria = INSS.categoria(getSalario());
        return (categoria.getLimite().getMaximo()>getSalario()? getSalario():categoria.getLimite().getMaximo()) * categoria.getAliquota()/100;
    }
    
    protected double calcularBase(){
        return getSalario()-descontoINSS();
    }
    
    public double descontoIRRF(){
        IRRF categoria = IRRF.categoria(calcularBase());
        return (calcularBase()*categoria.getAliquota()/100)-categoria.getDeducao()-(dependentes.size()*IRRF.DESCONTO_DEPENDENTES);
    }
    
    public double getSalarioLiquido(){
        return getSalario()-descontoINSS()-descontoIRRF()-descontoVR()-descontoVT();
    }

    @Override
    public String toString() {
        return String.format("------------------------------------------------------\n"
                + "Nome: %s\n"
                + "CPF: %s\n"
                + "Matricula: %s\n"
                + "Salário Bruto R$%.2f\n"
                + "Desconto vale refeição: R$%.2f\n"
                + "Desconto vale transporte: R$%.2f\n"
                + "Desconto INSS: R$%.2f\n"
                + "Desconto IRRF: R$%.2f\n"
                + "Salário Liquido: R$%.2f\n",getNome(),getCpf(),getMatricula(),getSalario(),descontoVR(),descontoVT(),descontoINSS(),descontoIRRF(),getSalarioLiquido());
    }
    
    

}
