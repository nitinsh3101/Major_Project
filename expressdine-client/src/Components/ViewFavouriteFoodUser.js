import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import FoodService from "../Services/FoodService";
import CartService from "../Services/CartService";
import swal from "sweetalert";

const ViewFavouriteFoodUser = () => {
  const [foodList, setFoodList] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));
 

  const addCart = (foodId) => {
    let cart = {
      food: {
        id: foodId,
      },
      user: {
        id: userId,
      },
    };
    console.log(cart);
    CartService.addToCart(cart).then((res) => {
      console.log(res);
    });
  };

  const removeItem = (FavouriteFoodId) => {
    FoodService.removeItem(FavouriteFoodId).then((res) => {
      swal({
        title: "Removed",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => ( window.location = "/ViewFavouriteFoodUser"), 2000);
    });
  };

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    FoodService.getAllFavouriteFood(userId)
      .then((response) => {
        setFoodList(response.data);
      })
      .catch((error) => {
        this.setState({ errorMessage: error.message });
        console.error("There was an error!", error);
      });
  }, []);

  return (
    <div>
      ViewFavouriteFoodUser
      <div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Name</th>
              <th scope="col">Price</th>
              <th scope="col">Category</th>
              <th scope="col">Delivery Time</th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            {foodList.map((food) => (
              <tr>
                <td>{food.id}</td>
                <td>{food.food.name}</td>
                <td>{food.food.price}</td>
                <td>{food.food.category}</td>
                <td>{food.food.deliveryTime}</td>

                <td>
                  <button
                    class="btn btn-primary"
                    onClick={() => addCart(food.food.id)}
                  >
                    Add To Cart
                  </button>
                </td>
                <td>
                  <button
                    class="btn btn-primary"
                    onClick={() => removeItem(food.id)}
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

export default ViewFavouriteFoodUser;
