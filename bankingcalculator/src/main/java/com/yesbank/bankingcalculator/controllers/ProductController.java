package com.yesbank.bankingcalculator.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesbank.bankingcalculator.model.ProductMaster;
import com.yesbank.bankingcalculator.repos.ProductRepo;

@RestController
@RequestMapping(value = "/bankingcalc-management")
public class ProductController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ProductRepo pr;

	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";

	@GetMapping(path = "/all", produces = "application/json")
	public Iterable<ProductMaster> getFields() {

		return pr.findAll();
	}

	@GetMapping(path = "/product/{id}", produces = "application/json")
	public ProductMaster getProductById(@PathVariable Long id) {
		logger.info("getProductById Method invoked");
		return pr.findById(id).get();
	}

	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public String createOrSaveProductMaster(@RequestBody ProductMaster pm) {

		try {
			logger.info("createOrSaveProductMaster Method invoked");
			pr.save(pm);
		} catch (Exception e) {
			logger.error("Issue in createOrSaveProductMaster", e);
			return FAILURE;
		}
		return SUCCESS;
	}

	@PutMapping(path = "/update}")
	public String updateProductMaster(@RequestBody ProductMaster pm) {
		try {
			logger.info("updateProductMaster Method invoked");
			pr.save(pm);
		} catch (Exception e) {
			logger.error("Issue in updateProductMaster", e);
			return FAILURE;
		}
		return SUCCESS;
	}

	@DeleteMapping(path = "/delete/{id}", produces = "application/json")
	public String deleteProduct(@PathVariable Long id) {
		try {
			logger.info("deleteProduct Method invoked");
			pr.deleteById(id);
		} catch (Exception e) {
			logger.error("Issue in deleteProduct", e);
			return FAILURE;
		}
		return SUCCESS;
	}

}
