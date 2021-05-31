package com.newlecture;

/**

 * 중위식 및 후위식 토큰을 저장해 두기 위한 연결리스트 큐 구조 입니다.

 * 실시간으로 처리할 용도가 아니라 단순히 자료 저장용이기 때문에

 * 스택을 역순으로 바꾸어서 사용해도 됬지만, 큐도 한번 사용해보고 싶었습니다.

 */

public class ListQueue {

          

           public ListNode front;

           public ListNode rear;

           public int count;

          

           public boolean isEmpty() {

                     return (count == 0);

           }

          

           public void enqueue(Object x, int type) {   // 큐에  자료를 넣음.

                     ListNode newNode = new ListNode(x);

                     newNode.type = type;

                     newNode.link = null;

                     if (count == 0)

                                front = rear = newNode;

                     else {

                                rear.link = newNode;

                                rear = newNode;

                     }

                     count++;

           }

          

           public Object dequeue() { // 큐에서 자료를 꺼내고 삭제. First In First Out.

                     if (count == 0)

                                return null;

                     else {

                                Object temp = front.data;

                                front = front.link;

                                if (front == null)

                                          rear = null;

                                count--;

                                return temp;

                     }

           }

}