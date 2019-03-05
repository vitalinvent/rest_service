package classesHibernate;

import javax.persistence.*;
import java.io.Serializable;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicEntity implements Serializable {

    public BasicEntity(){}
//    public BasicEntity(String _guid){
//        try {
//            this.guid=UUID.fromString(_guid);
//        } catch (Exception ex){
//            this.guid = new UUID(0,0);
//            //System.out.println(_guid+" "+ex.getMessage()); ;
//        }
//    }
//
//    @Id
//    @Column(name = "guid")
//    public UUID guid;
//    public UUID getGuid() {
//        return this.guid;
//    }
//    public void setGuid(String var1) {
//        this.guid = UUID.fromString(var1);
//    }
//
//    @Column(name = "naimenovanie",columnDefinition = "TEXT")
//    public String naimenovanie;
//    public String getNaimenovanie(){ return this.naimenovanie; }
//    public void setNaimenovanie(String _naimenovanie){ this.naimenovanie=_naimenovanie; }

}
