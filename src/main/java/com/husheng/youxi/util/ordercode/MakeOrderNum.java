package com.husheng.youxi.util.ordercode;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MakeOrderNum
 * @CreateTime 2015年9月13日 下午4:51:02
 * @author : mayi
 * @Description: 订单号生成工具，生成非重复订单号，理论上限1毫秒1000个，可扩展
 * 
 *               业务描述：
 * 
 *               首先从数据中查找最近的一条订单数据，然后将之前的订单号码+1作为新的订单号码，插入到数据库当中。（需求不能改变）
 * 
 *               当出现并发操作时，A从数据库中获取最近一条订单的订单号为N，这是A还没有完成新订单的插入操作。B用户进来，也获取最近一条订单的订单号为N，这是A和B
 *               想数据库同事插入的订单就有相同的订单号码。
 * 
 * 
 * 
 *               解决方法1：
 * 
 *               程序用同步锁控制（synchronized），性能急剧下降了，本身 java
 *               就是多线程的，你把它单线程使用，不是明智的选择，同时，如果分布式部署的时候，加了 synchronized 也无法控制并发。
 *               解决方法2： redis 自增。将订单号自增字段，交给redis管理。 解决方法3：
 *               乐观锁：（可能睡涉及到多次提交，用户体验性差）。 解决方法4： 数据库行锁：行锁的同时，可能会影响其他程序对数据库的操作。
 *               解决方式5： 数据库（唯一性约束UNIQUE KEY），由于订单号不能重复，当插入相同的订单号码，就会产生错误
 * 
 */
public class MakeOrderNum {
	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private int maxPerMSECSize = 1000;

	/**
	 * 生成非重复订单号，理论上限1毫秒1000个，可扩展
	 * 
	 * @param tname 测试用
	 */
	public synchronized String makeOrderNum() {
		try {
			// 最终生成的订单号
			String finOrderNum = "";
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分，精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
				if (orderNumCount >= maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// 组装订单号
				String countStr = maxPerMSECSize + orderNumCount + "";
				finOrderNum = nowLong + countStr.substring(1);
				orderNumCount++;
				return finOrderNum;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// 测试多线程调用订单号生成工具
		try {
			for (int i = 0; i < 10000; i++) {

				Thread t1 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						System.out.println(makeOrder.makeOrderNum());
					}
				});

				t1.start();

				Thread t2 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						System.out.println(makeOrder.makeOrderNum());
					}
				});

				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
