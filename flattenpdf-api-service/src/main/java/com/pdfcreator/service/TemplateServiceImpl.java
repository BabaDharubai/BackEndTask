/**
 * 
 */
package com.pdfcreator.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.pdfcreator.exceptions.EmptyListFoundException;
import com.pdfcreator.exceptions.FieldNotFoundException;
import com.pdfcreator.exceptions.TemplateNotFoundException;
import com.pdfcreator.model.Field;
import com.pdfcreator.model.Template;
import com.pdfcreator.repository.ITemplateRepository;

/**
 * @author BabaFakruddinDharuba
 *This class handles the Business Logic of the application and 
 */
@Service
public class TemplateServiceImpl implements ITemplateService{
	
	

	/**
	 * logger object to add logging details into the program to check the flow
	 */
	private Logger logger=LoggerFactory.getLogger(TemplateServiceImpl.class);
	/**
	 * An instance of Repository is injected to the variable
	 */
	private ITemplateRepository templateRepository;
	
	
	
	/**
	 * @param templateRepository the templateRepository to set
	 */
	@Autowired
	public void setTemplateRepository(ITemplateRepository templateRepository) {
		this.templateRepository = templateRepository;
	}



	/**
	 * This variable stores the destination path provided in the repository
	 */
	@Value("${destination}")
	public String destination;

	
	
	
	/**This method fill the details to the editable fields of the Pdf and returns a new Pdf having all the fields
	 * @param template to fill a specific pdf based on the Template Object Details passed
	 * @return a String declaring the message returned to the calling method 
	 * @throws IOException if there is anything goes wrong while reading and writing the file
	 */
	@Override
	public String fillDetails(Template template) throws  IOException
	{
		// TODO Auto-generated method stub

		logger.info("Inside fillDetails method to write values");
		String templateName=template.getTemplatename();
		List<Field> fields=template.getFields();
		String path=null;

		Template databaseTemplate=templateRepository.getByTemplatename(templateName);
		if(databaseTemplate==null) {
			logger.warn("Exception occurured due to No Template Found "+databaseTemplate);
			throw new TemplateNotFoundException("Templaate Not Found");
		}
		else {
			List<String> databaseFields=
					databaseTemplate.getFields()
					.stream()
					.map(temp->temp.getFieldname())
					.collect(Collectors.toList());

			List<String> userFields=
					template.getFields()
					.stream()
					.map(temp->temp.getFieldname())
					.collect(Collectors.toList());
			
			if(databaseFields.containsAll(userFields)) {
				path=databaseTemplate.getPath();
				String src=template.getTemplatename();
				int random=(int) (Math.random()*100);
				String des=destination.concat(src)+random+".pdf";

				File file = new File(des);
				file.createNewFile();

				PdfDocument pdf = new PdfDocument(new PdfReader(path),new PdfWriter(des));

				PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
				Map<String, PdfFormField> formFields = form.getFormFields();
				for (Entry<String, PdfFormField> entry : formFields.entrySet()) {
					for(Field field:fields) {
						if(entry.getKey().equalsIgnoreCase(field.getFieldname())) {
							if(field.getValue()==null) {
								field.setValue("");
							}
							formFields.get(entry.getKey()).setValue(field.getValue());
						}
					}
				}
				form.flattenFields();
				pdf.close();
				logger.info("File saved to the path "+des);
			}
			else {
				logger.warn("Exception occured due to Fields are Not Matched");
				throw new FieldNotFoundException("Field Not Found");
			}
		}
		logger.info("File is saved to the destinatio folder");
		return "File Saved";
	}

	/**This method retrieves all the Templates present in the DataBase
	 * @return all the Templates present in the Database Table
	 */
	@Override
	public List<Template> getAllTemplates() {
		// TODO Auto-generated method stub
		logger.info("Getting all Templates from DataBase");
		List<Template> templates=templateRepository.findAll();
		if(templates.isEmpty()) {
			logger.warn("Exception occured due to No Templates are available");
			throw new EmptyListFoundException("List is Empty");
		}
		return templates ;
	}

	/**This method retrieves a specific Template based on the templateName
	 * @param templateName to retrieve an specific Template based on the 
	 * @return an Template from the DataBase matched with the passed parameter
	 */
	@Override
	public Template findByName(String templateName) {
		// TODO Auto-generated method stub
		logger.info("Getting Template with the Name "+templateName);
		Template template=null;
		template=templateRepository.getByTemplatename(templateName);
		if(template==null) {
			logger.warn("Exception occured Template Not Found With "+templateName);
			throw new TemplateNotFoundException("Template Not Found");
		}
		logger.info("Populating template "+templateName);;
		return template;
	}

	/**This method adds the new Template to the DataBase
	 * @param template to add an Template Object into the DataBase
	 */
	@Override
	public void addTemplate(Template template) {
		// TODO Auto-generated method stub
		logger.info("Adding values into the database");
		templateRepository.save(template);
		
	}

}
