package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.goforcode.invoicify.repositories.BillingRecordRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {
	
	private BillingRecordRepository billingRecordRepository;
	
	BillingRecordController(){};
	
	BillingRecordController(BillingRecordRepository billingRecordRepository){
		this.billingRecordRepository = billingRecordRepository;
	}

	@GetMapping("")
	public String showBillingRecordPage() {
		return "billing-records/list";
	}
}
