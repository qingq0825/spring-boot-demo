package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guoqing.Qin
 * @ClassName LogController
 * @create 2021-01-13 18:17
 * @Description:
 */
@Slf4j
@RestController
@SuppressWarnings("ALL")
public class LogController {
    public LogController() {
        super();
    }

    @GetMapping("/log/{arg}")
    public HttpStatus log(@PathVariable("arg") String arg) {
        log.info(" ---------------------- log 方法打印日志 ---------------------");
        return HttpStatus.OK;
    }
}
