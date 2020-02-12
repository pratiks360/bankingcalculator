package com.yesbank.bankingcalculator.services;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
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
		Object result = null;
		try {
			String template = cv.getFormulaCode() + ".vm";
			VelocityEngine ve = new VelocityEngine();
			Properties props = new Properties();
			props.put("file.resource.loader.path", path);
			ve.init(props);
			Template t = ve.getTemplate(template);

			StringWriter writer = new StringWriter();
			t.merge(populate(cv.getAttributes()), writer);
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			logger.info("template generated with values :: " + writer.toString());
			result = (Object) engine.eval(writer.toString());
			logger.info("Result generated with serivce :: " + cv.getFormulaCode() + " :: " + result.toString());
			logger.info("Finished service compute with operation :: " + cv.getFormulaCode());

		} catch (ResourceNotFoundException | ParseErrorException | MethodInvocationException | ScriptException e) {
			logger.error(e);
		}
		return result.toString();

	}

	public VelocityContext populate(HashMap<String, String> hm) {
		VelocityContext context = new VelocityContext();
		for (Entry<String, String> entry : hm.entrySet())
			context.put(entry.getKey(), entry.getValue().replaceAll(",", ""));

		return context;

	}

}
