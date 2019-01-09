package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.TestSummary;
import ch.heigvd.gamification.api.dto.Test;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-12-17T16:12:28.893+01:00")

@Api(value = "test", description = "the test API")
public interface TestApi {

    @ApiOperation(value = "", notes = "", response = TestSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "This is the description of a test", response = TestSummary.class) })
    @RequestMapping(value = "/test",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TestSummary>> testGet();


    @ApiOperation(value = "", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new test", response = Void.class) })
    @RequestMapping(value = "/test",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> testPost(

@ApiParam(value = "The test required to regist a test" ,required=true ) @RequestBody Test body

);

}
