package com.iotlife.mqtt;

import com.iotlife.util.MqttConst;
import io.moquette.BrokerConstants;
import io.moquette.server.Server;
import io.moquette.server.config.IConfig;
import io.moquette.server.config.MemoryConfig;
import io.moquette.spi.security.IAuthenticator;
import io.moquette.spi.security.IAuthorizator;
import io.moquette.spi.security.ISslContextCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class Broker {

    private static final Logger log = LoggerFactory.getLogger(Broker.class);

    //    public static void main(String[] args) throws IOException {
//        final Server server = new Server();
//        //SSL 加密配置
//        Properties sslProps = new Properties();
//        //SSL 加密通道端口
//        sslProps.put(BrokerConstants.SSL_PORT_PROPERTY_NAME, MqttConst.SSL_PORT);
//        //密钥位置，这里是项目根目录
//        sslProps.put(BrokerConstants.JKS_PATH_PROPERTY_NAME, MqttConst.JKS_PATH);
//        sslProps.put(BrokerConstants.KEY_STORE_PASSWORD_PROPERTY_NAME, MqttConst.KEY_STORE_PASSWORD);
//        sslProps.put(BrokerConstants.KEY_MANAGER_PASSWORD_PROPERTY_NAME, MqttConst.KEY_MANAGER_PASSWORD);
//        sslProps.put(BrokerConstants.WSS_PORT_PROPERTY_NAME, MqttConst.SECURE_WEBSOCKET_PORT);
//
//        //未加密端口，暂时不知道如何屏蔽这两个端口
//        sslProps.put(BrokerConstants.PORT_PROPERTY_NAME,MqttConst.PORT);
//        sslProps.put(BrokerConstants.WEB_SOCKET_PORT_PROPERTY_NAME, MqttConst.WEB_SOCKET_PORT);
//
//        final IConfig config = new MemoryConfig(sslProps);
//
////	        final IConfig config = new FilesystemConfig();
//        //加载自定义handler
//        List<BrokerHandler> handlers = new ArrayList<BrokerHandler>();
//        handlers.add(new BrokerHandler());
//        ISslContextCreator sslCtxCreator = null;
//        IAuthenticator authenticator = null;
//        IAuthorizator authorizator = null;
//        server.startServer(config, handlers, sslCtxCreator, authenticator, authorizator);
//
//        log.info("VolvoBroker started-------------");
//
//        //绑定一个关闭服务器钩子
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                server.stopServer();
//            }
//        });
//    }
    @Bean
    public String IotLifeBroker() throws IOException {
        final Server server = new Server();
        //SSL 加密配置
        Properties sslProps = new Properties();
        //SSL 加密通道端口
        sslProps.put(BrokerConstants.SSL_PORT_PROPERTY_NAME, MqttConst.SSL_PORT);
        //密钥位置，这里是项目根目录
        sslProps.put(BrokerConstants.JKS_PATH_PROPERTY_NAME, MqttConst.JKS_PATH);
        sslProps.put(BrokerConstants.KEY_STORE_PASSWORD_PROPERTY_NAME, MqttConst.KEY_STORE_PASSWORD);
        sslProps.put(BrokerConstants.KEY_MANAGER_PASSWORD_PROPERTY_NAME, MqttConst.KEY_MANAGER_PASSWORD);
        sslProps.put(BrokerConstants.WSS_PORT_PROPERTY_NAME, MqttConst.SECURE_WEBSOCKET_PORT);

        //未加密端口，暂时不知道如何屏蔽这两个端口
        sslProps.put(BrokerConstants.PORT_PROPERTY_NAME, MqttConst.PORT);
        sslProps.put(BrokerConstants.WEB_SOCKET_PORT_PROPERTY_NAME, MqttConst.WEB_SOCKET_PORT);

        final IConfig config = new MemoryConfig(sslProps);

//	        final IConfig config = new FilesystemConfig();
        //加载自定义handler
        List<BrokerHandler> handlers = new ArrayList<BrokerHandler>();
        handlers.add(new BrokerHandler());
        ISslContextCreator sslCtxCreator = null;
        IAuthenticator authenticator = null;
        IAuthorizator authorizator = null;
        server.startServer(config, handlers, sslCtxCreator, authenticator, authorizator);

        log.info("IotLifeBroker started-------------");

        //绑定一个关闭服务器钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.stopServer();
            }
        });
        return "";
    }

}
