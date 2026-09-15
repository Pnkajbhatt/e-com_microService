package in.pnkj.ecomorderservice.service;

import org.springframework.stereotype.Service;

import in.pnkj.ecomorderservice.config.RestTemplateConfig;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final RestTemplate restTemplate;

    private OrderService(RestTemplateConfig restTemplateConfig, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String placeOrder(String productId) {
        Long response = restTemplate.getForObject(
                "http://localhost:8081/inventory/" + productId, Long.class);
        if (response < 200) {
            return "Out of Stock";
        }

        return "order Placed";
    }
}
