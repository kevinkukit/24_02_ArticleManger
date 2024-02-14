package com.KoreaIT.java.AM;

import java.time.LocalTime;
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

      if(cmd.isEmpty()) {
        System.out.println("명령어를 입력하세요");
        continue;
      }

      if(cmd.equals("system exit")) {
        break;
      }
      if (cmd.equals("article list")) {
        if(articles.isEmpty()) {
          System.out.println("게시글이 없습니다");
        } else {
          System.out.println(" 번호 | 제목 ");
          for(int j = articles.size() - 1; j >= 0;  j--) {
            Article article = articles.get(j);
            System.out.printf("  %d | %s \n", article.i, article.title);
          }
        }
      }

      else if (cmd.equals("article write")) {
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String body = sc.nextLine();
        LocalTime now = LocalTime.now();

        Article article = new Article(i, title, body, now);
        articles.add(article);

        System.out.printf("%d번 글이 생성되었습니다\n", i);
        i ++;
      }

      else if (cmd.startsWith("article detail")) {
        String[] cmdBits = cmd.split(" ");
        String num = cmdBits[2];
        int id = Integer.parseInt(num);
        boolean found = false;
        for (Article article : articles) {
          if (article.i == id) {  // articles 에서 가져온 article 객체의 글번호와 id 비교
            found = true;
            break;
          }
        }
        if(found) {
          Article article = articles.get(id - 1);
          System.out.println("번호: " + num);
          System.out.println("날짜: " + article.now);
          System.out.println("제목: " + article.title);
          System.out.println("내용: " + article.body);
        } else {
          System.out.println(num + "번 게시물은 존재하지 않습니다");
        }

      } else if (cmd.startsWith("article delete")) {
        String[] cmdBits = cmd.split(" ");
        String num = cmdBits[2];
        int id = Integer.parseInt(num);
        boolean found = false;
        for (Article article : articles) {
          if (article.i == id) {  // articles 에서 가져온 article 객체의 글번호와 id 비교
            found = true;
            break;
          }
        }
        if(found) {
          articles.remove(id-1);
        } else {
          System.out.println(num + "번 게시물은 존재하지 않습니다");
        }
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
  LocalTime now;

  public Article(int i, String title, String body, LocalTime now) {
    this.i = i;
    this.title = title;
    this.body = body;
    this.now = now;
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