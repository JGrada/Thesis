package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.*;

import java.util.ArrayList;
import java.util.HashMap;

public interface IApoio_poeState {
    //operações de todas as fases
    public apoio_poeState getState();
    void fecharFase();
    boolean avancarFase();
    boolean recuarFase();
    boolean changeToGestaoAL();
    boolean changeToGestaoCAND();
    boolean changeToGestaoDOC();
    boolean changeToGestaoORI();
    boolean changeToTratamentoProp();
    boolean changeFromGestaoPROPtoBase();
    boolean changeFromGestaoALtoBase();
    boolean changeFromGestaoDOCtoBase();
    boolean changeFromGestaoCANDtoBase();
    boolean changeFromGestaoORItoBase();
    boolean changeToGestaoManualAtribuicoesState();
    boolean changeToGestaoDeDocentesState();
    boolean changeFromGestaoManualAtribToFase3();
    boolean changeFromGestaoManualOrientToFase4();
    boolean changeToPropState();
    boolean changeFromTratamentoPropToBase();
    boolean changeFromF3MasF2AbertaToBase();
    boolean changeToF3MasF2Aberta();
    boolean changeToFase1State();
    boolean loadState();
    boolean changeToFaseBloqueadaAnterior();
    boolean changeToGestaoManualOrientState();

    void undo();
    void redo();

    //Fase 1
    void addAluno();
    void removerAluno(long nr);
    void addAlunoSingular(Aluno a);
    Aluno consultaAluno(long nr);
    ArrayList<Aluno> consultarAlunos();
     void editarAluno(long nr, String nome, String email, String siglaCurso, String siglaRamos, double Classificacao, boolean acesso, String IDProp);
    void addDocente();
    void addDocenteSingular(Docente d);
    void removerDocente(String email);
    void editarDocente(String email, String nome);
    Docente consultaDocente(String email);
    ArrayList<Docente> consultaDocentes();
    void addProposta();
    void addPropostaSingular(Proposta p);
    void removerProposta(String ID);
    public void editarProposta(String idProposta, long nrAluno, String titulo, String tipoDeProposta, boolean atribuida);
    Proposta consultaProposta(String idProposta);
    ArrayList<Proposta> consultaPropostas();
    void exportarDocentesParaCSV(String nomeFicheiro);
    void exportarAlunosParaCSV(String nomeFicheiro);
    void exportarPropostasParaCSV(String nomeFicheiro);
    void exportarCandidaturasParaCSV(String nomeFicheiro);

    //Fase 2
    void addCandidatura();
    Candidatura consultaCandidatura(long nrAluno);
    ArrayList<Candidatura> consultaCandidaturas();
    ArrayList<Aluno> consultaAlunosComAutoproposta();
    ArrayList<Aluno> consultarAlunosComCandidatura();
    ArrayList<Aluno> consultarAlunosSemCandidatura();
    ArrayList<Proposta> consultarListaDeAutopropostas();
    ArrayList<Proposta> consultarPropostasDeDocentes();
    ArrayList<Proposta> consultarPropostasComCandidaturas();
    ArrayList<Proposta> consultarPropostasSemCandidaturas();
    void removerCandidatura(long nr);
    void editarCandidatura(long nrAluno, ArrayList<String> propostas);
    void addCandidaturaIndividual(Candidatura c);


    //Fase 3
    void atribuirAutoproposta();
    void atribuirPropostaDeDocente();
    void atribuicaoDeAlunosSemPropostasDefinidas();
    void atribuirPropostaManualmente(long nrAluno, String idProposta);
    void removerPropostaManualmente(long nrAluno);
    //String consultaAlunosComAutoproposta(); mesma função da linha 36
    //String consultarAlunosComCandidatura(); mesma função da linha 37
    ArrayList<Aluno> consultarAlunosComPropostaAtribuida();
    ArrayList<Aluno> consultarAlunosSemPropostaAtribuida();
    //String consultarListaDeAutopropostas(); mesma função da linha 39
    //String consultarPropostasDeDocentes(); mesma função da linha 40
    ArrayList<Proposta> consultarPropostasDisponiveis();
    ArrayList<Proposta> consultarPropostasAtribuidas();

    //Fase 4
    void atribuirPropostaADocenteProponenteAutomaticamente();
    void atribuirManulamenteOrientadorAAlunosComProposta(long nrAluno, String emailProf, String IDproposta);
    Docente consultarOrientadorDeProposta(String idProposta);
    void editarOrientadorDeProposta(String idProposta, String emailNovoOrientador);
    void removerOrientadorDeProposta(String idProposta);
    ArrayList<Aluno> consultarAlunosComPropostaEComOrientador();
    ArrayList<Aluno> consultarAlunosComPropostaESemOrientador();
    Docente consultarDocenteComMenosOrientacoes();
    Docente consultarDocenteComMaisOrientacoes();
    String consultarMediaDeOrientacoesDosDocentes();
    void removerTodasAsAtribuicoes();
    String consultarPropostas();
    String consultarOrientacoesDocente(String email);

    //Fase 5
    //String consultarAlunosComPropostaAtribuida(); mesma linha 52
    ArrayList<Aluno> consultarAlunosComCandidaturaESemProposta();
    //String consultarPropostasDisponiveis(); 56
    //String consultarPropostasAtribuidas(); 57
    //String consultarDocenteComMenosOrientacoes();
    //String consultarDocenteComMaisOrientacoes();
    //String consultarMediaDeOrientacoesDosDocentes();
    double devolveNumPropostasSI();
    double devolveNumPropostasRAS();
    double devolveNumPropostasDA();
    public HashMap<String, Integer> DocentesComMaisOrientacoes();
    public HashMap<String, Number> EmpresasComMaisEstagios();













}


