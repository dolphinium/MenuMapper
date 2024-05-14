package estu.ceng.menumapper2.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import estu.ceng.menumapper2.models.CommentEntity;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoDBCommentRepository implements CommentRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;
    private MongoCollection<CommentEntity> commentCollection;

    public MongoDBCommentRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        commentCollection = client.getDatabase("test").getCollection("comments", CommentEntity.class);
    }
    @Override
    public long delete(String commentId) {
        return commentCollection.deleteOne(eq("_id",new ObjectId(commentId))).getDeletedCount();
    }

    @Override
    public CommentEntity update(CommentEntity commentEntity) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return commentCollection.findOneAndReplace(eq("_id", commentEntity.getId()), commentEntity, options);
    }

    @Override
    public List<CommentEntity> findAll() {
        return commentCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<CommentEntity> findAllCafeComments(String cafeId) {
        return commentCollection.find(eq("cafeId",cafeId)).into(new ArrayList<>());
    }

    @Override
    public CommentEntity save(CommentEntity commentEntity) {
        commentEntity.setId(new ObjectId());
        commentCollection.insertOne(commentEntity);
        return commentEntity;
    }

    @Override
    public double GetAverageCafeStars(String cafeId) {
        // TODO: WRITE AGGREGATION PIPELINE FOR GETTING AVERAGE CAFE STARS
        return 0;
    }
}
