package in.skg.userinfo.service;

import in.skg.userinfo.dto.UserDto;

import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDto);

    Optional<UserDto> getUserInfoById(int userId);
}
