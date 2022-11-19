/**
 * 
 */
package com.pdfcreator.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.pdfcreator.model.Template;

/**
 * @author BabaFakruddinDharuba
 *
 */
public interface ITemplateService {

	/**This method fill the details to the editable fields of the Pdf and returns a new Pdf having all the fields 
	 * @param template to fill a specific pdf based on the Template Object Details passed
	 * @return a String declaring the message returned to the calling method 
	 * @throws FileNotFoundException if there is no file available in the specified path then an FileNotFoundException occurs
	 * @throws IOException if there is anything goes wrong while reading and writing the file
	 */
	String fillDetails(Template template) throws FileNotFoundException, IOException;
	
	/**This method retrieves all the Templates present in the DataBase
	 * @return all the Templates present in the Database Table
	 */
	List<Template> getAllTemplates();
	
	/**This method retrieves a specific Template based on the templateName
	 * @param templateName to retrieve an specific Template based on the 
	 * @return an Template from the DataBase matched with the passed parameter
	 */
	Template findByName(String templateName);
	
	/**This method adds the new Template to the DataBase
	 * @param template to add an Template Object into the DataBase
	 */
	void addTemplate(Template template);
}
