package com.firstspringboot.firstspringboot.resourcehandson;

import java.io.File;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ResourcesInjectMain {
    // Ask the container to get the bean and 'put' it here (inject)
    @Resource(name = "dummy")
    private File dummy;
}
