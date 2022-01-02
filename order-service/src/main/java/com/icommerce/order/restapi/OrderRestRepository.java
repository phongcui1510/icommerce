package com.icommerce.order.restapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.icommerce.order.domain.CustomerOrder;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRestRepository extends MongoRepository<CustomerOrder, String> {
}
