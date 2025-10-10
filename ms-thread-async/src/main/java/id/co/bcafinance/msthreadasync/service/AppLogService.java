package id.co.bcafinance.msthreadasync.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bcafinance.msthreadasync.repository.AppLogRepository;
import id.co.bcafinance.msthreadasync.model.AppLog;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppLogService {

    private final AppLogRepository appLogRepository;
    private final ObjectMapper objectMapper;

    @Async("logExecutor")
    public void save(AppLog appLog) {
        appLogRepository.save(appLog);
    }
}

