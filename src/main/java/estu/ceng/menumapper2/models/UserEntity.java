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
public class UserEntity {
    private ObjectId id;
    private String role;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(name,
                userEntity.name) && Objects.equals(
                surname, userEntity.surname);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,role,name,surname,phoneNumber,password);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + name + '\'' + ", lastName='" + surname + '\'';
    }

}
