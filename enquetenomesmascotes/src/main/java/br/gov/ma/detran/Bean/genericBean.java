package br.gov.ma.detran.Bean;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.gov.ma.detran.DAO.MascotesDAO;
import br.gov.ma.detran.DAO.PessoaDAO;
import br.gov.ma.detran.Model.MascotesModel;
import br.gov.ma.detran.Model.PessoaModel;

@RequestScoped
@ManagedBean(name = "genericBean")
public class genericBean {
	private MascotesModel mascotes = new MascotesModel();
	private PessoaModel pessoa = new PessoaModel();
	PessoaModel idPessoa = null;
	
	public String cadastrar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			idPessoa = pessoaDAO.salvar(pessoa);
			
			pessoa.setId(idPessoa.getId());
			
			MascotesDAO mascotesDAO = new MascotesDAO();
			Calendar data = Calendar.getInstance();
			mascotes.setIdPessoa(pessoa);
			mascotes.setDataInsercao(data);
			mascotesDAO.salvar(mascotes);
			addMessage("Dados salvos com sucesso!");
		}catch(Exception e){
			addMessage("Não foi possível fazer o cadastro, tente novamente!!");
			System.err.println(e);
			return "";
		}
		return "";
		
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        mascotes.setNomeMascote1("");
        mascotes.setNomeMascote2("");
        mascotes.setNomeMascote3("");
        pessoa.setNome("");
        pessoa.setCpf("");
    }
	
	public MascotesModel getMascotes() {
		return mascotes;
	}
	public void setMascotes(MascotesModel mascotes) {
		this.mascotes = mascotes;
	}
	public PessoaModel getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}
}
