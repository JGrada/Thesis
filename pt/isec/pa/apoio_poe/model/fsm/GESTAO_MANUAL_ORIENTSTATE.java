package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class GESTAO_MANUAL_ORIENTSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ORIENTSTATE(apoio_poeContext context, PoE data) {
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
        return apoio_poeState.GESTAO_MANUAL_ORIENTSTATE;
    }
    @Override
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf, String IDproposta){
        careTaker.save();
        data.atribuirManualmenteOrientadorAAlunosComPropostas(nrAluno,emailProf, IDproposta);};
    @Override
    public Docente consultarOrientadorDeProposta(String idProposta){return data.consultarOrientadorDeProposta(idProposta);};
    @Override
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){
        careTaker.save();
        data.editarOrientadorDeProposta(idProposta, emailNovoOrientador);};
    @Override
    public void removerOrientadorDeProposta(String idProposta){
        careTaker.save();
        data.removerOrientadorDeProposta(idProposta);};
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}
    @Override
    public boolean changeFromGestaoManualOrientToFase4(){
        changeState(apoio_poeState.FASE4);
        return true;
    }
}
