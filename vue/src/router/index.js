import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AddMealView from '../views/AddMealView.vue'
import EditMealView from '../views/EditMealView.vue'
import DeleteMealView from '../views/DeleteMealView.vue'
import BrowseMeals from '../views/BrowseMeals.vue'
import BrowseHouseholds from '../views/BrowseHouseholds.vue'
import MyHousehold from '../views/MyHousehold.vue'
import AddHouseholdView from '../views/AddHouseholdView'
import BrowseMealPlans from '../views/BrowseMealPlans'
import AddMealPlan from '../views/AddMealPlan'
import EditMealPlan from '../views/EditMealPlan'
import BrowseMyMeals from '../views/BrowseMyMeals.vue'
import GenerateMealPlan from '../views/GenerateMealPlan.vue'
import MealPlanDetails from '../views/MealPlanDetailsView.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/addMeal",
      name: "addMeal",
      component: AddMealView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/editMeal/:id",
      name: "editMeal",
      component: EditMealView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/deleteMeal/:id",
      name: "deleteMeal",
      component: DeleteMealView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/browseMeals",
      name: "browseMeals",
      component: BrowseMeals,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/browseMyMeals",
      name: "browseMyMeals",
      component: BrowseMyMeals,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/browseHouseholds",
      name: "browseHouseholds",
      component: BrowseHouseholds,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/myHousehold",
      name: "myHousehold",
      component: MyHousehold,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addHousehold",
      name: "addHousehold",
      component: AddHouseholdView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/browseMealPlans",
      name: "browseMealPlans",
      component: BrowseMealPlans,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addMealPlan",
      name: "addMealPlan",
      component: AddMealPlan,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/editMealPlan",
      name: "editMealPlan",
      component: EditMealPlan,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/generateMealPlan",
      name: "generateMealPlan",
      component: GenerateMealPlan,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/mealPlanDetails/:id",
      name: "mealPlanDetails",
      component: MealPlanDetails,
      meta: {
        requiresAuth: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
