package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink04_TransForm_KeyBy {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(3);
        // 奇数分一组, 偶数分一组
        env
          .fromElements(10, 3, 5, 9, 20, 8)
          .keyBy(new KeySelector<Integer, ArrayList>() {
              @Override
              public ArrayList getKey(Integer value) throws Exception {
                  return new ArrayList();
              }
          })
          .print();

        /*env
          .fromElements(10, 3, 5, 9, 20, 8)
          .keyBy(value -> value % 2 == 0 ? "偶数" : "奇数")
          .print();*/

        env.execute();

    }

    public static class User{

    }

}


