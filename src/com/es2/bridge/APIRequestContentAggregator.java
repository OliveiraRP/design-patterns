package com.es2.bridge;

public class APIRequestContentAggregator extends APIRequest {

    public APIRequestContentAggregator() {}

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {

        return super.getContent(serviceId, contentId);
    }
}
