package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.util.ArrayList;

public class GESTAO_CANDState extends apoio_poeAdapter{
    public GESTAO_CANDState(apoio_poeContext context, PoE data) {
        super(context, data);
    }
    CareTaker careTaker = new CareTaker(data);

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_CAND;
    }

    @Override
    public boolean changeFromGestaoCANDtoBase() {
        changeState(apoio_poeState.FASE2);
        return false;
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
    public void addCandidatura(){
        careTaker.save();
        data.addCandidatura();
    }
    @Override
    public ArrayList<Candidatura> consultaCandidaturas(){return data.consultarCandidaturas();}
    @Override
    public Candidatura consultaCandidatura(long nrAluno){return data.consultarCandidatura(nrAluno);}
    @Override
    public ArrayList<Aluno> consultarAlunos(){return data.consultarAlunos();}
    @Override
    public void exportarCandidaturasParaCSV(String nomeFicheiro){data.exportarCandidaturasParaCSV(nomeFicheiro);};
    @Override
    public void addCandidaturaIndividual(Candidatura c){
        careTaker.save();
        data.addCandidaturaIndividual(c);
    };
    @Override
    public void removerCandidatura(long nr){
        careTaker.save();
        data.removerCandidatura(nr);
    }
    @Override
    public void editarCandidatura(long nrAluno, ArrayList<String> propostas){
        careTaker.save();
        data.editarCandidatura(nrAluno, propostas);
    }
}
