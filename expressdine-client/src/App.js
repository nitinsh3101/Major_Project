import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./Components/Login";
import ViewFoodRestOwner from "./Components/ViewFoodRestOwner";
import ViewFoodUser from "./Components/ViewFoodUser";
import ViewRestaurantAdmin  from "./Components/ViewRestaurantAdmin";
import ViewRestaurantUser from "./Components/ViewRestaurantUser";
import HomePage from "./Components/HomePage";
import AddRestaurantAdmin from "./Components/AddRestaurantAdmin";
import Header from "./Components/Header";
import Footer from "./Components/Footer";
import UpdateRestaurant from "./Components/UpdateRestaurant";
import AdminDashboard from "./Components/AdminDashboard";
import RestaurantOwnerDashboard from "./Components/RestaurantOwnerDashboard";
import UpdateFood from "./Components/UpdateFood";
import AboutUs from "./Components/AboutUs";
import ContactUs from "./Components/ContactUs";
import ViewComplaintOwner from "./Components/ViewComplaintOwner";
import AddRestaurantOwnerByAdmin from "./Components/AddRestaurantOwnerByAdmin";
import AddUser from "./Components/AddUser";
import AddFood from "./Components/AddFood";
import ViewFavouriteFoodUser from "./Components/ViewFavouriteFoodUser";
import ViewCart from "./Components/ViewCart";
import AddOrderFeedback from "./Components/AddOrderFeedback";
import AddComplaint from "./Components/AddComplaint";
import UserOrders from "./Components/UserOrders";
import UpdateUser from "./Components/UpdateUser";
import ViewLockedAccounts from "./Components/ViewLockedAccounts";
import ViewOrdersOwner from "./Components/ViewOrdersOwner";
import ViewFeedback from "./Components/ViewFeedback";
import ViewFavouriteRestaurantUser from "./Components/ViewFavouriteRestaurantUser";
import ViewOrderFeedbackOwner from "./Components/ViewOrderFeedbackOwner";
import AddFeedback from "./Components/AddFeedback";
import ViewComplaintUser from "./Components/ViewComplaintUser";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={<Login />} />
          <Route
            path="/viewFoodUser/:restId/:restName"
            element={<ViewFoodUser />}
          />
          <Route path="/restaurant" element={<ViewRestaurantUser />} />
          <Route path="/addRest" element={<AddRestaurantAdmin />} />
          <Route path="/viewRestAdmin" element={<ViewRestaurantAdmin />} />
          <Route
            path="/editRestaurant/:restId"
            element={<UpdateRestaurant />}
          />
          <Route path="/adminDashboard" element={<AdminDashboard />} />
          <Route
            path="/restOwnerDashboard"
            element={<RestaurantOwnerDashboard />}
          />
          <Route path="/viewFoodRestOwner" element={<ViewFoodRestOwner />} />
          <Route path="/editFood/:foodId" element={<UpdateFood />} />
          <Route path="/aboutUs" element={<AboutUs />} />
          <Route path="/contactUs" element={<ContactUs />} />
          <Route path="/viewComplaintOwner" element={<ViewComplaintOwner />} />
          <Route
            path="/addRestaurantOwner"
            element={<AddRestaurantOwnerByAdmin />}
          />
          <Route path="/addUser" element={<AddUser />} />
          <Route path="/addFood" element={<AddFood />} />
          <Route path="/viewCart" element={<ViewCart />} />
          <Route path="/addComplaint/:orderId" element={<AddComplaint />} />
          <Route
            path="/addOrderFeedback/:orderId"
            element={<AddOrderFeedback />}
          />
          <Route path="/userOrders" element={<UserOrders />} />
          <Route path="/editUser" element={<UpdateUser />} />
          <Route path="/lockedAccounts" element={<ViewLockedAccounts />} />
          <Route path="/viewOrdersOwner" element={<ViewOrdersOwner />} />
          <Route path="/viewFeedback" element={<ViewFeedback />} />
          <Route path="/viewOrderFeedback" element={<ViewOrderFeedbackOwner />} />
          <Route
            path="/viewFavouriteFoodUser"
            element={<ViewFavouriteFoodUser />}
          />
          <Route
            path="/viewFavouriteRestaurantUser"
            element={<ViewFavouriteRestaurantUser />}
          />
           <Route path="/addFeedback" element={<AddFeedback />} />
           <Route path="/viewComplaintUser" element={<ViewComplaintUser/>} />
        </Routes>
       
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
