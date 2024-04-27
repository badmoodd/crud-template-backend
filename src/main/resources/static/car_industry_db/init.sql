CREATE TABLE manufacturers
(
    manufacturer_id SERIAL PRIMARY KEY,
    name            VARCHAR(255),
    country         VARCHAR(255)
);

CREATE TABLE car_models
(
    model_id           SERIAL PRIMARY KEY,
    name               VARCHAR(255),
    manufacturer_name  VARCHAR(255),
    year_of_production INT,
    body_type          VARCHAR(50)
);

CREATE TABLE engines
(
    engine_id    SERIAL PRIMARY KEY,
    engine_model VARCHAR(255),
    power        INT,
    fuel_type    VARCHAR(50)
);

CREATE TABLE trims
(
    trim_id    SERIAL PRIMARY KEY,
    name       VARCHAR(255),
    model_name VARCHAR(255),
    price      DECIMAL(10, 2)
);

CREATE TABLE colors
(
    color_id SERIAL PRIMARY KEY,
    name     VARCHAR(255),
    code     VARCHAR(255)
);

CREATE TABLE sales
(
    sale_id    SERIAL PRIMARY KEY,
    date       DATE,
    car_name   VARCHAR(255),
    color_name VARCHAR(255),
    sale_price DECIMAL(10, 2)
);

CREATE TABLE service_centers
(
    service_id SERIAL PRIMARY KEY,
    name       VARCHAR(255),
    address    TEXT
);

CREATE TABLE service_work_types
(
    service_type_id SERIAL PRIMARY KEY,
    name            VARCHAR(255),
    description     TEXT,
    price           DECIMAL(10, 2)
);

CREATE TABLE employees
(
    employee_id         SERIAL PRIMARY KEY,
    full_name           VARCHAR(255),
    position            VARCHAR(255),
    service_center_name VARCHAR(255)
);

CREATE TABLE body_types
(
    body_type_id SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    description  TEXT
);

-- Добавление данных в таблицу manufacturers
INSERT INTO manufacturers (name, country)
VALUES ('Toyota', 'Japan'),
       ('Volkswagen', 'Germany'),
       ('Ford', 'USA'),
       ('Honda', 'Japan'),
       ('General Motors', 'USA'),
       ('BMW', 'Germany'),
       ('Mercedes-Benz', 'Germany'),
       ('Audi', 'Germany'),
       ('Nissan', 'Japan'),
       ('Hyundai', 'South Korea'),
       ('Renault', 'France'),
       ('Peugeot', 'France'),
       ('Fiat', 'Italy'),
       ('Mazda', 'Japan'),
       ('Kia', 'South Korea');

-- Добавление данных в таблицу car_models
INSERT INTO car_models (name, manufacturer_name, year_of_production, body_type)
VALUES ('Camry', 'Toyota', 2021, 'Sedan'),
       ('Golf', 'Volkswagen', 2020, 'Hatchback'),
       ('Focus', 'Ford', 2019, 'Sedan'),
       ('Accord', 'Honda', 2020, 'Sedan'),
       ('Civic', 'Honda', 2021, 'Sedan'),
       ('Cruze', 'General Motors', 2020, 'Sedan'),
       ('3 Series', 'BMW', 2021, 'Sedan'),
       ('E-Class', 'Mercedes-Benz', 2020, 'Sedan'),
       ('A4', 'Audi', 2021, 'Sedan'),
       ('Altima', 'Nissan', 2020, 'Sedan'),
       ('Sonata', 'Hyundai', 2021, 'Sedan'),
       ('Clio', 'Renault', 2020, 'Hatchback'),
       ('208', 'Peugeot', 2021, 'Hatchback'),
       ('500', 'Fiat', 2020, 'Hatchback'),
       ('3', 'Mazda', 2021, 'Sedan');

