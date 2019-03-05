package com.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Auther: admin
 * @Date: 2018/8/21 09:22
 * @Description:
 */
@Service
@Slf4j
public class SuanFaServiceImpl {
    private char[] reverse(char[] chars, int start, int end) {
        // str 判断null， 索引有效值判断
        if (chars == null || start < 0 || end >= chars.length || start >= end) {
            return chars;
        }

        while (start < end) {
            // 收尾字符互换，直到替换完成。
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }

    public void test() {
        log.info("翻转：" + solution1_0("hello world"));
        log.info(solution1_1("hello world"));
    }

    public String solution1_0(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        int length = sentence.length();
        // 第一步翻转所有字符
        char[] chars = reverse(sentence.toCharArray(), 0, length - 1);
        log.info(new String(chars));
        System.out.println(new String(chars));

        // 第二步翻转每个单词（重点：怎么找到单词）
        int start = 0, end = 0;
        while (start < length) {
            if (chars[start] == ' ') {
                // 遇到空格就向右边继续查找
                start++;
                end++;
            } else if (end == length || chars[end] == ' ') {
                // 遇到空格或者已经到了字符串末尾，此时翻转找到的单词内部字符，这里需要注意end-1
                chars = reverse(chars, start, end - 1);
                System.out.println(new String(chars));
                // 重新制定检查索引start
                start = end++;
            } else {
                // end加1，为了检查单词是否结束
                end++;
            }
        }
        return new String(chars);
    }

    public String solution1_1(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        // 去掉字符串收尾的空格
        sentence = trim(sentence);
        int len = sentence.length();
        char[] chars = sentence.toCharArray();
        int count = getSpaceCount(sentence);
        int newLen = 2 * count + len;
        // 扩容，内部使用System.arraycopy 方法实现。
        chars = Arrays.copyOf(chars, newLen);

        int index = len - 1;
        int newIndex = newLen - 1;
        while (index >= 0 && newIndex > index) {
            if (chars[index] == ' ') {
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
            } else {
                chars[newIndex--] = chars[index];
            }
            index--;
        }

        return new String(chars);
    }

    /**
     * 剔除字符串收尾的空格
     *
     * @param origin
     * @return
     */
    private String trim(String origin) {
        char[] chars = origin.toCharArray();
        int length = chars.length;
        int st = 0;
        while (st < length && chars[st] == ' ') {
            st++;
        }

        while (st < length && chars[length - 1] == ' ') {
            length--;
        }

        // 如果收尾有空格，就截取生成新的字符串
        if (st > 0 || length < chars.length) {
            origin = new String(chars, st, (length - st));
        }
        return origin;
    }

    private int getSpaceCount(String sentence) {
        char[] chars = sentence.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        return count;
    }

    //////////////2
    private int[] v2_0_solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int st = 0;
        int end = nums.length - 1;

        while (st < end) {
            // find even number
            if (isOdd(nums[st])) {
                st++;// 奇数，索引右移
            } else if (!isOdd(nums[end])) {
                end--;// 偶数，索引左移
            } else {
                // 奇偶数互换
                int temp = nums[st];
                nums[st] = nums[end];
                nums[end] = temp;
                st++;
                end--;
            }
        }
        return nums;
    }

    // 与1做按位运算，不为0就是奇数，反之为偶数
    private boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    private int[] v2_1_solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int st = 0;
        int evenCount = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!isOdd(nums[i])) {
                evenCount += 1;
                temp[evenCount - 1] = nums[i];
            } else {
                if (st < i) {
                    // 将奇数依次放在原数组前面
                    nums[st] = nums[i];
                }
                st++;
            }
        }

        if (evenCount > 0) {
            for (int i = st; i < nums.length; i++) {
                nums[i] = temp[i - st];
            }
        }
        return nums;
    }

}
