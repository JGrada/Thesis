package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class apoio_poeContext {
    private PoE data;
    private IApoio_poeState state;
    public static final String PROP_FASE = "FASE";
    public static final String PROP_CANDIDATURA = "CANDIDATURA";
    public static final String PROP_PROPOSTA = "PROPOSTA";
    public static final String PROP_ALUNO = "ALUNO";
    public static final String PROP_DOCENTE = "DOCENTE";
    private static apoio_poeContext instance = null;

    public static apoio_poeContext getInstance(){
        if(instance==null){
            instance = new apoio_poeContext();
        }
        return instance;
    }

    private apoio_poeContext(){
        this.data = new PoE();
        this.state = apoio_poeState.InicioState.createState(this, data);
    }

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(String property, PropertyChangeListener listener){
        pcs.addPropertyChangeListener(property, listener);
    }



    public void changeState(IApoio_poeState state){
        this.state = state;
        pcs.firePropertyChange(PROP_FASE, null, null);

    }
    public void undo(){state.undo();}
    public void redo(){state.redo();}

    public void fecharFase() {state.fecharFase();};
    public boolean avancarFase() {
        boolean resultado = state.avancarFase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean recuarFase() {
        boolean resultado = state.recuarFase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoAL() {
        boolean resultado = state.changeToGestaoAL();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoCAND(){
        boolean resultado = state.changeToGestaoCAND();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoDOC(){
        boolean resultado = state.changeToGestaoDOC();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoORI(){
        boolean resultado = state.changeToGestaoORI();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToTratamentoProp() {
        boolean resultado = state.changeToTratamentoProp();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoPROPtoBase() {
        boolean resultado = state.changeFromGestaoPROPtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoALtoBase() {
        boolean resultado = state.changeFromGestaoALtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoDOCtoBase() {
        boolean resultado = state.changeFromGestaoDOCtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoCANDtoBase() {
        boolean resultado = state.changeFromGestaoCANDtoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoORItoBase() {
        boolean resultado = state.changeFromGestaoORItoBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoManualAtribuicoesState() {
        boolean resultado = state.changeToGestaoManualAtribuicoesState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoDeDocentesState(){
        boolean resultado = state.changeToGestaoDeDocentesState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoManualAtribToFase3(){
        boolean resultado = state.changeFromGestaoManualAtribToFase3();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromGestaoManualOrientToFase4(){
        boolean resultado = state.changeFromGestaoManualOrientToFase4();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToPropState(){
        boolean resultado = state.changeToPropState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;

    }
    public boolean changeFromTratamentoPropToBase(){
        boolean resultado = state.changeFromTratamentoPropToBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeFromF3MasF2AbertaToBase(){
        boolean resultado = state.changeFromF3MasF2AbertaToBase();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToF3MasF2Aberta(){
        boolean resultado = state.changeToF3MasF2Aberta();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToFase1State(){
        boolean resultado = state.changeToFase1State();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean loadState(){
        boolean resultado = state.loadState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
        return resultado;
    }
    public boolean changeToFaseBloqueadaAnterior(){
        boolean resultado = state.changeToFaseBloqueadaAnterior();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }
    public boolean changeToGestaoManualOrientState(){
        boolean resultado = state.changeToGestaoManualOrientState();
        pcs.firePropertyChange(PROP_FASE, null, null);
        return resultado;
    }

    public void addAluno(){
        state.addAluno();
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void removerAluno(long nr){
        state.removerAluno(nr);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void addAlunoSingular(Aluno a){
        state.addAlunoSingular(a);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    };
    public Aluno consultaAluno(long nrAluno){
        return state.consultaAluno(nrAluno);
    }
    public ArrayList<Aluno> consultarAlunos(){return state.consultarAlunos();}
    public void editarAluno(long nr, String nome, String email, String siglaCurso, String siglaRamos, double Classificacao, boolean acesso, String IDProp)
    {
        state.editarAluno(nr, nome, email, siglaCurso, siglaRamos, Classificacao, acesso, IDProp);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void addDocente(){
        state.addDocente();
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
    }
    public void addDocenteSingular(Docente d){
        state.addDocenteSingular(d);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
    };
    public void removerDocente(String email){
        state.removerDocente(email);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
    }
    public void editarDocente(String email, String nome){
        state.editarDocente(email, nome);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
    }
    public Docente consultaDocente(String email){return state.consultaDocente(email);}
    public ArrayList<Docente> consultaDocentes(){return state.consultaDocentes();}
    public void addProposta(){
        state.addProposta();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
    }
    public void removerProposta(String ID){
        state.removerProposta(ID);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
    }
    public void editarProposta(String idProposta, long nrAluno, String titulo, String tipoDeProposta, boolean atribuida){
        state.editarProposta(idProposta, nrAluno, titulo, tipoDeProposta, atribuida);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
    }
    public void addPropostaSingular(Proposta p){
        state.addPropostaSingular(p);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
    };
    public Proposta consultaProposta(String idProposta){return state.consultaProposta(idProposta);}
    public ArrayList<Proposta> consultaPropostas(){return state.consultaPropostas();}
    public void addCandidatura(){
        state.addCandidatura();
        pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
    }
    public void addCandidaturaIndividual(Candidatura c){
        state.addCandidaturaIndividual(c);
        pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
    };
    public void removerCandidatura(long nr){
        state.removerCandidatura(nr);
        pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
    };
    public void editarCandidatura(long nrAluno, ArrayList<String> propostas){
        state.editarCandidatura(nrAluno, propostas);
        pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
    }
    public Candidatura consultaCandidatura(long nrAluno){return state.consultaCandidatura(nrAluno);}
    public ArrayList<Candidatura> consultaCandidaturas(){return state.consultaCandidaturas();}
    public ArrayList<Aluno> consultaAlunosComAutoproposta(){return state.consultaAlunosComAutoproposta();}
    public ArrayList<Aluno> consultarAlunosComCandidatura(){return state.consultarAlunosComCandidatura();}
    public ArrayList<Proposta> consultarListaDeAutopropostas(){return state.consultarListaDeAutopropostas();}
    public ArrayList<Proposta> consultarPropostasDocentes(){return state.consultarPropostasDeDocentes();};
    //public String consultarPropostasComCadidaturas(){return state.consultarPropostasComCadidaturas();}
    //public String consultarPropostasSemCadidaturas(){return state.consultarPropostasSemCadidaturas();}
    public void atribuirAutoproposta(){
        state.atribuirAutoproposta();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);

    }
    public void atribuirPropostaDeDocente(){
        state.atribuirPropostaDeDocente();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void atribuicaoDeAlunosSemPropostasDefinidas(){
        state.atribuicaoDeAlunosSemPropostasDefinidas();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){
        state.atribuirPropostaManualmente(nrAluno,idProposta);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void removerPropostaManualmente(long nrAluno){
        state.removerPropostaManualmente(nrAluno);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public ArrayList<Aluno> consultarAlunosComPropostaAtribuida(){return state.consultarAlunosComPropostaAtribuida();}
    public ArrayList<Aluno> consultarAlunosSemPropostaAtribuida(){return state.consultarAlunosSemPropostaAtribuida();}
    public ArrayList<Proposta> consultarPropostasDisponiveis(){return state.consultarPropostasDisponiveis();}
    public ArrayList<Proposta> consultarPropostasAtribuidas(){return state.consultarPropostasAtribuidas();}
    public void atribuirPropostaADocenteProponenteAutomaticamente(){
        state.atribuirPropostaADocenteProponenteAutomaticamente();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf, String IDProposta){
        state.atribuirManulamenteOrientadorAAlunosComProposta(nrAluno,emailProf, IDProposta);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public Docente consultarOrientadorDeProposta(String idProposta){return state.consultarOrientadorDeProposta(idProposta);}
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){
        state.editarOrientadorDeProposta(idProposta, emailNovoOrientador);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
    }
    public void removerOrientadorDeProposta(String idProposta){
        state.removerOrientadorDeProposta(idProposta);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public ArrayList<Aluno> consultarAlunosComPropostaEComOrientador(){return state.consultarAlunosComPropostaEComOrientador();}
    public ArrayList<Aluno> consultarAlunosComPropostaESemOrientador(){return state.consultarAlunosComPropostaESemOrientador();}
    public Docente consultarDocenteComMenosOrientacoes(){return state.consultarDocenteComMenosOrientacoes();}
    public Docente consultarDocenteComMaisOrientacoes(){return state.consultarDocenteComMaisOrientacoes();}
    public String consultarMediaDeOrientacoesDosDocentes(){return state.consultarMediaDeOrientacoesDosDocentes();}
    public ArrayList<Aluno> consultarAlunosComCandidaturaESemProposta(){return state.consultarAlunosComCandidaturaESemProposta();}
    public ArrayList<Aluno> consultarAlunosSemCandidatura(){return state.consultarAlunosSemCandidatura();}
    public ArrayList<Proposta> consultarPropostasComCandidaturas(){return state.consultarPropostasComCandidaturas();}
    public ArrayList<Proposta> consultarPropostasSemCandidaturas(){return state.consultarPropostasSemCandidaturas();}
    public void atribuirManualmenteOrientadorAAlunosComPropostas(long nrAluno, String emailProf, String IDproposta){
        state.atribuirManulamenteOrientadorAAlunosComProposta(nrAluno,emailProf, IDproposta);
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void removerTodasAsAtribuicoes(){
        state.removerTodasAsAtribuicoes();
        pcs.firePropertyChange(PROP_PROPOSTA, null, null);
        pcs.firePropertyChange(PROP_DOCENTE, null, null);
        pcs.firePropertyChange(PROP_ALUNO, null, null);
    }
    public void exportarAlunosParaCSV(String nomeFicheiro){state.exportarAlunosParaCSV(nomeFicheiro);};
    public void exportarDocentesParaCSV(String nomeFicheiro){state.exportarDocentesParaCSV(nomeFicheiro);}
    public void exportarPropostasParaCSV(String nomeFicheiro){state.exportarPropostasParaCSV(nomeFicheiro);};
    public void exportarCandidaturasParaCSV(String nomeFicheiro){state.exportarCandidaturasParaCSV(nomeFicheiro);};
    public apoio_poeState getState(){
        return state.getState();
    }
    public ArrayList<Proposta> consultarPropostas(){return state.consultaPropostas();}
    public String consultarOrientacoesDocente(String email){return state.consultarOrientacoesDocente(email);}

    public boolean carregar(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save"))){

            data = (PoE) ois.readObject();
            state = ((apoio_poeState) ois.readObject()).createState(this, data);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean save(){
        try(ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("save"))){

            oos.writeObject(data);
            oos.writeObject(state.getState());
            pcs.firePropertyChange(PROP_CANDIDATURA, null, null);
            pcs.firePropertyChange(PROP_PROPOSTA, null, null);
            pcs.firePropertyChange(PROP_DOCENTE, null, null);
            pcs.firePropertyChange(PROP_ALUNO, null, null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public double devolveNumPropostasSI(){return state.devolveNumPropostasSI();}
    public double devolveNumPropostasRAS(){return state.devolveNumPropostasRAS();}
    public double devolveNumPropostasDA(){return state.devolveNumPropostasDA();}
    public HashMap<String, Integer> DocentesComMaisOrientacoes(){return state.DocentesComMaisOrientacoes();}
    public HashMap<String, Number> EmpresasComMaisEstagios(){return state.EmpresasComMaisEstagios();}








}
