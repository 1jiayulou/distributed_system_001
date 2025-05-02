package com.jiayulou.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(value = "movie", url = "https://api.themoviedb.org")

public interface MovieFeignClient {

    @GetMapping("/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
    String getMovie(@RequestHeader("Authorization") String token);

}
