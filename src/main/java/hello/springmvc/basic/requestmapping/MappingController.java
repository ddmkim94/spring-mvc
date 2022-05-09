package hello.springmvc.basic.requestmapping;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("info log = {}", "helloBasic");
        return "ok";
=======
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Iterator;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic!");
        return "ok!";
>>>>>>> ohvely22
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
<<<<<<< HEAD
        log.info("info log = {}", "mappingGetV1");
=======
        log.info("mappingGetV1");
>>>>>>> ohvely22
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
<<<<<<< HEAD
        log.info("info log = {}", "mappingGetV2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 특정 파라미터가 들어가야 매핑
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params != "mode=debug"
     * params = {"mode=debug", "data=good"} 배열로 다중처리도 가능
     */
    @GetMapping(value = "/mapping-param", params = "mode")
    public String mappingParam() {
=======
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * @PathVariable 사용
     * 변수명이 같으면 생략가능!
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("userId={}", userId);
        return "ok!";
    }

    // 경로의 템플릿화!!
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String multiMappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId) {
        log.info("userId={}, orderId={}", userId, orderId);
        return "ok!!";
    }

    @GetMapping(value = "/mapping-param", params = "name")
    public String mappingParam(@RequestParam("name") String name) {
        log.info("mappingParam={}", name);
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode")
    public String mappingHeader(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Iterator<String> it = headerNames.asIterator();
        while (it.hasNext()) {
            String headerName = it.next();
            if (headerName.equals("mode")) {
                log.info("it={}", request.getHeader(headerName));
            }
        }
>>>>>>> ohvely22
        log.info("mappingParam");
        return "ok";
    }

<<<<<<< HEAD
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

=======
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(HttpEntity<String> httpEntity) throws ParseException {
        String jsonString = httpEntity.getBody();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

        String name = (String) jsonObject.get("name");
        long age = (Long) jsonObject.get("age");

        log.info("name={}, age={}", name, age);
        log.info("mappingConsumes");
        return "ok";
    }
>>>>>>> ohvely22
}
