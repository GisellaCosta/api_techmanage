package com.desafio.techmanage.controllers;

import com.desafio.techmanage.forms.UserForm;
import com.desafio.techmanage.models.User;
import com.desafio.techmanage.repositories.UserRepository;
import com.desafio.techmanage.services.UserService;
import com.desafio.techmanage.vo.UserVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

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
    void addUser_DeveCriarUsuarioComSucesso() {
        when(userService.addUser(any(UserForm.class))).thenReturn(userVO);

        ResponseEntity<UserVO> response = userController.addUser(userForm);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userVO, response.getBody());
    }

    @Test
    void findAllUsers_DeveRetornarListaUsuarios() {
        List<UserVO> users = Arrays.asList(userVO);
        when(userService.findAllUsers()).thenReturn(users);

        ResponseEntity<List<UserVO>> response = userController.findAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void findAllUsers_DeveRetornarListaVazia() {
        when(userService.findAllUsers()).thenReturn(List.of());

        ResponseEntity<List<UserVO>> response = userController.findAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void findUsersById_DeveRetornarUsuario() {
        when(userService.findUsersById(1L)).thenReturn(userVO);

        ResponseEntity<UserVO> response = userController.findUsersById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userVO, response.getBody());
    }

    @Test
    void findUsersById_DeveRetornarErroUsuarioNaoEncontrado() {
        when(userService.findUsersById(1L)).thenThrow(new RuntimeException("Usuário não encontrado"));

        Exception exception = assertThrows(RuntimeException.class, () -> userController.findUsersById(1L));

        assertEquals("Usuário não encontrado", exception.getMessage());
    }

    @Test
    void updateUsersById_DeveAtualizarUsuarioComSucesso() {
        when(userService.updateUsersById(eq(1L), any(UserForm.class))).thenReturn(userVO);

        ResponseEntity<UserVO> response = userController.updateUsersById(1L, userForm);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(userVO, response.getBody());
    }

    @Test
    void updateUsersById_DeveFalharUsuarioNaoEncontrado() {
        when(userService.updateUsersById(eq(1L), any(UserForm.class)))
                .thenThrow(new RuntimeException("Usuário não encontrado"));

        Exception exception = assertThrows(RuntimeException.class, () -> userController.updateUsersById(1L, userForm));

        assertEquals("Usuário não encontrado", exception.getMessage());
    }

    @Test
    void deleteUsersById_DeveDeletarUsuarioComSucesso() {
        doNothing().when(userService).deleteUsersById(1L);

        ResponseEntity<UserVO> response = userController.deleteUsersById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void deleteUsersById_DeveFalharUsuarioNaoEncontrado() {
        doThrow(new RuntimeException("Usuário não encontrado")).when(userService).deleteUsersById(1L);

        Exception exception = assertThrows(RuntimeException.class, () -> userController.deleteUsersById(1L));

        assertEquals("Usuário não encontrado", exception.getMessage());
    }
}
