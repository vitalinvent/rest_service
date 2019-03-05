package classesHibernate.old;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Base class class with property ID.
 *
 * 
 * 
 */

@MappedSuperclass
@Getter
@Setter
@ToString
public class BasicEntity {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(
            name = "id",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;



}
