/**
 * 
 */
package com.pdfcreator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdfcreator.model.Template;

/**This Class deals with the DataBase to send data to the database and retrieve data.
 * It is extending inbuild JpaRepository interface so based on the specific conditions declaration it goes and collect data without any implementation class 
 * @author BabaFakruddinDharubai
 *
 */
@Repository
public interface ITemplateRepository extends JpaRepository<Template, Integer>{

	/**This method reads the database and fetches the specified Template
	 * @param templateName to find along the table for a specific Template with the required Name
	 * @return an Template from the table 
	 */
	Template getByTemplatename(String templateName);
}
