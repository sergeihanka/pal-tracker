package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
public class EnvController {
    private String port, mem_limit, cf_inst_indx, cf_inst_addr;

    public EnvController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${MEMORY_LIMIT:NOT SET}") String mem_limit,
            @Value("${CF_INSTANCE_INDEX:NOT SET}") String cf_inst_indx,
            @Value("${CF_INSTANCE_ADDR:NOT SET}") String cf_inst_addr) {
        this.port = port;
        this.mem_limit = mem_limit;
        this.cf_inst_indx = cf_inst_indx;
        this.cf_inst_addr = cf_inst_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<String,String>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",mem_limit);
        env.put("CF_INSTANCE_INDEX",cf_inst_indx);
        env.put("CF_INSTANCE_ADDR",cf_inst_addr);
        return env;
    }
}
