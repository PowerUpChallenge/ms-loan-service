-- Crear schema si no existe
CREATE SCHEMA IF NOT EXISTS public;

-- Tabla: loan_type
CREATE TABLE IF NOT EXISTS loan_type (
    id_loan_type BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    min_amount NUMERIC(15,2) NOT NULL,
    max_amount NUMERIC(15,2) NOT NULL,
    interest_rate NUMERIC(5,4) NOT NULL,
    automatic_validation INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: loan_status
CREATE TABLE IF NOT EXISTS loan_status (
    id_loan_status BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: loan_application
CREATE TABLE IF NOT EXISTS loan_application (
    id_loan_application BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    id_loan_type BIGINT NOT NULL,
    amount NUMERIC(15,2) NOT NULL,
    term INTEGER NOT NULL,
    application_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_loan_status BIGINT NOT NULL,
    status_change_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Foreign keys
    CONSTRAINT fk_loan_application_loan_type
        FOREIGN KEY (id_loan_type)
        REFERENCES loan_type(id_loan_type)
        ON DELETE RESTRICT,

    CONSTRAINT fk_loan_application_loan_status
        FOREIGN KEY (id_loan_status)
        REFERENCES loan_status(id_loan_status)
        ON DELETE RESTRICT
);

-- Índices para mejorar el performance
CREATE INDEX IF NOT EXISTS idx_loan_application_email ON loan_application(email);
CREATE INDEX IF NOT EXISTS idx_loan_application_loan_type ON loan_application(id_loan_type);
CREATE INDEX IF NOT EXISTS idx_loan_application_loan_status ON loan_application(id_loan_status);
CREATE INDEX IF NOT EXISTS idx_loan_application_date ON loan_application(application_date);

-- Comentarios para documentación
COMMENT ON TABLE loan_type IS 'Tabla de tipos de préstamos disponibles';
COMMENT ON TABLE loan_status IS 'Tabla de estados posibles para una solicitud de préstamo';
COMMENT ON TABLE loan_application IS 'Tabla principal de solicitudes de préstamo';