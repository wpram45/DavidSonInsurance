package screens;


import utils.SizeUtils;
import javax.swing.*;
import java.awt.*;

public class ShowTable extends JDialog {
    protected JTable table1;
    private JPanel panelMain;
    private JScrollPane ScrollPane;
    private JButton DrawGraph;

    SizeUtils sizeUtil = new SizeUtils();

    DrawGraphs drawGraphs=new DrawGraphs();


    Listeners listeners=new Listeners();



    public ShowTable() {
        setTitle("Show data as TABLE");
        AddRowsTable.table1=table1;

        Dimension defaultSize = new Dimension((int) (sizeUtil.getWidth() / 1.5), (int) (sizeUtil.getHeight() - 100));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(true);

        //make visible false after
        setVisible(false);

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



       listeners.addListenersShowTable(DrawGraph,drawGraphs);
    }

}
