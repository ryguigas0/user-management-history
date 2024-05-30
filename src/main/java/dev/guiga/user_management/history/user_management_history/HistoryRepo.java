package dev.guiga.user_management.history.user_management_history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends CrudRepository<HistoryModel, Integer> {

}
