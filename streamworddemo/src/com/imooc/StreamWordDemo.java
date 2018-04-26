package com.imooc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用stream统计文章单词数
 * 
 * @author 晓风轻
 *
 */
public class StreamWordDemo {

  public static void main(String[] args) throws IOException {
    // 使用try-resource 关闭资源
    try (BufferedReader reader = new BufferedReader(
        new FileReader("webflux.txt"))) {

      long wordCount = reader.lines()
          // trim前后空格(使用方法引用)
          .map(String::trim)
          // 过滤掉空串
          .filter(s -> !s.isEmpty())
          // 把空格隔开的转为数组
          .map(s -> s.split(" "))
          // 得到数组长度
          .mapToInt(array -> array.length)
          // 并行(都是无状态操作)
          .parallel()
          // 求和
          .sum();

      System.out.println("单词数:" + wordCount);
    }

    // 使用try-resource 关闭资源
    try (BufferedReader reader = new BufferedReader(
        new FileReader("webflux.txt"))) {

      Map<String, Long> counts = reader.lines()
          // trim前后空格(使用方法引用)
          .map(String::trim)
          // 过滤掉空串
          .filter(s -> !s.isEmpty())
          // 把空格隔开的转为数组
          .map(s -> s.split(" "))
          // 数组转成流
          .map(array -> Stream.of(array))
          // 拉平
          .flatMap(stream -> stream)
          // 分组
          .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

      System.out.println("单词出现次数:" + counts);

      // 统计信息
      LongSummaryStatistics summaryStatistics = counts.entrySet().stream()
          // 得到次数
          .mapToLong(entry -> entry.getValue())
          // 统计
          .summaryStatistics();

      System.out.println("统计信息:" + summaryStatistics);
    }
  }

}
