package com.newlecture;

/**

 * ���� �� ť ������ ���� ��� Ŭ�����Դϴ�.

 * type������ �־ String�� ��ū���� ���� ��

 * type������ Ÿ���� ��Ÿ���� ���ڸ� �Է��ϵ��� �߽��ϴ�.

 * �̷��� ���� ������ �߰��߰� ����ȯ�� �������� �ҽ��� ���������Ŷ� �Ǵ��߽��ϴ�.

 */

public class ListNode {

Object data;

ListNode link;

int type; // ����� �ڷ��� Ÿ���� ��Ÿ��. ListQueue���� ���. �� ���α׷��󿡼� 1:operator, 2:����, 3:���°�ȣ, 4:�ݴ°�ȣ, 5:����



ListNode() {

          data = null;

          link = null;

}



ListNode(Object data) {

          this.data = data;

          link = null;

}

}