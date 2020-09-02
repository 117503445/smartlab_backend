package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.BehaviorLogGetDto;
import com.wizzstudio.smartlab.dto.BehaviorLogSetDto;
import com.wizzstudio.smartlab.repository.BehaviorLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/BehaviorLog")
@RestController
public class BehaviorLogController {
    private final BehaviorLogRepository behaviorLogRepository;

    public BehaviorLogController(BehaviorLogRepository behaviorLogRepository) {
        this.behaviorLogRepository = behaviorLogRepository;
    }

    @GetMapping()
    public Page<BehaviorLogGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return behaviorLogRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(BehaviorLogGetDto::fromEntity);
    }

    @PostMapping
    public BehaviorLogGetDto save(@RequestBody BehaviorLogSetDto behaviorLogSetDto) {
        var behaviorLogEntity = behaviorLogSetDto.toEntity();
        return BehaviorLogGetDto.fromEntity(behaviorLogRepository.save(behaviorLogEntity));
    }
}
