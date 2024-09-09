/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int[][] matrix;
    ListNode head;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        matrix = new int[m][n];
        if (m == 1 && n == 1) {
            matrix[0][0] = head.val;
            return matrix;
        }
        this.head = head;
        int left = 0, right = n - 1, top = 0, down = m - 1;
        for (int i = 0; i < m; i++)
            Arrays.fill(matrix[i], -1);

        while (left <= right && top <= down) {
            circle(left, right, top, down);
            left++;
            right--;
            top++;
            down--;
        }
        
        return matrix;
    }

    void circle(int left, int right, int top, int down) {
        if (top == down) {
            for (int j = left; j <= right; j++) {
                if (head != null) {
                    matrix[top][j] = head.val;
                    head = head.next;
                }
            }
        } else if (left == right) {
            for (int i = top; i <= down; i++) {
                if (head != null) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
            }
        } else {
            for (int j = left; j < right; j++) {
                if (head != null) {
                    matrix[top][j] = head.val;
                    head = head.next;
                }
            }
            for (int i = top; i < down; i++) {
                if (head != null) {
                    matrix[i][right] = head.val;
                    head = head.next;
                }
            }
            for (int j = right; j > left; j--) {
                if (head != null) {
                    matrix[down][j] = head.val;
                    head = head.next;
                }
            }
            for (int i = down; i > top; i--) {
                if (head != null) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
            }
        }
    }
}