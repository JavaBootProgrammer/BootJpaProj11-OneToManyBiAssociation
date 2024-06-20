package com.nt.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_COMPANY")
@Setter
@Getter
@RequiredArgsConstructor
public class Company {
	@Id
	@SequenceGenerator(name = "gen1", initialValue = 100, sequenceName = "COMPID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer companyID;

	@Column(length = 30)
	@NonNull
	private String name;

	@Column(length = 30)
	@NonNull
	private String address;

	@Column(length = 30)
	@NonNull
	private Long pinCode;

	@OneToMany(targetEntity = TechnicalJob.class, cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER) // to
																															// build
																															// assosiation
	// @JoinColumn(name = "companyID",referencedColumnName = "jobId")
	private Set<TechnicalJob> openings; // for 1 to M mapping

	public Company() {
		System.out.println("Company:: 0-param  constructor::" + this.getClass());
	}

	// toString()
	@Override
	public String toString() {
		return "Company [cid=" + companyID + ", name=" + name + ", addrs=" + address + ", pinCode=" + pinCode + "]";
	}

}
