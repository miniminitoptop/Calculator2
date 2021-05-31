package com.newlecture;

/**

 * 스택 및 큐 구조에 사용될 노드 클래스입니다.

 * type변수를 넣어서 String을 토큰으로 나눌 때

 * type변수에 타입을 나타내는 숫자를 입력하도록 했습니다.

 * 이렇게 하지 않으면 중간중간 형변환이 많아져서 소스가 복잡해질거라 판단했습니다.

 */

public class ListNode {

Object data;

ListNode link;

int type; // 저장된 자료의 타입을 나타냄. ListQueue에서 사용. 이 프로그램상에선 1:operator, 2:공백, 3:여는괄호, 4:닫는괄호, 5:숫자



ListNode() {

          data = null;

          link = null;

}



ListNode(Object data) {

          this.data = data;

          link = null;

}

}