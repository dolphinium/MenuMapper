package estu.ceng.menumapper2.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import estu.ceng.menumapper2.models.MenuItemEntity;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoDBMenuItemRepository implements MenuItemRepository{
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;
    private MongoCollection<MenuItemEntity> menuItemCollection;

    public MongoDBMenuItemRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        menuItemCollection = client.getDatabase("test").getCollection("menuItem", MenuItemEntity.class);
    }

    @Override
    public long delete(String menuItemName) {
        return menuItemCollection.deleteOne(eq("itemName", menuItemName)).getDeletedCount();
    }

    @Override
    public MenuItemEntity update(MenuItemEntity menuItemEntity) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return menuItemCollection.findOneAndReplace(eq("_id", menuItemEntity.getId()), menuItemEntity, options);
    }

    @Override
    public List<MenuItemEntity> findAllWithCafeName(String cafeName) {
        return menuItemCollection.find(eq("cafeName",cafeName)).into(new ArrayList<>());
    }

    @Override
    public List<MenuItemEntity> findAllWithMenuItemName(String menuItemName, boolean asc) {
        int sortOrder = asc ? 1 : -1;

        // Perform the query with sorting
        return menuItemCollection.find(eq("itemName", menuItemName))
                .sort(new Document("price", sortOrder))
                .into(new ArrayList<>());
    }

    @Override
    public MenuItemEntity save(MenuItemEntity menuItemEntity) {
        menuItemEntity.setId(new ObjectId());
        menuItemCollection.insertOne(menuItemEntity);
        return menuItemEntity;
    }

    @Override
    public List<MenuItemEntity> findAllWithCategoryName(String categoryName) {
        return menuItemCollection.find(eq("category",categoryName)).into(new ArrayList<>());
    }
}
