package fr.alma.today.repository;

import fr.alma.today.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    /**
     * Find all Products in the database
     * @return a Array list of products
     */
    ArrayList<Product> findAll();

    /**
     * Find a product in the database using its id
     *
     * @param id  of the territory
     * @return a Territory if the id matches
     */
    Product findById(String id);
    void deleteById(String id);

}
