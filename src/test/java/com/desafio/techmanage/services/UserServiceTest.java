package com.desafio.techmanage.services;

import com.desafio.techmanage.exceptions.business.DataAlreadyRegisteredException;
import com.desafio.techmanage.exceptions.business.DataNotRegisteredException;
import com.desafio.techmanage.forms.UserForm;
import com.desafio.techmanage.models.User;
import com.desafio.techmanage.repositories.UserRepository;
import com.desafio.techmanage.vo.UserVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user;
    private UserVO userVO;
    private UserForm userForm;

    private final Long USER_ID = 1L;
    private final String FULL_NAME = "João Silva";
    private final String EMAIL = "joao@email.com";
    private final String PHONE = "123456789";
    private final Date BIRTH_DATE = new Date();
    private final String USER_TYPE = "ADMIN";

    @BeforeEach
    void setUp() {
        user = new User(USER_ID, FULL_NAME, EMAIL, PHONE, BIRTH_DATE, USER_TYPE);
        userVO = new UserVO(USER_ID,FULL_NAME, EMAIL, PHONE, BIRTH_DATE, USER_TYPE);
        userForm = new UserForm(USER_ID,FULL_NAME, EMAIL, PHONE, BIRTH_DATE, USER_TYPE);
    }


    @Test
    void addUser_DeveAdicionarUsuarioComSucesso() {
        when(userRepository.findByEmail(userForm.getEmail())).thenReturn(Optional.empty());
        when(userRepository.findByPhone(userForm.getPhone())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserVO result = userService.addUser(userForm);

        assertNotNull(result);
        assertEquals(userVO.getFullName(), result.getFullName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void addUser_DeveFalhar_QuandoEmailJaCadastrado() {
        when(userRepository.findByEmail(userForm.getEmail())).thenReturn(Optional.of(user));

        assertThrows(DataAlreadyRegisteredException.class, () -> userService.addUser(userForm));
    }

    @Test
    void addUser_DeveFalhar_QuandoTelefoneJaCadastrado() {
        when(userRepository.findByEmail(userForm.getEmail())).thenReturn(Optional.empty());
        when(userRepository.findByPhone(userForm.getPhone())).thenReturn(Optional.of(user));

        assertThrows(DataAlreadyRegisteredException.class, () -> userService.addUser(userForm));
    }

    @Test
    void findAllUsers_DeveRetornarListaUsuarios() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<UserVO> result = userService.findAllUsers();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void findAllUsers_DeveRetornarListaVazia() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<UserVO> result = userService.findAllUsers();

        assertTrue(result.isEmpty());
    }

    @Test
    void findUsersById_DeveRetornarUsuario() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));

        UserVO result = userService.findUsersById(USER_ID);

        assertNotNull(result);
        assertEquals(FULL_NAME, result.getFullName());
    }

    @Test
    void findUsersById_DeveFalhar_QuandoUsuarioNaoEncontrado() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        assertThrows(DataNotRegisteredException.class, () -> userService.findUsersById(USER_ID));
    }

    @Test
    void updateUsersById_DeveAtualizarUsuarioComSucesso() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserVO result = userService.updateUsersById(USER_ID, userForm);

        assertNotNull(result);
        assertEquals(FULL_NAME, result.getFullName());
        verify(userRepository, times(1)).save(any(User.class));
    }
    @Test
    void updateUsersById_DeveFalhar_QuandoUsuarioNaoEncontrado() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        assertThrows(DataNotRegisteredException.class, () -> userService.updateUsersById(USER_ID, userForm));
    }

    @Test
    void deleteUsersById_DeveDeletarUsuarioComSucesso() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(USER_ID);

        assertDoesNotThrow(() -> userService.deleteUsersById(USER_ID));
        verify(userRepository, times(1)).deleteById(USER_ID);
    }

    @Test
    void deleteUsersById_DeveFalhar_QuandoUsuarioNaoEncontrado() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        assertThrows(DataNotRegisteredException.class, () -> userService.deleteUsersById(USER_ID));
    }
}