package demo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class init {
public static void main(String[] args) throws IOException {
	ArrayList<ball> balls=new ArrayList<ball>();
	ArrayList<Image> ballimg=new ArrayList<Image>();
	ballimg.add(ImageIO.read(new File("src\\img\\huaji2.png")));
	ballimg.add(ImageIO.read(new File("src\\img\\huaji4.png")));
	ballimg.add(ImageIO.read(new File("src\\img\\huaji3.png")));
	MyFrame a=new MyFrame(0,0,balls);
	for(int i=0;i<1000;i++)
	{
		int ballsize=(int) (Math.random()*(500-10)+10);
		balls.add(new npcball(
				(int)(Math.random()*(MyFrame.width-ballsize/2-15-ballsize/2)+ballsize/2),
				(int)(Math.random()*(MyFrame.height-ballsize/2-35-ballsize/2)+ballsize/2),
				ballimg,
				ballsize,
				(int)(Math.random()*(5-1)+1),
				Math.random()*(90),
				(Math.random()*1000)%2==0?1:-1,
				(Math.random()*1000)%2==0?1:-1
				)
		);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	}
}
	/*MyThread a=new MyThread();
	a.start();*/