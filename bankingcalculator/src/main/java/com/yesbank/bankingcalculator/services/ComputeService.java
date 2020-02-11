package com.yesbank.bankingcalculator.services;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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

	public String compute(ComputeVariables cv) {

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

			result = (Object) engine.eval(writer.toString());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();

	}

	public VelocityContext populate(HashMap<String,String> hm) {
		VelocityContext context = new VelocityContext();
		for (Entry<String, String> entry : hm.entrySet())
			context.put(entry.getKey(), entry.getValue().replaceAll(",", ""));

		return context;

	}

}
