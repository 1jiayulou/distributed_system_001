package com.jiayulou.order.service.impl;

import com.jiayulou.order.bean.Order;
import com.jiayulou.order.feign.ProductFeignClient;
import com.jiayulou.order.service.OrderService;
import com.jiayulou.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long userId, Long productId) {
        List<Product> productList = new ArrayList<>();
        //Product product = getProductFromRemoteWithLoadBalanceAnnotion(productId);
        Product product = productFeignClient.getProductById(productId);
        productList.add(product);
        Order order = new Order(1L,  product.getPrice().multiply(new BigDecimal(product.getNum())), userId, "zhangSan", "Canada", productList);
        return order;
    }

    private Product getProductFromRemote(Long productId) {
        List<ServiceInstance> instances =  discoveryClient.getInstances("service-product");
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("Request" + url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private Product getProductFromRemoteWithLoadBalance(Long productId) {
        ServiceInstance instance =  loadBalancerClient.choose("service-product");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("Request" + url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private Product getProductFromRemoteWithLoadBalanceAnnotion(Long productId) {
        String url = "http://service-product/product/" + productId;
        log.info("Request" + url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
