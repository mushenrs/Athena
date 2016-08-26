package me.mushen.athena.java.test;

import java.util.Arrays;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class ArrayExample {

    public static void main(String[] args){
        duplicateItemOfOrderArray();
        int[] array = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(array));
        int lastItem = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastItem;
        System.out.println(Arrays.toString(array));
    }

    private static void duplicateItemOfOrderArray(){
        int[] array = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9, 10};
        // 变动过程。空间复杂度为O(1); 时间复杂度为O(N + M^2), 其中N是数组的长度,M是重复数字的数量
//        [1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9, 10]
//        [1, 2, 3, 2, 2, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9, 10]
//        [1, 2, 3, 4, 2, 2, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9, 10]
//        [1, 2, 3, 4, 5, 2, 2, 5, 5, 6, 6, 7, 8, 9, 9, 9, 10]
//        [1, 2, 3, 4, 5, 6, 2, 2, 5, 5, 6, 7, 8, 9, 9, 9, 10]
//        [1, 2, 3, 4, 5, 6, 7, 2, 2, 5, 5, 6, 8, 9, 9, 9, 10]
//        [1, 2, 3, 4, 5, 6, 7, 8, 2, 2, 5, 5, 6, 9, 9, 9, 10]
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 2, 5, 5, 6, 9, 9, 10]
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 2, 5, 5, 6, 9, 9]
        System.out.println("Before: " + Arrays.toString(array));
        // 重复数字的数量
        int duplicateItems = 0;
        for(int index = 1; index < array.length; index++){
            if(duplicateItems == 0 || array[index] < array[index - 1]){
                // 当前索引与重复数字的数量之和等于数组的长度, 则无需处理
                if(index + duplicateItems == array.length){
                    break;
                }
                // 判断当前索引的前一个数字与N的重复数字的数量的索引对应的数字是否相等
                while(array[index - 1] == array[index + duplicateItems]){
                    duplicateItems++;
                    if(index + duplicateItems == array.length){
                        break;
                    }
                }
                // 将重复的数字断往后移动
                int item = array[index + duplicateItems];
                System.arraycopy(array, index, array, index + 1, duplicateItems);
                array[index] = item;
            }
        }
        System.out.println("After: " + Arrays.toString(array));
    }
}
