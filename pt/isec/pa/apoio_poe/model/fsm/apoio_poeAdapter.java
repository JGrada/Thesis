package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.util.ArrayList;
import java.util.HashMap;

abstract class apoio_poeAdapter implements IApoio_poeState{
    apoio_poeContext context;
    PoE data;

    public apoio_poeAdapter(apoio_poeContext context, PoE data){
        this.context = context;
        this.data = data;
    }

    public void changeState(apoio_poeState state){
            context.changeState(state.createState(context, data));
    }

    @Override
    public void fecharFase() {}
    @Override
    public boolean avancarFase() {return false;}
    @Override
    public boolean recuarFase() {return false;}
    @Override
    public boolean changeToGestaoAL() {return false;}
    @Override
    public boolean changeToGestaoCAND(){return false;}
    @Override
    public boolean changeToGestaoDOC(){return false;}
    @Override
    public boolean changeToGestaoORI(){return false;}
    @Override
    public boolean changeToTratamentoProp() {return false;}
    @Override
    public boolean changeFromGestaoPROPtoBase() {return false;}
    @Override
    public boolean changeFromGestaoALtoBase() {return false;}
    @Override
    public boolean changeFromGestaoDOCtoBase() {return false;}
    @Override
    public boolean changeFromGestaoCANDtoBase() {return false;}
    @Override
    public boolean changeFromGestaoORItoBase() {return false;}
    @Override
    public boolean changeToGestaoManualAtribuicoesState() {return false;}
    @Override
    public boolean changeToGestaoDeDocentesState(){return false;}
    @Override
    public boolean changeFromGestaoManualAtribToFase3(){return false;}
    @Override
    public boolean changeFromGestaoManualOrientToFase4(){return false;}
    public boolean changeToPropState(){return false;}
    public boolean changeFromTratamentoPropToBase(){return false;}
    public boolean changeFromF3MasF2AbertaToBase(){return false;}
    public boolean changeToF3MasF2Aberta(){return false;}
    public boolean changeToFase1State(){return false;}
    public boolean loadState(){return false;}
    public boolean changeToFaseBloqueadaAnterior(){return false;}

    @Override
    public void undo(){};
    @Override
    public void redo(){};

    //Fase 1
    @Override
    public void addAluno(){};
    @Override
    public void addAlunoSingular(Aluno a){};
    @Override
    public void removerAluno(long nrAluno){};
    @Override
    public void editarAluno(long nr, String nome, String email, String siglaCurso, String siglaRamos, double Classificacao, boolean acesso, String IDprop){};
    @Override
    public void addPropostaSingular(Proposta p){};
    @Override
    public void addDocente(){};
    @Override
    public void addDocenteSingular(Docente d){};
    @Override
    public void editarDocente(String email, String nome){};
    @Override
    public void addProposta(){};
    @Override
    public void removerProposta(String ID){};
    @Override
    public void editarProposta(String idProposta, long nrAluno, String titulo, String tipoDeProposta, boolean atribuida){};
    @Override
    public void exportarDocentesParaCSV(String nomeFicheiro){};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){};
    @Override
    public void exportarPropostasParaCSV(String nomeFicheiro){};
    @Override
    public void exportarCandidaturasParaCSV(String nomeFicheiro){};
    @Override
    public Aluno consultaAluno(long nrAluno) {return null;}
    @Override
    public ArrayList<Aluno> consultarAlunos() {return null;}
    @Override
    public Docente consultaDocente(String email){return null;}
    @Override
    public void removerDocente(String email){};
    @Override
    public ArrayList<Docente> consultaDocentes(){return null;}
    @Override
    public Proposta consultaProposta(String idProposta){return null;}
    @Override
    public ArrayList<Proposta> consultaPropostas(){return null;}



    //Fase 2
    @Override
    public void addCandidatura(){};
    @Override
    public void addCandidaturaIndividual(Candidatura c){};
    @Override
    public void removerCandidatura(long nr){};
    @Override
    public void editarCandidatura(long nrAluno, ArrayList<String> propostas){};
    @Override
    public Candidatura consultaCandidatura(long nrAluno){return null;}
    @Override
    public ArrayList<Candidatura> consultaCandidaturas(){return null;}
    @Override
    public ArrayList<Aluno> consultaAlunosComAutoproposta(){return null;}
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidatura(){return null;};
    @Override
    public ArrayList<Aluno> consultarAlunosSemCandidatura(){return null;};
    @Override
    public ArrayList<Proposta> consultarListaDeAutopropostas(){return null;};
    @Override
    public ArrayList<Proposta> consultarPropostasDeDocentes(){return null;};
    @Override
    public ArrayList<Proposta> consultarPropostasComCandidaturas(){return null;};
    @Override
    public ArrayList<Proposta> consultarPropostasSemCandidaturas(){return null;};



    //Fase 3
    @Override
    public void atribuirAutoproposta(){};
    @Override
    public void atribuirPropostaDeDocente(){};
    @Override
    public void atribuicaoDeAlunosSemPropostasDefinidas(){};
    @Override
    public void atribuirPropostaManualmente(long nrAluno, String idProposta){};
    @Override
    public void removerPropostaManualmente(long nrAluno){};
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaAtribuida(){return null;};
    @Override
    public ArrayList<Aluno> consultarAlunosSemPropostaAtribuida(){return null;};
    @Override
    public ArrayList<Proposta> consultarPropostasDisponiveis(){return null;};
    @Override
    public ArrayList<Proposta> consultarPropostasAtribuidas(){return null;};
    @Override
    public boolean changeToGestaoManualOrientState(){return false;}

    //Fase 4
    @Override
    public void atribuirPropostaADocenteProponenteAutomaticamente(){}
    @Override
    public void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf, String IDproposta){};
    @Override
    public Docente consultarOrientadorDeProposta(String idProposta){return null;};
    @Override
    public void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador){};
    @Override
    public void removerOrientadorDeProposta(String idProposta){};
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaEComOrientador(){return null;};
    @Override
    public ArrayList<Aluno> consultarAlunosComPropostaESemOrientador(){return null;};
    @Override
    public Docente consultarDocenteComMenosOrientacoes(){return null;};
    @Override
    public Docente consultarDocenteComMaisOrientacoes(){return null;};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return null;};





    //Fase 5
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidaturaESemProposta(){return null;};
    public void removerTodasAsAtribuicoes(){}
    public String consultarPropostas(){return null;}
    public String consultarOrientacoesDocente(String email){return null;}
    public double devolveNumPropostasSI(){return 0;}
    public double devolveNumPropostasRAS(){return 0;}
    public double devolveNumPropostasDA(){return 0;}
    @Override
    public HashMap<String, Integer> DocentesComMaisOrientacoes(){return null;}
    @Override
    public HashMap<String, Number> EmpresasComMaisEstagios(){return null;}







}
