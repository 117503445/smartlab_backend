package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.BehaviorLogGetDto;
import com.wizzstudio.smartlab.dto.BehaviorLogSetDto;
import com.wizzstudio.smartlab.entity.BehaviorLogEntity;
import com.wizzstudio.smartlab.repository.BehaviorLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping(value = "csv", produces = "application/json;charset=gbk")
    public String toCSV(HttpServletResponse response) {
        response.setHeader("Content-Disposition", "attachment;filename=BehaviorLog.csv");
        var behaviorLogs = behaviorLogRepository.findAll();
        StringBuilder s = new StringBuilder();
        s.append(BehaviorLogEntity.getCSVHeader());
        for (var behaviorLog : behaviorLogs) {
            s.append(behaviorLog.toCSV());
        }
        return s.toString();
    }
}
