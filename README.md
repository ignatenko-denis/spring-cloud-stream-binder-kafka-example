# spring-cloud-stream-binder-kafka-example

See linked project [zerocode-kafka-database](https://github.com/ignatenko-denis/zerocode-kafka-database)

## Kafka quick tutorial
Download and install [Kafka](https://kafka.apache.org/downloads)

```shell
# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

# To test Kafka, just create topic
bin/kafka-topics.sh --create --topic credit_rating --bootstrap-server localhost:9092
# If you got TimeOutException, 
# 1. kill running java-process Kafka 
# 2. or change ports in:
# config/zookeeper.properties property clientPort=2181
# config/server.properties property zookeeper.connect=localhost:2181
# config/server.properties property listeners=PLAINTEXT://localhost:9092

# List kafka topics
bin/kafka-topics.sh --list --zookeeper localhost:2181
# or
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

# Stop the Kafka broker or ZooKeeper with Ctrl-C

# If you also want to delete any data of your local Kafka environment including any events you have created along the way, run the command:
rm -rf /tmp/kafka-logs /tmp/zookeeper
```

Read the events from Kafka topic
```shell
$ bin/kafka-console-consumer.sh --topic credit_rating --from-beginning --bootstrap-server localhost:9092
```
Alternatives, [Offset Explorer (formerly Kafka Tool)](https://www.kafkatool.com/download.html) and [Kafkalytic - IntelliJ IDEs Plugin](https://plugins.jetbrains.com/plugin/11946-kafkalytic)

---
Documentation:
1. [Spring Cloud Stream Binder Kafka on GitHub](https://github.com/spring-cloud/spring-cloud-stream-binder-kafka)
1. [Spring Cloud Stream Reference Documentation](https://docs.spring.io/spring-cloud-stream/docs/3.1.4/reference/html/)

## Kafka SSL configuration in `config/server.properties`
```properties
listeners=PLAINTEXT://localhost:9092,SSL://localhost:9093

# path to truststore
ssl.truststore.location=/Users/sample/your-path/truststore.jks
# truststore password
ssl.truststore.password=sample                                                          
ssl.truststore.type=JKS

# path to keystore
ssl.keystore.location=/Users/sample/your-path/keystore.jks
# keystore password
ssl.keystore.password=sample                                                            
ssl.key.password=sample                                                                 
ssl.keystore.type=JKS

# The list of protocols enabled for SSL connections.
ssl.enabled.protocols=TLSv1.3,TLSv1.2,TLSv1.1,TLSv1
# To enable the broker to authenticate clients (2-way authentication), 
# you must configure all the brokers for client authentication. 
# Configure this to use required rather than requested 
# because misconfigured clients can still connect successfully and this provides a false sense of security.
ssl.client.auth=required
# If you want to enable SSL for inter-broker communication, 
# add the following to the broker properties file, which defaults to PLAINTEXT:
security.inter.broker.protocol=PLAINTEXT                                                
```