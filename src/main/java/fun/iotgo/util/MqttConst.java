package fun.iotgo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqttConst {

    public static final String SSL_PORT = "1883";

    public static final String JKS_PATH = "c://";

    public static final String KEY_STORE_PASSWORD = "password";

    public static final String KEY_MANAGER_PASSWORD = "password";

    public static final String SECURE_WEBSOCKET_PORT = "8080";

    public static final String PORT = "1883";

    public static final String WEB_SOCKET_PORT = "18080";

}
