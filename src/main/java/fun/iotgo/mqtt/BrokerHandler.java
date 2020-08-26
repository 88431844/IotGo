package fun.iotgo.mqtt;

import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * broker处理函数
 *
 * Created on 2016年7月4日 下午4:50:56
 * @modify author:修改人
 * Modify on 修改时间
 */
public class BrokerHandler implements InterceptHandler {

    private static final Logger log = LoggerFactory.getLogger(BrokerHandler.class);


    public void onConnect(InterceptConnectMessage arg0) {
        String clientID = arg0.getClientID();
        //设备状态写入redis中

        //设备上下线状态
        String devStatus = "dev_On/Offline_" + clientID;
        //1代表上线，0代表下线
//		JedisCache.set(devStatus, Const.DEVSTATUS_ONLINE);

        //设备是否删除状态
        String devIsDel = "dev_IsDel_" + clientID;
//		JedisCache.set(devIsDel, Const.DEVSTATUS_NOTDEL);

        //定义设备过期时间，当过n秒后还未更新过期时间，则认为该设备下线，并删除上下线状态这个key value对
//		JedisCache.expire(devStatus,Integer.parseInt((String) ConfigTools.getProperties("DEVSTATUS_LIVESECOND")));

        //设备逻辑连接到哪个collector上面（默认broker和collector部署在同一台服务器上面）
        String devConnTo = "dev_ConnTo_" + clientID;
//		String serverIp = IpTools.getServerIp();
//		JedisCache.set(devConnTo, serverIp);

        log.info("设备：" + clientID + "，上线，连接broker.........................................");
//		System.out.println("设备："+clientID+"，上线，连接broker.........................................");
    }

    public void onDisconnect(InterceptDisconnectMessage arg0) {
        String clientID = arg0.getClientID();
        //把设备状态写入redis中
        //设备上下线状态
        String devStatus = "dev_On/Offline_" + clientID;
//		JedisCache.set(devStatus, Const.DEVSTATUS_OFFLINE);//1代表上线，0代表下线

        //设备是否删除状态
        String devIsDel = "dev_IsDel_" + clientID;
//		JedisCache.set(devIsDel, Const.DEVSTATUS_ISDEL);

        //删除设备ID和host的配对关系
        String devConnTo = "dev_ConnTo_" + clientID;
//		JedisCache.del(devConnTo);

        log.info("设备：" + clientID + "，下线，断开broker.........................................");
//		System.out.println("设备："+clientID+"，下线，断开broker.........................................");
    }



    public void onPublish(InterceptPublishMessage arg0) {
        String clientID = arg0.getClientID();
        String topic = arg0.getTopicName();
        String payload = null;
        String dataKey = null;
        try {
//			payload = new String(arg0.getPayload().array(),Const.PUBLISH_MESSAGE_CHARSET);
            payload = new String(arg0.getPayload().array(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.info("BrokerHandler onPublish dev:" + clientID + ", 消息转换失败！");
//			System.out.println("BrokerHandler onPublish 消息转换失败！");
        }

//		System.out.println(clientID+"发布，主题："+topic+",消息："+payload);
        log.debug(clientID + "发布，主题：" + topic + ",消息：" + payload);

        //当设备发送消息时候，把最新一条数据存入redis中，为了当Volvo请求设备AQI数据时候，进行返回
        dataKey = clientID + "_data";
//		JedisCache.set(dataKey, payload);

        //到这里说明设备已经上线，当设备发送一条数据时，重置过期时间，达到设备上线效果
        String devStatus = "dev_On/Offline_" + clientID;
        //到设备推送数据时候，可能会出现一种情况就是，设备刚开始上线了，redis中上线状态为上线，
        //但是设备发送数据的时间超过了预先设置的DEVSTATUS_LIVESECOND时间，导致设备上线，但是redis中为下线
        //因此，在这里添加一个判断，如果设备发送数据，则说明设备上线，并且重置过期时间，达到设备上线效果
//		String keyStatus = JedisCache.get(devStatus);
//		if(null == keyStatus || "".equals(keyStatus)){
//			1代表上线，0代表下线
//			JedisCache.set(devStatus, Const.DEVSTATUS_ONLINE);
//		}
//		JedisCache.expire(devStatus,Integer.parseInt((String) ConfigTools.getProperties("DEVSTATUS_LIVESECOND")));
    }

    public void onSubscribe(InterceptSubscribeMessage arg0) {
        String clientID = arg0.getClientID();
        String topic = arg0.getTopicFilter();
//		System.out.println(clientID+"订阅了，主题："+topic);
        log.debug(clientID + "订阅了，主题：" + topic);
    }

    public void onUnsubscribe(InterceptUnsubscribeMessage arg0) {
        String clientID = arg0.getClientID();
        String topic = arg0.getTopicFilter();
//		System.out.println(clientID+"取消订阅了，主题："+topic);
        log.debug(clientID + "取消订阅了，主题：" + topic);
    }



}
