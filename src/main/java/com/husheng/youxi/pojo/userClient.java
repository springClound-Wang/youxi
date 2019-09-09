package com.husheng.youxi.pojo;

import java.util.Date;

/**
*
* todo:C端用户管理模块实体
* userClient<br/>
* 创建人:汪正章<br/>
* 时间：2019年09月09日 22:37:33 <br/>
* @version 1.0.0<br/>
*
*/
public class userClient implements java.io.Serializable{
	
    // 用户编号
    private Integer id;
    // 名称
    private String name;
    // 个性签名
    private String signature;
    //  性别 1男0女
    private Integer sex;
    // 头像url
    private String headImg;
    // 省份
    private String province;
    // 城市
    private String city;
    // 作品表编号
    private Integer worksId;
    // 积分
    private Integer integral;
    // 状态 1封停 0可用
    private Integer status;
    // 创建时间
    private String createTime;
    // 修改时间
    private String updateTime;
    
    public userClient() {
        super();
    }
    
    public userClient(Integer id,String name,String signature,Integer sex,String headImg,String province,String city,Integer worksId,Integer integral,Integer status,String createTime,String updateTime) {
        super();
        this.id = id;
        this.name = name;
        this.signature = signature;
        this.sex = sex;
        this.headImg = headImg;
        this.province = province;
        this.city = city;
        this.worksId = worksId;
        this.integral = integral;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
 	
 	
 	public String toString(Integer id,String name,String signature,Integer sex,String headImg,String province,String city,Integer worksId,Integer integral,Integer status,String createTime,String updateTime) {
        return "userClient:【this.id:"+id+",this.name:"+name+",this.signature:"+signature+",this.sex:"+sex+",this.headImg:"+headImg+",this.province:"+province+",this.city:"+city+",this.worksId:"+worksId+",this.integral:"+integral+",this.status:"+status+",this.createTime:"+createTime+",this.updateTime:"+updateTime+"】";
    }
   
}