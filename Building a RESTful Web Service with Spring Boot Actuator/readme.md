## Spring Guides - Building a RESTful Web Service with Spring Boot Actuator

### 说明

1. Spring Boot Actuator是Spring Boot的一个子项目，这里通过其构建一个生产级别的Rest服务；

2. 启动服务后，可以打开XShell客户端，输入如下指令（10.1.61.91是我的ip，可以改成自己的-ipconfig），可以看到返回404，因为现在是空服务，服务器无法找到资源；

```
[root@oadev ~]# curl 10.1.61.91:8080
{"timestamp":"2018-04-11T02:17:36.281+0000","status":404,"error":"Not Found","message":"No message available","path":"/"}
```

3. 健康检测

```
[root@oadev ~]# curl 10.1.61.91:8080/actuator/health
{"status":"UP"}
```

4. 返回数据

```
[root@oadev ~]# curl 10.1.61.91:8080/hello-world
{"id":1,"content":"Hello, Stranger!"} 
[root@oadev ~]# curl 10.1.61.91:8080/hello-world?name=jalen
{"id":2,"content":"Hello, jalen!"}
```

5. 修改配置文件，添加

```
server.port: 9000
management.server.port: 9001
management.server.address: 127.0.0.1
```

重启后，打开XShell调用，此时执行8080端口会无法连接,访问9000端口正常

```
[root@oadev ~]# curl 10.1.61.91:8080/hello-world
curl: (7) couldn't connect to host
```

```
[root@oadev ~]# curl 10.1.61.91:9000/hello-world
{"id":1,"content":"Hello, Stranger!"}
```

```
[root@oadev ~]# curl 10.1.61.91:9000/hello-world?name=jalen
{"id":2,"content":"Hello, jalen!"}
```

6. 关闭服务器，启动测试类，测试通过；

### 参考

https://spring.io/guides/gs/actuator-service/ （Spring Guides）

https://github.com/spring-guides/gs-actuator-service （Source Code）

