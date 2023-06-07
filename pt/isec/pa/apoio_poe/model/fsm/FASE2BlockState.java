package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class FASE2BlockState extends apoio_poeAdapter{
    public FASE2BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE2BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        if(data.faseFechada >=3){
            changeState(apoio_poeState.FASE3BLOCKSTATE);
            return true;
        }
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public boolean changeToFaseBloqueadaAnterior(){
        changeState(apoio_poeState.FASE1BLOCKSTATE);
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
    public Candidatura consultaCandidatura(long nrAluno){return data.consultarCandidatura(nrAluno);}
}
