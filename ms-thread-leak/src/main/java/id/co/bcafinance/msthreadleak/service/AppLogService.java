package id.co.bcafinance.msthreadleak.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bcafinance.msthreadleak.model.AppLog;
import id.co.bcafinance.msthreadleak.repository.AppLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class AppLogService {

    private final AppLogRepository appLogRepository;
    private final ObjectMapper objectMapper;

    public void save(AppLog appLog) {
        ExecutorService service = Executors.newFixedThreadPool(4);
		service.submit(new Runnable() {
			public void run() {
                appLogRepository.save(appLog);
			}
		});

    }
}

