package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.WechatOpenidGetDto;
import com.wizzstudio.smartlab.util.WeChatUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wechat")
@RestController
public class WechatController {
    @GetMapping("openid")
    public ResponseEntity<WechatOpenidGetDto> pageQuery(@RequestParam String code) throws Exception {
        var openid = WeChatUtil.AuthCode2Session(code);
        return ResponseEntity.ok(new WechatOpenidGetDto(openid));
    }
}
