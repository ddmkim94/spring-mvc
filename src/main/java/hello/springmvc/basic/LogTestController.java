package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

<<<<<<< HEAD
    // private final Logger log = LoggerFactory.getLogger(getClass());
    // private final Logger log2 = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
=======
    // private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "오연서❤️";
        String debugName = "오햇님️❤️";

        log.trace("trace log={}", name);
        log.debug("debug log={}", debugName);
>>>>>>> ohvely22
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

<<<<<<< HEAD
        return "ok";
    }
}
=======
        return "log 테스트 통과!!";
    }
}
>>>>>>> ohvely22
