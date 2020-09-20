package leetcode.medium;

public class RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode node = head;
    int size = 0;

    // 노드 사이즈 구하기
    while (node != null) {
      node = node.next;
      size++;
    }

    // 가장 첫 노드
    node = head;

    ListNode before = null;
    ListNode after = null;

    // n 노드 상태까지 반복
    for (int i = 0; i < size - n; i++) {
      before = node;
      node = node.next;
      after = node.next;
    }

    if (before != null) {
      before.next = after; // 전 노드를 없애기 위해 전 노드의 다음 노드를 해당 노드의 다음 노드로 설정
    } else { // 만약 그 전 노드가 없다면
      head = node.next; // head를 다음 노드로 설정
    }

    return head;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
