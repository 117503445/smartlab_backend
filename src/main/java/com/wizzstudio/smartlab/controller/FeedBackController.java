package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.FeedBackGetDto;
import com.wizzstudio.smartlab.dto.FeedBackSetDto;
import com.wizzstudio.smartlab.repository.FeedBackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
}
