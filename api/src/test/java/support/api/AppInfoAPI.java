package support.api;

import com.adifferentcolour.starter.domain.ApplicationInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class AppInfoAPI {

    private RestTemplate restTemplate;
    private String host;

    public AppInfoAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStatus() {
        return restTemplate.getForObject(getUrl("/healthcheck"), String.class);
    }

    private URI getUrl(String path) {
        host = "http://localhost:8080";
        return URI.create(host + path);
    }

    public ApplicationInfo getAppInfo() {
        return restTemplate.getForObject(getUrl("/app-info"), ApplicationInfo.class);
    }

}
