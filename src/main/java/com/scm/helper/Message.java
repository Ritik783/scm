package com.scm.helper;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String content;
    @Builder.Default
    private MessageType messageType=MessageType.Blue;
}
