package mau.project.sharepool.address;

import mau.project.sharepool.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
    private AddressRepository addressRepository;

    public List getAddress() {
        return addressRepository.findAll();
    }
}
