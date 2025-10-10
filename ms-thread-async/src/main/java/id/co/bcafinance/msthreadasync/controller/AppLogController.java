package id.co.bcafinance.msthreadasync.controller;

import id.co.bcafinance.msthreadasync.model.AppLog;
import id.co.bcafinance.msthreadasync.service.AppLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applogs")
@RequiredArgsConstructor
public class AppLogController {

    private final AppLogService appLogService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AppLog appLog) {
        appLogService.save(appLog);
        return ResponseEntity.ok("AppLog submitted for async processing");
    }

}

