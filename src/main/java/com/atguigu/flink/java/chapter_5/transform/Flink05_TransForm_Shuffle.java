package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink05_TransForm_Shuffle {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment().setParallelism(3);
        // 奇数分一组, 偶数分一组
        env
          .fromElements(10, 3, 5, 9, 20, 8)
          .shuffle();
        env.execute();

    }


}


