package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GESTAO_ALState extends apoio_poeAdapter{
    public GESTAO_ALState(apoio_poeContext context, PoE data) {
        super(context, data);
    }
    CareTaker careTaker = new CareTaker(data);

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_AL;
    }

    @Override
    public boolean changeFromGestaoALtoBase() {
        changeState(apoio_poeState.FASE1);
        return true;
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
    public void addAluno(){
        careTaker.save();

        data.addAluno();

    }
    @Override
    public void addAlunoSingular(Aluno a){
        careTaker.save();
        data.addAlunoSingular(a);
    }
    @Override
    public void removerAluno(long nr){
        careTaker.save();
        data.removerAluno(nr);};
    @Override
    public Aluno consultaAluno(long nrAluno){return data.consultarAluno(nrAluno);}
    @Override
    public void editarAluno(long nr, String nome, String email, String siglaCurso, String siglaRamos, double Classificacao, boolean acesso, String IDProp){
        careTaker.save();
        data.editarAluno(nr, nome, email, siglaCurso, siglaRamos, Classificacao, acesso, IDProp);
    }
    @Override
    public ArrayList<Aluno> consultarAlunos(){return data.consultarAlunos();}
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};




}
