package hello.springmvc.basic.response;

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