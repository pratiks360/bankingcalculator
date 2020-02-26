package com.yesbank.bankingcalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "FIELD_MASTER")
@Table(name = "FIELD_MASTER")
public class ProductFields {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "field_id", nullable = false)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
	private ComputeRules productID;

	@Column(name = "field_name")
	private String name;

	@Column(name = "minval")
	private String minval;

	@Column(name = "maxval")
	private String maxval;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComputeRules getProductID() {
		return productID;
	}

	public void setProductID(ComputeRules productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMinval() {
		return minval;
	}

	public void setMinval(String minval) {
		this.minval = minval;
	}

	public String getMaxval() {
		return maxval;
	}

	public void setMaxval(String maxval) {
		this.maxval = maxval;
	}
}
