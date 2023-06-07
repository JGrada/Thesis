package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;

public class TRATAMENTO_PROPState extends apoio_poeAdapter{
    public TRATAMENTO_PROPState(apoio_poeContext context, PoE data) {
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
        return apoio_poeState.TRATAMENTO_PROP;
    }

    @Override
    public boolean changeFromTratamentoPropToBase() {
        changeState(apoio_poeState.FASE3);
        return true;
    }

    @Override
    public boolean changeToGestaoManualAtribuicoesState(){
        changeState(apoio_poeState.GESTAO_MANUAL_ATRIBSTATE);
        return true;
    }

    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){
        data.save();
        data.atruibuicaoDeAlunosSemPropostasDefinidas();}

    @Override
    public void atribuirAutoproposta(){
        data.save();
        data.atribuirAutoproposta();}

    @Override
    public void atribuirPropostaDeDocente(){
        data.save();
        data.atribuirPropostaDeDocente();}

    @Override
    public void removerTodasAsAtribuicoes(){
        data.save();
        data.removerTodasAsAtribuicoes();}


}
