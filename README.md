# Spring Cloud


<center>
    <font face="Kristen ITC" color="#555555" size=3>💤 Khighness 💤</font><br>
</center>



## 💬 微服务序言



### 🚀 微服务架构概述

​		微服务架构时一种架构模式，它提倡将单一应用程序划分成一组小的服务，服务之间互相协调、互相配合，为哟过户提供最终价值。每个服务运行在其独立的进程中，服务与服务间采用轻量级的通信机制互相协作（通常是基于HTTP协议的Restful API）。每个服务都围绕着具体业务进行构建，并且能够别独立的部署到生产环境、类生产环境等。另外，应该尽量避免同一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具进行构建。



### ☁️ Spring Cloud简介

Spring Cloud = 分布式微服务架构的一站式解决方案。

> 分布式微服务

- 服务注册与发现
- 服务调用
- 服务熔断
- 负载均衡
- 服务降级
- 服务消息队列
- 配置中心管理
- 服务网关
- 服务监控
- 全链路追踪
- 自动化构建部署
- 服务定时任务调度操作

![image-20201125150829563](SpringCloud/image-20201125150829563.png)



> Cloud升级

![CloudUpgrade](SpringCloud/CloudUpgrade.jpg)



### 🏳️‍🌈 版本选型

> 官网限定：https://spring.io/projects/spring-cloud

截止 2020-11-25

| Spring Cloud Version                                         | Spring Boot Version              |
| :----------------------------------------------------------- | :------------------------------- |
| 2020.0.x aka Ilford                                          | 2.4.x                            |
| [Hoxton](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Hoxton-Release-Notes) | 2.2.x, 2.3.x (Starting with SR5) |
| [Greenwich](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Greenwich-Release-Notes) | 2.1.x                            |
| [Finchley](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Finchley-Release-Notes) | 2.0.x                            |
| [Edgware](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Edgware-Release-Notes) | 1.5.x                            |
| [Dalston](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Dalston-Release-Notes) | 1.5.x                            |



> 具体限定：https://start.spring.io/actuator/info

截止 2020-11-25

```json
    "spring-cloud": {
      "Finchley.M2": "Spring Boot >=2.0.0.M3 and <2.0.0.M5",
      "Finchley.M3": "Spring Boot >=2.0.0.M5 and <=2.0.0.M5",
      "Finchley.M4": "Spring Boot >=2.0.0.M6 and <=2.0.0.M6",
      "Finchley.M5": "Spring Boot >=2.0.0.M7 and <=2.0.0.M7",
      "Finchley.M6": "Spring Boot >=2.0.0.RC1 and <=2.0.0.RC1",
      "Finchley.M7": "Spring Boot >=2.0.0.RC2 and <=2.0.0.RC2",
      "Finchley.M9": "Spring Boot >=2.0.0.RELEASE and <=2.0.0.RELEASE",
      "Finchley.RC1": "Spring Boot >=2.0.1.RELEASE and <2.0.2.RELEASE",
      "Finchley.RC2": "Spring Boot >=2.0.2.RELEASE and <2.0.3.RELEASE",
      "Finchley.SR4": "Spring Boot >=2.0.3.RELEASE and <2.0.999.BUILD-SNAPSHOT",
      "Finchley.BUILD-SNAPSHOT": "Spring Boot >=2.0.999.BUILD-SNAPSHOT and <2.1.0.M3",
      "Greenwich.M1": "Spring Boot >=2.1.0.M3 and <2.1.0.RELEASE",
      "Greenwich.SR6": "Spring Boot >=2.1.0.RELEASE and <2.1.999.BUILD-SNAPSHOT",
      "Greenwich.BUILD-SNAPSHOT": "Spring Boot >=2.1.999.BUILD-SNAPSHOT and <2.2.0.M4",
      "Hoxton.SR9": "Spring Boot >=2.2.0.M4 and <2.3.7.BUILD-SNAPSHOT",
      "Hoxton.BUILD-SNAPSHOT": "Spring Boot >=2.3.7.BUILD-SNAPSHOT and <2.4.0.M1",
      "2020.0.0-M3": "Spring Boot >=2.4.0.M1 and <=2.4.0.M1",
      "2020.0.0-M4": "Spring Boot >=2.4.0.M2 and <=2.4.0-M3",
      "2020.0.0-M5": "Spring Boot >=2.4.0.M4 and <2.4.1-SNAPSHOT",
      "2020.0.0-SNAPSHOT": "Spring Boot >=2.4.1-SNAPSHOT"
    },
    "spring-cloud-alibaba": {
      "2.2.1.RELEASE": "Spring Boot >=2.2.0.RELEASE and <2.3.0.M1"
    },
```



