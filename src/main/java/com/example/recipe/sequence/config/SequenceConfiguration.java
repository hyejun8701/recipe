package com.example.recipe.sequence.config;

import com.example.recipe.sequence.DatePrefixGenerator;
import com.example.recipe.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {
    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator datePrefixGenerator = new DatePrefixGenerator();
        //datePrefixGenerator.setPattern("yyyyMMdd");

        return datePrefixGenerator;
    }

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setInitial(10000);
        sequenceGenerator.setSuffix("A");
        //sequenceGenerator.setPrefixGenerator(datePrefixGenerator());

        return  sequenceGenerator;
    }
}
