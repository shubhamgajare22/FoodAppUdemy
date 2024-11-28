package in.skg.userinfo.service.impl;

import in.skg.userinfo.dto.UserDto;
import in.skg.userinfo.entities.User;
import in.skg.userinfo.mapper.UserMapper;
import in.skg.userinfo.repo.UserRepo;
import in.skg.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    @Override
    public Optional<UserDto> getUserInfoById(int userId) {
        Optional<User> userById = this.userRepo.findById(userId);
        return Optional.of(UserMapper.INSTANCE.mapUserToUserDto(userById.get()));
    }
}
