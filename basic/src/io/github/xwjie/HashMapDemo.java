package io.github.xwjie;

import java.util.HashMap;

/**
 * hashmap如果key是自己对象
 * 需要覆盖hashcode和equal方法
 *
 * 最重要的是：对象放进去之后hashcode不能修改，否则找不出啦
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

        System.out.println("值为：" + map.get(user));

        // 如果id改了，导致hashcode改了，再也拿不出来了
        // key还是那个对象，并没有改变
        user.setId(2L);

        System.out.println("值为：" + map.get(user));

        // 所以hashcode要覆盖实现，和制定的关键信息绑定，而且这个字段不能改表
        // 如User对象的id必须加final，否则就是有bug
    }
}
