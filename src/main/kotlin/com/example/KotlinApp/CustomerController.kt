package com.example.KotlinApp

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("customers")
class CustomerController {
    @GetMapping("")
    fun index(model: Model): String {
        model.addAttribute("customers", "")
                return "customers/index"
    }

}