package id.co.bcafinance.msthreadleak.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bcafinance.msthreadleak.model.AppLog;
import id.co.bcafinance.msthreadleak.repository.AppLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppLogService {

    private final AppLogRepository appLogRepository;

    public void save(AppLog appLog) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(() -> {
            String threadName = Thread.currentThread().getName();
            log.info("[{}] Mulai menyimpan AppLog...", threadName);

            try {
                appLogRepository.save(appLog);
                log.info("[{}] Berhasil menyimpan AppLog", threadName);
            } catch (Exception e) {
                log.error("[{}] Gagal menyimpan AppLog", threadName, e);
            }
        });
    }
}
