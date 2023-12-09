INSERT INTO Client (name) VALUES
('Arturo'),
('Berlin'),
('Tokio'),
('Professor'),
('Dmytro'),
('Murillo'),
('Oleh'),
('Evgeniy'),
('Andrew'),
('Natalia');

INSERT INTO Planet (id, name) VALUES
('ABC13', 'Earth'),
('EFG46', 'Mars'),
('13AKR', 'Pluto'),
('12PCG', 'Mercuric'),
('1OP13', 'Jupiter');

INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
('2023-11-15 17:33:02', 1, 'ABC13', 'EFG46'),
('2023-05-11 13:24:36', 2, 'EFG46', 'ABC13'),
('2023-06-15 14:17:42', 3, 'ABC13', '13AKR'),
('2023-01-14 18:03:55', 4, 'ABC13', '12PCG'),
('2023-07-07 19:56:24', 5, 'ABC13', '1OP13'),
('2023-09-12 12:43:33', 6, 'ABC13', '13AKR'),
('2023-06-26 11:24:19', 7, 'EFG46', 'ABC13'),
('2023-10-13 07:27:21', 8, '12PCG', 'EFG46'),
('2023-03-27 16:59:22', 9, '1OP13', 'ABC13'),
('2023-02-23 19:02:23', 10, 'ABC13', '12PCG');