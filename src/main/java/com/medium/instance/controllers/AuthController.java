package com.medium.instance.controllers;


import com.medium.instance.models.user.WebUser;
import com.medium.instance.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {


    @Autowired
    private WebUserService userService;


    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UUID> registerUser(@Valid @RequestBody WebUser webuser) {
        UUID response = userService.createWebUser(webuser);
        return new ResponseEntity<UUID>(response, HttpStatus.CREATED);
    }


//    @PostMapping(path = "/login")
//    public UUID login() {
//        return UUID.fromString("ok");
//    }
//
//
//    @GetMapping(path = "/{userID}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<WebUser> getUser(@PathVariable String userID) {
//        WebUser user = new WebUser();
//        user.setFirstName("alex");
//        return new ResponseEntity<WebUser>(user, HttpStatus.OK);
//    }
//
//
//    @GetMapping
//    public WebUser[] getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "sort", required = false) String sort) {
//        return null;
//    }
//
//    @PutMapping(path = "/{userID}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public WebUser updateUser(@PathVariable String userID, @Valid @RequestBody WebUser webuser) {
//        if (this.users.containsKey(userID)) {
//            WebUser oldUser = this.users.get(userID);
//            oldUser.setFirstName(webuser.getFirstName());
//            this.users.put(userID, oldUser);
//            return webuser;
//        }
//        return null;
//    }
//
//
//    @DeleteMapping(path = "/{userID}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String userID){
//        users.remove(userID);
//        return ResponseEntity.ok().build();
//    }

}