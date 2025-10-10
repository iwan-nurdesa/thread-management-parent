package id.co.bcafinance.msthreadleak.controller;

import id.co.bcafinance.msthreadleak.model.AppLog;
import id.co.bcafinance.msthreadleak.service.AppLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

