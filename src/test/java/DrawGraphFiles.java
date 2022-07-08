import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.DrawGraphs;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawGraphFiles {


    DrawGraphs drawGraphs=new DrawGraphs();


    static final String basePath="/home/wpram45/Desktop/IntelliJProjects/FinalProject/";

    static String[] fileNames={"TimeSeriesChartPlansSelledByDate.png","piechartByMarketCoverage.png","LineChartExpirationDate.png","piechartByState.png"};


    @Test
    void testDrawTimeSeriesChartButton(){
      drawGraphs.drawTimeSeriesChartButton.doClick();
        File f = new File(basePath+fileNames[0]);



        Assertions.assertEquals(true,f.exists());

    }

    @Test
    void testDrawPieChartNumberButton1(){

        File f = new File(basePath+fileNames[1]);

        drawGraphs.drawPieChartNumberButton1.doClick();
        Assertions.assertEquals(true,f.exists());
    }


    @Test
    void testDrawLineChartUsersButton(){
        File f = new File(basePath+fileNames[2]);
        drawGraphs.drawLineChartUsersButton.doClick();
        Assertions.assertEquals(true,f.exists());
    }


    @Test

    void testDrawPieChartNumberButton(){
        File f = new File(basePath+fileNames[3]);
        drawGraphs.drawPieChartNumberButton.doClick();
        Assertions.assertEquals(true,f.exists());
    }



}
