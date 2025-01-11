package fuelEfficiencyApp;

import java.util.Scanner;

public class FuelEfficiencyApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("燃料管理アプリ");
    System.out.println("走行距離(km)を入力してください");
    double distance = scanner.nextDouble();

    System.out.println("給油したガソリン量(L)を入力してください");
    double fuel = scanner.nextDouble();

    // 入力チェック
    if (fuel != 0) {
      double fuelEfficiency = distance / fuel;
      System.out.println("燃費は" + fuelEfficiency + "km/Lです");
    } else {
      System.out.println("入力値が不正です");
    }
    scanner.close();
  }
}
