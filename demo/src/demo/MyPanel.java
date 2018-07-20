package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	ArrayList<ball> b;
	int x,y,xr,yr;
	MyPanel(ArrayList<ball> b)
	{
		this.b=b;
		System.out.println("panel已创建");
	}
	public void paint(Graphics g){
		
		try {super.paint(g);
		for(int i=0;i<b.size();i++)
		{
			x=(int)(b.get(i).x-(b.get(i).l/2));
			y=(int)(b.get(i).y-(b.get(i).l/2));
			xr=(int)b.get(i).l;
			yr=(int)b.get(i).l;
			g.drawImage(b.get(i).img.get((int) b.get(i).nowimg), x,y,xr,yr, null);
		}
			this.repaint();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
