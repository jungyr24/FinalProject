package client.ui.adminview.holder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TotalMoneyHolder {
    public JPanel totalMoneyPnl = new JPanel(), totalSalesPnl = new JPanel();
    public JLabel lblTitleTotalMoney = new JLabel("총 매출"), lblTotalSales = new JLabel(), lblTotalSalesMoney = new JLabel("합계");
    public JButton btnBackTotalMoney = new JButton("뒤로가기");

    public Vector<String> colTotalMoney = new Vector<>();
    public Vector<String> rowTotalMoney;
    public JTable table;
    public DefaultTableModel model;

    private final static String[] columns = {"No", "상품명", "가격","판매수량","총액"};

    public TotalMoneyHolder() {
        for (String col : columns) {
            colTotalMoney.addElement(col);
        }
    }
}
