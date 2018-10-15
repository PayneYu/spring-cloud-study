package com.payne.study.listener;

import com.netflix.appinfo.InstanceInfo;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: Huizhe Yu
 * @create: 2018-10-15 09:12
 */
@Component
public class EurekaStateChangeListener {

  private static Logger LOG = LoggerFactory.getLogger(EurekaStateChangeListener.class);

  /**
   * 服务下线事件
   * @param event
   */
  @EventListener
  public void listen(EurekaInstanceCanceledEvent event) {
    String appName = event.getAppName();
    String serverId = event.getServerId();
    String message = LocalDateTime.now() + ":" + appName + ":" + serverId;
    LOG.info("服务下线事件>"+message);
  }

  /**
   * 服务注册事件
   * @param event
   */
  @EventListener
  public void listen(EurekaInstanceRegisteredEvent event) {
    InstanceInfo instanceInfo = event.getInstanceInfo();
    String appName = instanceInfo.getAppName();
    String serverId = instanceInfo.getInstanceId();
    String message = LocalDateTime.now() + ":" + appName + ":" + serverId;
    LOG.info("服务注册事件>"+message);
  }

  /**
   * 服务续约事件
   * @param event
   */
  @EventListener
  public void listen(EurekaInstanceRenewedEvent event) {
    String appName = event.getAppName();
    String serverId = event.getServerId();
    String message = LocalDateTime.now() + ":" + appName + ":" + serverId;
    LOG.info("服务续约事件>"+message);
  }

  /**
   * 注册中心启动事件
   * @param event
   */
  @EventListener
  public void listen(EurekaRegistryAvailableEvent event) {
    LOG.info("注册中心启动事件");
  }

  /**
   * 启动事件
   * @param event
   */
  @EventListener
  public void listen(EurekaServerStartedEvent event) {
    LOG.info("注册中心Started事件");
  }

}
