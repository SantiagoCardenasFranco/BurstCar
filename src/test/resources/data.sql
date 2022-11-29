INSERT INTO public.user_app(id, email, identification, last_name, name, password)
	VALUES (20, '12@gmail.com', '123456789', 'Algo', 'nombre', 'w9Inpo<code>t0d0');
INSERT INTO public.rol_user(id, description, name, id_user) VALUES (20, 'Encargado de solicitar el servicio', 'Cliente', 20);

INSERT INTO public.user_app(id, email, identification, last_name, name, password)
	VALUES (29, '1265@gmail.com', '9876543', 'Algo', 'nombre', 'w90Inpo<code>t0d0');
INSERT INTO public.rol_user(id, description, name, id_user) VALUES (29, 'Encargado de solicitar de transportador', 'Conductor', 29);

INSERT INTO public.user_app(id, email, identification, last_name, name, password)
	VALUES (45, 'correo@gmail.com', '7846708', 'Algo', 'nombre', 'w5Mnpo<code>t0d0');
	INSERT INTO public.rol_user(id, description, name, id_user) VALUES (45, 'Encargado de solicitar el servicio', 'Cliente', 45);

INSERT INTO public.vehicle_service(id, description_service, service) VALUES (3, 'Encargado de transportar todo material', 'Carga');
INSERT INTO public.vehicle_service(id, description_service, service) VALUES (4, 'Encargado de transportar personal', 'Transporte');

INSERT INTO public.vehicle_features(id, brand, license_plate, model)
	VALUES (32, 'Chevrolet', 'XSB-86S', '2022');

INSERT INTO public.vehicle_features(id, brand, license_plate, model)
	VALUES (33, 'Nissan', 'XTW-56B', '2018');

insert into additional_data(id, quantity, type_data)
values (1, 9, 'Cantidad de usuarios');