package com.blog.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.UserDto;
import com.blog.repositories.UserRepo;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int id) {

		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		if (Objects.nonNull(userDto.getName()) && !"".equalsIgnoreCase(userDto.getName())) {
			user.setUserName(userDto.getName());
		}
		if (Objects.nonNull(userDto.getPassword()) && !"".equalsIgnoreCase(userDto.getPassword())) {
			user.setUserPassword(userDto.getPassword());
		}

		if (Objects.nonNull(userDto.getEmail()) && !"".equalsIgnoreCase(userDto.getEmail())) {
			user.setUserEmail(userDto.getEmail());
		}

		if (Objects.nonNull(userDto.getAbout()) && !"".equalsIgnoreCase(userDto.getAbout())) {
			user.setAbout(userDto.getAbout());
		}

		User updatedUser = this.userRepo.save(user);

		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(int id) {
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepo.findAll();

		List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDto;
	}

	@Override
	public void deleteUser(int id) {

		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		this.userRepo.delete(user);

	}

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setUserName(userDto.getName());
//		user.setUserPassword(userDto.getPassword());
//		user.setUserEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return userDto;
	}

}
