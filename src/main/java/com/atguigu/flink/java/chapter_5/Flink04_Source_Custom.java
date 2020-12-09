package com.atguigu.flink.java.chapter_5;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/8 22:44
 */
public class Flink04_Source_Custom {
    public static void main(String[] args) throws Exception {



        // 1. 创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        env.execute();
    }

    public static class MySource implements SourceFunction<WaterSensor> {

        @Override
        public void run(SourceContext<WaterSensor> ctx) throws Exception {

        }

        @Override
        public void cancel() {

        }
    }
}
