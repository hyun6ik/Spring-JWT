package com.example.jwt;

import com.example.jwt.entity.Authority;
import com.example.jwt.entity.User;
import com.example.jwt.entity.UserAndAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }


    @Component
    @Transactional(readOnly = true)
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            User user = new User().builder()
                    .username("hyunsik")
                    .password("123456")
                    .nickname("hyun6ik")
                    .activated(true)
                    .build();
            em.persist(user);

            Authority authority1 = new Authority().builder()
                    .authorityName("ROLE_USER")
                    .build();
            Authority authority2 = new Authority().builder()
                    .authorityName("ROLE_ADMIN")
                    .build();
            em.persist(authority1);
            em.persist(authority2);

            UserAndAuthority userAndAuthority1 = new UserAndAuthority().builder()
                    .user(user)
                    .authority(authority1)
                    .build();
            UserAndAuthority userAndAuthority2 = new UserAndAuthority().builder()
                    .user(user)
                    .authority(authority2)
                    .build();
            em.persist(userAndAuthority1);
            em.persist(userAndAuthority2);

//            UserAndAuthority userAndAuthority1 = new UserAndAuthority().createUserAndAuthority(user, authority1);
//            UserAndAuthority userAndAuthority2 = new UserAndAuthority().createUserAndAuthority(user, authority2);
//            em.persist(userAndAuthority1);
//            em.persist(userAndAuthority2);


        }
    }
}
