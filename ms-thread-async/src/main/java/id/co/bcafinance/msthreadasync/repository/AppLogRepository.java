package id.co.bcafinance.msthreadasync.repository;

import id.co.bcafinance.msthreadasync.model.AppLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLogRepository extends JpaRepository<AppLog, Long> {
}
