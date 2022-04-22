package mau.project.sharepool.address;

import mau.project.sharepool.account.Account;

import java.util.List;

public class AddressService {
    private AddressRepository addressRepository;

    public List getAddress() {
        return addressRepository.findAll();
    }
}
