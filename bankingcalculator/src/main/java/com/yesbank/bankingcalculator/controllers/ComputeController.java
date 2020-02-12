package com.yesbank.bankingcalculator.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yesbank.bankingcalculator.model.ComputeVariables;
import com.yesbank.bankingcalculator.services.ComputeService;

@RestController
public class ComputeController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ComputeService cs;

	@PostMapping(path = "/compute", consumes = "application/json", produces = "text/plain")
	public String getResult(@RequestBody ComputeVariables cv) throws Exception {

		logger.info("Invoking controller method getResult with operation " + cv.getFormulaCode());
		String result = "";

		result = cs.compute(cv);
		logger.info("Finished controller method getResult with operation " + cv.getFormulaCode());

		return result;
	}

}
