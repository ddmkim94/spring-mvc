package hello.springmvc.basic.response;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        return new ModelAndView("response/hello")
                .addObject("data", "hello");
    }

    // @Controller + String return => view의 논리적 이름
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "eunbin");
        return "response/hello";
    }

    /**
     * HTTP body를 처리하는 파라미터가 없는 경우는 요청 url을 사용해서 논리 뷰 이름으로 사용함ㄴ
     * 명확성이 너무 떨어지기 때문에 사용X
      */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "eunbin");
    }
}
=======
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

    @GetMapping("response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mv = new ModelAndView("response/hello");
        mv.addObject("data", "hello!!");
        return mv;
    }

    @GetMapping("response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "helloooo~");
        return "response/hello";
    }

    @GetMapping("response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello");
    }
}
>>>>>>> ohvely22
