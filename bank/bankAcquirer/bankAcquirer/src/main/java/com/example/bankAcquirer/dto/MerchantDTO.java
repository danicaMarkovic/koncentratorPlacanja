package com.example.bankAcquirer.dto;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class MerchantDTO {

	private Long id;
	
	private String merchantId;
	
	private String merchantPassword;
	
	private String merchantIssn;

	public MerchantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public String getMerchantIssn() {
		return merchantIssn;
	}

	public void setMerchantIssn(String merchantIssn) {
		this.merchantIssn = merchantIssn;
	}

	
	
	
	

}


