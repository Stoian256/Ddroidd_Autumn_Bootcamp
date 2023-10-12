package applicationPortal.internship.service;

import applicationPortal.internship.domain.Address;
import applicationPortal.internship.domain.Employer;
import applicationPortal.internship.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;

    public Employer addEmployer(String name, String phoneNumber, String email, Address address) {
        Employer employer = new Employer(0, name, phoneNumber, email, address);
        employerRepository.save(employer);
        return employer;
    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }
}
