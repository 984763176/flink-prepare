package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink01_TransForm_Map_Lambda {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env
          .fromElements(1, 2, 3, 4, 5)
          .map(ele -> ele * ele)
          .print();

        env.execute();
    }


}
