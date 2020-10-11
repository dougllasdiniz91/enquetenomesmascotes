package br.gov.ma.detran.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.ma.detran.Model.PessoaModel;

public class PessoaDAO {
	public PessoaModel salvar(PessoaModel pessoa) {
		PessoaModel retorno = null;
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			
			retorno = entityManager.merge(pessoa);
			
			entityTransaction.commit();
			
		}catch(Exception e){
			System.err.println(e);
			entityTransaction.rollback();
		}finally {
			entityManager.close();
		}
		return retorno;
	}
}
