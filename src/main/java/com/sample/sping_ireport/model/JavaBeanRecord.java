package com.sample.sping_ireport.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JavaBeanRecord {
	private String code;//订单编号
	private String payName;//付款方 
	private BigDecimal payCapacity;//运力服务
	private BigDecimal payContainer;//集装箱租金收入
	private BigDecimal payTotal; //收入小计
	private BigDecimal receiveTotal;//支出小计
	private BigDecimal profit; //利润小计
	private List<JavaBeanReceive> receive; //支出
	
	public JavaBeanRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JavaBeanRecord(String code, String payName, BigDecimal payCapacity, BigDecimal payContainer,
			BigDecimal payTotal, BigDecimal receiveTotal, BigDecimal profit, List<JavaBeanReceive> receive) {
		this.code = code;
		this.payName = payName;
		this.payCapacity = payCapacity;
		this.payContainer = payContainer;
		this.payTotal = payTotal;
		this.receiveTotal = receiveTotal;
		this.profit = profit;
		this.receive = receive;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public BigDecimal getPayCapacity() {
		return payCapacity;
	}

	public void setPayCapacity(BigDecimal payCapacity) {
		this.payCapacity = payCapacity;
	}

	public BigDecimal getPayContainer() {
		return payContainer;
	}

	public void setPayContainer(BigDecimal payContainer) {
		this.payContainer = payContainer;
	}

	public BigDecimal getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(BigDecimal payTotal) {
		this.payTotal = payTotal;
	}

	public BigDecimal getReceiveTotal() {
		return receiveTotal;
	}

	public void setReceiveTotal(BigDecimal receiveTotal) {
		this.receiveTotal = receiveTotal;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public List<JavaBeanReceive> getReceive() {
		return receive;
	}

	public void setReceive(List<JavaBeanReceive> receive) {
		this.receive = receive;
	}

	public static List<JavaBeanRecord> getList() {
		List<JavaBeanRecord> list = new ArrayList<JavaBeanRecord>();
		List<JavaBeanReceive> receives1 = new ArrayList<JavaBeanReceive>();
		List<JavaBeanReceive> receives2 = new ArrayList<JavaBeanReceive>();
		
		JavaBeanReceive beanReceive = new JavaBeanReceive("华为",new BigDecimal("10000"),new BigDecimal("10000"));
		JavaBeanReceive beanReceive2 = new JavaBeanReceive("华为111",new BigDecimal("10000"),new BigDecimal("10000"));
		JavaBeanReceive beanReceive3 = new JavaBeanReceive("华为111",new BigDecimal("10000"),new BigDecimal("10000"));
		
		receives1.add(beanReceive);
		receives1.add(beanReceive2);
		list.add(new JavaBeanRecord("D111","中农",new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),receives1));
		receives2.add(beanReceive);
		receives2.add(beanReceive2);
		receives2.add(beanReceive3);
		list.add(new JavaBeanRecord("D222","中农2",new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),new BigDecimal("10000"),receives2));
		return list;
	}
}
