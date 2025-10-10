package id.co.bcafinance.msthreadleak.repository;

import id.co.bcafinance.msthreadleak.model.AppLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLogRepository extends JpaRepository<AppLog, Long> {
}
