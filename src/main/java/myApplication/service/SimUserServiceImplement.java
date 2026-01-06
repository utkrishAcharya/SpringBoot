package myApplication.service;

import myApplication.exception.AppException;
import myApplication.model.SimUser;
import myApplication.repository.SimUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimUserServiceImplement implements SimUserService {

    @Autowired
    private SimUserRepository repository;

    @Override
    public SimUser addNewSimUser(SimUser simUser) throws AppException {
        return repository.save(simUser);
    }

    @Override
    public SimUser updateSimUserInfo(String simuserId, SimUser simUser) throws AppException {
        SimUser existing = repository.findById(simuserId)
                .orElseThrow(() -> new AppException("User not found"));

        existing.setName(simUser.getName());
        existing.setPhone(simUser.getPhone());
        existing.setEmail(simUser.getEmail());

        return repository.save(existing);
    }

    @Override
    public SimUser getSimUserInfo(String simuserId) throws AppException {
        return repository.findById(simuserId)
                .orElseThrow(() -> new AppException("User not found"));
    }

    @Override
    public List<SimUser> getAllSimUsers() throws AppException {
        return repository.findAll();
    }

    @Override
    public void deleteSimUser(String simuserId) throws AppException {
        repository.deleteById(simuserId);
    }

    @Override
    public SimUser findByUsername(String username) throws AppException {
        SimUser user = repository.findByUsername(username);
        if (user == null) {
            throw new AppException("User not found");
        }
        return user;
    }
}
