INSERT INTO note (important, created_at, id, author, content, title)
VALUES
(true, '2024-01-23 12:34:56', 1, 'e38f5705-66d9-4c7f-a7c8-21f26a7e40a8', 'Contenido de la nota 1', 'Título de la nota 1'),
(false, '2024-01-23 13:45:00', 2, '2e02df0d-0b1a-4e64-a3f2-bd3a223fae10', 'Contenido de la nota 2', 'Título de la nota 2'),
(true, '2024-01-24 08:30:00', 3, 'e38f5705-66d9-4c7f-a7c8-21f26a7e40a8', 'Contenido de la nota 3', 'Título de la nota 3'),
(false, '2024-01-25 10:15:00', 4, 'e38f5705-66d9-4c7f-a7c8-21f26a7e40a8', 'Contenido de la nota 4', 'Título de la nota 4'),
(true, '2024-01-26 14:45:00', 5, '2e02df0d-0b1a-4e64-a3f2-bd3a223fae10', 'Contenido de la nota 5', 'Título de la nota 5'),
(false, '2024-01-27 16:20:00', 6, '2e02df0d-0b1a-4e64-a3f2-bd3a223fae10', 'Contenido de la nota 6', 'Título de la nota 6');

-- Insertar datos en la tabla 'note_tags'
INSERT INTO note_tags (note_id, tags)
VALUES
(1, 'etiqueta1'),
(1, 'etiqueta2'),
(2, 'etiqueta3'),
(3, 'etiqueta4'),
(3, 'etiqueta5'),
(4, 'etiqueta6'),
(5, 'etiqueta7'),
(6, 'etiqueta8');