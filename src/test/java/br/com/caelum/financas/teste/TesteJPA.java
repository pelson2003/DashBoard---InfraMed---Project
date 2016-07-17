package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dashboard.dao.BrandsDAO;
import br.com.dashboard.dao.ConexaoUtil;
import br.com.dashboard.modelo.Brands;

public class TesteJPA {
public static void main(String[] args) {
	
	EntityManager emanager = ConexaoUtil.criarEntityManager();
	
	//Criando uma Brand
	Brands brands = new Brands();
	brands.setName("Adidas");
	brands.setQt_vendida(400);
	
	//Salvando uma Brand
	//	manager.getTransaction().begin();
	//	manager.persist(brands);
	//	manager.getTransaction().commit();

	
	BrandsDAO brandsDAO = new BrandsDAO(emanager);
	
	//Buscar por ID
	Brands procuraBrandPorID = brandsDAO.buscarPorID(1);
	System.out.println(procuraBrandPorID.getName());
	
	//BuscaTodos
	List<Brands> todasAsBrands = brandsDAO.buscarTodos();
	for(Brands brand : todasAsBrands ){
		System.out.println(brand.getId());
		System.out.println(brand.getName());
		System.out.println(brand.getQt_vendida());
	}
	
	
	//Buscar por Nome
	Brands procuraBrandPorName = brandsDAO.buscarPorName("Rebook");
	System.out.println(procuraBrandPorName.getName());
		
	
	
	
	
}
}
 