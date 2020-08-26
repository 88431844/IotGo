package fun.iotgo.mqtt;

import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import lombok.extern.slf4j.Slf4j;

/**
 * broker处理函数
 */
@Slf4j
public class BrokerHandler implements InterceptHandler {


    @Override
    public String getID() {
        return null;
    }

    @Override
    public Class<?>[] getInterceptedMessageTypes() {
        return new Class[0];
    }

    @Override
    public void onConnect(InterceptConnectMessage interceptConnectMessage) {
        log.info("onConnect : " + interceptConnectMessage.getClientID());
    }

    @Override
    public void onDisconnect(InterceptDisconnectMessage interceptDisconnectMessage) {
        log.info("onDisconnect : " + interceptDisconnectMessage.getClientID());
    }

    @Override
    public void onConnectionLost(InterceptConnectionLostMessage interceptConnectionLostMessage) {
        log.info("onConnectionLost : " + interceptConnectionLostMessage.getClientID());
    }

    @Override
    public void onPublish(InterceptPublishMessage interceptPublishMessage) {
        log.info("onPublish : " + interceptPublishMessage.getClientID());
    }

    @Override
    public void onSubscribe(InterceptSubscribeMessage interceptSubscribeMessage) {
        log.info("onSubscribe : " + interceptSubscribeMessage.getClientID());
    }

    @Override
    public void onUnsubscribe(InterceptUnsubscribeMessage interceptUnsubscribeMessage) {
        log.info("onUnsubscribe : " + interceptUnsubscribeMessage.getClientID());
    }

    @Override
    public void onMessageAcknowledged(InterceptAcknowledgedMessage interceptAcknowledgedMessage) {
        log.info("onMessageAcknowledged : " + interceptAcknowledgedMessage.getTopic());
    }
}
