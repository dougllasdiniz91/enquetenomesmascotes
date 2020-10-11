package br.gov.ma.detran.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.ma.detran.Model.MascotesModel;

public class MascotesDAO {
	public void salvar(MascotesModel mascotes) {
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			
			entityManager.persist(mascotes);
			
			entityTransaction.commit();
			
		}catch(Exception e){
			System.err.println(e);
			entityTransaction.rollback();
		}finally {
			entityManager.close();
		}
	}
}
