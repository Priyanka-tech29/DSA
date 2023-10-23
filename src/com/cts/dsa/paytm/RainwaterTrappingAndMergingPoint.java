/*In Problem 1, we first find the lengths of both linked lists, adjust the pointers for the longer list, 
and then traverse them together until we find the common merging point.
In Problem 2, we use two pointers to track the left and right boundaries. We also keep track of 
leftMax and rightMax values. As we iterate through the array, we calculate the trapped water by comparing 
the current height with the minimum of leftMax and rightMax and add it to the result. 
This ensures that we trap the rainwater between the two highest walls.*/

package com.cts.dsa.paytm;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RainwaterTrappingAndMergingPoint {
    public static ListNode findMergingPoint(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists to find their lengths
        int lenA = 0, lenB = 0;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        // Reset pointers to the beginning of the lists
        pA = headA;
        pB = headB;

        // Move the pointer of the longer list ahead by the length difference
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                pA = pA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                pB = pB.next;
                diff--;
            }
        }

        // Traverse both lists simultaneously to find the merging point
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        // Either pA or pB is the merging point
        return pA;
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        // Problem 1: Finding the merging point of two linked lists
        ListNode commonNode = new ListNode(7);
        commonNode.next = new ListNode(8);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = commonNode;

        ListNode headB = new ListNode(3);
        headB.next = commonNode;

        System.out.println("Merging Point: " + findMergingPoint(headA, headB).val);

        // Problem 2: Rainwater trapping
        int[] walls = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Rainwater: " + trap(walls));
    }
}

