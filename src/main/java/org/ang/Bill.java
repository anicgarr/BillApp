package org.ang;

	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

		
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
			private String billDueDate;
			@Column
			private String billingCycleStartDate;
			@Column
			private String billingCycleEndDate; 
				

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
			public String getBillDueDate() {
				return billDueDate;
			}
			public void setBillDueDate(String billDueDate) {
				this.billDueDate = billDueDate;
			}
			public String getBillingCycleStartDate() {
				return billingCycleStartDate;
			}
			public void setBillingCycleStartDate(String billingCycleStartDate) {
				this.billingCycleStartDate = billingCycleStartDate;
			}
			public String getBillingCycleEndDate() {
				return billingCycleEndDate;
			}
			public void setBillingCycleEndDate(String billingCycleEndDate) {
				this.billingCycleEndDate = billingCycleEndDate;
			}


			
		

}
