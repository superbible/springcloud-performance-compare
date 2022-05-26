package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.common.TestUtils;

@RestController
public class TestController {

    @Autowired
    Client client;

    @RequestMapping("/getName")
    public String getName() {
        return "Lucas Lee";
    }

    @RequestMapping("/stressTest")
    public String stressTest() throws Exception {
        return TestUtils.runThreads(100, 100, () -> client.getName());
    }
}
