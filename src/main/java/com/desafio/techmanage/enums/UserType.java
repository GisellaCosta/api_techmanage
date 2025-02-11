package com.desafio.techmanage.enums;

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
