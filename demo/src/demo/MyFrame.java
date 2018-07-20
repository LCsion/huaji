package demo;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	MyPanel panel;
	public static final int width=1920;
	public static final int height=1080;
	public MyFrame(int x,int y,ArrayList<ball> b){
		try {
			this.setBounds(x, y, width, height);
			panel=new MyPanel(b);
			this.add(panel);
			this.setVisible(true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	}
