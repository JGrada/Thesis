package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE1State extends apoio_poeAdapter{

    public FASE1State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE1;
    }

    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE2);
        return true;
    }
    @Override
    public void fecharFase() {
        data.faseFechada = 1;
    }

    @Override
    public boolean changeToGestaoAL(){
        changeState(apoio_poeState.GESTAO_AL);
        return true;
    }
    @Override
    public boolean changeToGestaoDOC() {
        changeState(apoio_poeState.GESTAO_DOC);
        return true;
    }

    @Override
    public boolean changeToPropState(){
        changeState(apoio_poeState.GESTAO_PROP);
        return true;
    }


}

