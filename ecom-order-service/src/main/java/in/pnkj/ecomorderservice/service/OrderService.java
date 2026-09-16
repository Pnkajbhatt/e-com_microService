package in.pnkj.ecomorderservice.service;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestClient;

@Service
public class OrderService {

    private final RestClient restClient;

    private OrderService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String placeOrder(String productId) {
        String response = restClient.get()
                .uri("http://localhost:8081/inventory/" + productId)
                .retrieve()
                .body(String.class);
        return response;
    }
}
