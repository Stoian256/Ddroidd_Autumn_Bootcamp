package applicationPortal.internship;

import applicationPortal.internship.main.ApplicationPortalMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DdroiddBootcampApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DdroiddBootcampApplication.class, args);
        ApplicationPortalMain applicationPortalMain = applicationContext.getBean(ApplicationPortalMain.class);
        //Petnru primele rulari cand se adauga date in baza de date
        //applicationPortalService.createDataStructure();
        //applicationPortalService.displayDataStructure();

        //applicationPortalMain.displayFromDatabase();

        applicationPortalMain.opperations();
    }

}
