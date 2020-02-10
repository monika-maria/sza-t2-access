package pl.monikamaria.access;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccessRestController {

    private List<User_> users = new ArrayList<>();

    public AccessRestController() {
        users.add(new User_("Monika", "", "ROLE_ADMIN", 0));
        users.add(new User_("Mikołaj", "", "ROLE_USER", 0));
    }

    @EventListener
    public void authenticationSuccess(AuthenticationSuccessEvent event) {

        String username = ((User) event.getAuthentication().getPrincipal()).getUsername();

        for(User_ user : users){
            if(user.getUsername().equals(username)){
                user.setCount(user.getCount()+1);
            }
        }

    }

    @GetMapping("/forAll")
    public String forAll(){
        return "Cześć nieznajomy";
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal){
        return "Cześć user " + principal.getName()
                + "\nIlość logowań: " + users.stream().filter(user -> user.getUsername().equals(principal.getName())).findFirst().get().getCount();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal){
        return "Cześć admin " + principal.getName()
                + "\nIlość logowań: " + users.stream().filter(user -> user.getUsername().equals(principal.getName())).findFirst().get().getCount();
    }

    @GetMapping("/closeSession")
    public String logout(Principal principal){
        return "Pa pa ";
    }
}
