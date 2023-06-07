package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;

public class GESTAO_ORIState extends apoio_poeAdapter{
    public GESTAO_ORIState(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_ORI;
    }

    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}

    @Override
    public boolean changeFromGestaoORItoBase(){
        changeState(apoio_poeState.FASE4);
        return true;
    }
}
