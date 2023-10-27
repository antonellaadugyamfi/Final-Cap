BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, meals, households, meal_plan, meal_plan_data;

CREATE TABLE households (
    household_id SERIAL,
    household_name VARCHAR(50) NOT NULL,
    household_owner VARCHAR(50) NOT NULL,
    CONSTRAINT PK_household PRIMARY KEY (household_id)
);

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	household_id int,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_household_id FOREIGN KEY (household_id) REFERENCES households(household_id)
);

CREATE TABLE meals (
    meal_id SERIAL,
    meal_name varchar(100) NOT NULL,
    description varchar(300) NOT NULL,
    ingredients varchar(300),
    instructions varchar(300),
    meal_owner varchar(50) NOT NULL,
    CONSTRAINT PK_meal_id PRIMARY KEY (meal_id)
);

CREATE TABLE meal_plan (
    meal_plan_id SERIAL,
    household_id int,
    meal_plan_name varchar(50) NOT NULL,
    CONSTRAINT PK_meal_plan_id PRIMARY KEY (meal_plan_id),
    CONSTRAINT FK_household_id FOREIGN KEY (household_id) REFERENCES households(household_id)
);

CREATE TABLE meal_plan_data (
    meal_plan_id int NOT NULL,
    planner_date date,
    meal_id int DEFAULT 1,
    CONSTRAINT FK_meal_plan_id FOREIGN KEY (meal_plan_id) REFERENCES meal_plan(meal_plan_id),
    CONSTRAINT FK_meal_id FOREIGN KEY (meal_id) REFERENCES meals(meal_id)
);

COMMIT TRANSACTION;