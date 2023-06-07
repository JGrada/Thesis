package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;

public class GESTAO_MANUAL_ATRIBSTATE extends apoio_poeAdapter{
    public GESTAO_MANUAL_ATRIBSTATE(apoio_poeContext context, PoE data) {
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
        return apoio_poeState.GESTAO_MANUAL_ATRIBSTATE;
    }
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){
        careTaker.save();
        data.atruibuicaoDeAlunosSemPropostasDefinidas();
    };
    @Override
    public void atribuirAutoproposta(){
        careTaker.save();
        data.atribuirAutoproposta();
    };
    @Override
    public void atribuirPropostaDeDocente(){
        careTaker.save();
        data.atribuirPropostaDeDocente();
    };
    @Override
    public boolean changeFromGestaoManualAtribToFase3() {
        changeState(apoio_poeState.FASE3);
        return false;
    }
    @Override
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){
        careTaker.save();
        data.atribuirPropostaManualmente(nrAluno,idProposta);
    };
    @Override
    public void removerPropostaManualmente(long nrAluno){data.removerPropostaManualmente(nrAluno);};
}
