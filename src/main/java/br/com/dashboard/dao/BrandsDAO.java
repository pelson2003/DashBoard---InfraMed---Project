package br.com.dashboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.dashboard.modelo.Brands;

public class BrandsDAO {

	EntityManager em;

	public BrandsDAO(EntityManager em) {
			this.em = em;
		}

	public BrandsDAO() {
		}

	// Buscar por ID
	public Brands buscarPorID(int id) {
		return em.find(Brands.class, id);

	}

	// Buscar Lista de Usuários
	@SuppressWarnings("unchecked")
	public List<Brands> buscarTodos() {
		Query query = em.createQuery("select b from Brands b");
		return query.getResultList();
	}

	public Brands buscarPorName(String name) {

		try {
			Query q = em.createQuery("select b from Brands b where b.name=:nameParam");
			q.setParameter("nameParam", name);
			q.setMaxResults(1);
			return (Brands) q.getSingleResult();
		} catch (NoResultException e) {
			// throw new DAOException("Registro nao encontrado", e);
			return null;
		}
	}

}
