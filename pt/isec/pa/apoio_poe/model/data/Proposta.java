package pt.isec.pa.apoio_poe.model.data;

import java.io.Serializable;

public class Proposta implements Comparable<Proposta>, Serializable, Cloneable {
    private final String idProposta;
    private long nrAluno;
    private String titulo;
    private String tipoDeProposta;
    private boolean atribuida;
    private String orientador;




    public Proposta(String tipoDeProposta, String idProposta, long nrAluno, String titulo, boolean atribuida) {
        this.tipoDeProposta = tipoDeProposta;
        this.idProposta = idProposta;
        this.nrAluno = nrAluno;
        this.titulo = titulo;
        this.atribuida = atribuida;

    }
    public String getTipoDeProposta() {return tipoDeProposta;}
    public void setTipoDeProposta(String tipoDeProposta) {this.tipoDeProposta = tipoDeProposta;}
    public String getIdProposta() {return idProposta;}
    public long getNrAluno() {return nrAluno;}
    public boolean isAtribuida() {return atribuida;}
    public void setAtribuida(boolean atribuida) {
        this.atribuida = atribuida;
    }
    public void setNrAluno(long nrAluno) {this.nrAluno = nrAluno;}
    public String getOrientador() {
        return orientador;
    }
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Proposta: ").append(tipoDeProposta).append(System.lineSeparator());
        sb.append("ID Proposta: ").append(idProposta).append(System.lineSeparator());
        sb.append("nrAluno: ").append(nrAluno).append(System.lineSeparator());
        sb.append("Titulo: ").append(titulo).append(System.lineSeparator());
        sb.append("Esta atribuida: ").append(isAtribuida()).append(System.lineSeparator());
            if(isAtribuida()){
                sb.append("Orientador: ").append(getOrientador()).append(System.lineSeparator());
            }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public int compareTo(Proposta o) {
        return idProposta.compareTo(o.idProposta);
    }

    @Override
    public Proposta clone() {
        try {
            Proposta clone = (Proposta) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