> 技术选型

![VersionSelect](SpringCloud/VersionSelect.jpg)



```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>top.parak.springcloud</groupId>
  <artifactId>cloud2020</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <developers>
    <developer>
      <name>KHighness</name>
      <email>parakovo@gmail.com</email>
    </developer>
  </developers>

  <modules>
  </modules>

  <!-- Jar Version Management-->
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <java.version>1.8</java.version>
    <junit.version>4.12</junit.version>
    <log4j.version>1.2.17</log4j.version>
    <lombok.version>1.18.16</lombok.version>
    <mysql.version>8.0.20</mysql.version>
    <fastjson.version>1.2.75</fastjson.version>
    <druid.version>1.2.3</druid.version>
    <spring.boot.version>2.2.2.RELEASE</spring.boot.version>
    <spring.cloud.version>Hoxton.SR1</spring.cloud.version>
    <spring.cloud.alibaba.version>2.1.0.RELEASE</spring.cloud.alibaba.version>
    <druid.spring.boot.starter.version>1.2.3</druid.spring.boot.starter.version>
    <mybatis.spring.boot.starter.version>2.1.1</mybatis.spring.boot.starter.version>
    <mybatis-plus.boot.starter.version>3.4.1</mybatis-plus.boot.starter.version>
    <hutool-all.version>5.5.1</hutool-all.version>
  </properties>

  <dependencyManagement>
    <dependencies>

      <!-- Spring Boot -->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>${spring.boot.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

      <!-- Spring Cloud -->
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring.cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

      <!-- Spring Cloud alibaba -->
      <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-alibaba-dependencies</artifactId>
        <version>${spring.cloud.alibaba.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

      <!-- Mysql -->
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
        <scope>runtime</scope>
      </dependency>

      <!-- Druid-->
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>${druid.version}</version>
      </dependency>

      <!-- Mybatis Starter -->
      <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis.spring.boot.starter.version}</version>
      </dependency>

      <!-- Druid Starter -->
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>${druid.spring.boot.starter.version}</version>
      </dependency>

      <!-- Junit -->
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
      </dependency>

      <!-- Lombok -->
      <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
        <scope>provided</scope>
      </dependency>

      <!-- Fastjson -->
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>${fastjson.version}</version>
      </dependency>

    </dependencies>
  </dependencyManagement>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <fork>true</fork>
          <addResources>true</addResources>
        </configuration>
      </plugin>
    </plugins>
  </build>

</project>
```



## 💠 服务注册中心



### 🌠 Eureka

> 概述

Github: https://github.com/Netflix/Eureka

Spring Cloud Eureka 是 Spring Cloud Netflix 微服务套件的一部分，基于 Netflix Eureka 做了二次封装，主要负责实现微服务架构中的服务治理功能。Spring Cloud Eureka 是一个基于 REST 的服务，并且提供了基于Java的客户端组件，能够非常方便地将服务注册到 Spring Cloud Eureka 中进行统一管理。



> 服务治理

在传统的RPC远程调用框架中，管理每个服务于服务之间的依赖关系比较复杂，所以需要使用服务治理，管理服务与服务之间的依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。



> 服务注册与发现

Eureka采用了CS的设计架构，Eureka Server作为服务注册功能的服务器，它是服务注册中心，而系统中的其他微服务，使用Eureka的客户端连接到Eureka Server并维持心跳连接。这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正常运行。

