package bupt.ugrd.controller;

/**
 * Created by Luyao on 2018/3/9.
 */

import bupt.ugrd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("getVerificationCode")
    public @ResponseBody String sendViaEmail(@RequestBody User user) {
        try {
            String verifiCode = "" + getRandNum(1, 999999);

            SimpleMailMessage message = new SimpleMailMessage();
            // Email Sender
            message.setFrom("superlaura18@163.com");

            // Email Receiver. In this version, we use userPhone field to represent userEmail, for free verification code!!
            message.setTo(user.getUserPhone());

            message.setSubject("GoldBugger");
            message.setText("Hi "+user.getUserName()+",\n\nWelcome to GoldBug Community! Please input Verification Code "+verifiCode+" to activate your account.\n\nBest,\nGoldBug Team");
            javaMailSender.send(message);
            return "success";
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Mail ERROR bbb");
        }
        return "failure";
    }

    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }

}
