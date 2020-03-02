package com.yesbank.bankingcalculator.model;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonRawValue;

@Entity(name = "DEFAULT_VALUES")
@Table(name = "DEFAULT_VALUES")
public class DefaultValues {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "default_id", nullable = false)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "field_id", nullable = false)
	private ProductFields productFields;

	@Column(name = "jsonData")
	@ElementCollection(targetClass = LinkedHashMap.class)
	@JsonRawValue
	private List<String> jsonData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductFields getProductFields() {
		return productFields;
	}

	public void setProductFields(ProductFields productFields) {
		this.productFields = productFields;
	}

	public List getJsonData() {
		return jsonData;
	}

	public void setJsonData(List jsonData) {
		this.jsonData = jsonData;
	}

}