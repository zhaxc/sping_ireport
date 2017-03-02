package com.sample.sping_ireport.model;

import java.math.BigDecimal;

public class JavaBeanReceive {
	private String receiveName; //收款方
	private BigDecimal receiveCapacity;//收款方运力购买
	private BigDecimal receiveContainer;//收款方集装箱租金支出
	
	public JavaBeanReceive() {
		super();
	}
	
	public JavaBeanReceive(String receiveName, BigDecimal receiveCapacity, BigDecimal receiveContainer) {
		this.receiveName = receiveName;
		this.receiveCapacity = receiveCapacity;
		this.receiveContainer = receiveContainer;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public BigDecimal getReceiveCapacity() {
		return receiveCapacity;
	}

	public void setReceiveCapacity(BigDecimal receiveCapacity) {
		this.receiveCapacity = receiveCapacity;
	}

	public BigDecimal getReceiveContainer() {
		return receiveContainer;
	}

	public void setReceiveContainer(BigDecimal receiveContainer) {
		this.receiveContainer = receiveContainer;
	}
	
}
