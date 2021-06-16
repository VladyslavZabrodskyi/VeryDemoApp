package com.ProjectForGit.ProjectForGit.Controller;

import com.ProjectForGit.ProjectForGit.AppUser.AppUserRole;
import com.ProjectForGit.ProjectForGit.Registration.RegistrationRequest;
import com.ProjectForGit.ProjectForGit.ShopItem.ShopItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("RegistrationRequest", new RegistrationRequest(AppUserRole.USER));
        return "registration";
    }

    @GetMapping("/error")
    public String getError(){
        return "error";
    }

    @GetMapping("/logout")
    public String getLogOut(){
        return "logout";
    }

    @GetMapping("/ShopItemList")
    public String getShopItems(Model model){
        model.addAttribute("ShopItems", ShopItemService.getShopItems());
        return "ShopItemList";
    }


}
