package dev.guiga.user_management.history.user_management_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService service;

    @GetMapping("/")
    public List<HistoryModel> list() {
        return service.listHistory();
    }

}
