package ru.clevertec.userservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.api.UserRepository;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.service.UserService;
import ru.clevertec.userservice.service.mappers.api.UserMapper;

import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
        User user = repository.findByNick(nick)
                .orElseThrow(EntityNotFoundException::new);

        return mapper.userToUserDetailsUser(user);
    }

    @Override
    @Transactional
    public User createUser(@Valid UserCreateDto userDto) {
        User user = mapper.userCreateDtoToUser(userDto);
        return repository.save(user);
    }

    @Override
    public User findById(UUID uuid) {
        return repository.findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<User> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public User updateByUuid(UUID uuid, @Valid UserCreateDto userDto) {
        User user = findById(uuid);
        mapper.update(user, userDto);

        return repository.save(user);

    }
}
