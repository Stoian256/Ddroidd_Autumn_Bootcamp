package applicationPortal.internship.service;

import applicationPortal.internship.domain.Address;
import applicationPortal.internship.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address addAddress(String address, String country, String state, String city) {
        Address newAddress = new Address(0, address, country, state, city);
        addressRepository.save(newAddress);
        return newAddress;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}
