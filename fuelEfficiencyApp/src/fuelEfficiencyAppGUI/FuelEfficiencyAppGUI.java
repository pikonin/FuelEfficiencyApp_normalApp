package fuelEfficiencyAppGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FuelEfficiencyAppGUI {
  public static void main(String[] args) {
    // フレーム作成
    JFrame frame = new JFrame("燃費管理アプリ");
    frame.setSize(300, 250);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // パネルとレイアウト
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);

    // フレーム表示
    frame.setVisible(true);
  }

  private static void placeComponents(JPanel panel) {
    panel.setLayout(null);

    // 距離入力
    JLabel distanceLabel = new JLabel("距離 (km):");
    distanceLabel.setBounds(10, 20, 80, 25);
    panel.add(distanceLabel);

    JTextField distanceText = new JTextField(20);
    distanceText.setBounds(100, 20, 165, 25);
    panel.add(distanceText);

    // 給油量入力
    JLabel fuelLabel = new JLabel("給油量 (L):");
    fuelLabel.setBounds(10, 50, 80, 25);
    panel.add(fuelLabel);

    JTextField fuelText = new JTextField(20);
    fuelText.setBounds(100, 50, 165, 25);
    panel.add(fuelText);

    // 計算ボタン
    JButton calculateButton = new JButton("計算");
    calculateButton.setBounds(10, 80, 80, 25);
    panel.add(calculateButton);

    // クリアボタン
    JButton clearButton = new JButton("クリア");
    clearButton.setBounds(100, 80, 80, 25);
    panel.add(clearButton);

    // 結果表示
    JLabel resultLabel = new JLabel("燃費: -- km/L");
    resultLabel.setBounds(10, 110, 200, 25);
    panel.add(resultLabel);

    // 計算ボタンアクション
    calculateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double distance = Double.parseDouble(distanceText.getText());
          double fuel = Double.parseDouble(fuelText.getText());
          if (fuel != 0) {
            double efficiency = distance / fuel;
            resultLabel.setText(String.format("燃費: %.2f km/L", efficiency));
          } else {
            resultLabel.setText("給油量が0では計算不可");
          }
        } catch (NumberFormatException ex) {
          resultLabel.setText("数値を入力してください");
        }
      }
    });

    // クリアボタンアクション
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 入力欄と結果ラベルをリセット
        distanceText.setText("");
        fuelText.setText("");
        resultLabel.setText("燃費: -- km/L");
      }
    });
  }
}
