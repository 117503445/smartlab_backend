package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.FeedBackGetDto;
import com.wizzstudio.smartlab.dto.FeedBackSetDto;
import com.wizzstudio.smartlab.entity.FeedbackEntity;
import com.wizzstudio.smartlab.repository.FeedBackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/feedback")
@RestController
public class FeedBackController {
    private final FeedBackRepository feedBackRepository;

    public FeedBackController(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }

    @GetMapping()
    public Page<FeedBackGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return feedBackRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(FeedBackGetDto::fromEntity);
    }

    @PostMapping
    public FeedBackGetDto save(@RequestBody FeedBackSetDto feedBackSetDto) {
        var feedBackEntity = feedBackSetDto.toEntity();
        return FeedBackGetDto.fromEntity(feedBackRepository.save(feedBackEntity));
    }

    @GetMapping(value = "csv", produces = "application/json;charset=gbk")
    public String toCSV(HttpServletResponse response) {
        response.setHeader("Content-Disposition", "attachment;filename=feedback.csv");
        var feedBacks = feedBackRepository.findAll();
        StringBuilder s = new StringBuilder();
        s.append(FeedbackEntity.getCSVHeader());
        for (var feedback : feedBacks) {
            s.append(feedback.toCSV());
        }
        return s.toString();
    }
}
