package com.gabrielkuhn.user.service;

import com.gabrielkuhn.user.entity.User;
import com.gabrielkuhn.user.repository.UserRepository;
import com.gabrielkuhn.user.vo.Department;
import com.gabrielkuhn.user.vo.ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
