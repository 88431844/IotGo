package com.iotlife.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqttConst {
    @Value("${broker.ssl.port:11883}")
    public static String SSL_PORT = "1883";

    @Value("${broker.jks.path:c://}")
    public static String JKS_PATH = "c://";

    @Value("${broker.key.store.password:password}")
    public static String KEY_STORE_PASSWORD = "password";

    @Value("${broker.key.manager.password:password}")
    public static String KEY_MANAGER_PASSWORD = "password";

    @Value("${broker.secure.websocket.port:8080}")
    public static String SECURE_WEBSOCKET_PORT = "8080";

    @Value("${broker.port:1883}")
    public static String PORT = "1883";

    @Value("${broker.web.socket.port:18080}")
    public static String WEB_SOCKET_PORT = "18080";

}
