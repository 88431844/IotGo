package fun.iotgo.mqtt;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

import java.net.URISyntaxException;

public class MQTTProducer {
    private final static String CONNECTION_STRING = "tcp://localhost:1883";
    private final static boolean CLEAN_START = true;
    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s

    public final static long RECONNECTION_ATTEMPT_MAX = 6;
    public final static long RECONNECTION_DELAY = 2000;

    public final static int SEND_BUFFER_SIZE = 2 * 1024 * 1024;//发送最大缓冲为2M

    public static void main(String[] args) {
        MQTT mqtt = new MQTT();
        try {
            //设置服务端的ip
            mqtt.setHost(CONNECTION_STRING);
            //连接前清空会话信息
            mqtt.setCleanSession(CLEAN_START);
            //设置重新连接的次数
            mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
            //设置重连的间隔时间
            mqtt.setReconnectDelay(RECONNECTION_DELAY);
            //设置心跳时间
            mqtt.setKeepAlive(KEEP_ALIVE);
            //设置缓冲的大小
            mqtt.setSendBufferSize(SEND_BUFFER_SIZE);

            //创建连接 ,使用阻塞式
            BlockingConnection connection = mqtt.blockingConnection();
            //开始连接
            connection.connect();
            try {
                int count = 0;
                while (true) {
                    count++;
                    //订阅的主题
                    String topic = "mqtt/test";
                    //主题的内容
                    String message = "hello " + count + " mqtt!";
                    connection.publish(topic, message.getBytes(), QoS.AT_LEAST_ONCE, false);
                    System.out.println("MQTTProducer Message  Topic=" + topic + "  Content :" + message);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}