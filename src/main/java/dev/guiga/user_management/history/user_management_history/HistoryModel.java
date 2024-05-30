package dev.guiga.user_management.history.user_management_history;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "history")
@Getter
@ToString
@NoArgsConstructor
public class HistoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String username;
    @Column
    private int failCount;
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public HistoryModel(String username, int failCount) {
        this.username = username;
        this.failCount = failCount;
        this.timestamp = new Date();
    }
}
