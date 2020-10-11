package br.gov.ma.detran.Model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mascote")
public class MascotesModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120387117465521251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message="Por Favor, Insira um Nome.")
	private String nomeMascote1;
	
	@NotNull
	@NotEmpty(message="Por Favor, Insira um Nome.")
	private String nomeMascote2;
	
	@NotNull
	@NotEmpty(message="Por Favor, Insira um Nome.")
	private String nomeMascote3;
	private Calendar dataInsercao;

	// bi-directional many-to-one association to PessoaModel
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idPessoa")
	private PessoaModel idPessoa;

	public MascotesModel() {

	}

	public PessoaModel getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(PessoaModel idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeMascote1() {
		return nomeMascote1;
	}

	public void setNomeMascote1(String nomeMascote1) {
		this.nomeMascote1 = nomeMascote1.toUpperCase();
	}

	public String getNomeMascote2() {
		return nomeMascote2;
	}

	public void setNomeMascote2(String nomeMascote2) {
		this.nomeMascote2 = nomeMascote2.toUpperCase();
	}

	public String getNomeMascote3() {
		return nomeMascote3;
	}

	public void setNomeMascote3(String nomeMascote3) {
		this.nomeMascote3 = nomeMascote3.toUpperCase();
	}

	public Calendar getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Calendar dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MascotesModel other = (MascotesModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
