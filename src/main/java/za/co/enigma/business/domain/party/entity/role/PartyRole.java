package za.co.enigma.business.domain.party.entity.role;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import za.co.enigma.business.domain.account.entity.bank.BeneficiaryBankAccount;
import za.co.enigma.business.domain.account.entity.bank.HolderBankAccount;
import za.co.enigma.business.domain.account.entity.bank.SignerBankAccount;
import za.co.enigma.business.domain.account.entity.bank.TrusteeBankAccount;
import za.co.enigma.business.domain.account.entity.loan.AuthorizedBorrowerLoanAccount;
import za.co.enigma.business.domain.account.entity.loan.CoBorrowerLoanAccount;
import za.co.enigma.business.domain.account.entity.loan.CoSignerLoanAccount;
import za.co.enigma.business.domain.account.entity.loan.GuarantorLoanAccount;
import za.co.enigma.business.domain.party.entity.Party;
import za.co.enigma.business.domain.party.entity.relationship.PartyRelationship;
import za.co.enigma.domain.archetypes.RoleDomainArchetype;

@EqualsAndHashCode(callSuper=true)

@Entity
@Table(name = "PARTY_ROLE",
uniqueConstraints={
		@UniqueConstraint(name = "PARTY_ROLE_02U",
				columnNames = { "ID", "UUID" })
}
		)
public class PartyRole extends RoleDomainArchetype implements Serializable {

	private static final long serialVersionUID = 5689108970129618527L;

	private PartyRoleType partyRoleType;
	private Party party;
	protected List<PartyRelationship> partyRelationships = new ArrayList<>();
	private List<TrusteeBankAccount> trusteeBankAccounts  = new ArrayList<>();
	private List<BeneficiaryBankAccount> beneficiaryBankAccounts  = new ArrayList<>();
	private List<SignerBankAccount> signerBankAccounts = new ArrayList<>();
	private List<HolderBankAccount> holderBankAccounts = new ArrayList<>();
	private List<CoSignerLoanAccount> coSignerLoanAccounts = new ArrayList<>();
	private List<AuthorizedBorrowerLoanAccount> authorizedBorrowerLoanAccounts = new ArrayList<>();
	private List<GuarantorLoanAccount> guarantorLoanAccounts = new ArrayList<>();
	private List<CoBorrowerLoanAccount> coBorrowerLoanAccounts = new ArrayList<>();
	
