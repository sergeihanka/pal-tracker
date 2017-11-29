package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> entries = new HashMap<>();
    private Long id = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(id);
        entries.put(id, timeEntry);
        id++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return entries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = new ArrayList<TimeEntry>(entries.values());
        return list;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        entries.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        entries.remove(id);
    }
}
