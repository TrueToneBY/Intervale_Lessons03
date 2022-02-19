package intervale.dz3.springbookdemo.openlibrary.repository;

import intervale.dz3.springbookdemo.openlibrary.exceptiom.OpenLibraryErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class OpenLibraryRestTemplate {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri("https://openlibrary.org").errorHandler(new OpenLibraryErrorHandler()).build();
    }
}
