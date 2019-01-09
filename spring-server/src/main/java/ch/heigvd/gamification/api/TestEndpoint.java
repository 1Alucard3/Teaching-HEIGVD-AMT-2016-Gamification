package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.Test;
import ch.heigvd.gamification.api.dto.TestSummary;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.model.Application;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestEndpoint implements TestApi {

    private ApplicationRepository applicationsRepository;

    public TestEndpoint(ApplicationRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }
    @Override
    public ResponseEntity<List<TestSummary>> testGet() {
        List<TestSummary> result = new ArrayList<>();
        for(Application application : applicationsRepository.findAll()){
            TestSummary ts = new TestSummary();
            ts.setApplicationName(application.getName());
            result.add(ts);
        }
        return ResponseEntity.ok(result);

    }

    @Override
    public ResponseEntity<Void> testPost(@RequestBody Test test) {
        Application newApplication = new Application();
        newApplication.setName(test.getApplicationName());
        String passwordHash = test.getPassword();
        newApplication.setPasswordHash(passwordHash);
        try{
            applicationsRepository.save(newApplication);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }
}
