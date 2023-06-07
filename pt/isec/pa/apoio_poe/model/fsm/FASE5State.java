package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.PoE;
import pt.isec.pa.apoio_poe.model.data.Proposta;

import java.util.ArrayList;
import java.util.HashMap;

public class FASE5State extends apoio_poeAdapter{
    public FASE5State(apoio_poeContext context, PoE data) {
        super(context, data);
    }

    @Override
    public apoio_poeState getState() {
        return apoio_poeState.FASE5;
    }

    public ArrayList<Aluno> consultarAlunosComPropostaAtribuida(){return data.consultarAlunosComPropostaAtribuida();};
    @Override
    public ArrayList<Aluno> consultarAlunosComCandidaturaESemProposta(){return data.consultarAlunosComCandidaturaESemProposta();};
    @Override
    public ArrayList<Proposta> consultarPropostasDisponiveis(){return data.consultarPropostasDisponiveis();};
    @Override
    public ArrayList<Proposta> consultarPropostasAtribuidas(){return data.consultarPropostasAtribuidas();};
    @Override
    public ArrayList<Proposta> consultaPropostas(){return data.consultarPropostas();}
    @Override
    public Docente consultarDocenteComMenosOrientacoes(){return data.consultarDocenteComMenosOrientacoes();};
    @Override
    public Docente consultarDocenteComMaisOrientacoes(){return data.consultarDocenteComMaisOrientacoes();};
    @Override
    public String consultarMediaDeOrientacoesDosDocentes(){return data.consultarMediaDeOrientacoesDosDocentes();};
    @Override
    public void exportarAlunosParaCSV(String nomeFicheiro){data.exportarAlunosParaCSV(nomeFicheiro);};
    @Override
    public String consultarOrientacoesDocente(String email){return data.consultarOrientacoesDocente(email);}
    @Override
    public double devolveNumPropostasSI(){return data.devolveNumPropostasSI();}
    @Override
    public double devolveNumPropostasRAS(){return data.devolveNumPropostasRAS();}
    @Override
    public double devolveNumPropostasDA(){return data.devolveNumPropostasDA();}
    @Override
    public HashMap<String, Integer> DocentesComMaisOrientacoes(){return data.DocentesComMaisOrientacoes();}
    @Override
    public HashMap<String, Number> EmpresasComMaisEstagios(){return data.EmpresasComMaisEstagios();}
}
