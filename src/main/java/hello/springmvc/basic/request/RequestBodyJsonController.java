package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======
import org.springframework.http.HttpEntity;
>>>>>>> ohvely22
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

<<<<<<< HEAD
/**
 * {"username":"eunbin", "age":31}
 * content-type: application/json
 */
=======
>>>>>>> ohvely22
@Slf4j
@Controller
public class RequestBodyJsonController {

<<<<<<< HEAD
=======
    // jackson 라이브러리: json -> Java Object!!
>>>>>>> ohvely22
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
<<<<<<< HEAD

=======
>>>>>>> ohvely22
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());

<<<<<<< HEAD
        response.getWriter().write("ok!");
=======
        response.getWriter().write("ok!!");
>>>>>>> ohvely22
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
<<<<<<< HEAD
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}", messageBody);
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());

        return "ok";
=======
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException{
        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());

        return "v2 ok!!";
>>>>>>> ohvely22
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
<<<<<<< HEAD
    public String requestBodyJsonV3(@RequestBody HelloData data) throws IOException {
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "ok";
=======
    public String requestBodyJsonV3(@RequestBody HelloData data) {
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "v3 ok!!";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> helloData) {
        HelloData data = helloData.getBody();
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "v4 ok!!";
>>>>>>> ohvely22
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
<<<<<<< HEAD
    public HelloData requestBodyJsonV5(@RequestBody HelloData data) throws IOException {
=======
    public HelloData requestBodyJsonV5(@RequestBody HelloData data) {
>>>>>>> ohvely22
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return data;
    }
}
