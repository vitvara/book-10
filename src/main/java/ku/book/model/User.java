package ku.book.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ku.book.config.AttributeEncryptor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    @Convert(converter = AttributeEncryptor.class)
    @ColumnTransformer(
           read = "cast(AES_DECRYPT(username, UNHEX('key')) as char(255))",
           write = "AES_ENCRYPT(?, UNHEX('key'))"
   )
   pri
    private String username;
    private String password;

    @Convert(converter = AttributeEncryptor.class)
    @ColumnTransformer(
        read = "cast(AES_DECRYPT(name, UNHEX('key')) as char(255))",
        write = "AES_ENCRYPT(?, UNHEX('key'))"
)
    private String name;

    private Instant createdAt;
}
