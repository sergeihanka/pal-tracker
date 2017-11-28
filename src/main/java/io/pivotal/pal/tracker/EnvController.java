package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
public class EnvController {

    @Value("${PORT:NOT SET}")
    private String port;

    @Value("${MEMORY_LIMIT:NOT SET}")
    private String mem_limit;

    @Value("${CF_INSTANCE_INDEX:NOT SET}")
    private String cf_inst_indx;

    @Value("${CF_INSTANCE_ADDR:NOT SET}")
    private String cf_inst_addr;

    private Map<String, String> env;

    public EnvController() {
        
    }

    public EnvController(String port, String mem_limit, String cf_inst_indx, String cf_inst_addr) {
        env = new HashMap<String,String>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",mem_limit);
        env.put("CF_INSTANCE_INDEX",cf_inst_indx);
        env.put("CF_INSTANCE_ADDR",cf_inst_addr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return env;
    }
}
