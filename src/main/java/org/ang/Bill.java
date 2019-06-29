package org.ang;

	import java.util.Date;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

		
		@Table(name="bill")
		@Entity
		public class Bill {
			
			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private long id;
			@Column
			private String creditorName;
			@Column
			private String creditorPhoneNumber; 
			@Column
			private String billAmount;	
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			private Calendar billDueDate;
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Calendar billingCycleStartDate;
			@Column
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Calendar billingCycleEndDate; 
				

			public Bill() {
			}
			
			
			public Bill(long id, String creditorName, String creditorPhoneNumber, String billAmount){
			} 
			public long getId() {
				return id;
			}
			
			public void setId(long id) {
				this.id=id;
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
			public String getBillAmount() {
				return billAmount;
			}
			public void setBillAmount(String billAmount) {
				this.billAmount = billAmount;
			}
			public Calendar getBillDueDate() {
				return billDueDate;
			}
			public void setBillDueDate(Calendar billDueDate) {
				this.billDueDate = billDueDate;
			}
			public Calendar getBillingCycleStartDate() {
				return billingCycleStartDate;
			}
			public void setBillingCycleStartDate(Calendar billingCycleStartDate) {
				this.billingCycleStartDate = billingCycleStartDate;
			}
			public Calendar getBillingCycleEndDate() {
				return billingCycleEndDate;
			}
			public void setBillingCycleEndDate(Calendar billingCycleEndDate) {
				this.billingCycleEndDate = billingCycleEndDate;
			}


			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + (int) (id ^ (id >>> 32));
				return result;
			}


			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Bill other = (Bill) obj;
				if (id != other.id)
					return false;
				return true;
			}


		

			


			
		

}
