package com.KoreaIT.java.AM;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("===프로그램 시작===");
    Scanner sc = new Scanner(System.in);

    int i = 1;
    while(true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();    // 문장입력받음

      if(cmd.equals("system exit")) {
        break;
      } else if (cmd.equals("article list")) {
        System.out.println("게시글이 없습니다");
      } else if (cmd.equals("article write")) {
        System.out.print("제목: ");
        String 제목 = sc.nextLine();
        System.out.print("내용: ");
        String 내용 = sc.nextLine();
        System.out.printf("%d번 글이 생성되었습니다\n", i);
        i ++;
      } else {
        System.out.println("존재하지 않는 명령어입니다.");
      }
    }

    sc.close();

    System.out.println("===프로그램 종료===");
  }
}