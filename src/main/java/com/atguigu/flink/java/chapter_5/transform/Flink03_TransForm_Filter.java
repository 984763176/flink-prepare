package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink03_TransForm_Filter {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(1);
        // 保留偶数, 舍弃奇数
        /*env
          .fromElements(10, 3, 5, 9, 20, 8)
          .filter(new FilterFunction<Integer>() {
              @Override
              public boolean filter(Integer value) throws Exception {
                  return value % 2 == 0;
              }
          })
          .print();*/
        env
          .fromElements(10, 3, 5, 9, 20, 8)
          .filter(value -> value % 2 == 0)
          .print();


        env.execute();
    }


}
