package com.hibernatedemo;


import java.util.List;

import jakarta.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistence");
        //Unit of Work
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	    try {
	    	entityManager.getTransaction().begin();
	    	//HQL --> Hibernate Query Lang
	    	//Select * from city
	    	//"from City c where c.countryCode='TUR' AND c.district='Istanbul'"
	    	//"from City c where c.name LIKE '%kar%'"
	    	// ASC-Ascending
	    	// DESC-Descending
	    	// "from City c Order By c.name DESC"
			/*
			 * List<String> countryCodes = entityManager.
			 * createQuery("select c.countryCode from City c Group By c.countryCode").
			 * getResultList();
			 * 
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
	    	
//	    	//INSERT
//	    	City city = new City();
//	    	city.setName("Honaz");
//	    	city.setCountryCode("TUR");
//	    	city.setDistrict("Ege");
//	    	city.setPopulation(2000);
//	    	entityManager.persist(city);
	    	
	    	//UPDATE
//	    	City city = entityManager.find(City.class, 4000);
//	    	city.setPopulation(2000000);
//	    	entityManager.persist(city);
	    	
	    	// CRUD Create Read Update Delete
	    	
	    	//DELETE
	    	City city = entityManager.find(City.class, 4104);
	    	entityManager.remove(city);
	    	
	    	//System.out.println(city.getDistrict());
	        entityManager.getTransaction().commit();
	    }finally {
	    	//entityManager.close();
	    	entityManagerFactory.close();
	    }
	}

}
