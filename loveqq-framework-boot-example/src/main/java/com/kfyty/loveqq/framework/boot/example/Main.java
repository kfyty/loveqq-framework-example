package com.kfyty.loveqq.framework.boot.example;

import com.kfyty.loveqq.framework.boot.K;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.BootApplication;
import com.kfyty.loveqq.framework.web.core.autoconfig.annotation.EnableWebMvc;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述: 启动类，需添加如下启动参数：
 * --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/jdk.internal.reflect=ALL-UNNAMED --add-opens java.base/sun.reflect.annotation=ALL-UNNAMED --add-opens=java.rmi/java.rmi=ALL-UNNAMED --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED --add-opens=java.rmi/sun.rmi.transport.tcp=ALL-UNNAMED
 * <p>
 * {@link EnableWebMvc} 必须注解在启动类才有效，并且只有添加了该注解，web 服务器才会启动
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@Slf4j
@EnableWebMvc
@BootApplication(scan = "com.kfyty.loveqq.framework.boot.**.example.**.*")
public class Main {

    public static void main(String[] args) throws Throwable {
        K.run(Main.class, args);
    }
}
