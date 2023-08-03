package mongo.mongopractice.user.repository;

import mongo.mongopractice.user.entity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByName(String name);
}
