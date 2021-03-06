import logo from "./logo.svg";
import "./App.css";
import Landing from "./app/core/components/layouts/Landing";
import Header from "./app/core/components/layouts/Header";
import Footer from "./app/core/components/layouts/Footer";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { AuthRouters } from "./app/auth/routings/AuthRouters";

//redux imports
import { Provider } from "react-redux";
import store from "./redux/store";
import DashboardRouter from "./app/dashboard/routings/DashboardRouter";
import { useEffect } from "react";
import setAuthToken from "./utils/setAuthToken";
import Alert from "./app/core/components/Alert";
import { loadUser } from "./app/auth/action/authAction";
import { loadFood } from "./app/food/actions/foodAction";
import FoodRouters from "./app/food/routings/FoodRouters";
import CartRouter from "./app/cart/CartRouter";
import ProfileRouter from "./app/profiles/routings/ProfileRouter";
// react and redux
if (localStorage.token && localStorage.userId) {
  setAuthToken(localStorage.token, localStorage.userId);
}
function App() {
  useEffect(() => {
    const userid = localStorage.getItem("userId");
    console.log("check for useeffect 1"); // do we need to update the userinfo?

    if (userid) store.dispatch(loadUser(userid));
    store.dispatch(loadFood());

    console.log("check for useeffect 2"); // do we need to update the userinfo?
  }, [loadUser, loadFood]);
  // it should do some fundamental checks for token.
  // useEffect
  return (
    <div className="App">
      <Provider store={store}>
        <Router>
          <Header />
          <Alert />
          <Routes>
            <Route path="/" element={<Landing></Landing>}></Route>
            <Route path="/auth/*" element={<AuthRouters></AuthRouters>}></Route>
            <Route
              path="/dashboard/*"
              element={<DashboardRouter></DashboardRouter>}
            ></Route>
            <Route path="/food/*" element={<FoodRouters></FoodRouters>}></Route>
            <Route path="/cart/*" element={<CartRouter />} />
            <Route path="/profiles/*" element={<ProfileRouter />} />
          </Routes>
          <Footer></Footer>
        </Router>
      </Provider>
    </div>
  );
}

export default App;
