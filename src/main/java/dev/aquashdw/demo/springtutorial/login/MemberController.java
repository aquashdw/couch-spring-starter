package dev.aquashdw.demo.springtutorial.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(
            @Autowired
            MemberService memberService
    ){
        this.memberService = memberService;
    }

    @GetMapping(
            "/home"
    )
    public String home(){
        return "home";
    }

    @GetMapping(
            "/member/sign-up"
    )
    public String signUp(Model model){
        model.addAttribute("member", new MemberDto());

        return "/member/signUpForm";
    }

    @PostMapping(
            "/member/sign-up-request"
    )
    public String signUpRequest(MemberDto dto){
        memberService.signUp(dto);

        return "redirect:/home";
    }

    @GetMapping(
            "/member/login"
    )
    public String login(){
        return "/member/loginForm";
    }
}
