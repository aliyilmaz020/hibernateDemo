package com.hibernatedemo;


import java.util.List;

import jakarta.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
	    try {
	    	entityManager.getTransaction().begin();
	    	
	    	//Select * from city
	    	//"from City c where c.countryCode='TUR' AND c.district='Istanbul'"
	    	//"from City c where c.name LIKE '%kar%'"
	        List<City> cities = entityManager.
	        		createQuery("from City c where c.name LIKE '%kar%'", City.class).getResultList();

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
