package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.CareTaker;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GESTAO_DOCState extends apoio_poeAdapter{
    public GESTAO_DOCState(apoio_poeContext context, PoE data) {
        super(context, data);
    }
    CareTaker careTaker = new CareTaker(data);
    @Override
    public apoio_poeState getState() {
        return apoio_poeState.GESTAO_DOC;
    }

    @Override
    public boolean changeFromGestaoDOCtoBase() {
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
    public void addDocente(){
        careTaker.save();
        data.addDocente();}
    @Override
    public void addDocenteSingular(Docente d){
        careTaker.save();
        data.addDocenteSingular(d);};
    @Override
    public Docente consultaDocente(String email){return data.consultarDocente(email);}
    @Override
    public void removerDocente(String email){
        careTaker.save();
        data.removerDocente(email);}
    @Override
    public void editarDocente(String email, String nome){
        careTaker.save();
        data.editarDocente(email, nome);}
    @Override
    public ArrayList<Docente> consultaDocentes(){return data.consultarDocentes();}
    @Override
    public void atribuirPropostaADocenteProponenteAutomaticamente(){
        careTaker.save();
        data.atribuirPropostaADocenteProponenteAutomaticamente();}
    @Override
    public void exportarDocentesParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};

}
