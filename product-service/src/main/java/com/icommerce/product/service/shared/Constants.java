package com.icommerce.product.service.shared;

public interface Constants {

    String API_VERSION = "/v1";
    String RESOURCE_VERSION = "/version";
    String PRODUCT_RESOURCE = "/products";
    String SUCCESS_STATUS = "Success";
    String FAILURE_STATUS = "Failure";

    String INTERNAL_SERVER_ERR_MSG = "Something went wrong, please contact admin";
    String BAD_REQUEST_ERR_MSG = "Bad Request";
    String RESOURCE_NOT_FOUND_ERR_MSG = "Resource not found";
    String ACCESS_DENIED_ERR_MSG = "Access denied";

    String ASYNC_POOL = "myCustomPool";
}