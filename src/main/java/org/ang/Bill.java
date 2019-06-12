package org.ang;

	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

		
		@Table(name="bill")
		@Entity
		public class Bill {
			
			@Id
			@GeneratedValue
			private long billId;
			@Column
			private String creditorName;
			@Column
			private String creditorPhoneNumber; 
			@Column
			private Long billAmount;	
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Date billDueDate;
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Date billingCycleStartDate;
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd")

			private Date billingCycleEndDate; 
				

			public Bill() {
			}
			
			
			public Bill(long billId, String creditorName, String creditorPhoneNumber, long billAmount){
				// TODO Auto-generated constructor stub
			} 
			public long getBillId() {
				return billId;
			}
			public void setBillId(long billId) {
				this.billId = billId;
			}

		public String getCreditorName() {
				return creditorName;
			}
			public void setCreditorName(String creditorName) {
				this.creditorName = creditorName;
			}
			public String getCreditorPhoneNumber() {
				return creditorPhoneNumber;
			}
			public void setCreditorPhoneNumber(String creditorPhoneNumber) {
				this.creditorPhoneNumber = creditorPhoneNumber;
			}
			public Long getBillAmount() {
				return billAmount;
			}
			public void setBillAmount(Long billAmount) {
				this.billAmount = billAmount;
			}
			public Date getBillDueDate() {
				return billDueDate;
			}
			public void setBillDueDate(Date billDueDate) {
				this.billDueDate = billDueDate;
			}
			public Date getBillingCycleStartDate() {
				return billingCycleStartDate;
			}
			public void setBillingCycleStartDate(Date billingCycleStartDate) {
				this.billingCycleStartDate = billingCycleStartDate;
			}
			public Date getBillingCycleEndDate() {
				return billingCycleEndDate;
			}
			public void setBillingCycleEndDate(Date billingCycleEndDate) {
				this.billingCycleEndDate = billingCycleEndDate;
			}


			
		

}
