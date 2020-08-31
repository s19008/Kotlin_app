package com.example.KotlinApp

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import kotlin.text.StringBuilder

@Controller
@RequestMapping("/form")
class FormController {

    @GetMapping("janken")
    fun janken() :String {
        return "form/janken"
    }

    @PostMapping("janken")
    fun janken(model: Model, @RequestParam janken :String) :String {
        var resultBuilder = StringBuilder("resultBuilder")
        resultBuilder.append("あなたは")
        when (janken) {
            "g" -> {
                resultBuilder.append("グー")
            }
            "c" -> {
                resultBuilder.append("チョキ")
            }
            else -> {
                resultBuilder.append("パー")
            }
        }
        resultBuilder.append("を出して")
        var random : Double = Math.random()
        when {
            random < 0.333 -> {
                resultBuilder.append("勝ちました。")
            }
            random < 0.666 -> {
                resultBuilder.append("負けました。")
            }
            else -> {
                resultBuilder.append("引き分けました。")
            }
        }
        model.addAttribute("result", resultBuilder)
        return "form/janken"
    }


}

