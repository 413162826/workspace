package com.suguowen.model;

import java.util.Date;

public class GfCar {
	
	
	public GfCar() {
		
	}
	
	public GfCar(Integer carId, String carNumber) {
		super();
		this.carId = carId;
		this.carNumber = carNumber;
	}

	private Integer carId;

    private String carNumber;

    private String carType;

    private String carBrandNumber;

    private String carBrand;

    private Integer carVolume;

    private String carLicenseFront;

    private String carLicenseReverse;

    private String carPhotoFron;

    private String carPhotoFlank;

    private String carPhotoReverse;

    private Date ctime;

    private Date modifyTime;

    private String varifyStatus;

    private Date varifyTime;

    private Integer carUnitPrice;

    private Integer userId;

    private String carPhone;

    private Integer carStatus;

    private String varifyRemark;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrandNumber() {
        return carBrandNumber;
    }

    public void setCarBrandNumber(String carBrandNumber) {
        this.carBrandNumber = carBrandNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getCarVolume() {
        return carVolume;
    }

    public void setCarVolume(Integer carVolume) {
        this.carVolume = carVolume;
    }

    public String getCarLicenseFront() {
        return carLicenseFront;
    }

    public void setCarLicenseFront(String carLicenseFront) {
        this.carLicenseFront = carLicenseFront;
    }

    public String getCarLicenseReverse() {
        return carLicenseReverse;
    }

    public void setCarLicenseReverse(String carLicenseReverse) {
        this.carLicenseReverse = carLicenseReverse;
    }

    public String getCarPhotoFron() {
        return carPhotoFron;
    }

    public void setCarPhotoFron(String carPhotoFron) {
        this.carPhotoFron = carPhotoFron;
    }

    public String getCarPhotoFlank() {
        return carPhotoFlank;
    }

    public void setCarPhotoFlank(String carPhotoFlank) {
        this.carPhotoFlank = carPhotoFlank;
    }

    public String getCarPhotoReverse() {
        return carPhotoReverse;
    }

    public void setCarPhotoReverse(String carPhotoReverse) {
        this.carPhotoReverse = carPhotoReverse;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getVarifyStatus() {
        return varifyStatus;
    }

    public void setVarifyStatus(String varifyStatus) {
        this.varifyStatus = varifyStatus;
    }

    public Date getVarifyTime() {
        return varifyTime;
    }

    public void setVarifyTime(Date varifyTime) {
        this.varifyTime = varifyTime;
    }

    public Integer getCarUnitPrice() {
        return carUnitPrice;
    }

    public void setCarUnitPrice(Integer carUnitPrice) {
        this.carUnitPrice = carUnitPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public String getVarifyRemark() {
        return varifyRemark;
    }

    public void setVarifyRemark(String varifyRemark) {
        this.varifyRemark = varifyRemark;
    }
}