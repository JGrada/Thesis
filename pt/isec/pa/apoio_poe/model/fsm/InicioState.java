package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;

public class InicioState extends apoio_poeAdapter{
    public InicioState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.InicioState;
    }

    @Override
    public boolean avancarFase() {
        changeState(apoio_poeState.FASE1);
        return true;
    }

    @Override
    public boolean loadState(){
        context.carregar();
        return true;
    }
}
