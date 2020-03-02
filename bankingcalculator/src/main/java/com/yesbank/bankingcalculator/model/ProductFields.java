package com.yesbank.bankingcalculator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private ProductMaster productID;

	@Column(name = "field_name")
	private String name;

	@Column(name = "minval")
	private String minval;

	@Column(name = "maxval")
	private String maxval;

	@Column(name = "type")
	private String type;

	@Column(name = "Mandatory")
	private String isMandatory;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productFields")
	private List<DefaultValues> def_fields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductMaster getProductID() {
		return productID;
	}

	public void setProductID(ProductMaster productID) {
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

	public List<DefaultValues> getDef_fields() {
		return def_fields;
	}

	public void setDef_fields(List<DefaultValues> def_fields) {
		this.def_fields = def_fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}
}
