package com.clinic.clinic.docs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class SwaggerHTMLRedirector {
    @GetMapping("/docs")
    public RedirectView docs() {
        return new RedirectView("/v2/api-docs");
    }

    @GetMapping("/docs_ui")
    public RedirectView docsUi() {
        return new RedirectView("/swagger-ui/index.html");
    }
}
