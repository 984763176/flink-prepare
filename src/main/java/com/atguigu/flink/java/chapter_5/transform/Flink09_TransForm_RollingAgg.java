package com.atguigu.flink.java.chapter_5.transform;

import com.atguigu.flink.java.chapter_5.WaterSensor;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink09_TransForm_RollingAgg {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(2);
        /*DataStreamSource<Integer> stream = env.fromElements(1, 2, 3, 4, 5);
        KeyedStream<Integer, String> kbStream = stream.keyBy(ele -> ele % 2 == 0 ? "奇数" : "偶数");
        kbStream.sum(0).print("sum");
        kbStream.max(0).print("max");
        kbStream.min(0).print("min");*/

        ArrayList<WaterSensor> waterSensors = new ArrayList<>();
        waterSensors.add(new WaterSensor("sensor_1", 1607527992000L, 20));
        waterSensors.add(new WaterSensor("sensor_1", 1607527994000L, 50));
        waterSensors.add(new WaterSensor("sensor_1", 1607527996000L, 50));
        waterSensors.add(new WaterSensor("sensor_2", 1607527993000L, 10));
        waterSensors.add(new WaterSensor("sensor_2", 1607527995000L, 30));

        KeyedStream<WaterSensor, String> kbStream = env
          .fromCollection(waterSensors)
          .keyBy(WaterSensor::getId);

        kbStream
          .maxBy("vc", false)
          .print("max...");

        env.execute();

    }


}



