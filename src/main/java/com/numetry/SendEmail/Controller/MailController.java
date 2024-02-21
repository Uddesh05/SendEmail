package com.numetry.SendEmail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Entity;

import com.numetry.SendEmail.Entiy.MailEntity;
import com.numetry.SendEmail.Service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

@Autowired
private MailService mailService;


@PostMapping("/send/{mail}")
 public String sendMail(@PathVariable String mail, @RequestBody MailEntity mailentity) {
	 mailService.sendMail(mail, mailentity);
	 return "Mail Sent Successfully...";
 }
}
