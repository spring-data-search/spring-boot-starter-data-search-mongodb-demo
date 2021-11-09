package app.commerceio.spring.data.search.mongo.demo.customer;

import app.commerceio.spring.data.search.mongodb.SearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends SearchRepository<Customer, String> {
}
