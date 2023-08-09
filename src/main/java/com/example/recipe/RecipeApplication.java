package com.example.recipe;

import com.example.recipe.shop.Product;
import com.example.recipe.shop.config.ShopConfiguration;
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
					"com.example.recipe.sequence.*Dao",
					"com.example.recipe.sequence.*Service"
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

		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
		Product aaa = context.getBean("aaa", Product.class);
		Product cdrw = context.getBean("cdrw", Product.class);
		System.out.println(aaa);
		System.out.println(cdrw);
	}

}
