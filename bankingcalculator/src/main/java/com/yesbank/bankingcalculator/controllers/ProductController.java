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

	@GetMapping(path = "/all", produces = "application/json")
	private Iterable<ProductMaster> getFields() {

		return pr.findAll();
	}

	@GetMapping(path = "/product/{id}", produces = "application/json")
	ProductMaster getProductById(@PathVariable Long id) {
		return pr.findById(id).get();
	}

	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	private String createOrSaveEmployee(@RequestBody ProductMaster pm) {

		try {

			pr.save(pm);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	@PutMapping(path = "/update/{id}")
	private String updateEmployee(@RequestBody ProductMaster pm, @PathVariable Long id) {
		try {

			pr.save(pm);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	@DeleteMapping(path = "/delete/{id}", produces = "application/json")
	private String deleteProduct(@PathVariable Long id) {
		try {
			pr.deleteById(id);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

}
