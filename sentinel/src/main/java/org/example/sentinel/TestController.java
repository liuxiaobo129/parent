package org.example.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class TestController {
    @SentinelResource("testResource")
    @GetMapping("/test")
    public String test() {
        System.out.println("testResource");
        return "Hello, Sentinel!";
    }


    public static void main(String[] args) {

    }
}


class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(nums);
    }




    public static void find(int term, int index,int[] nums,AtomicBoolean flag){
        for(int j = 1; j <= term; j++){
            if(index + j == nums.length-1){
                flag.set(true);
            }
            if (index + j <= nums.length-1){
                find(nums[index + j],index + j,nums,flag);
            }
        }
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

 class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1!= null || l2!= null) {
            int x = (l1!= null)? l1.val : 0;
            int y = (l2!= null)? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1!= null) {
                l1 = l1.next;
            }
            if (l2!= null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 构建第一个链表，例如表示数字 342（逆序存储）
        ListNode l1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(9);
        ListNode node6 = new ListNode(9);

        l1.next = node2;
        node2.next = node3;
        node3.next = node6;

        // 构建第二个链表，例如表示数字 465（逆序存储）
        ListNode l2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        ListNode node7 = new ListNode(9);

        l2.next = node4;
        node4.next = node5;
        node5.next = node7;

        ListNode result = addTwoNumbers(l1, l2);

        // 输出结果链表，以验证结果
        while (result!= null) {
            System.out.print(result.val);
            result = result.next;
        }
        ListNode head = new ListNode(2);
        ListNode pre = null ;
        ListNode current  = head;

        while(current != null){
            ListNode next =  current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

    }
}





