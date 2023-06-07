package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

import java.util.ArrayList;

public class FASE1BlockState extends apoio_poeAdapter{
    public FASE1BlockState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE1BLOCKSTATE;
    }
    //aqui só vai dar para consultar, mas não alterar
    public boolean avancarFase() {
        if(data.faseFechada >=2){
            changeState(apoio_poeState.FASE2BLOCKSTATE);
            return true;
        }
        changeState(apoio_poeState.FASE2);
        return true;
    }
    @Override
    public Aluno consultaAluno(long nrAluno){return data.consultarAluno(nrAluno);}
    @Override
    public ArrayList<Aluno> consultarAlunos(){return data.consultarAlunos();}
    @Override
    public Docente consultaDocente(String email){return data.consultarDocente(email);}
    @Override
    public ArrayList<Docente> consultaDocentes(){return data.consultarDocentes();}
    @Override
    public Proposta consultaProposta(String IDProposta){return data.consultarProposta(IDProposta);}
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}
}
