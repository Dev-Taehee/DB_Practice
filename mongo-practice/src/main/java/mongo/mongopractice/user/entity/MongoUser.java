package mongo.mongopractice.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class MongoUser {

    private String id;
    private String name;
    private int age;

}
