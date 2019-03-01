package com.lingjuan;

import com.lingjuan.utils.GsonUtil;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        System.out.println("==="+ GsonUtil.GsonString(set));
    }



}