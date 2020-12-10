package com.atguigu.flink.java.chapter_5.transform;

import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author lizhenchao@atguigu.cn
 * @Date 2020/12/10 7:17
 */
public class Flink07_TransForm_Connect {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> intStream = env.fromElements(1, 2, 3, 4, 5);
        DataStreamSource<String> stringStream = env.fromElements("a", "b", "c");
        // 把两个流连接在一起: 貌合神离
        ConnectedStreams<Integer, String> cs = intStream.connect(stringStream);
        cs.getFirstInput().print("first");
        cs.getSecondInput().print("second");
        env.execute();

    }


}


