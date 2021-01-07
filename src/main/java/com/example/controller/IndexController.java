package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Guoqing.Qin
 * @ClassName IndexController
 * @create 2021-01-06 16:48
 * @Description:
 */
@RestController
@SuppressWarnings("ALL")
public class IndexController {
    public IndexController() {
        super();
    }

    @GetMapping("index")
    public ResponseEntity<String> index(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int RemotePort = request.getRemotePort();
        int localPort = request.getLocalPort();
        int serverPort = request.getServerPort();

        return new ResponseEntity<>(String.format("url=%s,RemotePort=%s,localPort=%s,serverPort=%s", url, RemotePort,localPort,serverPort), HttpStatus.OK);
    }

}
