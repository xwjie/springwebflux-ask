package com.imooc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 回答学员问题，使用stream统计文件数
 * 
 * @author 晓风轻
 *
 */
public class StreamDemo2 {

  public static void main(String[] args) throws IOException {
    // walk已经递归了
    // Files.walk(Paths.get(".")).forEach(System.out::println);

    // 使用try-resource 关闭资源
    try (Stream<Path> paths = Files.walk(Paths.get("."))) {

      Map<String, Long> fileCount = paths
          // 过滤掉目录
          .filter(Files::isRegularFile)
          // 得到path的文件名
          .map(p -> p.toFile().getName())
          // 分组
          .collect(Collectors.groupingBy(
              // 得到后缀
              StreamDemo2::getFileExt, Collectors.counting()));

      System.out.println("文件类型:" + fileCount);
    }
  }

  /**
   * 得到文件后缀
   * 
   * @param name
   * @return
   */
  public static String getFileExt(String name) {
    // System.out.println(name);
    int index = name.lastIndexOf('.');

    if (index < 0) {
      return "";
    }

    return name.substring(index + 1);
  }

}
