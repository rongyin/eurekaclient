package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class ClientService {

    @Autowired
    private DiscoveryClient discoveryClient;
    @ResponseBody
    @RequestMapping("/getName")
    public String getName(){
        return "client name";
    }

    @ResponseBody
    @GetMapping("/getType")
    public Object getType(){
        HashMap<String,String> r = new HashMap<>();
        r.put("t","t1");
        r.put("g","g");
        return discoveryClient.getInstances("service-hi-ha");
        //return discoveryClient.getServices();
        //return r;
    }
}
