package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class FASE3State extends apoio_poeAdapter{
    public FASE3State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    CareTaker careTaker = new CareTaker(data);

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3;
    }

    @Override
    public void undo(){
        careTaker.undo();
    }
    @Override
    public void redo(){
        careTaker.redo();
    }

    @Override
    public boolean recuarFase() {
        System.out.println(data.faseFechada);
        if(data.faseFechada <= 1) {
            changeState(apoio_poeState.FASE2);
            return true;
        }
        changeState(apoio_poeState.FASE2BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 3;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
        return true;
    }
    @Override
    public boolean changeToTratamentoProp(){
        changeState(apoio_poeState.TRATAMENTO_PROP);
        return true;
    }
    @Override
    public boolean changeToF3MasF2Aberta(){
        if(data.faseFechada <= 1) {
            changeState(apoio_poeState.FASE3MasFASE2AbertaState);
            return true;
        }
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public boolean changeToGestaoManualAtribuicoesState(){
        changeState(apoio_poeState.GESTAO_MANUAL_ATRIBSTATE);
        return true;
    }
    @Override
    public ArrayList<Aluno> consultaAlunosComAutoproposta(){return data.consultarAlunosComAutoproposta();};
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidatura(){return data.consultarAlunosComCandidatura();};
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaAtribuida(){return data.consultarAlunosComPropostaAtribuida();};
    @Override
    public ArrayList<Aluno> consultarAlunosSemPropostaAtribuida(){return data.consultarAlunosSemPropostaAtribuida();};
    @Override
    public ArrayList<Proposta> consultarListaDeAutopropostas(){return data.consultarListaDeAutopropostas();};
    @Override
    public ArrayList<Proposta> consultarPropostasDeDocentes(){return data.consultarPropostasDocentes();};
    @Override
    public ArrayList<Proposta> consultarPropostasDisponiveis(){return data.consultarPropostasDisponiveis();};
    @Override
    public ArrayList<Proposta> consultarPropostasAtribuidas(){return data.consultarPropostasAtribuidas();};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){
        careTaker.save();

        data.atruibuicaoDeAlunosSemPropostasDefinidas();}


}
