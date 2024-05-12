package estu.ceng.menumapper2.dtos;

import estu.ceng.menumapper2.models.MenuItemEntity;
import org.bson.types.ObjectId;

public record MenuItemDTO(
        String id,
        String cafeName,
        String itemName,
        double price,
        String category
) {
    public MenuItemDTO(MenuItemEntity p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getCafeName(),
                p.getItemName(),
                p.getPrice(),
                p.getCategory());
    }
    public MenuItemEntity toMenuItemEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new MenuItemEntity(_id, cafeName, itemName, price, category);
    }
}
