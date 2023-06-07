package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta{
    private String idEntidadeAcolhimento;
    private String areaDestino;

    public Estagio(String tipoDeProposta, String idProposta, long nrAluno, String titulo, String idEntidadeAcolhimento, String areaDestino, boolean atribuida) {
        super(tipoDeProposta,idProposta, nrAluno, titulo, atribuida);
        this.idEntidadeAcolhimento = idEntidadeAcolhimento;
        this.areaDestino = areaDestino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Entidade acolhimento: ").append(idEntidadeAcolhimento).append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    public String getIdEntidadeAcolhimento() {
        return idEntidadeAcolhimento;
    }
    public String getAreaDestino() {
        return areaDestino;
    }
    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }
}
