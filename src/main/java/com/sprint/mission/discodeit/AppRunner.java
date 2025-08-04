package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {
    // 서비스를 필드로 선언
    private final UserService userService;
    private final ChannelService channelService;
    private final MessageService messageService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Discodeit Application Runner Started");
        User user = setupUser();
        Channel channel = setupChannel();
        messageCreateTest(channel, user);
        System.out.println("Discodeit Application Runner Finished");
    }

    private User setupUser() {
        User user = userService.create("woody", "woody@codeit.com", "woody1234");
        return user;
    }

    private Channel setupChannel() {
        Channel channel = channelService.create(ChannelType.PUBLIC, "공지", "공지 채널입니다.");
        return channel;
    }

    private void messageCreateTest(Channel channel, User author) {
        Message messgae = messageService.create("안녕하세요", channel.getId(),author.getId());
        System.out.println("메세지 생성 완료: " + messgae.getId() + "");
    }


}
