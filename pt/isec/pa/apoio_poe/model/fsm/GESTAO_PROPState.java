package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GESTAO_PROPState extends apoio_poeAdapter{
    public GESTAO_PROPState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    CareTaker careTaker = new CareTaker(data);

    @Override
    public void undo(){
        careTaker.undo();
    }
    @Override
    public void redo(){
        careTaker.redo();
    }
    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_PROP;
    }

    @Override
    public boolean changeFromGestaoPROPtoBase() {
        changeState(apoio_poeState.FASE1);
        return false;
    }
    @Override
    public void addProposta(){
        careTaker.save();
        data.addProposta();
    }
    @Override
    public void addPropostaSingular(Proposta p){
        careTaker.save();
        data.addPropostaSingular(p);}
    @Override
    public void removerProposta(String ID){
        careTaker.save();
        data.removerProposta(ID);}
    @Override
    public void editarProposta(String idProposta, long nrAluno, String titulo, String tipoDeProposta, boolean atribuida){
        careTaker.save();
        data.editarProposta(idProposta, nrAluno, titulo, tipoDeProposta, atribuida);
    };
    @Override
    public Proposta consultaProposta(String IDProposta){return data.consultarProposta(IDProposta);}
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}
    @Override
    public void exportarPropostasParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};
}
