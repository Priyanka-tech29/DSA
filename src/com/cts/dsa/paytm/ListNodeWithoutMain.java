/*
 * package com.cts.dsa.paytm;
 * 
 * public class ListNode {
 * 
 * int val; ListNode next; ListNode(int val) { this.val = val; this.next = null;
 * }
 * 
 * 
 * public ListNode findMergingPoint(ListNode headA, ListNode headB) { ListNode
 * pA = headA; ListNode pB = headB;
 * 
 * // Traverse both lists to find their lengths int lenA = 0, lenB = 0; while
 * (pA != null) { lenA++; pA = pA.next; } while (pB != null) { lenB++; pB =
 * pB.next; }
 * 
 * // Reset pointers to the beginning of the lists pA = headA; pB = headB;
 * 
 * // Move the pointer of the longer list ahead by the length difference if
 * (lenA > lenB) { int diff = lenA - lenB; while (diff > 0) { pA = pA.next;
 * diff--; } } else { int diff = lenB - lenA; while (diff > 0) { pB = pB.next;
 * diff--; } }
 * 
 * // Traverse both lists simultaneously to find the merging point while (pA !=
 * pB) { pA = pA.next; pB = pB.next; }
 * 
 * // Either pA or pB is the merging point return pA; }
 * 
 * }
 */


