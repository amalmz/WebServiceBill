package com.example.webapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="CUSTOMER_ALL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "CUSTOMER_ID")
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("CUSTOMER_ID")
    @Column(name = "CUSTOMER_ID")
	@XmlElement(name = "customerId") 
    private Long CUSTOMER_ID;
    
	@XmlElement(name = "custCode") 
	@Column(name = "CUSTCODE")
    private String CUSTCODE;	

	@Column(name = "CSTYPE")
    private String CSTYPE ; 
	
	
	public Long getId() {
	    return CUSTOMER_ID;
	}

	public void setId(Long id) {
	    CUSTOMER_ID = id;
	}
	public String getCUSTCODE() {
		return CUSTCODE;
	}
	public void setCUSTCODE(String cUSTCODE) {
		CUSTCODE = cUSTCODE;
	}
	public String getCSTYPE() {
		return CSTYPE;
	}
	public void setCSTYPE(String cSTYPE) {
		CSTYPE = cSTYPE;
	}

}
