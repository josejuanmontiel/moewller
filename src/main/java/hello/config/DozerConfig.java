package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Configuration
public class DozerConfig {

    @Bean(name = "org.dozer.Mapper")
    public Mapper getMapper() {

        List<String> mappingFiles = Arrays.asList(
            "classpath:mapping-dozer.xml" // "file:///path/to/mapping-dozer.xml"
        );
        
        Mapper mapper = DozerBeanMapperBuilder.create()
            .withMappingFiles(mappingFiles)
            .build();

        return mapper;
    }

}