package cn.nonocast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@SpringBootApplication
@RequestMapping("/")
public class SeedApplication {

    @RequestMapping(value="**", method= RequestMethod.GET)
    public String any(HttpServletRequest request, Model model) {
        model.addAttribute("uri", request.getRequestURI());
        return "any";
    }

	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}
