package com.springtest.dao.forth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final int MIN_COUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    private final MailService mailService;

    public static List<User> users = Arrays.asList(
            User.of("id1", "park1", Level.BASIC, 50, 30),
            User.of("id2", "park2", Level.SILVER, 30, 40),
            User.of("id3", "park3", Level.GOLD, 40, 50));

    public int asdf() {
        return 1;
    }

    public void upgradeLevels() {
        for (User user : users) {
            if(canUpgradeLevel(user)) {
                user.upgradeLevel();
                sendUpgradeEMail(user);
            }
        }
    }

    private void sendUpgradeEMail(User user) {
        //원래는 user.email()로 보내야함
        mailService.sendMail("1004mapa2@naver.com", "메일 테스트", "ㅎㅇㅋㅋ");

    }

    private boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch(currentLevel) {
            case BASIC -> {
                return user.getLogin() >= MIN_COUNT_FOR_SILVER;
            }
            case SILVER -> {
                return user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD;
            }
            case GOLD -> {
                return false;
            }
            default -> throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }
}
