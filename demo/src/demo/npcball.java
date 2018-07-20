package demo;

import java.awt.Image;
import java.util.ArrayList;

public class npcball extends ball implements Runnable{
	double v;//球的速度,每1毫秒的移动的距离
	double d;//球的运动角度，从其坐标顺时针计算
	double av;//球的衰减加速度百分比
	double gv;//向下加速度
	double mg;//重力加速度
	double ef;//弹力
	double gva;//重力加速度计数器
	static double fn=1000000;//空气阻力常数，越大阻力越小
	static double kn=1;//弹力常数
	static double G=300;//重力常数，越小重力越大
	int r_l;//球的左右运动方向,左为-1,右为1，垂直纵向为0
	int d_u;//球的上下运动方向，上为-1，下为1,垂直横向为0
	static int room_width=MyFrame.width;//屏幕长
	static int room_height=MyFrame.height;//屏幕宽
	static int k=10;//运动刷新率
	double g;//质量
	public npcball(int x,int y,ArrayList<Image> img, double l, double v,double d,int r_l,int d_u){
		super(x,y,img,l,Math.random());
		this.v=v;
		this.d=d;
		this.av=1-(l/fn);
		this.r_l=r_l;
		this.d_u=d_u;
		gva=1;
		g=(l/G)*(l/G);
		new Thread(this).start();
	}
	public void mmotioning()//k为刷新频率，为毫秒值
	{
		gv=(v*k/Math.sin(Math.PI/180*90)*Math.sin(Math.PI/180*(d)));
		ef=ef<(g/2)?0:ef;
		mg=((g>gv&&y>room_height-l/2-35)?gv:g)*gva;
		gva=mg>=g?y>room_height-l/2-35?1:gva+0.05:1;
		y=y+(d_u*(gv+((d_u==1||ef!=0)?mg:-mg))-ef);
		x=x+(r_l*(v*k/Math.sin(Math.PI/180*90)*Math.sin(Math.PI/180*(90-d))));
		v*=av;
		r_l=x<l/2?1:x>room_width-l/2-15?-1:r_l;
		d_u=y<l/2?1:y>room_height-l/2-35?-1:d_u;
		ef=y>room_height-l/2-35?gv*kn:0;
		nowimg=nowimg>=img.size()-0.8?0:nowimg+(Math.random()/100);
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				this.mmotioning();
				Thread.sleep(k);
				if(v==0)
					return;
			}
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// TODO 自动生成的方法存根
		
	}
}
