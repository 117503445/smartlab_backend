package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.config.EnvironmentConfig;
import com.wizzstudio.smartlab.dto.FeedBackGetDto;
import com.wizzstudio.smartlab.dto.FeedBackSetDto;
import com.wizzstudio.smartlab.entity.FeedbackEntity;
import com.wizzstudio.smartlab.repository.FeedBackRepository;
import com.wizzstudio.smartlab.util.ServerChanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/api/feedback")
@RestController
public class FeedBackController {
    private final EnvironmentConfig environmentConfig;
    private final FeedBackRepository feedBackRepository;

    public FeedBackController(FeedBackRepository feedBackRepository, EnvironmentConfig environmentConfig) {
        this.feedBackRepository = feedBackRepository;
        this.environmentConfig = environmentConfig;
    }

    @GetMapping()
    public Page<FeedBackGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return feedBackRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(FeedBackGetDto::fromEntity);
    }

    @PostMapping
    public FeedBackGetDto save(@RequestBody FeedBackSetDto feedBackSetDto) throws IOException {
        var feedBackEntity = feedBackSetDto.toEntity();

        var serverChans = environmentConfig.getServerChan();
        for (var serverChan : serverChans) {
            System.out.println(serverChan);
            ServerChanUtil.Push(serverChan, feedBackEntity.getType() + "丨" + feedBackEntity.getPage(), feedBackEntity.getContactInfo() + ";" + feedBackEntity.getContent());
        }
        return FeedBackGetDto.fromEntity(feedBackRepository.save(feedBackEntity));
    }

    @GetMapping(value = "download", produces = "application/json;charset=gbk")
    public String downloadCSV(HttpServletResponse response) {
        response.setHeader("Content-Disposition", "attachment;filename=feedback.csv");
        return getFeedbackCSV();
    }

    @GetMapping(value = "view", produces = "application/json;charset=gbk")
    public String viewCSV() {
        return getFeedbackCSV();
    }

    private String getFeedbackCSV() {
        var feedBacks = feedBackRepository.findAll();
        StringBuilder s = new StringBuilder();
        s.append(FeedbackEntity.getCSVHeader());
        for (var feedback : feedBacks) {
            s.append(feedback.toCSV());
        }
        return s.toString();
    }
}
