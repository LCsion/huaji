package demo;

import java.awt.Image;
import java.util.ArrayList;

public class ball {
	double x;//球的横左边
	double y;//球的纵坐标
	ArrayList<Image> img;//球的贴图
	double l;//球的半径
	double nowimg; //球的当前贴图代数
	public ball(double x, double y, ArrayList<Image> img,double l,double nowimg) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.l=l;
		this.nowimg=nowimg;
	}
}
