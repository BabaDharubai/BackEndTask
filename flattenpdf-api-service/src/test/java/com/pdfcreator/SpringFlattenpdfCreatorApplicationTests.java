package com.pdfcreator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pdfcreator.exceptions.EmptyListFoundException;
import com.pdfcreator.exceptions.TemplateNotFoundException;
import com.pdfcreator.model.Field;
import com.pdfcreator.model.Template;
import com.pdfcreator.repository.ITemplateRepository;
import com.pdfcreator.service.ITemplateService;

@SpringBootTest

class SpringFlattenpdfCreatorApplicationTests {

	@Autowired
	ITemplateService templateService;

	@MockBean
	ITemplateRepository templateRepository;

	/**
	 * This method tests the findByName method
	 */
	@Test
	@DisplayName("Testing findByName Method")
	public void testTemplateName() {
		Template template = new Template(1, "employeeId",
				Stream.of(new Field(1, "name", null), new Field(2, "employeeNo", null)).collect(Collectors.toList()),
				"C:\\Users\\BabaFakruddinDharuba\\Desktop\\Project\\editableFields\\employeeId.pdf");

		when(templateRepository.getByTemplatename("employeeId")).thenReturn(template);

		assertEquals(templateService.findByName("employeeId"), template);
	}

	/**
	 * This method tests tests the findByName method
	 */
	@Test
	@DisplayName("Testing findByName Method")
	public void testTemplateNameNull() {

		when(templateRepository.getByTemplatename("employeeId")).thenReturn(null);

		assertThrows(TemplateNotFoundException.class, ()->templateService.findByName("employeeId"));
	}

	/**
	 * This method tests the getAllTemplates method
	 */
	@Test
	@DisplayName("Testing GetAll Method")
	public void testTemplateGetAll() {

		when(templateRepository.findAll()).thenThrow(EmptyListFoundException.class);

		assertThrows(EmptyListFoundException.class, ()->templateService.getAllTemplates());
	}

}
