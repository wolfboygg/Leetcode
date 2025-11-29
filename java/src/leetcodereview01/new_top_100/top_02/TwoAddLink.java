package leetcodereview01.new_top_100.top_02;

import java.util.List;

/**
 * 两数相加 两个链表
 */
public class TwoAddLink {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumber(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry != 0 && node1 == null && node2 == null) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        } else {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            temp.val += carry;
        }

        // 反转
        ListNode newNode = new ListNode(-1);
        pre = pre.next;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = newNode.next;
            newNode.next = pre;
            pre = next;
        }
        return newNode.next;
    }

    public ListNode addTwoNumber02(ListNode node1, ListNode node2) {
        // 两个链表想加 完成之后要反转
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val = node.val % 10;
            pre.next = node;
            pre = pre.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry != 0 && node1 == null && node2 == null) {
            pre.next = new ListNode(carry);
        } else {
            // 这里还需要判断
            pre.next = node1 == null ? node2 : node1;
            pre = pre.next;
            pre.val += carry;
            if (pre.val > 10) {
                pre.next = new ListNode(pre.val / 10);
                pre.val = pre.val % 10;
            }
        }
        temp = temp.next;
        // 反转列表
        ListNode P1 = new ListNode(-1);
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = P1.next;
            P1.next = temp;
            temp = next;
        }
        return P1.next;
    }

    public ListNode addTwoNumber03(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        // 看看还有没有
        if (carry != 0 && node1 == null && node2 == null) {
            temp.next = new ListNode(carry);
        } else {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            temp.val += carry;
            if (temp.next != null) {
                temp.next.val += temp.val / 10;
            } else {
                temp.next = new ListNode(temp.val / 10);
            }
            temp.val %= 10;
        }
        // 反转
        pre = pre.next;
        // 反转列表
        ListNode P1 = new ListNode(-1);
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = P1.next;
            P1.next = pre;
            pre = next;
        }
        return P1.next;
    }

    public ListNode addTwoNumber04(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        // 然后处理进位问题
        if (carry != 0 && node1 != null && node2 != null) {
            temp.next = new ListNode(carry);
        } else {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            temp.val += carry;
            if (temp.val > 10) {
                carry = temp.val / 10;
                temp.val %= 10;
                if (temp.next == null) {
                    ListNode node = new ListNode(carry);
                    temp.next = node;
                } else {
                    temp.val += carry;
                }
            }
        }
        // 反转链表
        ListNode P1 = new ListNode(-1);
        pre = pre.next;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = P1.next;
            P1.next = pre;
            pre = next;
        }
        return P1.next;
    }

    public ListNode addTwoNumber05(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int carry = 0;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry != 0 && node1 == null && node2 == null) {
            temp.next = new ListNode(carry);
        } else {
            temp.next = node1 == null ? node2 : node1;
            ListNode node = temp.next;
            node.val += carry;
            if (node.val > 10) {
                carry = node.val % 10;
                if (node.next == null) {
                    node.next = new ListNode(carry);
                } else {
                    ListNode next = node.next;
                    next.val += carry;
                }
                node.val /= 10;
            }
        }
        // 进行反转
        pre = pre.next;
        ListNode newTemp = new ListNode(-1);
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = newTemp.next;
            newTemp.next = pre;
            pre = next;
        }
        return newTemp.next;
    }

    public ListNode addTwoNumber06(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node2.val;
            node.val += node1.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 == null && node2 == null) {
            temp.next = new ListNode(carry);
        } else {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            temp.val += carry;
            if (temp.val > 10) {
                carry = temp.val / 10;
                temp.val %= 10;
                temp.next = new ListNode(carry);
            }
        }
        // 需要反转
        pre = pre.next;
        ListNode newPre = new ListNode(-1);
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = newPre.next;
            newPre.next = pre;
            pre = next;
        }
        return newPre.next;
    }


    public ListNode addTwoNumber07(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        int carry = 0;
        ListNode temp = new ListNode(-1);
        ListNode pre = temp;
        while (node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val / 10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry > 0) {
            if (node1 == null && node2 == null) {
                temp = new ListNode(carry);
            } else {
                ListNode node = node1 == null ? node2 : node1;
                while (carry > 0 && node != null) {
                    int value = node.val + carry;
                    carry = value / 10;
                    node.val %= 10;
                    temp.next = node;
                    temp = temp.next;
                    node = node.next;
                }
                if (carry > 0) {
                    temp.next = new ListNode(carry);
                }
            }
        }
        ListNode node = pre.next;
        temp = new ListNode(-1);
        pre = temp;
        while (node != null) {
            ListNode next = node.next;
            node.next = temp.next;
            temp.next = node;
            node = next;
        }
        return pre.next;
    }

    public ListNode addTwoNumber08(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while(node1 != null && node2 != null) {
            ListNode node = new ListNode(carry);
            node.val += node1.val;
            node.val += node2.val;
            carry = node.val/10;
            node.val %= 10;
            temp.next = node;
            temp = temp.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 != null || node2 != null) {
            temp.next = node1 == null ? node2 : node1;
            temp = temp.next;
            while (carry > 0) {
                System.out.println(temp.val + "," + carry);
                temp.val += carry;
                carry = temp.val / 10;
                temp.val %= 10;
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }

            }
            System.out.println(carry);
            if (carry > 0) {
                temp.next = new ListNode(carry);
            }
        } else {
            temp.next = new ListNode(carry);
        }
        temp = new ListNode(-1);
        pre = pre.next;
        while(pre != null) {
            ListNode next = pre.next;
            pre.next = temp.next;
            temp.next = pre;
            pre = next;
        }
        return temp.next;

    }



    public static void main (String[]args){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        TwoAddLink twoAddLink = new TwoAddLink();
        ListNode node = twoAddLink.addTwoNumber06(node1, node4);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}