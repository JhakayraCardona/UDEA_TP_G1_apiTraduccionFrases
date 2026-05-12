--0. Asegurar que el autonumérico de los campos ID esté sincronizado
SELECT setval(
    pg_get_serial_sequence('frase', 'id'),
     COALESCE((SELECT MAX(id) FROM frase) + 1, 1),
    false
);

SELECT setval(
    pg_get_serial_sequence('idioma', 'id'),
     COALESCE((SELECT MAX(id) FROM idioma) + 1, 1),
    false
);


--1. Agregar los idiomas
INSERT INTO idioma
	(idioma)
	VALUES
		('Alemán'),
		('Francés'),
		('Inglés'),
		('Ruso'),
		('Portugues')
	ON CONFLICT(idioma) DO NOTHING;

--2. Agregar las frases
INSERT INTO frase
	(texto)
	VALUES
		('Hola'),
		('Buenos días'),
		('Buenas Tardes'),
		('Buenas Noches'),
		('Cómo estas?'),
		('Cómo te llamas?'),
		('De dónde vienes?'),
		('Mundo')
	ON CONFLICT(texto) DO NOTHING;

--3. Agregar las traducciones
INSERT INTO traduccion
	(idfrase, ididioma, texto)
	SELECT F.id, I.id, datos.traduccion
		FROM (
			VALUES
			('Hola', 'Alemán', 'Hallo'),
			('Hola', 'Francés', 'Salut'),
			('Hola', 'Inglés', 'Hello'),
			('Hola', 'Ruso', N'привет (privet)'),
			('Buenos días', 'Alemán', 'Guten morgen'),
			('Buenos días', 'Francés', 'Bonjour'),
			('Buenos días', 'Inglés', 'Good morning'),
			('Buenos días', 'Ruso', N'Доброе утро (Dobroye utro)'),
			('Buenas Tardes', 'Alemán', 'Guten nachmittag'),
			('Buenas Tardes', 'Francés', 'Bonsoir'),
			('Buenas Tardes', 'Inglés', 'Good afternoon'),
			('Buenas Tardes', 'Ruso', N'Добрый день (Dobryy den´)'),
			('Buenas Noches', 'Alemán', 'Gute nacht'),
			('Buenas Noches', 'Francés', 'Bonne nuit'),
			('Buenas Noches', 'Inglés', 'Good evening'),
			('Buenas Noches', 'Ruso', N'Спокойной ночи (Spokoynoy nochi)'),
			('Cómo estas?', 'Alemán', 'Wie geht es dir'),
			('Cómo estas?', 'Francés', 'Comment est il vous?'),
			('Cómo estas?', 'Inglés', 'How are you?'),
			('Cómo estas?', 'Ruso', N'Как ты (Kak ty)'),
			('Cómo te llamas?', 'Alemán', 'Wie heißt du?'),
			('Cómo te llamas?', 'Francés', 'Comment tu t´apelles?'),
			('Cómo te llamas?', 'Inglés', 'What is your name?'),
			('Cómo te llamas?', 'Ruso', N'(Как тебя зовут (Kak tebya zovut)'),
			('De dónde vienes?', 'Alemán', 'Wo kommst du her'),
			('De dónde vienes?', 'Francés', 'D´où viens-tu?'),
			('De dónde vienes?', 'Inglés', 'Where you come from?'),
			('De dónde vienes?', 'Ruso', N'Откуда ты родом? (Otkuda ty rodom?)'),
			('Mundo', 'Inglés', 'World')
			) datos(frase, idioma, traduccion)
		JOIN idioma I ON datos.idioma = I.idioma
		JOIN frase F ON datos.frase = F.texto
	ON CONFLICT(idfrase, ididioma) 
		DO UPDATE SET
			texto = EXCLUDED.texto;

