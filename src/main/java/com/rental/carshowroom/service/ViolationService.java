package com.rental.carshowroom.service;

import com.rental.carshowroom.model.User;
import com.rental.carshowroom.model.Violation;
import com.rental.carshowroom.model.enums.UserStatus;
import com.rental.carshowroom.repository.UserRepository;
import com.rental.carshowroom.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@PropertySource("classpath:validationmessages.properties")
public class ViolationService {

    private ViolationRepository violationRepository;
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public ViolationService(ViolationRepository violationRepository, UserService userService, UserRepository userRepository) {
        this.violationRepository = violationRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Violation addViolationForUser(Violation violation) {
        User user = userService.findUser(violation.getViolatingUser().getId());
        if (findViolationsFromLastDays(violation.getViolatingUser().getId(), LocalDateTime.now().minusDays(30)).size() >= 2) {
            user.setStatus(UserStatus.BANNED);
        }
        return violationRepository.save(Violation.builder()
                .violatingUser(user)
                .violationType(violation.getViolationType())
                .violationEnd(LocalDateTime.now().plusDays(30))
                .violationStart(LocalDateTime.now())
                .build());
    }

    public User banUser(Long id) {
        User userInDb = userService.findUser(id);
        userInDb.setStatus(UserStatus.BANNED);
        return userRepository.save(userInDb);
    }

    public User unbanUser(Long id) {
        User userInDb = userService.findUser(id);
        userInDb.setStatus(UserStatus.ACTIVE);
        return userRepository.save(userInDb);
    }

    public List<Violation> findViolationsFromLastDays(Long id, LocalDateTime date) {
        return violationRepository.findAllByViolatingUserAndViolationStartAfter(User.builder().id(id).build(), date);
    }
}
