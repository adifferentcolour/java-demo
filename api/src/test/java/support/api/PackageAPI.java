package support.api;

import com.adifferentcolour.starter.domain.Bundle;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class PackageAPI {

    private static final String BASE_URL = "http://localhost:8080/api`/package";

    private RestTemplate restTemplate;

    public PackageAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private URI getUrl(String path) {
        return URI.create(String.format("%s/%s", BASE_URL, path));
    }

    public Bundle createPackage(Bundle pack) {
        return restTemplate.postForObject(getUrl("create"), pack, Bundle.class);
    }

    public Bundle getPackage(long id) {
        return restTemplate.getForObject(getUrl(String.format("/get?id=%s", id)), Bundle.class);
    }
}
