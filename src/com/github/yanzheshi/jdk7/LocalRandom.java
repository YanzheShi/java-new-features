package com.github.yanzheshi.jdk7;

import java.util.Random;

/**
 * @author shiyanzhe
 * @date 2019/1/24
 */
public class LocalRandom {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        System.out.println(random.nextInt(1));

/*        for (int i = 0; i < 100; i++) {
            int randomInt = random.nextInt(10);
            System.out.println(randomInt);

        }*/
    }
}
