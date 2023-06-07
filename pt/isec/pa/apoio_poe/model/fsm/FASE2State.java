package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class FASE2State extends apoio_poeAdapter{

    public FASE2State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2;
    }

    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 0) {
            changeState(apoio_poeState.FASE1);
            return true;
        }
        changeState(apoio_poeState.FASE1BLOCKSTATE) ;
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 2;
    }
    @Override
    public boolean avancarFase() {
        if(data.faseFechada <=1){
            changeState(apoio_poeState.FASE3MasFASE2AbertaState);
            return true;
        }
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public boolean changeToGestaoCAND() {
        changeState(apoio_poeState.GESTAO_CAND);
        return true;
    }

    @Override
    public ArrayList<Aluno> consultaAlunosComAutoproposta(){return data.consultarAlunosComAutoproposta();}
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidatura(){return data.consultarAlunosComCandidatura();};
    @Override
    public ArrayList<Aluno> consultarAlunosSemCandidatura(){return data.consultarAlunosSemCandidatura();};
    @Override
    public ArrayList<Proposta> consultarListaDeAutopropostas(){return data.consultarListaDeAutopropostas();};
    @Override
    public ArrayList<Proposta> consultarPropostasDeDocentes(){return data.consultarPropostasDocentes();};
    @Override
    public ArrayList<Proposta> consultarPropostasComCandidaturas(){return data.consultarPropostasComCandidaturas();};
    @Override
    public ArrayList<Proposta> consultarPropostasSemCandidaturas(){return data.consultarPropostasSemCandidaturas();};
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}


}
