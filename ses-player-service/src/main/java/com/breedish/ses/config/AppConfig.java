package com.breedish.ses.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static java.util.Collections.singletonList;

@Configuration
public class AppConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
        return (Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) -> {
            jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
            jacksonObjectMapperBuilder.featuresToDisable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
        };
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        final DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(singletonList("dozer-converters.xml"));
        return mapper;
    }

}
