package com.hibernatedemo;


import java.util.List;

import jakarta.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistence");
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
	        List<City> cities = entityManager.
	        		createQuery("from City c Order By c.name DESC", City.class).getResultList();

	        for (City city : cities) {
	            System.out.println(city.getName() + ": " + city.getPopulation());
	        }
	        entityManager.getTransaction().commit();
	    }finally {
	    	//entityManager.close();
	    	entityManagerFactory.close();
	    }
	}

}
