package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {

	@GetMapping("")
	public String showBillingRecordPage() {
		return "billing-records/list";
	}
}
