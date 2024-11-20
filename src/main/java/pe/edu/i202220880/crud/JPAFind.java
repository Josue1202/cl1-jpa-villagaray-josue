package pe.edu.i202220880.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220880.entity.Country;


public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Realizar la búsqueda del país con el código "PER"
            Country country = em.find(Country.class, "PER");

            if (country != null) {
                // Imprimir el nombre de las ciudades peruanas con población > 700k usando una lambda
                country.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName()));
            } else {
                System.out.println("El país con código 'PER' no existe.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Cerrar el EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}