package com.yesbank.bankingcalculator.services;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.tools.generic.MathTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yesbank.bankingcalculator.model.ComputeVariables;

@Component
public class ComputeService {
	@Value("${template_path}")
	String path;
	protected final Log logger = LogFactory.getLog(getClass());

	public String compute(ComputeVariables cv) {
		logger.info("Invoking service compute with operation :: " + cv.getFormulaCode());
		String result = null;
		StringWriter writer = new StringWriter();
		try {
			String template = cv.getFormulaCode() + ".vm";
			VelocityEngine ve = new VelocityEngine();
			Properties props = new Properties();
			props.put("file.resource.loader.path", path);
			ve.init(props);
			Template t = ve.getTemplate(template);
			t.merge(populate(cv.getAttributes()), writer);
			result = writer.toString();
			logger.info("template generated with values :: " + result);
			logger.info("Result generated with serivce :: " + cv.getFormulaCode() + " :: " + result);
			logger.info("Finished service compute with operation :: " + cv.getFormulaCode());

		} catch (ResourceNotFoundException | ParseErrorException | MethodInvocationException e) {
			logger.error(e);
		}
		return result;

	}

	public VelocityContext populate(HashMap<String, String> hm) {
		VelocityContext context = new VelocityContext();
		context.put("math", new MathTool());
		for (Entry<String, String> entry : hm.entrySet())
			context.put(entry.getKey(), entry.getValue().replaceAll(",", ""));

		return context;

	}

}
