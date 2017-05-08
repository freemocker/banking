package za.co.enigma.business.domain.account.entity.loan;

import za.co.enigma.business.domain.party.entity.role.PartyRole;
import za.co.enigma.domain.archetypes.MomentIntervalDomainArchetype;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="GUARANTOR_LOAN_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="GUARANTOR_LOAN_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GuarantorLoanAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = -3523341659196494195L;
	
	private LoanAccount loanAccount;
	private PartyRole partyRole;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "LOAN_ACCOUNT_ID", foreignKey = @ForeignKey(name = "LOAN_ACCOUNT_GUARANTOR_FK01"))
	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "LOAN_ACCOUNT_GUARANTOR_PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private GuarantorLoanAccount guarantorLoanAccount;
		
		public Builder() {
			this.guarantorLoanAccount = new GuarantorLoanAccount();
		}
		
		public Builder withId(long id) {
			this.guarantorLoanAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.guarantorLoanAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.guarantorLoanAccount.setTenant(tenant);
	    	return this;
	    }
		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.guarantorLoanAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.guarantorLoanAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(LoanAccount loanAccount){
			this.guarantorLoanAccount.setLoanAccount(loanAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.guarantorLoanAccount.setPartyRole(partyRole);
			return this;
		}
		
		public GuarantorLoanAccount build() {
			return this.guarantorLoanAccount;
		}
	}
}