-- Добавление данных в таблицу engines
INSERT INTO engines (engine_model, power, fuel_type)
VALUES ('2.5L Inline-4', 203, 'Gasoline'),
       ('2.0L Inline-4', 147, 'Gasoline'),
       ('1.5L Inline-4', 160, 'Gasoline'),
       ('2.0L Inline-4', 212, 'Gasoline'),
       ('1.5L Inline-4', 174, 'Gasoline'),
       ('1.4L Inline-4', 153, 'Gasoline'),
       ('2.0L Inline-4', 255, 'Gasoline'),
       ('2.0L Inline-4', 268, 'Gasoline'),
       ('2.0L Inline-4', 201, 'Gasoline'),
       ('2.5L Inline-4', 188, 'Gasoline'),
       ('2.5L Inline-4', 191, 'Gasoline'),
       ('1.5L Inline-4', 130, 'Gasoline'),
       ('1.2L Inline-4', 100, 'Gasoline'),
       ('2.5L Inline-4', 186, 'Gasoline'),
       ('2.0L Inline-4', 180, 'Gasoline');

-- Добавление данных в таблицу trims
INSERT INTO trims (name, model_name, price)
VALUES ('LE', 'Camry', 25000.00),
       ('SE', 'Camry', 28000.00),
       ('SEL', 'Golf', 27000.00),
       ('SE', 'Focus', 23000.00),
       ('LX', 'Accord', 27000.00),
       ('EX', 'Civic', 24000.00),
       ('LS', 'Cruze', 22000.00),
       ('330i', '3 Series', 40000.00),
       ('E 350', 'E-Class', 55000.00),
       ('Premium', 'A4', 42000.00),
       ('S', 'Altima', 28000.00),
       ('SEL', 'Sonata', 29000.00),
       ('RS', 'Clio', 25000.00),
       ('GT Line', '208', 23000.00),
       ('Pop', '500', 22000.00);

-- Добавление данных в таблицу colors
INSERT INTO colors (name, code)
VALUES ('Red', '#FF0000'),
       ('Blue', '#0000FF'),
       ('Black', '#000000'),
       ('White', '#FFFFFF'),
       ('Silver', '#C0C0C0'),
       ('Gray', '#808080'),
       ('Green', '#008000'),
       ('Yellow', '#FFFF00'),
       ('Orange', '#FFA500'),
       ('Purple', '#800080'),
       ('Brown', '#A52A2A'),
       ('Beige', '#F5F5DC'),
       ('Gold', '#FFD700'),
       ('Pink', '#FFC0CB'),
       ('Turquoise', '#40E0D0');

-- Добавление данных в таблицу sales
INSERT INTO sales (date, car_name, color_name, sale_price)
VALUES ('2023-01-15', 'Camry', 'Red', 26000.00),
       ('2023-02-20', 'Golf', 'Blue', 28000.00),
       ('2023-03-25', 'Focus', 'Black', 24000.00),
       ('2023-04-10', 'Accord', 'White', 29000.00),
       ('2023-05-12', 'Civic', 'Silver', 25000.00),
       ('2023-06-18', 'Cruze', 'Gray', 22000.00),
       ('2023-07-22', '3 Series', 'Green', 43000.00),
       ('2023-08-30', 'E-Class', 'Yellow', 57000.00),
       ('2023-09-05', 'A4', 'Orange', 44000.00),
       ('2023-10-08', 'Altima', 'Purple', 30000.00),
       ('2023-11-15', 'Sonata', 'Brown', 31000.00),
       ('2023-12-20', 'Clio', 'Beige', 26000.00),
       ('2024-01-25', '208', 'Gold', 24000.00),
       ('2024-02-28', '500', 'Pink', 23000.00),
       ('2024-03-30', 'Camry', 'Turquoise', 27000.00);

-- Добавление данных в таблицу service_centers
INSERT INTO service_centers (name, address)
VALUES ('AutoService Express', '123 Main St, Anytown, USA'),
       ('QuickFix Auto', '456 Elm St, Othertown, USA'),
       ('Precision Auto Care', '789 Maple St, Anycity, USA'),
       ('Swift Service Center', '101 Oak St, Anycity, USA'),
       ('A1 Auto Repair', '321 Pine St, Othertown, USA'),
       ('MegaMotor Service', '456 Cedar St, Anytown, USA'),
       ('Car Clinic', '789 Birch St, Othertown, USA'),
       ('DriveRight Repair', '147 Walnut St, Anytown, USA'),
       ('TopTech Auto', '258 Hickory St, Othertown, USA'),
       ('MasterMechanic', '369 Spruce St, Anycity, USA'),
       ('AutoWorks Center', '741 Birch St, Anycity, USA'),
       ('RoadRunner Repair', '852 Pine St, Othertown, USA'),
       ('FixIt Garage', '963 Cedar St, Anytown, USA'),
       ('SpeedyService Auto', '159 Maple St, Othertown, USA'),
       ('QuickFix Motors', '357 Elm St, Anytown, USA');

