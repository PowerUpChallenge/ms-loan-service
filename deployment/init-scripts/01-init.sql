-- Datos iniciales para loan_status
INSERT INTO loan_status (name, description) VALUES
('PENDING', 'Solicitud en revisión'),
('APPROVED', 'Solicitud aprobada'),
('REJECTED', 'Solicitud rechazada'),
('UNDER_REVIEW', 'Solicitud en análisis adicional')
ON CONFLICT DO NOTHING;

-- Datos iniciales para loan_type (ejemplos)
INSERT INTO loan_type (name, min_amount, max_amount, interest_rate, automatic_validation) VALUES
('Personal Loan', 1000.00, 50000.00, 0.0899, 1),
('Mortgage Loan', 50000.00, 500000.00, 0.0450, 0),
('Auto Loan', 5000.00, 100000.00, 0.0650, 1),
('Education Loan', 1000.00, 100000.00, 0.0350, 0)
ON CONFLICT DO NOTHING;