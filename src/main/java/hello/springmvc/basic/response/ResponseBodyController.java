package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@RestController // @Controller + @ResponseBody
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("hello");
=======
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
// @Controller
@RestController
public class ResponseBodyController {

    /**
     * V1 ~ V3: return String
      */
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
>>>>>>> ohvely22
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

<<<<<<< HEAD
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "OK";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("eunbin");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    // 상태 코드를 직접 지정할 수 있는 어노테이션 지원
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("eunbin");
        helloData.setAge(20);

        return helloData;
    }




}
=======
    @GetMapping("/response-body-string-v2-1")
    public ResponseEntity<HelloData> responseBodyV2_1() {
        HelloData data = new HelloData();
        data.setUsername("오연서");
        data.setAge(37);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    // @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    /**
     * V1 ~ V3: return JSON
     */

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData data = new HelloData();
        data.setUsername("오연서");
        data.setAge(37);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    // @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData data = new HelloData();
        data.setUsername("오연서");
        data.setAge(37);

        return data;
    }

    // @ResponseBody
    @GetMapping("/response-body-json-v3")
    public HelloData responseBodyJsonV3(@RequestBody HelloData helloData) {
        HelloData data = new HelloData();
        data.setUsername(helloData.getUsername());
        data.setAge(helloData.getAge());

        return data;
    }

    @RequestMapping("converter-test-v1")
    public String hello(@RequestBody String text) {
        return text;
    }
}
>>>>>>> ohvely22
