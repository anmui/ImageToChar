package test2;

import java.awt.image.BufferedImage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Main
{
	public static BufferedImage grayImage(String image) throws IOException
	{
		File file = new File(image);
		final String base = "@#&$%*o!;.";//灰度值越小越黑
		int flag=0;
		BufferedImage bi = null;
		try
		{
			bi=ImageIO.read(file);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int  width=bi.getWidth();
		int height=bi.getHeight();
		File file2 = new File("fzu.txt");
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
		BufferedImage grayBufferedImage= new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
		for(int y=0;y<height;y+=10)
		{
			for(int x=0;x<width;x+=5)
			{
				//计算灰度
				int color=bi.getRGB(x, y);
				int r = (color >> 16) & 0xff;
	            int g = (color >> 8) & 0xff;
	            int b = color & 0xff;
	            int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
	            int index = Math.round(gray*11/ 255);//最接近int值
	            if(index>=10)
	            {
	            	bw.append(" ");
	            }
	            else 	bw.append(base.charAt(index));
	   
			}
			bw.append("\r\n");
		}
		bw.close();
		 return grayBufferedImage;
	}
	public static void main(String[] arg) throws IOException
	{
		String image="C:\\Users\\Mac\\Desktop\\timg.jpg";
		grayImage(image);
	}
	
}