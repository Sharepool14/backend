package mau.project.sharepool.address;

import mau.project.sharepool.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    public List getAddress() {
        return addressRepository.findAll();
    }
}
