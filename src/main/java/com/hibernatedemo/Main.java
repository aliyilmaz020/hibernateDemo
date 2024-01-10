package com.hibernatedemo;


import java.util.List;

import jakarta.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
	    try {
	    	entityManager.getTransaction().begin();

	        List<City> cities = entityManager.createQuery("from City", City.class).getResultList();

	        for (City city : cities) {
	            System.out.println(city.getName() + ": " + city.getPopulation());
	        }
	        entityManager.getTransaction().commit();
	    }finally {
	    	entityManager.close();
	    	entityManagerFactory.close();
	    }
	}

}
