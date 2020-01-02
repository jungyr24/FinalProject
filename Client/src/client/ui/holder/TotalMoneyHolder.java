package client.ui.holder;

import javax.swing.*;

public class TotalMoneyHolder {
    public JPanel totalMoneyPnl = new JPanel(), totalSalesPnl = new JPanel();
    public JLabel lblTitleTotalMoney = new JLabel("총 매출"), lblTotalSales = new JLabel(), lblTotalSalesMoney = new JLabel();
    public JButton btnBackTotalMoney = new JButton("뒤로가기");
    public String colTotalMoney[] = {};
    public String rowTotalMoney[][] = {};
    public JTable table;
}
