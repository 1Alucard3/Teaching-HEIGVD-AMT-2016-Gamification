package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.Event;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class EventsEndpoint implements EventsApi {

  private final ApplicationRepository applicationsRepository;
  private final EventProcessor eventProcessor;

  public EventsEndpoint(ApplicationRepository applicationsRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
    this.applicationsRepository = applicationsRepository;
    this.eventProcessor = eventProcessor;
  }

  @Override
  public ResponseEntity reportEvent(@RequestHeader(value="X-Gamification-Token") String xGamificationToken, @RequestBody Event event) {
    String targetApplicationName = xGamificationToken;
    String targetEndUserId = event.getUserId();
    Application targetApplication = applicationsRepository.findByName(targetApplicationName);
    if (targetApplication == null || targetEndUserId == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    eventProcessor.processEvent(targetApplication, event);
    return ResponseEntity.accepted().build();
  }


}
