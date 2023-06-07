package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.fsm.FASE2State;
import pt.isec.pa.apoio_poe.model.fsm.IApoio_poeState;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import java.io. * ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class UI {
    private int opcao;
    private apoio_poeContext fsm;
    private boolean finish = false;

    public UI(apoio_poeContext fsm){
        this.fsm = fsm;
    }


    public int getOpcao() {
        return opcao;
    }
    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
    public void start(){
        while(!finish){
            System.out.println(fsm.getState());
            switch(fsm.getState()){
                case InicioState:
                    mostraMenuInicio();
                    break;
                case FASE1:
                    mostraMenuIncial();
                    break;
                case FASE1BLOCKSTATE:
                    mostraMenuFase1Bloqueada();
                    break;
                case FASE2:
                    mostraMenuSegundaFase();
                    break;
                case FASE2BLOCKSTATE:
                    mostraMenuFase2Bloqueada();
                    break;
                case FASE3:
                    mostraMenuTerceiraFase();
                    break;
                case FASE3BLOCKSTATE:
                    mostraMenuFase3Bloqueada();
                    break;
                case FASE4:
                    mostraMenuQuartaFase();
                    break;
                case FASE5:
                    mostraMenuQuintaFase();
                    break;
                case GESTAO_PROP:
                    mostraMenuOperacoesPropostas1Fase();
                    break;
                case GESTAO_DOC:
                    mostraMenuOperacoesDocentes1Fase();
                    break;
                case GESTAO_AL:
                    mostraMenuOperacoesAlunos1Fase();
                    break;
                case GESTAO_CAND:
                    mostraMenuOperacoesCandidaturas2Fase();
                    break;
                case TRATAMENTO_PROP:
                    mostraMenuOperacoesPropostas3Fase();
                    break;
                case GESTAO_ORI:
                    mostraMenuOperacoesDocentes4Fase();
                    break;
                case GESTAO_MANUAL_ATRIBSTATE:
                    mostraMenuGestaoManualAtrib();
                    break;

                case GESTAO_MANUAL_ORIENTSTATE:
                    mostraMenuOrientadores4Fase();
                    break;
                case FASE3MasFASE2AbertaState:
                    mostraMenuF3MasF2Aberta();
                    break;

            }
        }
    }

    public void mostraMenuFase1Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar um aluno");
        System.out.println("2 - Consultar todos os alunos");
        System.out.println("3 - Consultar um docente");
        System.out.println("4 - Consultar todos os docentes");
        System.out.println("5 - Consultar uma proposta");
        System.out.println("6 - Consultar todas as propostas");
        System.out.println("7 - Avancar para a fase seguinte");
        System.out.println("8 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc.nextLong();
                System.out.println(fsm.consultaAluno(nrAluno));
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunos());
            }
            case 3 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o e-mail do docente");
                String emailProf = sc1.nextLine();
                System.out.println(fsm.consultaDocente(emailProf));
            }
            case 4 -> {
                System.out.println(fsm.consultaDocentes());;
            }
            case 5 -> {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Insira o id da proposta");
                String idProposta = sc2.nextLine();
                System.out.println(fsm.consultaProposta(idProposta));;
                ;}
            case 6 -> {
                System.out.println(fsm.consultaPropostas());
                ;
            }
            case 7 -> {
                fsm.avancarFase();
            }
            case 8 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }
    }
    public void mostraMenuFase2Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura");
        System.out.println("3 - Consultar alunos sem candidatura");
        System.out.println("4 - Consultar a lista de autoproposta");
        System.out.println("5 - Consultar propostas de docentes");
        System.out.println("6 - Consultar propostas com candidaturas");
        System.out.println("7 - Consultar propostas sem candidaturas");
        System.out.println("8 - Consultar uma candidatura");
        System.out.println("9 - Avancar Fase");
        System.out.println("10 - Recuar para Fase bloqueada anterior");
        System.out.println("11 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultaAlunosComAutoproposta());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidatura());
            }
            case 3 -> {
                System.out.println(fsm.consultarAlunosSemCandidatura());
            }
            case 4 -> {
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 5 -> {
                System.out.println(fsm.consultarPropostasDocentes());;
            }
            case 6 -> {
                System.out.println(fsm.consultarPropostasComCandidaturas());;
                ;
            }
            case 7 -> {
                System.out.println(fsm.consultarPropostasSemCandidaturas());;
            }
            case 8-> {
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc.nextLong();
                System.out.println(fsm.consultaCandidatura(nrAluno));;
            }
            case 9 -> {
                fsm.avancarFase();
            }
            case 10 -> {
                fsm.changeToFaseBloqueadaAnterior();
            }
            case 11 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }
    }
    public void mostraMenuFase3Bloqueada(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura");
        System.out.println("3 - Consultar alunos com proposta atribuida");
        System.out.println("4 - Consultar alunos sem proposta atribuida");
        System.out.println("5 - Consultar lista de autopropostas");
        System.out.println("6 - Consultar propostas de docentes");
        System.out.println("7 - Consultar propostas disponiveis");
        System.out.println("8 - Consultar propostas atribuidas");
        System.out.println("9 - Avancar Fase");
        System.out.println("10 - Recuar para Fase bloqueada anterior");
        System.out.println("11 - Sair da aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.consultaAlunosComAutoproposta();
            }
            case 2 -> {
                fsm.consultarAlunosComCandidatura();
            }
            case 3 -> {
                fsm.consultarAlunosComPropostaAtribuida();
            }
            case 4 -> {
                fsm.consultarAlunosSemPropostaAtribuida();
            }
            case 5 -> {
                fsm.consultarListaDeAutopropostas();
            }
            case 6 -> {
                fsm.consultarPropostasDocentes();
                ;
            }
            case 7 -> {
                fsm.consultarPropostasDisponiveis();
            }
            case 8-> {
                fsm.consultarPropostasAtribuidas();
            }
            case 9 -> {
                fsm.avancarFase();
            }
            case 10 -> {
                fsm.changeToFaseBloqueadaAnterior();
            }
            case 11 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }
    }
    public void mostraMenuInicio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Começar novo");
        System.out.println("2 - Carregar Save");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.avancarFase();
            }
            case 2 -> {
                fsm.loadState();
                ;}


        }
    }
    public void mostraMenuIncial() {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Opcoes para alunos");
        System.out.println("2 - Opcoes para docentes");
        System.out.println("3 - Opcoes para propostas");
        System.out.println("4 - Avançar de Fase");
        System.out.println("5 - Fechar Fase");
        System.out.println("6 - Terminar Aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.changeToGestaoAL();
            }
            case 2 -> {
                fsm.changeToGestaoDOC();
                ;}
            case 3 -> {
                fsm.changeToPropState();
                ;
            }
            case 4 -> {
                fsm.avancarFase();
                ;
            }
            case 5 -> {
                fsm.fecharFase();
                ;
            }
            case 6 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;

            }
        }
    }
    public void mostraMenuOperacoesAlunos1Fase() {
        Scanner sc = new Scanner(System.in);
        int opcaoAlunos;

        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Adicionar todos os alunos a partir de ficheiro");
        System.out.println("2 - Exportar alunos para ficheiro csv");
        System.out.println("3 - Regressar à fase base");
        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.addAluno();
                //System.out.println(fsm.consultaAlunos());
            }
            case 2 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);

            }
            case 3 ->{
                fsm.changeFromGestaoALtoBase();
            }

        }

    }
    public void mostraMenuOperacoesDocentes1Fase() {
        Scanner sc = new Scanner(System.in);
        int opcaoAlunos;

        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Adicionar todos os decentes a partir de ficheiro");
        System.out.println("2 - Exportar docentes para ficheiro csv");
        System.out.println("3 - Regressar ao menu anterior");


        System.out.println("---------------");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.addDocente();
                System.out.println(fsm.consultaDocentes());
            }

            case 2 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();
                fsm.exportarDocentesParaCSV(nomeFicheiro);
            }
            case 3 -> {
                fsm.changeFromGestaoDOCtoBase();
            }
        }
    }
    public void mostraMenuOperacoesPropostas1Fase() {
            Scanner sc = new Scanner(System.in);
            int opcaoAlunos;

            System.out.println("---------------");
            System.out.println("O que pretende fazer?");
            System.out.println("1 - Adicionar todos as propostas a partir de ficheiro");
            System.out.println("2 - Exportar propostas para ficheiro csv");
            System.out.println("3 - Regressar ao menu anterior");
            System.out.println("---------------");

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    fsm.addProposta();
                    System.out.println(fsm.consultaPropostas());
                }
                case 2 -> {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Insira o nome do ficheiro");
                    String nomeFicheiro = sc1.nextLine();
                    fsm.exportarPropostasParaCSV(nomeFicheiro);
                }
                case 3 -> {
                    fsm.changeFromGestaoPROPtoBase();
                }
            }

        }
    public void mostraMenuSegundaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Opcoes para candidaturas");
        System.out.println("2 - Opcoes para alunos");
        System.out.println("3 - Opcoes para propostas");
        System.out.println("4 - Recuar fase");
        System.out.println("5 - Fechar fase");
        System.out.println("6 - Avancar fase");
        System.out.println("7 - Fechar aplicacao");
        System.out.println("---------------");
        int opcao = sc.nextInt();


        switch (opcao) {
            case 1 -> {
                fsm.changeToGestaoCAND();
            }
            case 2 -> {
                System.out.println("O que pretende fazer?");
                System.out.println("1 - Consultar alunos com autoproposta");
                System.out.println("2 - Consultar alunos com candidatura registada");
                System.out.println("3 - Consultar alunos sem candidatura registada");
                int op = sc.nextInt();
                switch(op){
                    case 1 -> {
                        System.out.println(fsm.consultaAlunosComAutoproposta());;
                    }
                    case 2 -> {
                        System.out.println(fsm.consultarAlunosComCandidatura());;
                    }
                    case 3 -> {
                        System.out.println(fsm.consultarAlunosSemCandidatura());;
                    }
                }
                ;}
            case 3 -> {
                System.out.println(fsm.consultarPropostas());;
                ;
            }
            case 4 -> {
                fsm.recuarFase();
            }
            case 5 -> {
                fsm.fecharFase();
            }
            case 6 -> {
                fsm.avancarFase();
            }
            case 7 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }

    }
    public void mostraMenuOperacoesCandidaturas2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Inserir candidaturas a partir de ficheiro");
        System.out.println("2 - Consultar candidaturas");
        System.out.println("3 - Exportar candidaturas para ficheiro csv");
        System.out.println("4 - Regressar ao menu base");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.addCandidatura();
            }
            case 2 -> {
                System.out.println(fsm.consultaCandidaturas());;
                ;}
            case 3 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();
                fsm.exportarCandidaturasParaCSV(nomeFicheiro);

            }
            case 4 -> {
                fsm.changeFromGestaoCANDtoBase();
            }
        }
    }
    public void mostraMenuOperacoesAlunos2Fase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura registada");
        System.out.println("3 - Consultar alunos sem candidatura registada");
        System.out.println("4 - Regressar ao menu base");

        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidatura());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarAlunosSemCandidatura());
                ;
            }
            case 4 -> {
                mostraMenuSegundaFase();
                ;
            }
        }
    }
    public void mostraMenuOperacoesPropostas2Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar propostas com autoproposta");
        System.out.println("2 - Consultar propostas de docentes"); //FALTA FAZER ISTO
        System.out.println("3 - Consultar propostas que ja tem candidaturas");
        System.out.println("4 - Consultar propostas que nao tem candidaturas");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarPropostasComCandidaturas());
                ;
            }
            case 4 -> {
                System.out.println(fsm.consultarPropostasSemCandidaturas());
                ;
            }

        }
    }
    public void mostraMenuTerceiraFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Fazer alteracoes nas propostas");
        System.out.println("2 - Consulta de propostas");
        System.out.println("3 - Consulta de alunos");
        System.out.println("4 - Exportar alunos para ficheiro csv");
        System.out.println("5 - Recuar fase");
        System.out.println("6 - Avancar para a proxima fase");
        System.out.println("7 - Fechar Fase");
        System.out.println("8 - Fechar aplicação");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                fsm.changeToTratamentoProp();
            }
            case 2 -> {
                mostraMenuComConsultasDePropostas3Fase();
                ;}
            case 3 -> {
                mostraMenuConsultaAlunos3Fase();
                ;
            }
            case 4 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 5 -> {
                fsm.recuarFase();
            }

            case 6 -> {
                fsm.avancarFase();
            }
            case 7 -> {
                fsm.fecharFase();
            }
            case 8 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }
    }
    public void mostraMenuF3MasF2Aberta() {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir autoproposta");
        System.out.println("2 - Atribuir proposta de docente");
        System.out.println("3 - Recuar Fase");
        System.out.println("4 - Regressar ao menu base");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.atribuirAutoproposta();
                ;
            }
            case 2 -> {
                fsm.atribuirPropostaDeDocente();
                ;
            }
            case 3 -> {
                fsm.recuarFase();
            }
            case 4 -> {
                fsm.changeFromF3MasF2AbertaToBase();
                ;
            }
        }
    }
    public void mostraMenuGestaoManualAtrib(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir proposta manualmente");
        System.out.println("2 - Remover proposta manualmente");
        System.out.println("3 - Regressar ao menu anterior");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o id da proposta");
                String idProposta = sc1.nextLine();
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc1.nextLong();
                fsm.atribuirPropostaManualmente(nrAluno, idProposta);


                ;
            }
            case 2 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o numero de aluno");
                Long nrAluno = sc1.nextLong();
                fsm.removerPropostaManualmente(nrAluno);
            }
            case 3 -> {
                fsm.changeFromGestaoManualAtribToFase3();

            }
        }

    }
    public void mostraMenuOperacoesPropostas3Fase() {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir autopropostas");
        System.out.println("2 - Atribuir propostas de docentes a alunos");
        System.out.println("3 - Atribuir/remover uma proposta manualmente");
        System.out.println("4 - Remover todas as atribuicoes (exceto as autopropostas e as propostas de docentes com aluno associado");
        System.out.println("5 - Regressar ao menu anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.atribuirAutoproposta();
                ;
            }
            case 2 -> {
                fsm.atribuirPropostaDeDocente();
            }
            case 3 -> {
                fsm.changeToGestaoManualAtribuicoesState();

            }
            case 4 -> {
                fsm.removerTodasAsAtribuicoes();
                ;
            }
            case 5 ->{
                fsm.changeFromTratamentoPropToBase();
            }
        }
    }
    public void mostraMenuComConsultasDePropostas3Fase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar propostas com autoproposta");
        System.out.println("2 - Consultar propostas de docentes"); //FALTA FAZER ISTO
        System.out.println("3 - Consultar propostas disponiveis");
        System.out.println("4 - Consultar propostas atribuidas");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarPropostasDocentes());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarPropostasDisponiveis());
                ;
            }
            case 4 -> {
                System.out.println(fsm.consultarPropostasAtribuidas());
                ;
            }

        }
    }
    public void mostraMenuConsultaAlunos3Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar alunos com autoproposta");
        System.out.println("2 - Consultar alunos com candidatura registada");
        System.out.println("3 - Consultar alunos com proposta atribuida");
        System.out.println("4 - Consultar alunos sem proposta atribuida");

        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarListaDeAutopropostas());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidatura());
                ;}
            case 3 -> {
                System.out.println(fsm.consultarAlunosComPropostaAtribuida());
            }
            case 4 -> {
                System.out.println(fsm.consultarAlunosSemPropostaAtribuida());
                ;
            }
        }
    }
    public void mostraMenuQuartaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir docentes automaticamente");
        System.out.println("2 - Operacoes manuais a docentes");
        System.out.println("3 - Consulta dados");
        System.out.println("4 - Exportar alunos para ficheiro csv");
        System.out.println("5 - Avancar para a proxima fase");
        System.out.println("6 - Recuar Fase");
        System.out.println("7 - Fechar Fase");
        System.out.println("8 - Fechar aplicação");
        System.out.println("---------------");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {

                mostraMenuOperacoesDocentes4Fase();
            }
            case 2 -> {
                fsm.changeToGestaoManualOrientState();
                ;}
            case 3 -> {
                System.out.println("O que pretende fazer?");
                System.out.println("1 - Lista de Alunos com proposta atribuida e com orientador");
                System.out.println("2 - Lista de Alunos com proposta atribuida e sem orientador");
                System.out.println("3 - Consulta dados sobre os docentes");
                System.out.println("4 - Regressar ao menu anterior");
                int op = sc.nextInt();

                switch (op){
                    case 1 -> {
                        System.out.println(fsm.consultarAlunosComPropostaEComOrientador());
                    }
                    case 2 -> {
                        System.out.println(fsm.consultarAlunosComPropostaESemOrientador());
                    }
                    case 3 -> {
                        System.out.println("O que pretende fazer?");
                        System.out.println("1 - Consultar dados de um Docente");
                        System.out.println("2 - Consultar maximo, minimo e media de orientações");
                        int ope = sc.nextInt();
                        if(ope == 1){
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Insira o e-mail do docente que pretende consultar");
                            String emailProf = sc1.nextLine();
                            System.out.println(fsm.consultarOrientacoesDocente(emailProf));
                        }
                    }
                    case 4 ->{
                        fsm.changeFromGestaoORItoBase();
                    }
                }

                ;
            }
            case 4 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();

                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 5 -> {
                fsm.avancarFase();
            }
            case 6 -> {
                fsm.recuarFase();
            }
            case 7 -> {
                fsm.fecharFase();
            }
            case 8 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }
        }
    }
    public void mostraMenuOperacoesDocentes4Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Associar os docentes proponentes as respetivas propostas");
        System.out.println("2 - Atribuir automcaticamente os docentes as suas propostas");
        System.out.println("3 - Atribuir orientador manualmente");
        System.out.println("4 - Obter dados sobre os docentes");
        System.out.println("5 - Regressar a menu anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                fsm.atribuirPropostaADocenteProponenteAutomaticamente();
            }
            case 2 -> {
                fsm.atribuirPropostaADocenteProponenteAutomaticamente();
                ;}
            case 3 -> {
                System.out.println("Insira o numero do aluno associado a esta proposta");
                Long nrAluno = sc.nextLong();
                System.out.println("Insira o e-mail do novo orientador");
                String emailProf = sc.nextLine();

                System.out.println("Insira o IDProposta");
                String IDProposta = sc.nextLine();
                fsm.atribuirManulamenteOrientadorAAlunosComProposta(nrAluno,emailProf, IDProposta);
            }
            case 4 -> {
                System.out.println("O que pretende fazer?");
                System.out.println("1 - Consultar dados de um Docente");
                System.out.println("2 - Consultar maximo, minimo e media de orientações");
                int ope = sc.nextInt();
                if(ope == 1){
                    System.out.println("Insira o e-mail do docente que pretende consultar");
                    String emailProf = sc.nextLine();
                    System.out.println(fsm.consultarOrientacoesDocente(emailProf));
                }
            }
            case 5 -> {
                fsm.changeFromGestaoORItoBase();
            }

        }
    }
    public void mostraMenuOrientadores4Fase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Atribuir orientador a uma proposta");
        System.out.println("2 - Consultar orientador de uma proposta");
        System.out.println("3 - Editar orientador de uma proposta");
        System.out.println("4 - Remover orientador de uma proposta");
        System.out.println("5 - Regressar ao menu anterior");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nr de aluno ao qual a proposta vai ser atribuida");
                long nraluno = sc.nextLong();
                System.out.println("Insira o email do orientador");
                String emailOrientador = sc1.nextLine();
                System.out.println("Insira o ID da proposta");
                String IDproposta = sc1.nextLine();
                fsm.atribuirManualmenteOrientadorAAlunosComPropostas(nraluno, emailOrientador, IDproposta);
            }
            case 2 -> {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc2.nextLine();
                System.out.println(fsm.consultarOrientadorDeProposta(IDProposta));
                ;}
            case 3 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc1.nextLine();
                System.out.println("Insira o email do orientador");
                String emailOrientador = sc1.nextLine();
                fsm.editarOrientadorDeProposta(IDProposta, emailOrientador);
            }
            case 4 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o ID da proposta");
                String IDProposta = sc1.nextLine();
                fsm.removerOrientadorDeProposta(IDProposta);
                ;
            }
            case 5 -> {
                fsm.changeFromGestaoManualOrientToFase4();
            }
        }
    }
    public void mostraMenuSobreDadosDosOrientadores(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar lista de estudantes com proposta atribuida e com orientador");
        System.out.println("2 - Consultar lista de estudantes com proposta atribuida e sem orientador");
        System.out.println("3 - Obter dados sobre os docentes");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarAlunosComPropostaEComOrientador());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComPropostaESemOrientador());
                ;}
            case 3 -> {
                System.out.println("O que pretende fazer?");
                System.out.println("1 - Consultar dados de um Docente");
                System.out.println("2 - Consultar maximo, minimo e media de orientações");
                int ope = sc.nextInt();
                if(ope == 1){
                    System.out.println("Insira o e-mail do docente que pretende consultar");
                    String emailProf = sc.nextLine();
                    System.out.println(fsm.consultarOrientacoesDocente(emailProf));
                }
            }

        }
    }
    public void mostraMenuQuintaFase(){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("---------------");
        System.out.println("O que pretende fazer?");
        System.out.println("1 - Consultar lista de estudantes com proposta atribuida");
        System.out.println("2 - Consultar lista de estudantes sem proposta atribuida e com opcoes de candidatura");
        System.out.println("3 - Consultar propostas disponiveis");
        System.out.println("4 - Consultar propostas atribuidas");
        System.out.println("5 - Exportar alunos para ficheiro csv");
        System.out.println("6 - Ver dados sobre docentes");
        System.out.println("7 - Terminar Aplicação");
        System.out.println("---------------");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.println(fsm.consultarAlunosComPropostaAtribuida());
            }
            case 2 -> {
                System.out.println(fsm.consultarAlunosComCandidaturaESemProposta());
                ;}
            case 3 ->{
                System.out.println(fsm.consultarPropostasDisponiveis());
                }
            case 4 ->{
                System.out.println(fsm.consultarPropostasAtribuidas());
            }
            case 5 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Insira o nome do ficheiro");
                String nomeFicheiro = sc1.nextLine();
                fsm.exportarAlunosParaCSV(nomeFicheiro);
            }
            case 6 -> {
                System.out.println("Docente com mais orientações:"+fsm.consultarDocenteComMaisOrientacoes());
                System.out.println("Docente com menos orientações:"+fsm.consultarDocenteComMenosOrientacoes());
                System.out.println("Média de orientações:"+fsm.consultarMediaDeOrientacoesDosDocentes());
            }
            case 7 -> {
                System.out.println("Pretende guardar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                opcao = sc.nextInt();
                if(opcao == 1){
                    fsm.save();
                }
                finish = true;
            }

        }
    }





}








