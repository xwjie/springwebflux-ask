package io.github.xwjie;

import java.util.HashMap;

/**
 * hashmap如果key是自己对象
 * 一般需要覆盖hashcode和equal方法
 *
 * 最重要的是：
 * 1. 对象放进去之后hashcode不能修改，否则找不出啦
 * 2. 即使equals总是false，也能找到！
 *
 * 原因：因为先比较hashcode，然后比较地址==，最后才是equals
 *
 * @author  https://xwjie.github.io/
 */
public class HashMapDemo {

    public static void main(String[] args) {
        // hashcode是int类型，是会重复的。
        System.out.println("BC".hashCode());
        System.out.println("Ab".hashCode());

        User user = new User(1L);

        // 如果map的key是自己定义的对象！
        HashMap<User, String> map = new HashMap<>();

        map.put(user, "放进去的数据");

        System.out.println(map.size());

        System.out.println("值为：" + map.get(user));

        // 如果id改了，导致hashcode改了，再也拿不出来了
        // key还是那个对象，并没有改变
        user.setId(2L);

        System.out.println("值为：" + map.get(user));

        // 所以hashcode要覆盖实现，和指定的关键信息绑定，而且这个字段不能改变
        // 如User对象的id必须加final，否则就是有bug
    }
}
