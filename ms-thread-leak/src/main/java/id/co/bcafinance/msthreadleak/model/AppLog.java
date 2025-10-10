package id.co.bcafinance.msthreadleak.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.function.Consumer;

@Entity
@Table(name = "app_log")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class AppLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "deleted")
    private boolean deleted;

    // === AppLog specific fields ===
    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "event_name", columnDefinition = "text")
    private String eventName;

    @Column(name = "data_request", columnDefinition = "text")
    private String dataRequest;

    @Column(name = "process_status", columnDefinition = "text")
    private String processStatus;

    @Column(name = "data_response", columnDefinition = "text")
    private String dataResponse;

    @Column(name = "backtrace", columnDefinition = "text")
    private String backTrace;

    @Column(name = "mobile_id", length = 20)
    private String mobileId;

    @Column(name = "error_code", length = 10)
    private String errorCode;

    // === Utility method (dari BaseModel) ===
    public <T> void setIfNotNull(Consumer<T> setter, T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}

