package org.example.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") Long id) {
        // 这里可以根据id从数据库或者其他数据源获取用户信息
        System.out.println("test");
        return "test";
    }



    @GetMapping("/users2/{id}")
    public String getUser2(@PathVariable("id") Long id) {
        // 这里可以根据id从数据库或者其他数据源获取用户信息

        return "test2";
    }

}




 class PermutationGenerator {

    /**
     * 生成给定数组的所有全排列
     *
     * @param nums 输入的整数数组
     * @return 包含所有全排列的列表，每个全排列是一个整数列表
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 开始回溯过程
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    /**
     * 回溯函数，用于生成全排列
     *
     * @param result    存储所有全排列结果的列表
     * @param tempList  当前正在构建的全排列列表
     * @param nums      原始的整数数组
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // 当当前构建的列表长度等于原始数组长度时，说明已经生成了一个完整的全排列
        if (tempList.size() == nums.length) {
            // 将当前完整的全排列添加到结果列表中，注意要创建一个新的列表副本，避免后续修改影响结果
            result.add(new ArrayList<>(tempList));
            return;
        }

        // 遍历原始数组中的每个元素
        for (int num : nums) {
            // 如果当前正在构建的列表中还没有包含该元素
            if (!tempList.contains(num)) {
                // 将该元素添加到当前构建的列表中
                tempList.add(num);
                // 递归调用回溯函数，继续构建下一层的全排列
                backtrack(result, tempList, nums);
                // 回溯：将刚刚添加的元素从当前构建的列表中移除，以便尝试其他可能的排列
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationGenerator generator = new PermutationGenerator();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = generator.permute(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}