package estu.ceng.menumapper2.dtos;

import estu.ceng.menumapper2.models.CafeEntity;
import org.bson.types.ObjectId;

public record CafeDTO(
        String id,
        String cafeName,
        double location_X,
        double location_Y,
        UserDTO cafeOwner
) {
    public CafeDTO(CafeEntity p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getCafeName(),
                p.getLocation_X(),
                p.getLocation_Y(),
                new UserDTO(p.getCafeOwner()));
    }

    public CafeEntity toCafeEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new CafeEntity(_id, cafeName, location_X,location_Y, cafeOwner.toUserEntity());
    }
}
