package com.atguigu.flink.java.chapter_5.sink;

import com.alibaba.fastjson.JSON;
import com.atguigu.flink.java.chapter_5.WaterSensor;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.ArrayList;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 14:46
 */
public class Flink01_Sink_Kafka {
    public static void main(String[] args) throws Exception {
        ArrayList<WaterSensor> waterSensors = new ArrayList<>();
        waterSensors.add(new WaterSensor("sensor_1", 1607527992000L, 20));
        waterSensors.add(new WaterSensor("sensor_1", 1607527994000L, 50));
        waterSensors.add(new WaterSensor("sensor_1", 1607527996000L, 50));
        waterSensors.add(new WaterSensor("sensor_2", 1607527993000L, 10));
        waterSensors.add(new WaterSensor("sensor_2", 1607527995000L, 30));

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(1);
        env
          .fromCollection(waterSensors)
          .map(JSON::toJSONString)
          .addSink(new FlinkKafkaProducer<String>("hadoop102:9092", "topic_sensor", new SimpleStringSchema()));


        env.execute();
    }
}