-- Добавление данных в таблицу service_work_types
INSERT INTO service_work_types (name, description, price)
VALUES ('Oil Change', 'Standard oil change service', 50.00),
       ('Brake Inspection', 'Inspection and adjustment of brakes', 60.00),
       ('Tire Rotation', 'Rotating tires to ensure even wear', 40.00),
       ('Engine Tune-Up', 'Comprehensive engine tune-up service', 150.00),
       ('Wheel Alignment', 'Adjustment of wheel alignment', 80.00),
       ('Battery Replacement', 'Replacement of car battery', 120.00),
       ('Air Conditioning Service', 'Maintenance and repair of AC system', 100.00),
       ('Transmission Flush', 'Flush and refill transmission fluid', 120.00),
       ('Cooling System Flush', 'Flush and refill cooling system', 100.00),
       ('Diagnostic Service', 'Diagnostic check for vehicle issues', 80.00),
       ('Fuel System Cleaning', 'Cleaning and maintenance of fuel system', 90.00),
       ('Brake Pad Replacement', 'Replacement of brake pads', 120.00),
       ('Exhaust System Repair', 'Repair and maintenance of exhaust system', 110.00),
       ('Suspension Repair', 'Repair and maintenance of suspension system', 130.00),
       ('Electrical System Repair', 'Repair and maintenance of electrical system', 100.00);

-- Добавление данных в таблицу employees
INSERT INTO employees (full_name, position, service_center_name)
VALUES ('John Doe', 'Mechanic', 'AutoService Express'),
       ('Jane Smith', 'Service Advisor', 'QuickFix Auto'),
       ('Michael Johnson', 'Technician', 'Precision Auto Care'),
       ('Emily Williams', 'Mechanic', 'Swift Service Center'),
       ('David Brown', 'Service Advisor', 'A1 Auto Repair'),
       ('Jennifer Jones', 'Technician', 'MegaMotor Service'),
       ('Christopher Davis', 'Mechanic', 'Car Clinic'),
       ('Jessica Miller', 'Service Advisor', 'DriveRight Repair'),
       ('Daniel Wilson', 'Technician', 'TopTech Auto'),
       ('Sarah Martinez', 'Mechanic', 'MasterMechanic'),
       ('Kevin Anderson', 'Service Advisor', 'AutoWorks Center'),
       ('Amanda Taylor', 'Technician', 'RoadRunner Repair'),
       ('Matthew Thomas', 'Mechanic', 'FixIt Garage'),
       ('Linda Garcia', 'Service Advisor', 'SpeedyService Auto'),
       ('Robert Hernandez', 'Technician', 'QuickFix Motors');

-- Добавление данных в таблицу body_types
INSERT INTO body_types (name, description)
VALUES ('Sedan', 'A car body configuration with separate compartments for engine, passengers, and cargo.'),
       ('Hatchback', 'A car body configuration with a rear door that swings upward to provide access to a cargo area.'),
       ('SUV', 'A vehicle with a body style similar to a station wagon, but built on a light-truck chassis.'),
       ('Coupe', 'A two-door car with a fixed roof and a sloping rear roofline.'),
       ('Convertible', 'A car with a folding or retractable roof.'),
       ('Wagon', 'A car with a long roof and a rear door, often referred to as an estate or station wagon.'),
       ('Van', 'A vehicle primarily designed for transporting goods or passengers.'),
       ('Truck', 'A motor vehicle designed to transport cargo.'),
       ('Crossover', 'A vehicle built on a car platform combining features of a SUV and a passenger car.'),
       ('Minivan', 'A passenger van with additional seats and amenities.');
