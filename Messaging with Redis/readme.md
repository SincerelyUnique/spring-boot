## Spring Guides - Messaging with Redis

### 说明

1. 该项目演示了通过redis实现的消息监听的功能；
2. 通过StringRedisTemplate模板实现向redis的chat频道发送一条消息"Hello from Redis!"；
3. 通过Spring的RedisMessageListenerContainer容器监听chat频道所发送的消息，当消息到达时，调用Receiver类中receiveMessage方法打印该条消息；
4. 在chat频道添加3条消息，发送的次序和接收次序不一致，先发a消息，不一定先打印a消息；

### 参考

http://www.runoob.com/redis/redis-install.html（redis安装及启动教程）