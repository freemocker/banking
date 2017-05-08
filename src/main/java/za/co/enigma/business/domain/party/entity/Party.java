package za.co.enigma.business.domain.party.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.role.AccountRole;
import za.co.enigma.business.domain.account.entity.role.AccountTransactionRole;
import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.domain.archetypes.PartyDomainArchetype;


@EqualsAndHashCode(callSuper=true)

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="PARTY",
uniqueConstraints= {
        @javax.persistence.UniqueConstraint(
                name="PARTY_02U", 
                columnNames={"ID", "UUID"})
        }
)
@NamedQueries(
		{
			@NamedQuery(name=Party.findAll,query="SELECT p FROM Party p")
		})
public abstract class Party extends PartyDomainArchetype  {
    
    private static final long serialVersionUID = -8574288458859355337L;

    private static final String PREFIX = "za.co.enigma.business.domain.party.entity.";
    public static final String findAll = PREFIX + "all";
    
    private String cellphone;
    private String telephone;
    private String emailAddress;
    private String address;
    protected List<PartyRole> partyRoles = new ArrayList<>();
    protected List<AccountTransactionRole> accountTransactionRoles = new ArrayList<>();
    protected List<AccountRole> accountRoles = new ArrayList<>();
    
	@Column(name="CELLPHONE")
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Column(name="TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name="EMAIL_ADDRESS")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JoinTable(name= "PARTY_PARTY_ROLE",
			joinColumns=@JoinColumn(name ="PARTY_ID"),
			inverseJoinColumns = @JoinColumn(name = "PARTY_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<PartyRole> getPartyRoles() {
		return partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

	@JoinTable(name= "PARTY_ACCOUNT_TRANSACTION_ROLE",
			joinColumns=@JoinColumn(name ="PARTY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_TRANSACTION_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountTransactionRole> getAccountTransactionRoles() {
		return accountTransactionRoles;
	}

	public void setAccountTransactionRoles(List<AccountTransactionRole> accountTransactionRoles) {
		this.accountTransactionRoles = accountTransactionRoles;
	}

	@JoinTable(name= "PARTY_ACCOUNT_ROLE",
			joinColumns=@JoinColumn(name ="PARTY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ROLE_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AccountRole> getAccountRoles() {
		return accountRoles;
	}

	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}
	
	
	
}