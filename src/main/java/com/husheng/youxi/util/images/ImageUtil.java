package com.husheng.youxi.util.images;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

/**
 * 图像裁剪以及压缩处理工具类
 * 
 * 提供基于JDK Image I/O 的解决方案(JDK探索失败)
 * 
 * 
 * @author
 * @since 1.0
 */
public class ImageUtil {

	// 输出打印日志
	public static boolean IS_DEBUG = true;


	/**
	 * 缩放后裁剪图片方法
	 * 
	 * @param srcImageFile 源文件
	 * @param x            x坐标
	 * @param y            y坐标
	 * @param destWidth    最终生成的图片宽
	 * @param destHeight   最终生成的图片高
	 * @param finalWidth   缩放宽度
	 * @param finalHeight  缩放高度
	 */
	public static void abscut(String srcImageFile, String targetFile, int x, int y, int destWidth, int destHeight,
			int finalWidth, int finalHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度

			if (srcWidth >= destWidth && srcHeight >= destHeight) {
				Image image = bi.getScaledInstance(finalWidth, finalHeight, Image.SCALE_DEFAULT);// 获取缩放后的图片大小
				cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, null); // 绘制截取后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", new File(targetFile));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		FileUtils.copyFile(new File("E:/kekeproject3/moonvip/WebRoot/resources/images/avatar/1.jpg"), new File(
				"E:\\kekeproject3\\.metadata\\.me_tcat7\\webapps\\moonvip\\resource\\avatar\\2015\\07\\22\\201507222047304.jpg"));
	}
}
