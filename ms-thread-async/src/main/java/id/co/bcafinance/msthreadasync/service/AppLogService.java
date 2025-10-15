package id.co.bcafinance.msthreadasync.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bcafinance.msthreadasync.repository.AppLogRepository;
import id.co.bcafinance.msthreadasync.model.AppLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppLogService {

    private final AppLogRepository appLogRepository;

    @Async("logExecutor")
    public void save(AppLog appLog) {
        log.info("Mulai menyimpan AppLog...");

        try {
            appLogRepository.save(appLog);
            log.info("Berhasil menyimpan AppLog");
        } catch (Exception e) {
            log.error("Gagal menyimpan AppLog", e);
        }
    }
}


