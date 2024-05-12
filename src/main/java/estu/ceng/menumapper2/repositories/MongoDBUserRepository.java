package estu.ceng.menumapper2.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import estu.ceng.menumapper2.models.UserEntity;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

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

    public long delete(String phoneNumber) {
        return userCollection.deleteOne(eq("phoneNumber", phoneNumber)).getDeletedCount();
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return userCollection.findOneAndReplace(eq("_id", userEntity.getId()), userEntity, options);
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

    @Override
    public UserEntity findOne(String id) {
        return userCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public UserEntity findOneWithPhoneNumber(String phoneNumber) {
        return userCollection.find(eq("phoneNumber", phoneNumber)).first();
    }

}
