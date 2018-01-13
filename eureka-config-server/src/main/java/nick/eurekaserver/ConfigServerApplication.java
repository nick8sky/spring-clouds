package nick.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//@EnableDiscoveryClient
@AutoConfigurationPackage
@EnableConfigServer  //启动类添加@EnableConfigServer，激活对配置中心的支持
/**
 * 用于服务注册和发现
 * eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳
 * （因此可以在内存中完成），
 * 在默认情况下erureka server center也是一个eureka server ,必须要指定一个 server
 * fetch-registry: false
 */
public class ConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
