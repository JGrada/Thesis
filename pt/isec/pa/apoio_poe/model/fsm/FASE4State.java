package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.util.ArrayList;

public class FASE4State extends apoio_poeAdapter{

    public FASE4State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE4;
    }


    @Override
    public boolean recuarFase() {
        if(data.faseFechada <= 2) {
            changeState(apoio_poeState.FASE3);
            return true;
        }
        changeState(apoio_poeState.FASE3BLOCKSTATE);
        return false;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 3;
    }
    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE5);
        return true;
    }

    @Override
    public boolean changeToGestaoORI() {
        changeState(apoio_poeState.GESTAO_ORI);
        return true;
    }
    @Override
    public boolean changeToGestaoManualOrientState() {
        changeState(apoio_poeState.GESTAO_MANUAL_ORIENTSTATE);
        return true;
    }
    @Override
    public boolean changeToGestaoDeDocentesState(){
        changeState(apoio_poeState.GESTAO_DOC);
        return true;
    }
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaEComOrientador(){return data.consultarAlunosComPropostaEComOrientador();};
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaESemOrientador(){return data.consultarAlunosComPropostaESemOrientador();};
    @Override
    public Docente consultarDocenteComMenosOrientacoes(){return data.consultarDocenteComMenosOrientacoes();};
    @Override
    public Docente consultarDocenteComMaisOrientacoes(){return data.consultarDocenteComMaisOrientacoes();};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return data.consultarMediaDeOrientacoesDosDocentes();};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};
    @Override
    public String consultarOrientacoesDocente(String email){return data.consultarOrientacoesDocente(email);}





}
