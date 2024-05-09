package estu.ceng.menumapper2.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.models.UserEntity;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBUserRepository implements UserRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;
    private MongoCollection<UserEntity> userCollection;

    public MongoDBUserRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        userCollection = client.getDatabase("test").getCollection("user", UserEntity.class);
    }

    public long delete(String id) {
        return userCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }


    @Override
    public UserDTO update(UserDTO UserDTO) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return userCollection.find().into(new ArrayList<>());
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setId(new ObjectId());
        userCollection.insertOne(userEntity);
        return userEntity;
    }

}
