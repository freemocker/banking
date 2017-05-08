package za.co.enigma.domain.archetypes;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author luckson
 * The baseEntity object consist of attribute that are required on all entities
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -421794538113547606L;

    private long id;
    private int optLock = Integer.valueOf(0);
    private String uuid;
    private int tenant;
    
    @Id
    @GeneratedValue(generator = "ID_SEQUENCE", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ID_SEQUENCE" , allocationSize= 25, initialValue = 1000, sequenceName = "ID_SEQUENCE")
    @Column(name ="ID")
    public Long getId() {
        return this.id;
    }
    
    @NotNull
    @Column(name = "OPT_LOCK", nullable = false)
    @Version
    public int getOptLock() {
        return this.optLock;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setOptLock(int optlock) {
        this.optLock = optlock;
    }
     
    @Column(name = "UUID", length = 100, nullable = false)
    @NotNull(message= "\"The uuid field cannot be null. \"")
    public String getUuid() {
        if (this.uuid == null || "".equals(this.uuid)) {
            this.uuid = (new UUID(ThreadLocalRandom.current().nextLong(), ThreadLocalRandom.current().nextLong())).toString();
        }
        return this.uuid;
    }

    @Column(name = "TENANT", length = 100, nullable = false)
    @NotNull(message= "\"The tenant field cannot be null. \"")
	public int getTenant() {
		return tenant;
	}

	public void setTenant(int tenant) {
		this.tenant = tenant;
	}
    
}
