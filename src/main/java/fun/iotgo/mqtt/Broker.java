package fun.iotgo.mqtt;

import io.moquette.broker.Server;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.MemoryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
@Slf4j
/**
 * MQTT broker 服务器
 */
public class Broker {

    @Bean
    public String IotGoBroker() throws IOException {
        Server server = new Server();

        Properties properties = new Properties();
        properties.setProperty("port", "9999");
        IConfig config = new MemoryConfig(properties);

        List<BrokerHandler> handlers = new ArrayList<>();
        handlers.add(new BrokerHandler());
        server.startServer(config, handlers);

        log.info("IotGoBroker started-------------");
        return "";
    }



}
