package com.wizzstudio.smartlab.controller;

import com.wizzstudio.smartlab.dto.DataLogGetDto;
import com.wizzstudio.smartlab.dto.DataLogSetDto;
import com.wizzstudio.smartlab.repository.DataLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/DataLog")
@RestController
public class DataLogController {
    private final DataLogRepository dataLogRepository;

    public DataLogController(DataLogRepository dataLogRepository) {
        this.dataLogRepository = dataLogRepository;
    }

    @GetMapping()
    public Page<DataLogGetDto> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return dataLogRepository.findAll(PageRequest.of(pageNum - 1, pageSize)).map(DataLogGetDto::fromEntity);
    }

    @PostMapping
    public DataLogGetDto save(@RequestBody DataLogSetDto DataLogSetDto) {
        var DataLogEntity = DataLogSetDto.toEntity();
        return DataLogGetDto.fromEntity(dataLogRepository.save(DataLogEntity));
    }
}
