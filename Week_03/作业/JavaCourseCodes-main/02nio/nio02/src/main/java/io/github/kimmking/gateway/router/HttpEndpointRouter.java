package io.github.kimmking.gateway.router;

import java.util.List;

public interface HttpEndpointRouter {

    String route(String endpoints);
    String route(List<String> endpoints);
    
}
