package com.vertigo.aws.lambda.apis;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateOrderLambda {
    
    public APIGatewayProxyResponseEvent createOrder(APIGatewayProxyRequestEvent request) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(request.getBody(), Order.class);
        return new ApiGatewayProxyResponseEvent().withStatusCode(200).withBody("Order ID: " + order.id);
    }

}