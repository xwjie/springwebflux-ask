package com.imooc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
  }

}
