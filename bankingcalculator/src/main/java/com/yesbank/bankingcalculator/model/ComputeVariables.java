package com.yesbank.bankingcalculator.model;

import java.util.HashMap;

public class ComputeVariables {
	private String formulaCode;

	private HashMap<String, String> attributes;

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	public void setFormulaCode(String formulaCode) {
		this.formulaCode = formulaCode;
	}

	public String getFormulaCode() {
		return formulaCode;
	}

}
