package com.example.demo.obj;

import java.util.Date;

public class UserDto {
  private Long id;
  private String name;
  private String address;
  private String phone;
  private Date updateDate;
  private Date createDate;
  private Date deleteDate;
  
  public UserDto(Long id, String name, String address, String phone, Date updateDate, Date createDate, Date deleteDate) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.updateDate = updateDate;
    this.createDate = createDate;
    this.deleteDate = deleteDate;
  }
  

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public Date getUpdateDate() {
    return updateDate;
  }
  
  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
  
  public Date getCreateDate() {
    return createDate;
  }
  
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  public Date getDeleteDate() {
    return deleteDate;
  }
  
  public void setDeleteDate(Date deleteDate) {
    this.deleteDate = deleteDate;
  }
}
