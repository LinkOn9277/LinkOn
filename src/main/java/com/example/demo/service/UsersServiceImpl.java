package com.example.demo.service;

import com.example.demo.constant.Role;
import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService , UserDetailsService{

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public String sigUp(UsersDTO usersDTO) {

        Users users = modelMapper.map(usersDTO, Users.class);
        log.info("서비스에서 받아온 값 : " + users);

        Users usersCheck = usersRepository.findByEmail(users.getEmail());
        log.info("서비스에 받아온 값을 다시 초기화 해서 저장 : " + users);
        if (usersCheck != null){
            log.info("이미 가입된 회원입니다.");
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }else {
            log.info("가입되지 않은 회원입니다.");
            users.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
            log.info("패스워드 반환 값 : " + users.getPassword());

            users.setRole(Role.ADMIN);
            usersRepository.save(users);
            usersDTO = modelMapper.map(users, UsersDTO.class);

            return usersDTO.getName();
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // username => email 들어옴
        // 입력받은 email을 통해서 Entity 찾기

        Users users =
                usersRepository.findByEmail(email);

        if (users == null){
            log.info("현재 입력하신 email로는 가입된 정보가 없습니다.");
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
            // 핸들러 만들어 줘야함 차후에 try & catch 사용
        }
        log.info("로그인 시도하는 사람 : " + users);
        log.info("로그인하는 사람의 권한 : " + users.getRole().name());

        // 권한을 담을 변수
        String role = "";

        if (users.getRole().name().equals(Role.ADMIN.name())){
            log.info("관리자 로그인 시도중");
            role = users.getRole().name();
        }else {
            log.info("일반유저 로그인 시도중");
            role = users.getRole().name();
        }

        UserDetails userDetails =
                User.builder().username(users.getEmail())
                        .password(users.getPassword())
                        .roles(role).build();

        return userDetails;
    }
}
