CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE,
    birth_date DATE,
    user_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

COMMENT ON TABLE Users IS 'Armazenamento dos dados dos usuários';

COMMENT ON COLUMN Users.full_name IS 'Nome completo do usuário';
COMMENT ON COLUMN Users.email IS 'E-mail do usuário (único)';
COMMENT ON COLUMN Users.phone IS 'Número de telefone do usuário (único)';
COMMENT ON COLUMN Users.birth_date IS 'Data de nascimento do usuário';
COMMENT ON COLUMN Users.user_type IS 'Tipo de usuário (exemplo: admin, cliente, funcionário)';
COMMENT ON COLUMN Users.created_at IS 'Data de criação do registro';
COMMENT ON COLUMN Users.updated_at IS 'Data da última atualização do registro';

INSERT INTO Users (full_name, email, phone, birth_date, user_type)
VALUES
('João Silva', 'joao.silva@example.com', '+55 11 12345-6789', '1990-05-20', 'ADMIN'),
('Maria Oliveira', 'maria.oliveira@example.com', '+55 21 23456-7890', '1985-10-10', 'EDITOR'),
('Carlos Pereira', 'carlos.pereira@example.com', '+55 31 34567-8901', '1992-02-15', 'VIEWER'),
('Ana Souza', 'ana.souza@example.com', '+55 41 45678-9012', '1987-07-22', 'ADMIN'),
('Pedro Santos', 'pedro.santos@example.com', '+55 51 56789-0123', '1995-03-30', 'EDITOR'),
('Paula Costa', 'paula.costa@example.com', '+55 61 67890-1234', '1989-11-11', 'VIEWER'),
('Lucas Almeida', 'lucas.almeida@example.com', '+55 71 78901-2345', '1991-08-05', 'ADMIN'),
('Juliana Lima', 'juliana.lima@example.com', '+55 81 89012-3456', '1993-12-25', 'EDITOR'),
('Roberto Pereira', 'roberto.pereira@example.com', '+55 91 90123-4567', '1988-01-10', 'VIEWER'),
('Fernanda Souza', 'fernanda.souza@example.com', '+55 85 01234-5678', '1994-06-18', 'ADMIN');


