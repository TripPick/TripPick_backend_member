package com.touripick.backend_member.domain.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.touripick.backend_member.domain.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SiteUserInfoEvent {
    public static final String Topic = "userinfo";

    private String action;

    private String userId;

    private String phoneNumber;

    private LocalDateTime eventTime;

    public static SiteUserInfoEvent fromEntity(String action, SiteUser siteUser) {
        SiteUserInfoEvent message = new SiteUserInfoEvent();

        message.action = action;
        message.userId = siteUser.getUserId();
        message.phoneNumber = siteUser.getPhone();
        message.eventTime = LocalDateTime.now();

        return message;
    }
}