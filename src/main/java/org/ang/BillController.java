package org.ang;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ang.BillRepository;
import org.ang.Bill;

@Controller
public class BillController {
	
//@Autowired
//private BillRepository billRepository;
 // @Autowired
	private BillRepository billRepository;
	
// private final BillRepository billRepository;
//  private BillRepository billRepository;
   
//   @Bean
//   public BillRepository billRepository() {
//       return new BillRepository();
//   }
 @Autowired
	public void setBillRepository(@Lazy BillRepository billRepository) {
	    this.billRepository = billRepository;
	}
	
	  @GetMapping("addbill")
	    public String addABillPage() {
	        return "addbill";

		}
	        
	  @PostMapping("addbill")
	    public String addBillSubmit(@RequestParam String creditorName, @RequestParam String billDueDate,@RequestParam String creditorPhoneNumber,@RequestParam Long billAmount, @RequestParam String billingCycleStartDate, @RequestParam String billingCycleEndDate) {
	        return "redirect:listofbills";
	        
	        
	    }     
	  billRepository.save(bill);
      return "redirect:listofbills";
  }
	    

	  @GetMapping("listofbills")
	    public String showUpdateForm(Model model) {
	        model.addAttribute("bills", billRepository.findAll());
	        return "listofbills";
	    }


	  
//
//	    @GetMapping("edit/{billId}")
//	    public String showUpdateForm(@PathVariable("billId") long billId, Model model) {
//	        Bill bill = billRepository.findById(billId)
//	            .orElseThrow(() -> new IllegalArgumentException("Invalid Bill Id:" + billId));
//	        model.addAttribute("student", bill);
//	        return "updatebill";
//	    }
//
//	    @PostMapping("update/{billId}")
//	    public String updateBill(@PathVariable("id") long billId, @Valid Bill bill, BindingResult result,
//	        Model model) {
//	        if (result.hasErrors()) {
//	            bill.setBillId(billId);
//	            return "update-bill";
//	        }
//
//	        billRepository.save(bill);
//	        model.addAttribute("bills", billRepository.findAll());
//	        return "index";
//	    }
//
//	    @GetMapping("delete/{id}")
//	    public String deleteBill(@PathVariable("billId") long billId, Model model) {
//	        Bill bill = billRepository.findById(billId)
//	            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + billId));
//	        billRepository.delete(bill);
//	        model.addAttribute("bills", billRepository.findAll());
//	        return "index";
//	    }  
		

}
