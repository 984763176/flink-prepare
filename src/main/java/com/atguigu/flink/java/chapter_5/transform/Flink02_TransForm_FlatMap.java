package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink02_TransForm_FlatMap {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(1);
        // 新的流存储每个元素的平方和3次方
        /*env
          .fromElements(1, 2, 3, 4, 5)
          .flatMap(new FlatMapFunction<Integer, Integer>() {
              @Override
              public void flatMap(Integer value, Collector<Integer> out) throws Exception {
                  out.collect(value * value);
                  out.collect(value * value * value);
              }
          })
          .print();*/
        env
          .fromElements(1, 2, 3, 4, 5)
          .flatMap((Integer value, Collector<Integer> out) -> {
              out.collect(value * value);
              out.collect(value * value * value);
          }).returns(Types.INT)
          .print();


        env.execute();
    }


}
