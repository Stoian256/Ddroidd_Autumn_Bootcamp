package applicationPortal.internship.controller;

import applicationPortal.internship.main.ApplicationPortalMain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicationPortal")
@RequiredArgsConstructor
public class ApplicationOperationController {
    private final ApplicationPortalMain applicationPortalMain;

    @PostMapping("/add2NewJobs")
    @ResponseStatus(HttpStatus.CREATED)
    public void add2NewJobListings() {
        applicationPortalMain.add2NewJobListings();
    }

    @GetMapping("displayJobsByEmployer/{id}")
    public void displayJobsByEmployer(@PathVariable("id") int id) {
        applicationPortalMain.displayJobsByEmployer(id);
    }

    @GetMapping("displayApplicantsByEmployer")
    public void displayApplicantsByEmployer() {
        applicationPortalMain.displayApplicantsByEmployer();
    }

    @GetMapping("displayApplicantsByJobListing")
    public void displayApplicantsByJobListing() {
        applicationPortalMain.displayApplicantsByJobListing();
    }


}
