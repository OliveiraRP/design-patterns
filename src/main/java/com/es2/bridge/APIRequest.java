package com.es2.bridge;

import java.util.HashMap;
import java.util.UUID;

public class APIRequest {

    protected HashMap<String, APIServiceInterface> services = new HashMap<>();

    public APIRequest() {}

    public String addService(APIServiceInterface service) {

        String id = UUID.randomUUID().toString();
        this.services.put(id, service);
        return id;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {

        APIServiceInterface apiServiceInterface = services.get(serviceId);
        if(apiServiceInterface == null)
            throw new ServiceNotFoundException();

        return apiServiceInterface.getContent(contentId);
    }

    public String setContent(String serviceId, String content) throws  ServiceNotFoundException {

        APIServiceInterface apiServiceInterface = services.get(serviceId);
        if(apiServiceInterface == null)
            throw new ServiceNotFoundException();

        return apiServiceInterface.setContent(content);
    }
}
