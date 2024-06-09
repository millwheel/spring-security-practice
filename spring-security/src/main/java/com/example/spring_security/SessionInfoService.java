package com.example.spring_security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionInfoService {

    private final SessionRegistry sessionRegistry;

    public void sessionInfo(){
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();// 모든 사용자 가져오기

        for (Object principal : allPrincipals) {
            List<SessionInformation> allSessions = sessionRegistry.getAllSessions(principal, false);// 활성화된 세션만
            for (SessionInformation sessionInformation : allSessions) {
                log.info("사용자:{}, 세션ID:{}, 최종요청시간:{}", principal, sessionInformation.getSessionId(), sessionInformation.getLastRequest());
            }
        }

    }

}
