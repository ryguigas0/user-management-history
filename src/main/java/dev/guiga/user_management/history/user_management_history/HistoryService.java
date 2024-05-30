package dev.guiga.user_management.history.user_management_history;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepo repo;

    public List<HistoryModel> listHistory() {
        List<HistoryModel> list = new ArrayList<HistoryModel>();

        repo.findAll().forEach(h -> list.add(h));

        return list;
    }
}
