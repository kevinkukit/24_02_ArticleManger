package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("===프로그램 시작===");
    Scanner sc = new Scanner(System.in);

    int i = 1;
    List<Article> articles = new ArrayList<>();

    while(true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();    // 문장입력받음

      if(cmd.length() == 0) {
        System.out.println("명령어를 입력하세요");
        continue;
      }

      if(cmd.equals("system exit")) {
        break;

      } else if (cmd.equals("article list")) {
        if(articles.isEmpty()) {
          System.out.println("게시글이 없습니다");
        } else {
          System.out.println("번호|제목|내용");
          for(Article article : articles) {
            System.out.println(article.toString());
          }
        }

      } else if (cmd.equals("article write")) {
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String body = sc.nextLine();

        Article article = new Article(i, title, body);
        articles.add(article);

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

class Article {
  int i;
  String title;
  String body;

  public Article(int i, String title, String body) {
    this.i = i;
    this.title = title;
    this.body = body;
  }

  public String toString() {
    return i + " | " + title + " | " + body;
  }
}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//  public static void main(String[] args) {
//    System.out.println("===프로그램 시작===");
//    Scanner sc = new Scanner(System.in);
//
//    List<Article> articles = new ArrayList<>(); // 게시글을 저장할 리스트
//
//    int i = 1;
//    while (true) {
//      System.out.print("명령어 ) ");
//      String cmd = sc.nextLine(); // 문장 입력 받음
//
//      if (cmd.equals("system exit")) {
//        break;
//      } else if (cmd.equals("article list")) {
//        if (articles.isEmpty()) {
//          System.out.println("게시글이 없습니다");
//        } else {
//          for (Article article : articles) {
//            System.out.println(article.toString());
//          }
//        }
//      } else if (cmd.equals("article write")) {
//        System.out.print("제목: ");
//        String 제목 = sc.nextLine();
//        System.out.print("내용: ");
//        String 내용 = sc.nextLine();
//
//        Article article = new Article(i, 제목, 내용); // 새로운 게시글 생성
//        articles.add(article); // 리스트에 추가
//        System.out.printf("%d번 글이 생성되었습니다\n", i);
//        i++;
//      } else {
//        System.out.println("존재하지 않는 명령어입니다.");
//      }
//    }
//
//    sc.close();
//
//    System.out.println("===프로그램 종료===");
//  }
//}
//
//class Article {
//  private int 번호;
//  private String 제목;
//  private String 내용;
//
//  public Article(int 번호, String 제목, String 내용) {
//    this.번호 = 번호;
//    this.제목 = 제목;
//    this.내용 = 내용;
//  }
//
//  @Override
//  public String toString() {
//    return 번호 + ". " + 제목 + " - " + 내용;
//  }
//}