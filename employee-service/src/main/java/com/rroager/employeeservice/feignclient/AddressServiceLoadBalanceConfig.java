// Used when load balancing with Eureka Discovery Server

//package com.rroager.employeeservice.feignclient;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value = "ADDRESS-SERVICE")
//public class AddressServiceLoadBalanceConfig {
//
//    // Enables load balancer for the feign client to AddressService whenever it is used
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//
//}
