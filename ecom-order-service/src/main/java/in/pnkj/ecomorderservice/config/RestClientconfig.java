package in.pnkj.ecomorderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientconfig {
    @Bean 
    public RestClient restClient() {
        return RestClient.create();
    }
}
