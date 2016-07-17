package br.com.dashboard.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ConexaoUtil {

	static EntityManager emanager = null;

	public static EntityManager criarEntityManager() {

		if (emanager == null) {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dashboard");	
			EntityManager emanager = entityManagerFactory.createEntityManager();
			return emanager;
			

		}
		return emanager;
	}
}