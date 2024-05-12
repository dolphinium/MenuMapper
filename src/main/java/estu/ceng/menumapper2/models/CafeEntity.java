package estu.ceng.menumapper2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CafeEntity {
    private ObjectId id;
    private String cafeName;
    private double location_X;
    private double location_Y;
    private UserEntity cafeOwner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CafeEntity cafeEntity = (CafeEntity) o;
        return Objects.equals(id, cafeEntity.id) && Objects.equals(
                cafeName, cafeEntity.cafeName) && Objects.equals(
                cafeOwner, cafeEntity.cafeOwner);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,cafeName,location_X,location_Y,cafeOwner);
    }

    @Override
    public String toString() {
        return "Cafe{" + "id=" + id + ", cafeName='" + cafeName + '\'' + ", location='" + location_X + ","+location_Y+ '\'';
    }
}
