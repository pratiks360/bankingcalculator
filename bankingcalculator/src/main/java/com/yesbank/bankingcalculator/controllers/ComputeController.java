package com.yesbank.bankingcalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yesbank.bankingcalculator.model.ComputeVariables;
import com.yesbank.bankingcalculator.services.ComputeService;

@RestController
public class ComputeController {

	@Autowired
	ComputeService cs;

	@PostMapping(path = "/compute", consumes = "application/json", produces = "text/plain")
	public String getResult(@RequestBody ComputeVariables cv) {
		String result = "computation error";
		try {

			result = cs.compute(cv);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
