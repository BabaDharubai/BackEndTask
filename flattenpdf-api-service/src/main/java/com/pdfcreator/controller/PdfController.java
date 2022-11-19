/**
 * 
 */
package com.pdfcreator.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdfcreator.model.Template;
import com.pdfcreator.service.ITemplateService;

/**
 * @author BabaFakruddinDharubai
 *
 */
@RestController
public class PdfController {

	/**
	 * Autowiring templateService
	 */
	private ITemplateService templateService;
	
	/**
	 * @param templateService the templateService to set
	 */
	@Autowired
	public void setTemplateService(ITemplateService templateService) {
		this.templateService = templateService;
	}
	
	
	/**
	 * Logger object to add the logging details into the program to check while deploying and finding out the flow
	 */
	Logger logger=LoggerFactory.getLogger(PdfController.class);
	
	
	

	/**This method is used to call all the templates present in the database
	 * @return List of templates available in the DataBase 
	 */
	@GetMapping("/")
	ResponseEntity<List<Template>> getAll() {
		logger.info("Calling getAll method");
		List<Template> templates=templateService.getAllTemplates();
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "getting list of templates");
		logger.info("Populating Templates");
		return ResponseEntity.ok().headers(header).body(templates);
	}

	/**This method is used to pass the Template object to the service layer
	 * @param template to take the input as Template object from the Body
	 * @return ResponseEntity with headers, body and status
	 * @throws FileNotFoundException if the File is not available in the specified location
	 * @throws IOException when there is no file found are the path is wrong
	 */
	@PostMapping("/")
	public ResponseEntity<String> flatForm(@RequestBody Template template) throws IOException {
		logger.info("Checking requested Template ");
		String result=templateService.fillDetails(template);
		HttpHeaders headers= new HttpHeaders();
		headers.add("info","adding values to an editable pdf");
		return ResponseEntity.ok().headers(headers).body(result);
	}
	
	/**This method is used to pass the templateName to retrieve a specific template based on the name
	 * @param templateName to retrieve a specific Template Object based on the TemplateName 
	 * @return an Template Object available in the database
	 */
	@GetMapping("/{templateName}")
	public ResponseEntity<Template> getByTemplateName(@PathVariable("templateName") String templateName) {
		logger.info("checking template name info in data");
		HttpHeaders headers=new HttpHeaders();
		Template template=templateService.findByName(templateName);
		headers.add("info", "retrieving templates by "+templateName);
		return ResponseEntity.ok().headers(headers).body(template);
		
	}
	
	/**This method passes the Template Object body to save the new template into the database
	 * @param template to add into the database with required fields
	 * @return a String declaring the statement of the method
	 */
	@PostMapping("/add")
	public ResponseEntity<String> addTemplate(@RequestBody Template template) {
		logger.info("adding template details to database");
		HttpHeaders headers=new HttpHeaders();
		templateService.addTemplate(template);
		headers.add("info", "adding template to database");
		return ResponseEntity.ok().headers(headers).body("Added "+template+" to database");
	}
}
