package com.yesbank.bankingcalculator.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesbank.bankingcalculator.model.ComputeRules;
import com.yesbank.bankingcalculator.repos.ProductRepo;

@RestController
public class ProductController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ProductRepo pr;

	@GetMapping(path = "/rules", produces = "application/json")
		private Iterable<ComputeRules> getFields() {
			
			return pr.findAll();
		}
	
}
