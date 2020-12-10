package com.atguigu.flink.java.chapter_5.transform;

import com.atguigu.flink.java.chapter_5.WaterSensor;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink10_TransForm_Process {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(2);

        ArrayList<WaterSensor> waterSensors = new ArrayList<>();
        waterSensors.add(new WaterSensor("sensor_1", 1607527992000L, 20));
        waterSensors.add(new WaterSensor("sensor_1", 1607527994000L, 50));
        waterSensors.add(new WaterSensor("sensor_1", 1607527996000L, 50));
        waterSensors.add(new WaterSensor("sensor_2", 1607527993000L, 10));
        waterSensors.add(new WaterSensor("sensor_2", 1607527995000L, 30));

        /*env
          .fromCollection(waterSensors)
          .process(new ProcessFunction<WaterSensor, Tuple2<String, Integer>>() {
              @Override
              public void processElement(WaterSensor value,
                                         Context ctx,
                                         Collector<Tuple2<String, Integer>> out) throws Exception {
                  out.collect(new Tuple2<>(value.getId(), value.getVc()));
              }
          })
          .print();*/
        /*env
          .fromCollection(waterSensors)
          .keyBy(WaterSensor::getId)
          .process(new KeyedProcessFunction<String, WaterSensor, Tuple2<String, Integer>>() {
              @Override
              public void processElement(WaterSensor value, Context ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
                  out.collect(new Tuple2<>("key是:" + ctx.getCurrentKey(), value.getVc()));
              }
          })
          .print();*/
        env.execute();
    }
}



