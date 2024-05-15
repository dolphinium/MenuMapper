package estu.ceng.menumapper2.dtos;

import estu.ceng.menumapper2.models.CafeEntity;
import org.bson.types.ObjectId;

public record CafeDTO(
        String id,
        String cafeName,
        double[] location,
        String ownerId
) {
    public CafeDTO(CafeEntity p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getCafeName(),
                p.getLocation(),
                p.getOwnerId());
    }

    public CafeEntity toCafeEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new CafeEntity(_id, cafeName, location, ownerId);
    }
}
