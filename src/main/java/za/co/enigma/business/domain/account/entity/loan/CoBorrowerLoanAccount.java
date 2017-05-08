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
@Table(name="CO_BORROWER_LOAN_ACCOUNT",
uniqueConstraints= {
		@javax.persistence.UniqueConstraint(name="CO_BORROWER_LOAN_ACCOUNT_02U", columnNames={"ID", "UUID"})
}
		)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CoBorrowerLoanAccount extends MomentIntervalDomainArchetype {

	private static final long serialVersionUID = 6015668797034812362L;
	
	private LoanAccount loanAccount;
	private PartyRole partyRole;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "LOAN_ACCOUNT_ID", foreignKey = @ForeignKey(name = "LOAN_ACCOUNT_CO_BORROWER__FK01"))
	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ROLE_ID", foreignKey = @ForeignKey(name = "LOAN_ACCOUNT_CO_BORROWER__PARTY_ROLE_FK01"))
	public PartyRole getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

	@XmlTransient
	public static class Builder {
		private CoBorrowerLoanAccount coBorrowerLoanAccount;
		
		public Builder() {
			this.coBorrowerLoanAccount = new CoBorrowerLoanAccount();
		}
		
		public Builder withId(long id) {
			this.coBorrowerLoanAccount.setId(id);
			return this;
		}
	  	    
	    public Builder withUuid(String uuid) {
	    	this.coBorrowerLoanAccount.setUuid(uuid);
	    	return this;
	    }
	    
	    public Builder withTenant(int tenant) {
	    	this.coBorrowerLoanAccount.setTenant(tenant);
	    	return this;
	    }

		public Builder withEffectiveFrom(LocalDateTime effectiveFrom) {
			this.coBorrowerLoanAccount.setEffectiveFrom(effectiveFrom);
			return this;
		}
		public Builder withEffectiveTo(LocalDateTime effectiveTo) {
			this.coBorrowerLoanAccount.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withBankAccount(LoanAccount loanAccount){
			this.coBorrowerLoanAccount.setLoanAccount(loanAccount);
			return this;
		}
		
		public Builder withPartyRole(PartyRole partyRole) {
			this.coBorrowerLoanAccount.setPartyRole(partyRole);
			return this;
		}
		
		public CoBorrowerLoanAccount build() {
			return this.coBorrowerLoanAccount;
		}
	}
}
