package myApplication.service;

import myApplication.exception.AppException;
import myApplication.model.SimUser;

import java.util.List;

public interface SimUserService {
    SimUser addNewSimUser(SimUser simUser) throws AppException;
    SimUser updateSimUserInfo(String simuserId, SimUser simUser) throws AppException;
    SimUser getSimUserInfo(String simuserId ) throws AppException;
    List<SimUser> getAllSimUsers() throws AppException;
    void deleteSimUser(String simuserId) throws AppException;

    SimUser findByUsername(String username) throws AppException;

}

