package com.adifferentcolour.starter.services;

import com.adifferentcolour.starter.domain.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

@Service
public class PackageService {

    @Autowired
    public PackageService() {

    }


}
