package hello.springmvc.requestmapping;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic!");
        return "ok!";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
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
        log.info("mappingParam");
        return "ok";
    }

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
}
