package pe.edu.i202220880.crud;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220880.entity.City;
import pe.edu.i202220880.entity.Country;
import pe.edu.i202220880.entity.CountryLanguage;

import java.util.List;


public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();


            Country country = new Country("XYZ", "Isla Panchi", "Asia", "Desierto", 5000.0, 2024, 1000000, 75.0, 20000.0, 18000.0, "Isla", "República", "Juan Pérez", 1, "XY", null, null);

            City city1 = new City(null, "Ciudad Loca", "Distrito Loco", 800000, country);
            City city2 = new City(null, "Ciudad Grande", "Distrito Grande", 1200000, country);
            City city3 = new City(null, "Ciudad Pequeña", "Distrito Pequeño", 500000, country);

            CountryLanguage language1 = new CountryLanguage(null, "Lengua A", true, 80.0, country);
            CountryLanguage language2 = new CountryLanguage(null, "Lengua B", true, 20.0, country);

            country.setCities(List.of(city1, city2, city3));
            country.setLanguages(List.of(language1, language2));

            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();


        }
    }
