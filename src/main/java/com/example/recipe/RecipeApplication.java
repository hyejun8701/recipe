package com.example.recipe;

import com.example.recipe.config.SequenceGeneratorConfig;
import com.example.recipe.domain.SequenceDao;
import com.example.recipe.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		includeFilters = {
			@ComponentScan.Filter(
			type = FilterType.REGEX,
			pattern = {
					"com.example.recipe.*.*Dao",
					"com.example.recipe.*.*Service"
			})
		},
		excludeFilters = {
			@ComponentScan.Filter(
					type = FilterType.ANNOTATION,
					classes = {org.springframework.stereotype.Controller.class}
			)
		}
)
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext("com.example.recipe");
		SequenceDao sequenceDao = (SequenceDao) context.getBean("sequenceDao");
		System.out.println(sequenceDao.getNextValue("IT"));
		System.out.println(sequenceDao.getNextValue("IT"));
	}

}
