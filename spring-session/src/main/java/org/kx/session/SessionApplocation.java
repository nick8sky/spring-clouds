package org.kx.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * create by sunkx on 2018/1/4
 */
@SpringBootApplication
@RestController
public class SessionApplocation {

    public static void main(String[] args) {
        SpringApplication.run(SessionApplocation.class, args);
    }

    @GetMapping("/")
    public String uid(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return uid.toString() + ":" + session.getId();
    }

}
