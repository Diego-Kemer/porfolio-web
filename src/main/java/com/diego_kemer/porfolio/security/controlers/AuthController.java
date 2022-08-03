
package com.diego_kemer.porfolio.security.controlers;

import com.diego_kemer.porfolio.security.Message;
import com.diego_kemer.porfolio.security.dto.JwtDto;
import com.diego_kemer.porfolio.security.dto.LogiUser;
import com.diego_kemer.porfolio.security.dto.NewUser;
import com.diego_kemer.porfolio.security.entities.Role;
import com.diego_kemer.porfolio.security.entities.User;
import com.diego_kemer.porfolio.security.enums.RoleList;
import com.diego_kemer.porfolio.security.jwt.JwtProvides;
import com.diego_kemer.porfolio.security.repositories.UserRepository;
import com.diego_kemer.porfolio.security.services.RoleService;
import com.diego_kemer.porfolio.security.services.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncode;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtProvides jwtProvides;
    private UserRepository userRepository;
    
    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncode, UserService userService, RoleService roleService, JwtProvides jwtProvides, UserRepository userRepository) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncode = passwordEncode;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvides = jwtProvides;
        this.userRepository = userRepository;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LogiUser loginUser, BindingResult bindignResult){
        if (bindignResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
            try {
                UsernamePasswordAuthenticationToken authentToken = new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authentToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvides.generateToken(authentication);
                JwtDto jwtDto = new JwtDto(jwt);
                return new ResponseEntity<>(jwtDto, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new Message("Revise sus credenciales") , HttpStatus.BAD_REQUEST);
            }
    }
    
    @PostMapping("/register")
    public ResponseEntity<Object> resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (userRepository.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity<>(new Message("El usuario ya està registrado"), HttpStatus.BAD_REQUEST);
        }
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        User user = new User(newUser.getUserName(),
                passwordEncode.encode(newUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleList.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }
    
    
}
