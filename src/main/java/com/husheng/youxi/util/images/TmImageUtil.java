/**
 * 
 */
package com.husheng.youxi.util.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * @author Administrator
 * 
 */
public class TmImageUtil {
	

	/**
	 * 获取图片的宽度和高度 com.tz.util.images 方法名：getImageWH 创建人：xuchengfei
	 * 时间：2015年8月14日-下午1:35:08
	 * 
	 * @param src
	 * @return HashMap<String,Object>
	 * @exception @since 1.0.0
	 */
	public static HashMap<String, Object> getImageWH(String src) {
		try {
			File srcfile = new File(src);
			if (!srcfile.exists())
				return null;
			BufferedImage image = ImageIO.read(srcfile);
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (image != null) {
				map.put("width", image.getWidth());
				map.put("height", image.getHeight());
			} else {
				map.put("width", 0);
				map.put("height", 0);
			}
			return map;
		} catch (Exception e) {
			System.out.println("创建缩略图发生异常" + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		File file = new File("d://mysql/4.jpg");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile().getAbsolutePath());
		System.out.println(getImageWH("D:/keke.png"));
	}

}
