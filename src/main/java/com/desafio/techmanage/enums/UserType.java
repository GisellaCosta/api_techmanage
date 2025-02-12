package com.desafio.techmanage.enums;

import com.desafio.techmanage.exceptions.business.DataAlreadyRegisteredException;
import com.desafio.techmanage.exceptions.business.DataNotRegisteredException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserType {
    ADMIN("Administrador - Acesso total"),
    EDITOR("Editor - Pode modificar conteúdo"),
    VIEWER("Visualizador - Apenas leitura");

    private final String descricao;

    UserType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
