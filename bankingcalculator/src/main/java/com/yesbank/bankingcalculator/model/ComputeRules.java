package com.yesbank.bankingcalculator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "PRODUCT_MASTER")
@Table(name = "PRODUCT_MASTER")
public class ComputeRules {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "product_type")
	private String productType;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "productID")
	 private List<ProductFields> fields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<ProductFields> getFields() {
		return fields;
	}

	public void setFields(List<ProductFields> fields) {
		this.fields = fields;
	}
	
	
	
}
