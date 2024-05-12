package estu.ceng.menumapper2.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import estu.ceng.menumapper2.models.CafeEntity;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;
@Repository
public class MongoDBCafeRepository implements CafeRepository{
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;

    private MongoCollection<CafeEntity> cafeCollection;
    public MongoDBCafeRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        cafeCollection = client.getDatabase("test").getCollection("cafe", CafeEntity.class);
    }

    @Override
    public long delete(String cafeName) {
        return cafeCollection.deleteOne(eq("cafeName",cafeName)).getDeletedCount();
    }

    @Override
    public CafeEntity update(CafeEntity cafeEntity) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return cafeCollection.findOneAndReplace(eq("_id", cafeEntity.getId()), cafeEntity, options);
    }

    @Override
    public List<CafeEntity> findAll() {
        return cafeCollection.find().into(new ArrayList<>());
    }

    @Override
    public CafeEntity save(CafeEntity cafeEntity) {
        cafeEntity.setId(new ObjectId());
        cafeCollection.insertOne(cafeEntity);
        return cafeEntity;
    }

    @Override
    public CafeEntity findOneWithCafeName(String cafeName) {
        return cafeCollection.find(eq("cafeName", cafeName)).first();
    }
}
