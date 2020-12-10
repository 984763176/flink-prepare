package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Collections;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink06_TransForm_Split {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(3);
        // 奇数一个流, 偶数一个流
        SplitStream<Integer> splitStream = env
          .fromElements(10, 3, 5, 9, 20, 8)
          .split(value -> value % 2 == 0
            ? Collections.singletonList("偶数")
            : Collections.singletonList("奇数"));
        splitStream
          .select("偶数")
          .print("偶数");

        splitStream
          .select("奇数")
          .print("奇数");
        env.execute();

    }


}


