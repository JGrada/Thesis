package pt.isec.pa.apoio_poe.model.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Candidatura implements Comparable<Candidatura>, Serializable, Cloneable{
        private final long nrAluno;
        private ArrayList<String> arrayCandidaturas = new ArrayList<>();

    public Candidatura(long nrAluno, ArrayList<String> arrayCandidaturas) {
        this.nrAluno = nrAluno;
        this.arrayCandidaturas = arrayCandidaturas;
    }

    public long getNumero() {return nrAluno;}
    public ArrayList<String> getArrayCandidaturas() {return arrayCandidaturas;}

    public void setArrayCandidaturas(ArrayList<String> arrayCandidaturas) {
        this.arrayCandidaturas = arrayCandidaturas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numero de aluno:").append(nrAluno).append(System.lineSeparator());
        sb.append("Propostas:").append(arrayCandidaturas).append(System.lineSeparator());

        return sb.toString();
    }
    @Override
    public int compareTo(Candidatura c) {
        return Long.compare(nrAluno, c.nrAluno);
    }

    @Override
    public Candidatura clone() {
        try {
            Candidatura clone = (Candidatura) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