在服务注册与发现中心，有一个注册中心，当服务器启动的时候，会把自己服务器的信息比如服务地址、通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地RPC调用RPC远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务于服务之间的一个依赖关系（服务治理概念）。在任何RPC远程框架中，都会有一个注册中心（存放服务地址相关信息（接口地址））。



> Eureka组件：Eureka Server和Eureka Client

1️⃣ Eureka Server提供服务注册服务

各个微服务节点通过配置启动后，会在Eureka Server中进行注册，这样Eureka Server中的服务注册表将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观看到。

2️⃣ Eureka Client通过注册中心进行访问

是一个Java客户端，用于简化Eureka Sever的交互，客户端同时也具备一个内置的、使用轮询负载算法的负载均衡器。在应用启动后，将会在Eureka Server发送心跳(默认周期为30S)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server将会从服务注册表中把这个服务节点移除。



> Eureka的自我保护模式

1️⃣概述

默认情况下，如果Eureka Server在一定时间内没有接收到某个微服务实例的心跳，Eureka Server将会注销该实例（默认90秒）。但是当前网络分区故障发生（延时、卡顿、拥挤）时，微服务与Eureka Server之间无法正常通信，以上行为会变得危险——因为微服务本身是健康的，此时本不应该注销这个微服务。Eureka通过“自我保护模式”来解决这个问题————当Eureka节点在短时间内丢失过多客户端时候，那么这个节点就进入自我保护模式。

2️⃣用途

保护模式主要用于一组Eureka Client和Eureka Server之间存在网络分区场景下的保护。一旦进入保护模式，Eureka Server将会尝试保护其微服务注册表中的信息，不再删除服务注册表中的数据，也就是不会注销任何微服务。使用自我保护模式，可以让Eureka集群更加的健壮、稳定。

3️⃣设计哲学

宁可保护错误的服务注册信息，也不盲目注销任何可能健康的服务实例。

4️⃣关闭自我保护模式

Eureka的自我保护模式默认是开启的，关闭需要配置Eureka Server：

```yml
eureka:
  server:
    # 关闭自我保护模式，对没有心跳的微服务直接杀无赦，保证不可用服务及时踢除
    enable-self-preservation: false 
    # 清理无效节点的时间间隔，默认是60000ms
    eviction-interval-timer-in-ms: 2000
```

重启Eureka Server进入Eureka可视化，可以看到这句话：

```plaintext
THE SELF PRESERVATION MODE IS TURNED OFF. THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
```

配置Eureka Client

```properties
eureka:
  instance:
    # Eureka Client向Eureka Server发送心跳的时间间隔/频率，单位为秒(默认是30S)
    # 在这个时间间隔后，Eureka Server没有收到Eureka client的心跳，将剔除服务
    lease-renewal-interval-in-seconds: 1
    # Eureka Server在收到最后一次心跳后等待时间上限，单位为秒(默认是90S)
    # 超时将剔除服务
    lease-expiration-duration-in-seconds: 2
```

开启微服务并且很快停止，可以看到Eureka Server的日志上1s过期了一个服务，Eureka可视化上注册的服务直接消失



> Eureka停更说明

Eureka 2.x停止更新，Eureka 1.x 在开源社区依然活跃。

