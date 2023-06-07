package pt.isec.pa.apoio_poe.model.data;

import java.io.Serializable;

public class Docente implements Comparable<Docente>, Serializable, Cloneable {

    private String nome;
    private final String email;
    private String funcaoProjeto;
    private String propostaAssociada;
    private int nrDeOrientacoes;


    public Docente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getPropostaAssociada() {
        return propostaAssociada;
    }
    public void setPropostaAssociada(String propostaAssociada) {
        this.propostaAssociada = propostaAssociada;
    }
    public int getNrDeOrientacoes() {
        return nrDeOrientacoes;
    }
    public void setNrDeOrientacoes(int nrDeOrientacoes) {
        this.nrDeOrientacoes = nrDeOrientacoes;
    }
    public String getFuncaoProjeto() {return funcaoProjeto;}
    public void setNome(String nome) {this.nome = nome;}
    public void setFuncaoProjeto(String funcaoProjeto) {this.funcaoProjeto = funcaoProjeto;}

    public int incrementaNrDeOrientacoes(){nrDeOrientacoes++; return nrDeOrientacoes;}
    public int decrementaNrDeOrientacoes(String orientadorAtual){nrDeOrientacoes--; return nrDeOrientacoes;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(nome).append(System.lineSeparator());
        sb.append("E-mail: ").append(email).append(System.lineSeparator());
        sb.append("Funcao Projeto: ").append(funcaoProjeto).append(System.lineSeparator());
        sb.append("Proposta associada: ").append(propostaAssociada).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public int compareTo(Docente o) {
        return email.compareTo(o.email);
    }

    @Override
    public Docente clone() {
        try {
            Docente clone = (Docente) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}