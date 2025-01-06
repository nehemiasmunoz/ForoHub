package com.marvic.forohub.service.user.inter;

import com.marvic.forohub.dtos.user.NewUserDTO;
import com.marvic.forohub.dtos.user.UserDTO;

import java.util.Set;

public interface IUserService {

    Set<UserDTO> getUsers();

    UserDTO getUserById(Long id);

    UserDTO saveUser(NewUserDTO user);
}