	@Column(name="PARTY_ROLE_TYPE")
	@Enumerated(EnumType.STRING)
	public PartyRoleType getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(PartyRoleType partyRoleType) {
		this.partyRoleType = partyRoleType;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PARTY_ID", foreignKey = @ForeignKey(name = "PARTY_FK01"))
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	
	@JoinTable(name= "PARTY_ROLE_PARTY_RELATIONSHIP",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "PARTY_RELATIONSHIP_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<PartyRelationship> getPartyRelationships() {
		return partyRelationships;
	}

	public void setPartyRelationships(List<PartyRelationship> partyRelationships) {
		this.partyRelationships = partyRelationships;
	}

	@JoinTable(name= "PARTY_ROLE_TRUSTEE_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "TRUSTEE_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<TrusteeBankAccount> getTrusteeBankAccounts() {
		return trusteeBankAccounts;
	}

	public void setTrusteeBankAccounts(List<TrusteeBankAccount> trusteeBankAccounts) {
		this.trusteeBankAccounts = trusteeBankAccounts;
	}

	@JoinTable(name= "PARTY_ROLE_BENEFICIARY_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "BENEFICIARY_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<BeneficiaryBankAccount> getBeneficiaryBankAccounts() {
		return beneficiaryBankAccounts;
	}

	public void setBeneficiaryBankAccounts(List<BeneficiaryBankAccount> beneficiaryBankAccounts) {
		this.beneficiaryBankAccounts = beneficiaryBankAccounts;
	}

	@JoinTable(name= "PARTY_ROLE_SIGNER_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "SIGNER_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<SignerBankAccount> getSignerBankAccounts() {
		return signerBankAccounts;
	}

	public void setSignerBankAccounts(List<SignerBankAccount> signerBankAccounts) {
		this.signerBankAccounts = signerBankAccounts;
	}

	@JoinTable(name= "PARTY_ROLE_HOLDER_BANK_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "HOLDER_BANK_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<HolderBankAccount> getHolderBankAccounts() {
		return holderBankAccounts;
	}

	public void setHolderBankAccounts(List<HolderBankAccount> holderBankAccounts) {
		this.holderBankAccounts = holderBankAccounts;
	}

	@JoinTable(name= "PARTY_ROLE_CO_SIGNER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "CO_SIGNER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<CoSignerLoanAccount> getCoSignerLoanAccounts() {
		return coSignerLoanAccounts;
	}

	public void setCoSignerLoanAccounts(List<CoSignerLoanAccount> coSignerLoanAccounts) {
		this.coSignerLoanAccounts = coSignerLoanAccounts;
	}


	@JoinTable(name= "PARTY_ROLE_AUTHORIZED_BORROWER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHORIZED_BORROWER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<AuthorizedBorrowerLoanAccount> getAuthorizedBorrowerLoanAccounts() {
		return authorizedBorrowerLoanAccounts;
	}

	public void setAuthorizedBorrowerLoanAccounts(List<AuthorizedBorrowerLoanAccount> authorizedBorrowerLoanAccounts) {
		this.authorizedBorrowerLoanAccounts = authorizedBorrowerLoanAccounts;
	}


	@JoinTable(name= "PARTY_ROLE_GUARANTOR_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "GUARANTOR_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<GuarantorLoanAccount> getGuarantorLoanAccounts() {
		return guarantorLoanAccounts;
	}

	public void setGuarantorLoanAccounts(List<GuarantorLoanAccount> guarantorLoanAccounts) {
		this.guarantorLoanAccounts = guarantorLoanAccounts;
	}

	@JoinTable(name= "PARTY_ROLE_CO_BORROWER_LOAN_ACCOUNT",
			joinColumns=@JoinColumn(name ="PARTY_ROLE_ID"),
			inverseJoinColumns = @JoinColumn(name = "CO_BORROWER_LOAN_ACCOUNT_ID"))
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	public List<CoBorrowerLoanAccount> getCoBorrowerLoanAccounts() {
		return coBorrowerLoanAccounts;
	}

	public void setCoBorrowerLoanAccounts(List<CoBorrowerLoanAccount> coBorrowerLoanAccounts) {
		this.coBorrowerLoanAccounts = coBorrowerLoanAccounts;
	}

	@XmlTransient
	public static class Builder {
		private PartyRole partyRole;

		public Builder(){
			this.partyRole = new PartyRole();
		}
		public Builder withId(long id) {
			this.partyRole.setId(id);
			return this;
		}

		public Builder withUuid(String uuid) {
			this.partyRole.setUuid(uuid);
			return this;
		}

		public Builder withTenant(int tenant) {
			this.partyRole.setTenant(tenant);
			return this;
		}

		public Builder withName(String name) {
			this.partyRole.setName(name);
			return this;
		}

		public Builder withDescription(String description) {
			this.partyRole.setDescription(description);
			return this;
		}

		public Builder withEffectiveFrom( LocalDate effectiveFrom) {
			this.partyRole.setEffectiveFrom(effectiveFrom);
			return this;
		}

		public Builder withEffectiveTo( LocalDate effectiveTo) {
			this.partyRole.setEffectiveTo(effectiveTo);
			return this;
		}
		
		public Builder withParty(Party party) {
			this.partyRole.setParty(party);
			return this;
		}
		
		public Builder withPartyRelationships(PartyRelationship partyRelationship) {
			this.partyRole.getPartyRelationships().add(partyRelationship);
			return this;
			
		}

		public Builder withTrusteeBankAccount(TrusteeBankAccount trusteeBankAccount) {
			this.partyRole.getTrusteeBankAccounts().add(trusteeBankAccount);
			return this;
		}
		
		public Builder withBeneficiaryBankAccount(BeneficiaryBankAccount beneficiaryBankAccount) {
			this.partyRole.getBeneficiaryBankAccounts().add(beneficiaryBankAccount);
			return this;
		}
		
		
		public Builder withSignerBankAccount(SignerBankAccount signerBankAccount) {
			this.partyRole.getSignerBankAccounts().add(signerBankAccount);
			return this;
		}
		
		public Builder withHolderBankAccount(HolderBankAccount holderBankAccount) {
			this.partyRole.getHolderBankAccounts().add(holderBankAccount);
			return this;
		}
		
		public Builder withCoSignerLoanAccount(CoSignerLoanAccount coSignerLoanAccount) {
			this.partyRole.getCoSignerLoanAccounts().add(coSignerLoanAccount);
			return this;
		}
		
		public Builder withAuthorizedBorrowerLoanAccount(AuthorizedBorrowerLoanAccount authorizedBorrowerLoanAccount) {
			this.partyRole.getAuthorizedBorrowerLoanAccounts().add(authorizedBorrowerLoanAccount);
			return this;
		}
		
		public Builder withGuarantorLoanAccount(GuarantorLoanAccount guarantorLoanAccount) {
			this.partyRole.getGuarantorLoanAccounts().add(guarantorLoanAccount);
			return this;
		}
		
		public Builder withCoBorrowerLoanAccount(CoBorrowerLoanAccount coBorrowerLoanAccount) {
			this.partyRole.getCoBorrowerLoanAccounts().add(coBorrowerLoanAccount);
			return this;
		}
		
		public PartyRole build(){
			return this.partyRole;
		}
	}

}