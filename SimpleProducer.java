import java.util.*;
import org.apache.kafka.clients.producer.*;

public class SimpleProducer {
 public static void main(String[] args) {
        String topicName = "SimpleProducerTopic";
        String key = "key1";
        String value = "Value-1";


        Properties props = new Properties();

        //producer object uses this list to connect to kafka cluster
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        //creating kafka producer object
        Producer<String, String> producer = new KafkaProducer <>(props);

        //creating kafka record object
        //List<Header> headers = Arrays.asList(new RecordHeader("header_key", "header_value".getBytes()));
         
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);

        //Adding custom message to kafka message
        record.headers().add("client-id", "2334".getBytes());
        producer.send(record);

    producer.close();

    System.out.println("SimpleProducer Completed.");
}
}
