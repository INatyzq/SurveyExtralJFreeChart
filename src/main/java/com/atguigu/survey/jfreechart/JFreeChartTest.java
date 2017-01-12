package com.atguigu.survey.jfreechart;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {

	public static void main(String[] args) throws IOException {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("张三",10);
		dataset.setValue("李四",20);
		dataset.setValue("王五",30);
		dataset.setValue("赵六",40);
		
		JFreeChart chart = ChartFactory.createPieChart3D("数据", dataset);
		
		TextTitle title = chart.getTitle();
		title.setFont(new Font("微软雅黑", Font.BOLD, 50));
		
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(new Font("宋体", Font.ITALIC, 20));
		
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("黑体", Font.PLAIN, 10));
		plot.setForegroundAlpha(0.4f);
		
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0},{1}/{3},{2}"));
		
		File file = new File("1.jpg");
		ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
		System.out.println("OK....");
	}

}
