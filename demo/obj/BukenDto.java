package com.example.demo.obj;

public class BukenDto {
  private Long propertyId;
  private String propertyName;
  private String address;
  private String propertyType;
  private String propertyArea;
  private String price;
  private String syozokuCompanyId;
  private String status;

  public BukenDto() {
  }

  public BukenDto(Long propertyId, String propertyName, String address, String propertyType, String propertyArea, String price, String syozokuCompanyId, String status) {
    this.propertyId = propertyId;
    this.propertyName = propertyName;
    this.address = address;
    this.propertyType = propertyType;
    this.propertyArea = propertyArea;
    this.price = price;
    this.syozokuCompanyId = syozokuCompanyId;
    this.status = status;
  }

  public Long getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(Long propertyId) {
    this.propertyId = propertyId;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  public String getPropertyArea() {
    return propertyArea;
  }

  public void setPropertyArea(String propertyArea) {
    this.propertyArea = propertyArea;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getSyozokuCompanyId() {
    return syozokuCompanyId;
  }

  public void setSyozokuCompanyId(String syozokuCompanyId) {
    this.syozokuCompanyId = syozokuCompanyId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
