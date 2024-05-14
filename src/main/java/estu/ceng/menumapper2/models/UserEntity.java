package estu.ceng.menumapper2.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();


    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

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
