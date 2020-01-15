package Home;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersRepository extends MongoRepository<Pets, String> {
    Pets findBy_id(ObjectId _id);
}
