package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class FASE3BlockState extends apoio_poeAdapter{
    public FASE3BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE3BLOCKSTATE;
    }

    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE4);
        return true;
    }
    @Override
    public boolean changeToFaseBloqueadaAnterior(){
        changeState(apoio_poeState.FASE2BLOCKSTATE);
        return true;
    }
    @Override
    public ArrayList<Aluno> consultaAlunosComAutoproposta(){return data.consultarAlunosComAutoproposta();};
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidatura(){return data.consultarAlunosComCandidatura();};
    @Override
    public ArrayList<Aluno> consultarAlunosSemCandidatura(){return data.consultarAlunosSemCandidatura();};
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
}
