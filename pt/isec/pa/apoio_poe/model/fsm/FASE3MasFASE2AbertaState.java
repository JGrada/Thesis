package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;

public class FASE3MasFASE2AbertaState extends apoio_poeAdapter{
    public FASE3MasFASE2AbertaState(apoio_poeContext context, PoE data) {
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
        return apoio_poeState.FASE3MasFASE2AbertaState;
    }

    @Override
    public boolean changeFromF3MasF2AbertaToBase(){
        changeState(apoio_poeState.FASE3);
        return true;
    }
    @Override
    public void atribuirAutoproposta(){
        careTaker.save();
        data.atribuirAutoproposta();};
    @Override
    public void atribuirPropostaDeDocente(){
        careTaker.save();
        data.atribuirPropostaDeDocente();};

    @Override
    public boolean recuarFase() {
        changeState(apoio_poeState.FASE2) ;
        return true;
    }





}
