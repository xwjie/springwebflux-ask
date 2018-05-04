package com.imooc;

/**
 * 使用 javap -c StringDemo.class 反编译看字节码
 * @author 晓风轻
 *
 */
public class StringDemo {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    StringDemo demo = new StringDemo();

    demo.setName("晓风轻");

    String s = "我的名字是[" + demo.getName() + "].";
    System.out.println(s);
  }

}
