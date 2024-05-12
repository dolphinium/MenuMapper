package estu.ceng.menumapper2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemEntity {
    private ObjectId id;
    private String cafeName;
    private String itemName;
    private double price;
    private String category;
}
