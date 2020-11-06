package com.star.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @Author: StarC
 * @Date: 2020/6/4 13:47
 * @Description:
 */
public class ConsumerStart {

     static class KafkaConsumerThread extends Thread{

        private KafkaConsumer<String,String> kafkaConsumer;
        private ExecutorService service;
        private int threadNums;
         ConcurrentHashMap<TopicPartition, OffsetAndMetadata>offsets;

        public KafkaConsumerThread(Properties pros,String topic, int threadNums){
            kafkaConsumer = new KafkaConsumer<String, String>(pros);
            kafkaConsumer.subscribe(Collections.singletonList(topic));
            this.threadNums = threadNums;
            service = new ThreadPoolExecutor(threadNums,threadNums,0L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(1000),new ThreadPoolExecutor.CallerRunsPolicy());
            offsets = new ConcurrentHashMap<>();
        }

        @Override
        public void run() {
            try {
                while(true){
                    ConsumerRecords<String,String> records = kafkaConsumer.poll(Duration.ofMillis(100));
                    if(!records.isEmpty()){
                        service.submit(new recordHandler(records,offsets));
                        if(!offsets.isEmpty()){
                            kafkaConsumer.commitSync(offsets);
                            offsets.clear();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                kafkaConsumer.close();
            }
        }
    }

     static class recordHandler extends Thread{
         private final ConsumerRecords<String,String> records ;
         ConcurrentHashMap<TopicPartition, OffsetAndMetadata>offsets;
         public recordHandler(ConsumerRecords<String,String> consumer, ConcurrentHashMap<TopicPartition, OffsetAndMetadata>offsets ){
             this.records = consumer;
             this.offsets = offsets;
         }

         @Override
         public void run() {

             for(TopicPartition tp:records.partitions()){
                 List<ConsumerRecord<String,String>> tpRecords = records.records(tp);
                 //处理Records,
                 long lastConsumerOffset = tpRecords.get(tpRecords.size()-1).offset();
                 if(!offsets.containsKey(tp)){
                     offsets.put(tp,new OffsetAndMetadata(lastConsumerOffset+1));
                 }else{
                     long position = offsets.get(tp).offset();
                     if(position < lastConsumerOffset+1){
                         offsets.put(tp,new OffsetAndMetadata(lastConsumerOffset+1));
                     }

                 }
             }
         }
     }
}
