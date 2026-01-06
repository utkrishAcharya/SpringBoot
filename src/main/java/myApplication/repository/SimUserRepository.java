package myApplication.repository;

import myApplication.model.SimUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimUserRepository extends MongoRepository<SimUser, String> {

    // it helps to find  a user by their username
    SimUser findByUsername(String username);

}