[eureka-wiki](https://github.com/Netflix/eureka/wiki)

The existing open source work on eureka 2.0 is discontinued. The code base and artifacts that were released as part of the existing repository of work on the 2.x branch is considered use at your own risk.

Eureka 1.x is a core part of Netflix's service discovery system and is still an active project.



### 💤 ZooKeeper

> 概述

官网: [apache-zookeeper](https://zookeeper.apache.org/)

wiki文档: [wiki-zookeeper](https://cwiki.apache.org/confluence/display/ZOOKEEPER/Index)

ZooKeeper是用于维护配置信息，命名，提供分布式同步以及提供组服务的集中式服务。



> Docker运行Zookeeper

```shell
$ docker pull zookeeper
$ docker run -d -it -p 2181:2181 --name=zoo zookeeper
```



> POM

```xml
<dependencies>
    <!-- SpringBoot整合Zookeeper客户端 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
        <exclusions>
            <!-- 排除自带的zookeeper3.5.3 -->
            <exclusion>
                <groupId>org.apache.zookeeper</groupId>
                <artifactId>zookeeper</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <!-- 添加zookeeper3.4.14 -->
    <dependency>
        <groupId>org.apache.zookeeper</groupId>
        <artifactId>zookeeper</artifactId>
        <version>3.4.14</version>
        <!-- 排除自带的Slf4j -->
        <exclusions>
            <exclusion>
                <artifactId>slf4j-log4j12</artifactId>
                <groupId>org.slf4j</groupId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```



> YML

```yml
server:
  port: 8004
  tomcat:
    uri-encoding: UTF-8

spring:
  application:
    name: cloud-provider-payment
  cloud:
    zookeeper:
      connect-string: 192.168.117.155:2181 # 虚拟机开启或者云服务器开启Zookeeper服务
```



### 💫 Consul

> 概述

官网：[Consul](https://www.consul.io/docs/intro)

入门文档：[spring-cloud-consul](https://www.springcloud.cc/spring-cloud-consul.html)

Consul(Go语言开发)是一种服务网格解决方案，提供具有服务发现，配置和分段功能的全功能控制平面。



> Docker运行Consul

```shell
$ mkdir -p /home/consul/data /home/consul/conf
$ docker run -d --name=con -p 8500:8500  -v /home/consul/conf/:/consul/conf/                   -v /home/consul/data/:/consul/data/ consul
```

Consul有前端可视化界面，此时输入虚拟机IP:8500即可访问。



> POM

```xml
<dependencies>
    <!-- SpringCloud Consul Server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-consul-discovery</artifactId>
    </dependency>
</dependencies>
```



> YML

```yml
server:
  port: 8006
  tomcat:
    uri-encoding: UTF-8

spring:
  application:
    name: consul-provider-payment
  cloud:
    consul:
      host: 192.168.117.155
      port: 8500
      discovery:
        service-name: ${spring.application.name}
        # 开指定启IP地址注册
        prefer-ip-address: true
```



### 🌀 CAP

> CAP原则

在一个分布式系统中：

- C(Consistency): 一致性(All nodes see the same data at the same time)

- A(Availability): 可用性(Reads and writes always succeed)

- P(Partition tolerance): 分区容错性(The system continues to operate despite arbitrary message loss or failure of part of the system)

以上三点只能满足任意两点，不可能三者兼顾。



> 三个注册中心

现在的分布式微服务架构都必须保证P原则

|  组件名   | 语言 | CAP  | 服务健康检查 | 对外暴露接口 | Spring Cloud集成 |
| :-------: | :--: | :--: | :----------: | :----------: | :--------------: |
|  Eureka   | Java |  AP  |   可配支持   |     HTTP     |      已集成      |
|  Consul   |  Go  |  CP  |     支持     |   HTTP/DNS   |      已集成      |
| Zookeeper | Java |  CP  |     支持     |    客户端    |      已集成      |





## 🔱 服务调用



### 🎗Ribbon

> 说明

wiki文档：[wiki-ribbon](https://github.com/Netflix/ribbon/wiki)

Spring Cloud Ribbon是基于Netflix的开源项目，主要功能是提供客户端的软件负载均衡算法和服务调用。

Ribbon客户端组件提供一系列完善的配置项如连接超时、重试等。简单的说，就是在配置文件中列出Load Balancer（简称LB）后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等）去连接这些机器。我们很容易使用Ribbon实现自定义的负载均衡算法。



> LB

Load Balance，负载均衡，将用户请求平摊到多个服务器上，从而达到系统的HA（高可用）。



> 核心组件IRule

![image-20201218194608766](SpringCloud/image-20201218194608766.png)

1️⃣根据特定算法从服务列表中选取一个要访问的服务：

- RoundRobinRule: 轮询(默认)
- RandomRule: 随机
- RetryRule: 先按照RoundRule的策略获取服务，如果服务失败则在指定时间内进行重试，获取可用的服务
- WeightedResponseTimeRule: 对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
- BestAvaiableRule: 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量小的服务
- AvailabilityFilteringRule: 先过滤掉故障实例，再选择并发较小的实例
- ZoneAvoidanceRule: 默认规则，复合判断server所在区域的性能和server的可用性选择服务器

2️⃣自定义算法的规则（官方文档警告）：

自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下，否则自定义的这个配置类就会被所有的Ribbon客户端共享，达不到特殊定制化的目的。

@SpringBootApplication包含三大注解：

- @SpringBootConfiguration

- @EnableAutoConfiguration
- @ComponentScan

因此，自定义配置类不能与SpringbootApplication主启动类放在一个包下。



### 🛑 OpenFeign



> 概述

Feign是一个声明式WebService客户端，使用Feign能让编写Web Service客户端更加简单。使用方法时定义一个服务接口然后在上面添加注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。

Feign旨在使编写Java Http客户端变得更容易。

前期使用Ribbon + RestTemplate时，使用RestTemplate对http请求的封装处理，形成了一套模板化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上来配置它（以前是Dao接口上标注一个Feign注解即可），即可完成对服务提供方的接口绑定，简化了使用Spring Cloud Ribbon时，自动封装服务调用客户端的开发量。

Feign集成了Ribbon。

利用Ribbon维护了Payment的服务列表信息，并且通过轮询实现端的负载均衡，而与Ribbon不同的是，通过Feign不同的是，通过Feign只需要定义服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。



|                            Feign                             |                          OpenFeign                           |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| Feign是SpringCloud组件中的一个轻量级RESTful的HTTP服务客户端。Feign内置了Ribbon，用来做客户端负载均衡，去调用服务注册中心的服务。Feign的使用方法：使用Feign的注解定义接口，调用这个接口，就可以调用服务注册中心的服务。 | OpenFeign是Spring Cloud在Feign的基础上支持了SpringMVC的注解，如@RequestMapping等等。OpenFeign的@FeignClient可以解析SpringMVC的@RequestMapping注解下的接口，并通过动态代理的方式产生实现类，实现类中做负载均衡并调用其他服务。 |
| <dependency>     <groupId>org.springframework.cloud</groupId>     <artifactId>spring-cloud-starter-feign</artifactId> </dependency> | <dependency>     <groupId>org.springframework.cloud</groupId>     <artifactId>spring-cloud-starter-openfeign</artifactId> </dependency> |



> 超时控制

默认Feign客户端只等待1秒钟，但是服务端处理需要超过1秒钟，导致Feign客户端不想等待，直接返回报错。为了避免这样的情况，有时候我们需要设置Feign客户端的超时控制。

```yml
# 设置feign客户端超时时间(Openfeign默认支持ribbon)
ribbon:
  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间
  ReadTimeout: 5000
  # 指的是建立连接后从服务器读取到可用资源所用的时间
  ConnectTimeout: 5000
```



## 🔰 服务降级



服务雪崩

多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C又调用其他的服务器，这就是所谓的“扇出”。如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的“雪崩效应”。

对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。

通常一个模块下的某个实例失败后，这时候这个模块依然还会接收流量，然后这个有问题的模块还调用了其他的模块，这样就会发生级联故障，或者叫雪崩。



### ⚡ Hystrix

> 说明

Github: https://github.com/Netflix/Hystrix

Hystrix不再主动开发，并且当前处于维护模式。

Hystrix（1.5.18版）足够稳定，可以满足Netflix现有应用程序的需求。



> 概述

在分布式环境中，不可避免地会有许多服务依赖项中的某些失败。Hystrix是一个库，可通过添加延迟公差和容错逻辑来帮助您控制这些分布式服务之间的交互。Hystrix通过隔离服务之间的访问点，停止服务之间的级联故障并提供后备选项来实现此目的，以提高系统的整体弹性。

“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的、可处理的备选响应（Fallback），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。



> 作用

- 提供保护并控制延迟和失败，以及通过第三方客户端库访问的依赖项的失败
- 停止复杂的分布式系统中的级联故障
- 快速失败并快速修复
- 回退并在可能的情况下正常降级
- 启用实时监视、警报和操作控制



> 并发场景

1️⃣并发场景及解决要求

- 超时导致服务器变慢（转圈）=> 超时不再等待
- 出错（宕机或程序运行出错）=> 出错要有兜底

2️⃣解决方案

- 服务提供者超时，服务调用者不能一直卡死等待，必须有服务降级
- 服务提供者宕机，服务调用者不能一直卡死等待，必须有服务降级
- 服务提供者正常，服务调用者自己出故障或有自我要求（自己的等待时间小于服务时间），



> 服务降级

1️⃣概念

当服务器压力剧增的情况下，根据当前业务情况及流量对一些服务和页面有策略的降级，以此释放服务器资源以保证核心任务的正常运行。

服务器忙，请稍后再试，不让客户端等待并立刻返回一个友好提示。

2️⃣触发

- 程序运行异常
- 超时
- 服务熔断
- 线程池/信号量打满

3️⃣解决

降级配置：

服务提供者设置自身调用超时时间的峰值，峰值内可以正常运行；

超过了需要有兜底的方法处理，作服务降级fallback。



> 服务熔断

1️⃣熔断机制

熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个为副护出错不可用或者相响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回错误的响应信息。

当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回”错误”的响应信息。当检测到该节点微服务响应正常后恢复调用链路。

2️⃣断路器

断路器的三个重要参数：

- 快照时间窗：断路器确定是否打开需要统计一下请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒。
- 请求总数阈值：在快照时间窗内，必须满足请求总数阈值才有资格熔断。默认为20，意味着在10秒内，如果在hystrix命令的调用次数不足20次，即使所有的请z求都超时或其他原因失败，断路器都不会打开。
- 错误百分比阈值：当请求总数在快照时间窗内超过了阈值，比如发生了30次调用，如果在这30次调用中，有15次发生了超时异常，也就是超过50%的错误百分比，在默认设定50%阈值情况下，这时候就会将断路器打开。

开启或者关闭的条件：

- 当满足一定的阈值的时候（默认10秒内超过20哥请求次数）
- 当失败率达到一定的时候（默认10秒内超过50%的请求失败）
- 到达以上阈值，断路器将会开启
- 当开启的时候，所有请求都不会进行转发
- 一段时间之后（默认是5秒），这个时候断路器是半开状态，会让其中一个请求进行转发。如果成功，断路器会关闭，若失败，继续开启。重复4和5。

断路器打开之后：

- 再有请求调用的时候，将不会调用主逻辑，而是直接调用降级fallback，通过断路器，实现了自动地发现错误并将降级逻辑切换为主逻辑，减少响应延迟的效果。
- 恢复原来的主逻辑：
  - 对于这一问题，hystrix也为我们实现了自动恢复功能。
  - 当断路器打开，对主逻辑进行熔断之后，hystrix会启动一个休眠时间窗，在这个时间窗内，降级逻辑是临时的成为主逻辑，当休眠时间窗到期，断路器将进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么断路器将继续闭合，主逻辑恢复，如果这次请求依然有问题，断路器继续进入打开状态，休眠时间窗重新计时。



> Dashboard监控

Hystrix提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地记录所有通过Hystrix发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求成功、多少失败等。Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控。Spring Cloud夜提供了Hystrix Dashboard的整合，对监控内容转换成可视化界面。



> POM

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```

> YML

```yml
server:
  port: 9001

spring:
  application:
    name: cloud-consumer-hystrix-dashboard

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka
  instance:
    # 使用IP注册进Eureka Server
    prefer-ip-address: true
```

> Main

```java
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001Application.class, args);
    }
}
```

输入http://localhost:8001/hystrix.stream即可进行监控：

![image-20210119232242203](SpringCloud/image-20210119232242203.png)

