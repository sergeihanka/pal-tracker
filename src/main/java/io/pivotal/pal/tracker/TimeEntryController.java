package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    public TimeEntryRepository repo;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.repo = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody TimeEntry timeEntry) {
        TimeEntry entry = repo.create(timeEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long l) {
        TimeEntry entry = repo.find(l);
        if(entry != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entry);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> entries = repo.list();
        return ResponseEntity.status(HttpStatus.OK).body(entries);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") long l, @Valid @RequestBody TimeEntry expected) {
        TimeEntry entry = repo.update(l, expected);
        if(entry != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entry);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id")long l) {
        repo.delete(l);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
