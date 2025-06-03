package com.asliutkarsh.jsonvsproto.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import com.asliutkarsh.jsonvsproto.entity.User;
import com.asliutkarsh.protobuf.UserProto;
import com.asliutkarsh.jsonvsproto.service.UserService;

@RestController
@RequestMapping("/api/users/proto")
public class UserControllerProto {

    private final UserService userService;

    public UserControllerProto(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/x-protobuf")
    public UserProto.UserList getAllUsers() {
        List<UserProto.User> users = userService.getAllUsers().stream()
                .map(this::toProto)
                .collect(Collectors.toList());
        return UserProto.UserList.newBuilder().addAllUsers(users).build();
    }

    @GetMapping(value = "/{id}", produces = "application/x-protobuf")
    public UserProto.User getUserById(@PathVariable Long id) {
        return toProto(userService.getUserById(id));
    }

    @PostMapping(consumes = "application/x-protobuf", produces = "application/x-protobuf")
    public UserProto.User createUser(@RequestBody byte[] requestBytes) throws Exception {
        UserProto.User request = UserProto.User.parseFrom(requestBytes);
        User user = fromProto(request);
        return toProto(userService.createUser(user));
    }
    
    @PutMapping(value = "/{id}", consumes = "application/x-protobuf", produces = "application/x-protobuf")
    public UserProto.User updateUser(@PathVariable Long id, @RequestBody byte[] requestBytes) throws Exception {
        UserProto.User request = UserProto.User.parseFrom(requestBytes);
        User user = fromProto(request);
        return toProto(userService.updateUser(id, user));
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    private UserProto.User toProto(User user) {
        return UserProto.User.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setAge(user.getAge())
                .build();
    }

    private User fromProto(UserProto.User proto) {
        return User.builder()
                .name(proto.getName())
                .email(proto.getEmail())
                .age(proto.getAge())
                .build();
    }
}
