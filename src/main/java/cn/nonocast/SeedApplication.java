package cn.nonocast;

import cn.nonocast.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SpringBootApplication
@RequestMapping("/")
public class SeedApplication {
    @Autowired
    private PageService pageService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String home(HttpServletRequest request) {
        String query = "";
        if(request.getQueryString() != null) {
            query = "?" + request.getQueryString();
        }
        return "redirect:/index.html" + query;
    }

    @RequestMapping(value="**/*.html", method=RequestMethod.GET)
    public Object dispatch(@RequestParam(value="action", required=false, defaultValue="show") String action, HttpServletRequest request, Model model) {
        if (action.equals("edit")) return edit(request, model);
        return show(request, model);
    }

    public HttpEntity show(HttpServletRequest request, Model model) {
        String uri = request.getRequestURI();
        String content = "<html><body><a href='" + uri + "?action=edit" + "'>edit</a></body></html>";

         if(pageService.has(uri)) {
            content = pageService.get(uri);
         }

        model.addAttribute("uri", uri);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new HttpEntity(content, headers);
    }

    public ModelAndView edit(HttpServletRequest request, Model model) {
        ModelAndView mav = new ModelAndView("edit");
        String uri = request.getRequestURI();
        model.addAttribute("uri", uri);
        if(pageService.has(uri)) {
            model.addAttribute("content", pageService.get(uri));
        }
        mav.addAllObjects(model.asMap());
        return mav;
    }

    @RequestMapping(value="**/*.html", method=RequestMethod.POST)
    public String update(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String uri = request.getRequestURI();
        String content = request.getParameter("content");
        pageService.put(uri, content);
        return "redirect:" + uri + "?action=edit";
    }

	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}
}
