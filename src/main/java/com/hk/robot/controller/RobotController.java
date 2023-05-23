package com.hk.robot.controller;

import com.plexpt.chatgpt.ChatGPT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author : HK意境
 * @ClassName : RobotController
 * @date : 2023/5/23 23:06
 * @description :
 * @Todo :
 * @Bug :
 * @Modified :
 * @Version : 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/robot")
public class RobotController {

    @Resource
    private ChatGPT chatGPT;

    @GetMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestParam("q") String q) {

        String answer;
        if (Objects.isNull(q) || q.length() == 0) {
            answer = "请描述一下你想要资讯的问题哦!";
        } else {
            // 获取答案
            String chat = this.chatGPT.chat(q);
            answer = chat;
        }

        return ResponseEntity.ok(answer);
    }

    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestParam("q") String q) {

        return ResponseEntity.ok("response:" + q);
    }


}
