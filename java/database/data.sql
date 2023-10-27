BEGIN TRANSACTION;

INSERT INTO households(household_name, household_owner) VALUES ('Admin Home', 'admin');
INSERT INTO households(household_name, household_owner) VALUES ('home2', 'user');
INSERT INTO households(household_name, household_owner) VALUES ('Slick Household', 'Jeremy');
INSERT INTO households(household_name, household_owner) VALUES ('Anita Home', 'Anita');
INSERT INTO households(household_name, household_owner) VALUES ('Antonella Home', 'Antonella');
INSERT INTO households(household_name, household_owner) VALUES ('Brett Home', 'Brett');
INSERT INTO households(household_name, household_owner) VALUES ('Mohamed Home', 'Mohamed');


INSERT INTO users (username,password_hash,role, household_id) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 2);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 1);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Charles','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Anita','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 4);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Antonella','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 5);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Brett','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 6);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Mohamed','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 7);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Jeremy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Mich','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Nick','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Rockey','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Andrew','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Caroline','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Adam','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Dean','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Bailey','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Viv','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Nix','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);
INSERT INTO users (username,password_hash,role, household_id) VALUES ('Zach','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 3);

INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('Meal Name', 'Meal Description', 'Meal Ingredients', 'Meal Instructions', 'admin');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('PIZZA', 'Dish of Italian origin consisting of bread dough topped with some combination of cheese and toppings', 'cheese, sauce, crust, veggies, meats', 'bake in oven for a set time', 'user');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('PASTA', 'Italian descent, typically made from a dough of wheat flour mixed with water or eggs, and formed into sheets or other shapes, then cooked by boiling or baking', 'cheese, sauce, noodles, veggies, meats', 'boil in water until ready', 'Charles');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('BURGER', 'A patty of ground beef grilled and placed between two halves of a bun', 'cheese, lettuce, tomato, bun, meat', 'prepare toppings and sauces, grill meat, warm up buns, and combine all', 'user');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('TACO', 'Mexican food that consists of a folded and usually fried piece of thin bread (called a tortilla) that is filled with meat, cheese, lettuce, etc', 'cheese, lettuce, tomato, meat, tortilla', 'prepare toppings, cook your meat of choice, warm up tortilla and build your taco', 'Brett');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('GRILLED CHICKEN', 'A piece of grilled chicken you can serve with other dishes', 'chicken, herbs, butter', 'bake chicken in oven at a set temperature', 'Anita');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('SOUP', 'A liquid food with a meat, fish, or vegetable stock as a base and often containing pieces of solid food', 'tomato, chicken, herbs, biscuits', 'prepare herbs and vegetables, cook protein, add broth', 'Mohamed');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('CHICKEN SALAD', 'Healthy meal with combines a salad with your choice of chicken', 'tomato, chicken, onions, dressing, cheese', 'prepare chicken, pick toppings and sauces and combine', 'Antonella');
INSERT INTO meals(meal_name, description, ingredients, instructions, meal_owner) VALUES ('LOBSTER ROLL', 'Delicious lobster roll with fresh ingredients', 'lobster meat, mayo, butter, celery, spices, roll', '1. Cook lobster meat and mix with mayo. 2. Prepare buttered roll. 3. Add lobster mixture and celery. 4. Serve and enjoy!', 'Charles');


INSERT INTO meal_plan(household_id, meal_plan_name) VALUES (3, 'Slick Weekend');
INSERT INTO meal_plan(household_id, meal_plan_name) VALUES (4, 'Anita Meal Plan');
INSERT INTO meal_plan(household_id, meal_plan_name) VALUES (5, 'Antonella Meal Plan');
INSERT INTO meal_plan(household_id, meal_plan_name) VALUES (6, 'Brett Meal Plan');
INSERT INTO meal_plan(household_id, meal_plan_name) VALUES (7, 'Mohamed Meal Plan 4');

INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (3, '1/2/24', 3);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (2, '1/5/24', 4);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (4, '1/6/24', 2);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (5, '1/7/24', 3);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (1, '8/10/23', 9);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (1, '8/11/23', 9);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (1, '8/12/23', 9);
INSERT INTO meal_plan_data(meal_plan_id, planner_date, meal_id) VALUES (1, '8/13/23', 9);

COMMIT TRANSACTION;
