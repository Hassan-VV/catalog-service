package com.cloup.api.v1;

import com.cloup.data.properties.PolarProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends AbstractController implements DefaultApi {

    private final PolarProperties polarProperties;

    public HomeController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @Override
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(polarProperties.getGreeting());
    }
}
