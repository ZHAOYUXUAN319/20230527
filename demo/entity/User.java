package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user12")
public class User implements Serializable {
	/**
	 * ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 名前
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 住所
	 */
	@Column(name = "address")
	private String address;
	/**
	 * 電話番号
	 */
	@Column(name = "phone")
	private String phone;
	/**
	 * 更新日時
	 */
	@Column(name = "update_date")
	private Date updateDate;
	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;
	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;

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