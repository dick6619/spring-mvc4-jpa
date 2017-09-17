//package com.iii.ui.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.iii.emp.service.CustomerService;
//import com.iii.emp.vo.Customer;
//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//
//	@Autowired(required = true)
//	@Qualifier("customerService")
//	private CustomerService customerService;
//
//	@GetMapping("/")
//	public String getHome() {
//		return "redirect:customers.action";
//	}
//
//	@GetMapping("/customers")
//	public ModelAndView getCustomers() {
//		ModelAndView model = new ModelAndView("customers");
//		List<Customer> list = customerService.getAllCustomers();
//		model.addObject("customers", list);
//		return model;
//	}
//
//	@GetMapping("/editCustomerView/{customerId}")
//	public ModelAndView getEditCustomerForm(@PathVariable("customerId") String customerId) {
//		ModelAndView model = new ModelAndView("editCustomer");
//		Customer cus = customerService.getCustomer(Long.parseLong(customerId));
//		model.addObject("customer", cus);
//		return model;
//	}
//
//	@RequestMapping(value = "editCustomer", method = RequestMethod.POST)
//	public ModelAndView editCustomer(HttpServletRequest req, HttpServletResponse res) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("customers");
//		String customerId = req.getParameter("customerId");
//		String name = req.getParameter("name");
//		String country = req.getParameter("country");
//
//		Customer customer = customerService.updateCustomer(Long.parseLong(customerId), name, country);
//		if (customer != null) {
//			model.addObject("saveSuccess", "Customer Added SuccessFully:" + customer.getCustomerName());
//		} else {
//			model.addObject("saveError", "Customer creation failed");
//		}
//		List<Customer> list = customerService.getAllCustomers();
//		model.addObject("customers", list);
//		return model;
//
//	}
//
//	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
//	public ModelAndView addCustomer(HttpServletRequest req, HttpServletResponse res) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("customers");
//		String name = req.getParameter("name");
//		String country = req.getParameter("country");
//
//		Customer customer = customerService.addCustomer(name, country);
//		if (customer != null) {
//			model.addObject("saveSuccess", "Customer Added SuccessFully:" + customer.getCustomerName());
//		} else {
//			model.addObject("saveError", "Customer creation failed");
//		}
//		List<Customer> list = customerService.getAllCustomers();
//		model.addObject("customers", list);
//		return model;
//
//	}
//}
