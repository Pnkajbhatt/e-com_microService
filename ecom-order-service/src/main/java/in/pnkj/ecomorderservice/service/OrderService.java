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
        // Long response = re.getForObject(
        // "http://localhost:8081/inventory/" + productId, Long.class);
        Long response = restClient.get()
                .uri("http://localhost:8081/inventory/" + productId)
                .retrieve()
                .body(Long.class);

        if (response < 200) {
            return "Out of Stock";
        }

        return "order Placed";
    }
}
