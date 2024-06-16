package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_TECHJOB")
@Setter
@Getter
@RequiredArgsConstructor
public class TechnicalJob {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  jobId;
	@NonNull
	@Column(length=30)
	private  String    roleName;
	@NonNull
	private   Double   minSalary;
	@NonNull
	private   Double  maxSalary;
	@NonNull
	private   Integer  vacanciesCount;
	
	@ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="company_id",referencedColumnName = "cid")   //company_id is going to  FK column in child table pointing  cid pk colum of parent table
	private   Company    company;
	
	public TechnicalJob() {
		System.out.println("TechnicalJob::0-param constructor");
	}

	
	
	//toString()
	
	@Override
	public String toString() {
		return "TechnicalJob [jobId=" + jobId + ", roleName=" + roleName + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + ", vacanciesCount=" + vacanciesCount + "]";
	}
	

}
