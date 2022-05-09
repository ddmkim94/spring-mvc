package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> ohvely22

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

<<<<<<< HEAD
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

=======
    /**
     * 반환 타입이 없으면서(void) response 객체에 값을 직접 집어넣으면 view 조회 X!
     */
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
>>>>>>> ohvely22
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

<<<<<<< HEAD
        response.getWriter().write("ok!!");
=======
        response.getWriter().write("ok");
>>>>>>> ohvely22
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
<<<<<<< HEAD
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age) {
        log.info("username={}, age={}", username, age);
        return "스프링에서 제공하는 @RequestParam으로 요청 파라미터 받기";
    }

=======
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int age) {

        // 지정한 타입에 맞게 요청 파라미터를 바인딩까지 해줌!!
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * @RequestParam 사용
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
     */
>>>>>>> ohvely22
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);
<<<<<<< HEAD
        return "okok";
    }

    /**
     * String, int 등의 단순 타입이면 @RequestParam 도 생략 가능!
     * 변수명을 넘어오는 요청 파라미터와 같은 이름으로 설정해야함
     */
=======
        return "ok";
    }

    /**
     * @RequestParam 사용
     * String, int 등의 단순 타입이면 @RequestParam 도 생략 가능
     */

>>>>>>> ohvely22
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
<<<<<<< HEAD
        return "okok";
=======
        return "ok";
>>>>>>> ohvely22
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
<<<<<<< HEAD
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        log.info("username={}, age={}", username, age);
        return "okok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "EUNBIN") String username,
            @RequestParam(defaultValue = "-1") int age) {

        log.info("username={}, age={}", username, age);
        return "okok";
    }

    /**
     * 파라미터 값이 1개가 확실한 경우 -> Map
     * 파라미터 값이 여러 개인 경우 -> MultiValueMap
     * MultiValueMap: 1개의 key에 여러 개의 value가 들어가있는 형태
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam MultiValueMap<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "okok";
    }

    /**
     * @ModelAttribute 동작 방식
     * 1. HelloData 객체를 생성
     * 2. 요청 파라미터의 이름으로 HelloData의 프로퍼티를 찾는다.
     * 3. 해당 프로퍼티의 setter()를 호출해서 요청 파라미터의 값을 바인딩한다.
     */

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    /**
     * int, String, Integer와 같은 단순 타입: @RequestParam 사용
     * 나머지 객체 타입: @ModelAttribute 사용
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
=======
            @RequestParam(required = false) String username,
            @RequestParam(required = true) int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    /**
     * defaultValue는 기본값을 지정해주기 때문에 required 옵션이 필요가 없어짐
     * null값을 받기 위해 기본형 타입을 래퍼 클래스 타입으로 받을 필요가 사라짐
     * 빈 문자의 경우에도 기본 값이 적용!! (중요!)
     */
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefaultValue(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    /**
     * ModelAttribute는 요청 파라미터가 없으면 해당 타입의 기본값을 자동으로 입력
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData data) {
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData data) {
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "ok";
    }



}
>>>>>>> ohvely22
