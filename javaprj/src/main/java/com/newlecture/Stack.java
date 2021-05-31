package com.newlecture;

/**

 * 스택구조라면 가지고 있어야 할 기능들을 인터페이스로 정의해뒀습니다.

 */

interface Stack {

           boolean isEmpty();         // 모두 public abstract가 생략되어 있음.

           void push(Object x, int type);

           Object pop();

           void delete();

           Object peek();

}
