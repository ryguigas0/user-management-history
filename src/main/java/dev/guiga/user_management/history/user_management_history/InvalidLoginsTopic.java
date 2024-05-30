package dev.guiga.user_management.history.user_management_history;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * InvalidLoginsTopic
 */
@Service
public class InvalidLoginsTopic {
    @Autowired
    private HistoryRepo repo;

    @Value("${topic.name.consumer}")
    private String topicName;

    private static final Logger log = LoggerFactory.getLogger(InvalidLoginsTopic.class);

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("RECEIVED MESSAGE FROM " + topicName);

        Gson gson = new Gson();
        FailLoginTO failLoginTO = gson.fromJson(payload.value(), FailLoginTO.class);
        
        HistoryModel model = repo.save(new HistoryModel(failLoginTO.username(), failLoginTO.failCount()));
        log.info("SAVED HISTORY: " + model.toString());
    }
}