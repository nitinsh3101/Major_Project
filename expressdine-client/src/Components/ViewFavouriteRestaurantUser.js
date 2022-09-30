import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import RestaurantService from "../Services/RestaurantService";
import swal from "sweetalert";

const ViewFavouriteRestaurantUser = () => {
  const [RestaurantList, setRestaurantList] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  const removeItem = (restaurantId) => {
    RestaurantService.removeItem(restaurantId).then((res) => {
      swal({
        title: "Removed",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => ( window.location = "/ViewFavouriteRestaurantUser"), 2000);
    });
  };

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    RestaurantService.getAllFavouriteRestaurant(userId)
      .then((response) => {
        setRestaurantList(response.data);
      })
      .catch((error) => {
        this.setState({ errorMessage: error.message });
        console.error("There was an error!", error);
      });
  }, []);

  return (
    <div>
      ViewFavouriteRestaurantUser
      <div>
        <table class="table">
          <thead>
            <tr>
  
              <th scope="col">Name</th>
              <th scope="col">Address</th>
              <th scope="col">Phone</th>
              <th scope="col">Offer Percent</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            {RestaurantList.map((restaurant) => (
              <tr>

                <td>{restaurant.restaurant.name}</td>
                <td>{restaurant.restaurant.address}</td>
                <td>{restaurant.restaurant.phone}</td>
                <td>{restaurant.restaurant.offerPercent}</td>

                <td>
                  <button
                    class="btn btn-primary"
                    onClick={() => removeItem(restaurant.id)}
                  >
                    Remove
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ViewFavouriteRestaurantUser;
