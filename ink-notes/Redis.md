# Data sousrce
[Redis Cloud Console (redislabs.com)](https://app.redislabs.com/#/subscriptions/subscription/2241112/bdb-view/12110932/configuration)
# Guides
[Redis Extension Reference Guide - Quarkus](https://quarkus.io/guides/redis-reference)
[Java guide | Redis](https://redis.io/docs/connect/clients/java/)

# Connect java
```
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:NW6Y2UUqhIS43CNO7LjlZNOeMP7W8Wts@redis-17838.c327.europe-west1-2.gce.cloud.redislabs.com:17838");
        Connection connection = jedis.getConnection();
    }
}
```