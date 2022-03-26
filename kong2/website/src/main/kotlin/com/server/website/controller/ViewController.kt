package com.server.website.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class ViewController {

    @RequestMapping("/")
    fun index(model: Model) : String {
        return "index"
    }
}