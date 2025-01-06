package com.marvic.forohub.service.user;

import com.marvic.forohub.dtos.user.NewUserDTO;
import com.marvic.forohub.dtos.user.UserDTO;
import com.marvic.forohub.entities.user.User;
import com.marvic.forohub.exceptions.DataNotFoundException;
import com.marvic.forohub.repository.user.UserRepository;
import com.marvic.forohub.service.user.inter.IUserService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService implements IUserService {

    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) throw new DataNotFoundException("Sin registros.");
        return Set.of();
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) throw new DataNotFoundException("Usuario no encontrado.");
        return new UserDTO(user.get());
    }

    @Override
    @Transactional
    public UserDTO saveUser(NewUserDTO user) {
        return new UserDTO(userRepository.save(new User(user)));
    }
}
